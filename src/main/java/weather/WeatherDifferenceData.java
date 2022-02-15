package weather;

import base.DifferenceData;

public class WeatherDifferenceData extends DifferenceData {

    private final int DAY_VALUE_PLACE = 1;

    private final int MIN_VALUE_PLACE = 3;

    private final int MAX_VALUE_PLACE = 2;

    private int day;

    private int min;

    private int max;

    public WeatherDifferenceData(String line) {
        String[] cut = cutLineBySpaces(line);

        this.min = parseStrToInt(cut[MIN_VALUE_PLACE]);
        this.max = parseStrToInt(cut[MAX_VALUE_PLACE]);
        this.day = parseStrToInt(cut[DAY_VALUE_PLACE]);
        this.difference = this.max - this.min;
    }

    public static WeatherDifferenceData of(String line) {
        return new WeatherDifferenceData(line);
    }

    private int parseStrToInt(String str) {
        return (int) Double.parseDouble(removeUnexpectedStarEnding(str));
    }

    private String removeUnexpectedStarEnding(String str) {
        return str.replace("*", "");
    }



    public int getDay() {
        return day;
    }

}
