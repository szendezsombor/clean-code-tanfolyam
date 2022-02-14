import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        new Main().readFile("C:\\learn\\clean-code-tanfolyam\\src\\main\\resources\\weather.dat");
    }

    void readFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                getDifference(line);
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    int getDifference(String line) {
        String[] cut = line.split("\\s+");
        int difference = 500000;
        if (cut.length > 1) {
            int currentDifference = getMaxValue(cut) - getMinValue(cut);
            if (currentDifference < difference) difference = currentDifference;
        }

        return difference;
    }

    int getMinValue(String[] cut) {
        return Integer.parseInt(removeUnexpectedStarEnding(cut[2]));
    }

    int getMaxValue(String[] cut) {
        return Integer.parseInt(removeUnexpectedStarEnding(cut[1]));
    }

    String removeUnexpectedStarEnding(String str) {
        return str.replace('*', '');
    }
}
