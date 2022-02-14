package weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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

        try (Stream<String> lines = Files.lines(Path.of(path))) {
            findSmallest(lines);
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    private void findSmallest(Stream<String> lines) {
        lines.skip(NUMBER_OF_HEADER_LINES)
                .filter(this::lineWithInvalidDayValue)
                .forEach(this::calculateDifference);
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
        int currentDifference = parser.calculateMinMaxDifference(cutLine);
        if (currentDifference < difference.get()) {
            difference.set(currentDifference);
            day.set(parser.getDay(cutLine));
        }
    }

    private String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }
}
