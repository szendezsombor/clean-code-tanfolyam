package football;

public class FootballData {

    private final int MIN_PLACE = 9;
    private final int MAX_PLACE = 7;
    private final int TEAM_NAME_PLACE = 2;

    private int min;
    private int max;
    private int difference;
    private String teamName;

    public FootballData(String[] cut) {
        this.teamName = cut[TEAM_NAME_PLACE];
        this.max = Integer.parseInt(cut[MAX_PLACE]);
        this.min = Integer.parseInt(cut[MIN_PLACE]);
        this.difference = this.max - this.min;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
