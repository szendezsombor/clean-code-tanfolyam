import football.Football;
import weather.Weather;

public class Main {

    public static void main(String[] args) {
        String footballDatFilePath = "C:\\learn\\clean-code-tanfolyam\\src\\main\\resources\\football.dat";
        String weatherDatFilePath = "C:\\learn\\clean-code-tanfolyam\\src\\main\\resources\\weather.dat";

        int day = new Weather(weatherDatFilePath).getDayOfTemperatureMinimumDifference();
        System.out.println("Day of the minimum difference: " + day);
        String teamName = new Football(footballDatFilePath).getFootballTeamWithMinDifference();
        System.out.println("Football team of min score difference: " + teamName);
    }
}
