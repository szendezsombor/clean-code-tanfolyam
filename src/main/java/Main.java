import weather.WeatherMinMaxDifferenceCalculator;

public class Main {

    public static void main(String[] args) {
        int day = new WeatherMinMaxDifferenceCalculator().getDayOfMinimumDifference("C:\\learn\\clean-code-tanfolyam\\src\\main\\resources\\weather.dat");
        System.out.println("Day of the minimum difference: " + day);
    }
}
