package weather;

public class WeatherData {

    private final int DAY_VALUE_PLACE = 1;

    private final int MIN_VALUE_PLACE = 3;

    private final int MAX_VALUE_PLACE = 2;

    private int day;

    private int min;

    private int max;

    private int difference;

    public WeatherData(String line) {
        String[] cut = cutLineBySpaces(line);

        this.min = parseStrToInt(cut[MIN_VALUE_PLACE]);
        this.max = parseStrToInt(cut[MAX_VALUE_PLACE]);
        this.day = parseStrToInt(cut[DAY_VALUE_PLACE]);
        this.difference = this.max - this.min;
    }

    public static WeatherData of(String line) {

        return new WeatherData(line);
    }

    private int parseStrToInt(String str) {
        return (int) Double.parseDouble(removeUnexpectedStarEnding(str));
    }

    private String removeUnexpectedStarEnding(String str) {
        return str.replace("*", "");
    }

    private String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }

    public int getDay() {
        return day;
    }

    public int getDifference() {
        return difference;
    }
}
