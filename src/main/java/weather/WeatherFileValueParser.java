package weather;

public class WeatherFileValueParser {

    private final int DAY_VALUE_PLACE = 1;
    private final int MIN_VALUE_PLACE = 2;
    private final int MAX_VALUE_PLACE = 3;

    public int getDay(String[] cut) {
        return parseStrToInt(cut[DAY_VALUE_PLACE]);
    }

    public int getMinMaxDifference(String[] cut) {
        return getMaxValue(cut) - getMinValue(cut);
    }

    private int getMinValue(String[] cut) {
        return parseStrToInt(cut[MAX_VALUE_PLACE]);
    }

    private int getMaxValue(String[] cut) {
        return parseStrToInt(cut[MIN_VALUE_PLACE]);
    }

    private int parseStrToInt(String str) {
        return (int) Double.parseDouble(removeUnexpectedStarEnding(str));
    }

    private String removeUnexpectedStarEnding(String str) {
        return str.replace("*", "");
    }
}
