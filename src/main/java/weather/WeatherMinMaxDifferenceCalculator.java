package weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class WeatherMinMaxDifferenceCalculator {

    private final int NUMBER_OF_HEADER_LINES = 2;

    private final WeatherFileValueParser parser;

    private AtomicInteger difference;

    private AtomicInteger day;

    public WeatherMinMaxDifferenceCalculator() {
        this.parser = new WeatherFileValueParser();
    }

    public int getDayOfMinimumDifference(String path) {

        processWeatherFile(path);

        return day.get();
    }

    private void processWeatherFile(String path) {
        resetCompareValues();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().skip(NUMBER_OF_HEADER_LINES)
                    .filter(this::lineWithInvalidDayValue)
                    .forEach(this::calculateDifference);
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    private void resetCompareValues() {
        difference = new AtomicInteger(Integer.MAX_VALUE);
        day = new AtomicInteger(Integer.MAX_VALUE);
    }

    private boolean lineWithInvalidDayValue(String line) {
        return !line.contains("mo");
    }

    private void calculateDifference(String line) {
        String[] cutLine = cutLineBySpaces(line);
        int currentDifference = parser.getMinMaxDifference(cutLine);
        if (currentDifference < difference.get()) {
            difference.set(currentDifference);
            day.set(parser.getDay(cutLine));
        }
    }

    private String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }
}
