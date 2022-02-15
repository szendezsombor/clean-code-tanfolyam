package base;

public class DifferenceData {

    protected int difference;

    public int getDifference() {
        return difference;
    }

    protected String[] cutLineBySpaces(String line) {
        return line.split("\\s+");
    }
}
