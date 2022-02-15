package base;

import file.FileParser;

public class DifferenceCalculator {

    protected final int NUMBER_OF_HEADER_LINES;

    protected FileParser parser;

    public DifferenceCalculator(String path, int NUMBER_OF_HEADER_LINES) {
        this.parser = new FileParser(path);
        this.NUMBER_OF_HEADER_LINES = NUMBER_OF_HEADER_LINES;
    }
}
