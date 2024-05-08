import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class MountainPass {

    public static int[][] mountainData;
    private static Location peakLocation;
    private static Location lowestLocation;

    public static void main(String[] args) throws FileNotFoundException {
        Location location = new Location();
        System.out.print("File Name? ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        scanner.close();
        readCsvWithSplit(filename);
        DrawingPanel panel = new DrawingPanel(mountainData[0][0], mountainData[0][1]);
        Graphics g = panel.getGraphics();
        peakLocation = new Location().peak();
        lowestLocation = new Location().valley();
        drawElevationMap(g, mountainData);
        drawHighestPoint(g);
    }

    public static void readCsvWithSplit(String filename) throws FileNotFoundException {
        List<int[]> tempList = new ArrayList<>();
        Scanner filedata = new Scanner(new File(filename));
        int rowCount = 0;
        while (filedata.hasNextLine()) {
            String line = filedata.nextLine();
            String[] stringArray = line.split(",");
            int[] row = new int[stringArray.length];
            for (int i = 0; i < row.length; i++) {
                row[i] = Integer.parseInt(stringArray[i]);
            }
            tempList.add(row);
            rowCount++;
        }
        mountainData = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            mountainData[i] = tempList.get(i);
        }
    }

    public static void drawElevationMap(Graphics g, int[][] elevationData) {
        int minElevation = lowestLocation.getElevation();
        int maxElevation = peakLocation.getElevation();
        for (int i = 1; i < elevationData.length; i++) {
            for (int j = 0; j < elevationData[i].length; j++) {
                int grayValue = computeGrayValue(elevationData[i][j], minElevation, maxElevation);
                g.setColor(new Color(grayValue, grayValue, grayValue));
                g.fillRect(j, i, 1, 1);
            }
        }
    }

    public static void drawHighestPoint(Graphics g) {
        g.setColor(new Color(255, 0, 0));
        g.fillRect(peakLocation.getX(), peakLocation.getY(), 1, 1);
    }

    public static int computeGrayValue(int elevation, int minElevation, int maxElevation) {
        return (int) (255.0 * (elevation - minElevation) / (maxElevation - minElevation));
    }
}
