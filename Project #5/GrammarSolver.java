import java.util.*;

// Gabriel Malicoat
// CS 142 - Programming Project #4
//
// Grammar solver will take a list of strings and
// parse that into a map, the map will then use
// the information in a generate method that is
// capable of creating different sentences and expressions
public class GrammarSolver 
{
    private ArrayList<String> keys = new ArrayList<String>();
    private Map<String, ArrayList<String>> grammarMap;
    private Random random = new Random();

    // Default constructor will take a list and
    // parse that list into a keys and values for 
    // the given values passed in.
    public GrammarSolver(List<String> list)
    {
        if(list == null || list.isEmpty())
        {
            throw new IllegalArgumentException("Grammar cant be null or empty");
        }
        
        grammarMap = new HashMap<>();

        for(String rules : list)
        {
            String[] parts = rules.split("::=");
            String nonTerminal = parts[0].trim();
            String[] valueParts = parts[1].split("\\|");
            keys.add(parts[0].trim());
            if(grammarMap.containsKey(nonTerminal))
            {
                throw new IllegalArgumentException("Duplicate error for non terminal " + nonTerminal);
            }
            ArrayList<String> allValuesList = new ArrayList<>();
            for(String allValues : valueParts)
            {
                allValuesList.add(allValues.trim());
            }
            grammarMap.put(nonTerminal, allValuesList);
        }
    }

    // Contains will look through the keys and
    // return true or false depending on if it does
    // or does not contain that Key
    public boolean contains(String symbol)
    {
        return keys.contains(symbol);
    }

    // getSymbols will create a new Set of 
    // the different non terminal keys in the
    // list itself then return that set
    public Set<String> getSymbols() {
        Set<String> symbols = new HashSet<>();

        for (Map.Entry<String, ArrayList<String>> entry : grammarMap.entrySet()) {
            String nonTerminal = entry.getKey();
            symbols.add(nonTerminal);
            for (String production : entry.getValue()) {
                String[] parts = production.split("\\s+");
                for (String part : parts) {
                    if (part.startsWith("<") && part.endsWith(">")) {
                        symbols.add(part);
                    }
                }
            }
        }
        return symbols;
    }
    
    // generates based off of the symbols provided
    // the function will recurse and append every part
    // until it reached a terminal symbol then
    // returns the string.
    public String generate(String symbol) {
        if (symbol == null || symbol.length() == 0) {
            throw new IllegalArgumentException("Symbol cannot be null or empty");
        }

        if (!contains(symbol)) {
            return symbol;
        } else {
            ArrayList<String> productions = grammarMap.get(symbol);
            String randomProduction = productions.get(random.nextInt(productions.size()));
            String[] parts = randomProduction.split("\\s+");
            StringBuilder result = new StringBuilder();
            for (String part : parts) {
                result.append(generate(part)).append(" ");
            }
            return result.toString().trim();
        }
    }
}