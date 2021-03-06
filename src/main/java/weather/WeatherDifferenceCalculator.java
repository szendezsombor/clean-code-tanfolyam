package weather;

import base.DifferenceCalculator;

import java.util.stream.Stream;

public class WeatherDifferenceCalculator extends DifferenceCalculator {

    public WeatherDifferenceCalculator(String path) {
        super(path, 2);
    }

    public int getDayOfTemperatureMinimumDifference() {
        return findSmallest(this.parser.readFileLines().stream());
    }

    private int findSmallest(Stream<String> lines) {
        return lines.skip(NUMBER_OF_HEADER_LINES)
                .filter(this::lineWithInvalidDayValue)
                .map(WeatherDifferenceData::of)
                .sorted(this::sortByDifference)
                .findFirst()
                .orElseThrow()
                .getDay();
    }

    private boolean lineWithInvalidDayValue(String line) {
        return !line.contains("mo");
    }


}
