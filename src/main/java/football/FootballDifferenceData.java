package football;

import base.DifferenceData;

public class FootballDifferenceData extends DifferenceData {

    private final int MIN_PLACE = 9;
    private final int MAX_PLACE = 7;
    private final int TEAM_NAME_PLACE = 2;

    private int min;
    private int max;
    private String teamName;

    public FootballDifferenceData(String line) {
        String[] cut = cutLineBySpaces(line);

        this.teamName = cut[TEAM_NAME_PLACE];
        this.max = Integer.parseInt(cut[MAX_PLACE]);
        this.min = Integer.parseInt(cut[MIN_PLACE]);
        this.difference = Math.abs(this.max - this.min);
    }

    public static FootballDifferenceData of(String line) {
        return new FootballDifferenceData(line);
    }

    public String getTeamName() {
        return teamName;
    }
}
