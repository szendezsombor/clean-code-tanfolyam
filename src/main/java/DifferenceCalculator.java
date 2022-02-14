import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DifferenceCalculator {

    int DAY_VALUE_PLACE = 1;
    int MIN_VALUE_PLACE = 2;
    int MAX_VALUE_PLACE = 3;

    int getDayOfMinimumDifference(String file) {
        int difference = Integer.MAX_VALUE;
        int day = Integer.MAX_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            skipHeaderLineReading(br);
            while ((line = br.readLine()) != null) {
                String[] cut = cutLineBySpaces(line);
                int currentDifference = getDifference(cut);
                if (currentDifference < difference)  {
                    difference = currentDifference;
                    day = getDay(cut);
                }
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }

        return day;
    }

    void skipHeaderLineReading(BufferedReader br) throws IOException {
        br.readLine();
    }

    String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }

    int getDifference(String[] cut) {

        int difference = Integer.MAX_VALUE;

        if (cut.length > 1) difference = getMaxValue(cut) - getMinValue(cut);

        return difference;
    }

    int getDay(String[] cut) {
        return (int) Double.parseDouble(removeUnexpectedStarEnding(cut[DAY_VALUE_PLACE]));
    }

    int getMinValue(String[] cut) {
        return (int) Double.parseDouble(removeUnexpectedStarEnding(cut[MAX_VALUE_PLACE]));
    }

    int getMaxValue(String[] cut) {
        return (int) Double.parseDouble(removeUnexpectedStarEnding(cut[MIN_VALUE_PLACE]));
    }

    String removeUnexpectedStarEnding(String str) {
        return str.replace("*", "");
    }
}
