package weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherFileValueParserTest {

    private WeatherFileValueParser parser;
    private String[] weatherDataArray;

    @BeforeEach
    void beforeEach() {
        parser = new WeatherFileValueParser();
        weatherDataArray = new String[]{ "", "1", "88", "59"};
    }

    @Test
    void Given_WeatherDataLine_When_CalculateMinMaxDifference_Then_ReturnCorrectDifferenceValue() {
        int result = parser.calculateMinMaxDifference(weatherDataArray);
        assertEquals(result, 29);
    }

    @Test
    void Given_WeatherDataLine_When_GetDay_Then_ReturnCorrectDayValue() {
        int result = parser.getDay(weatherDataArray);
        assertEquals(result, 1);
    }
}