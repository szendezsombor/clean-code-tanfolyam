package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileParser {

    private final String path;

    public FileParser(String path) {
        this.path = path;
    }

    public List<String> readFileLines() {
        try (Stream<String> lines = Files.lines(Path.of(path))) {
            return lines.toList();
        } catch (IOException exception) {
            System.out.println(exception);
        }
        return null;
    }

}
