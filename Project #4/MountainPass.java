import java.util.*;
import java.io.*;

public class MountainPass {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("File Name? ");
        Scanner filename = new Scanner(System.in);
        Location.readCsvWithSplit(filename.nextLine());
    }
}