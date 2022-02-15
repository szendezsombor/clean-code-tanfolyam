package football;

import base.DifferenceCalculator;

import java.util.stream.Stream;

public class Football extends DifferenceCalculator {

    public Football(String path) {
        super(path, 1);
    }

    public String getFootballTeamWithMinDifference() {
        return findMinDifferenceFootballTeam(parser.readFileLines().stream());
    }

    String findMinDifferenceFootballTeam(Stream<String> lines) {
        return lines.skip(NUMBER_OF_HEADER_LINES)
                .filter(this::invalidLine)
                .map(FootballData::of)
                .sorted(this::sortByDifference)
                .findFirst()
                .orElseThrow()
                .getTeamName();
    }

    private boolean invalidLine(String line) {
        return !line.contains("-------");
    }
}
