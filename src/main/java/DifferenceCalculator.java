import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class DifferenceCalculator {
    private final int NUMBER_OF_HEADER_LINES = 2;

    private final ValueProcessor processor;
    private AtomicInteger difference;
    private AtomicInteger day;


    public DifferenceCalculator() {
        this.processor = new ValueProcessor();
    }

    public int getDayOfMinimumDifference(String path) {
        resetValues();

        try (BufferedReader br = loadFile(path)) {
            Stream<String> lines = getFileContent(br);

            lines.forEach(this::processLine);

        } catch (IOException exception) {
            handleFileLoadException(exception);
        }
        return day.get();
    }

    private void resetValues() {
        difference = new AtomicInteger(Integer.MAX_VALUE);
        day = new AtomicInteger(Integer.MAX_VALUE);
    }

    private void processLine(String line) {
        String[] cutLine = cutLineBySpaces(line);
        int currentDifference = processor.getMinMaxDifference(cutLine);
        if (currentDifference < difference.get())  {
            difference.set(currentDifference);
            day.set(processor.getDay(cutLine));
        }

    }

    private BufferedReader loadFile(String path) throws FileNotFoundException {
        return new BufferedReader(new FileReader(path));
    }

    private void handleFileLoadException(IOException exception) {
        System.out.println(exception);
    }

    private Stream<String> getFileContent(BufferedReader br) throws IOException {
        return br.lines().skip(NUMBER_OF_HEADER_LINES);
    }

    private String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }
}
