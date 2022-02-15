package football;

import file.FileParser;

import java.util.stream.Stream;

public class Football {

    private final int HEADER_LINES_NO = 1;
    private final FileParser parser;

    public Football(String path) {
        parser = new FileParser(path);
    }

    public String getFootballTeamWithMinDifference() {
        return findMinDifferenceFootballTeam(parser.readFileLines().stream());
    }

    String findMinDifferenceFootballTeam(Stream<String> lines) {
        return lines.skip(HEADER_LINES_NO)
                .filter(this::invalidLine)
                .map(this::createFootballData)
                .sorted(this::sortByScoreDifference)
                .findFirst()
                .orElseThrow()
                .getTeamName();

    }

    private int sortByScoreDifference(FootballData f1, FootballData f2) {
        return Integer.compare(f1.getDifference(), f2.getDifference());
    }

    private boolean invalidLine(String line) {
        return !line.contains("-------");
    }

    private FootballData createFootballData(String line) {
        return new FootballData(cutLineBySpaces(line));
    }

    private String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }
}
