package football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Football {

    private final int HEADER_LINES_NO = 1;
    private List<FootballData> data = new ArrayList<>();

    public String calculateMinDifference(String path) {
        try (Stream<String> lines = Files.lines(Path.of(path))) {
            return findMinDifferenceFootballTeam(lines);
        } catch (IOException exception) {
            System.out.println(exception);
        }

        return "";
    }

    String findMinDifferenceFootballTeam(Stream<String> lines) {
        lines.skip(HEADER_LINES_NO)
                .filter(this::invalidLine)
                .forEach(this::createFootballData);

        return data.stream()
                .sorted(this::sortByScoreDifference)
                .findFirst()
                .get()
                .getTeamName();
    }

    private int sortByScoreDifference(FootballData f1, FootballData f2) {
        return Integer.compare(f1.getDifference(), f2.getDifference());
    }

    private boolean invalidLine(String line) {
        return !line.contains("-------");
    }

    private void createFootballData(String line) {
        data.add(new FootballData(cutLineBySpaces(line)));
    }

    private String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }
}
