import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DifferenceCalculator {

    int getMinimumDifference(String file) {
        int difference = Integer.MAX_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            skipHeaderLineReading(br);
            while ((line = br.readLine()) != null) {
                int currentDifference = getDifference(line);
                if (currentDifference < difference) difference = currentDifference;
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }

        return difference;
    }

    void skipHeaderLineReading(BufferedReader br) throws IOException {
        br.readLine();
    }

    int getDifference(String line) {
        String[] cut = line.split("\\s+");
        int difference = Integer.MAX_VALUE;

        if (cut.length > 1) difference = getMaxValue(cut) - getMinValue(cut);

        return difference;
    }

    int getMinValue(String[] cut) {
        return (int) Double.parseDouble(removeUnexpectedStarEnding(cut[3]));
    }

    int getMaxValue(String[] cut) {
        return (int) Double.parseDouble(removeUnexpectedStarEnding(cut[2]));
    }

    String removeUnexpectedStarEnding(String str) {
        return str.replace("*", "");
    }
}
