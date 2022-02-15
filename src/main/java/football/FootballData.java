package football;

import base.DifferenceData;

public class FootballData extends DifferenceData {

    private final int MIN_PLACE = 9;
    private final int MAX_PLACE = 7;
    private final int TEAM_NAME_PLACE = 2;

    private int min;
    private int max;
    private String teamName;

    public FootballData(String line) {
        String[] cut = cutLineBySpaces(line);

        this.teamName = cut[TEAM_NAME_PLACE];
        this.max = Integer.parseInt(cut[MAX_PLACE]);
        this.min = Integer.parseInt(cut[MIN_PLACE]);
        this.difference = Math.abs(this.max - this.min);
    }

    public static FootballData of(String line) {
        return new FootballData(line);
    }

    public String getTeamName() {
        return teamName;
    }
}
