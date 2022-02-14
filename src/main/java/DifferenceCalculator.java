import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DifferenceCalculator {

    private ValueProcessor processor;

    public DifferenceCalculator() {
        this.processor = new ValueProcessor();
    }

    public int getDayOfMinimumDifference(String path) {
        int difference = Integer.MAX_VALUE;
        int day = Integer.MAX_VALUE;

        try (BufferedReader br = loadFile(path)) {
            String line;
            skipHeadersLineReading(br);

            while ((line = br.readLine()) != null) {
                String[] cutLine = cutLineBySpaces(line);
                int currentDifference = processor.getMinMaxDifference(cutLine);

                if (currentDifference < difference)  {
                    difference = currentDifference;
                    day = processor.getDay(cutLine);
                }
            }
        } catch (IOException exception) {
            handleFileLoadException(exception);
        }

        return day;
    }

    private BufferedReader loadFile(String path) throws FileNotFoundException {
        return new BufferedReader(new FileReader(path));
    }

    private void handleFileLoadException(IOException exception) {
        System.out.println(exception);
    }

    private void skipHeadersLineReading(BufferedReader br) throws IOException {
        br.readLine();
        br.readLine();
    }

    private String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }
}
