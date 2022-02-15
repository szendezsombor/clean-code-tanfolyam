package weather;

import base.DifferenceCalculator;

import java.util.stream.Stream;

public class WeatherMinMaxDifferenceCalculator extends DifferenceCalculator {

    public WeatherMinMaxDifferenceCalculator(String path) {
        super(path, 2);
    }

    public int getDayOfMinimumDifference() {
        return findSmallest(this.parser.readFileLines().stream());
    }

    private int findSmallest(Stream<String> lines) {
        return lines.skip(NUMBER_OF_HEADER_LINES)
                .filter(this::lineWithInvalidDayValue)
                .map(WeatherData::of)
                .sorted(this::sortByDifference)
                .findFirst()
                .orElseThrow()
                .getDay();
    }

    private int sortByDifference(WeatherData w1, WeatherData w2) {
        return Integer.compare(w1.getDifference(), w2.getDifference());
    }

    private boolean lineWithInvalidDayValue(String line) {
        return !line.contains("mo");
    }


}
