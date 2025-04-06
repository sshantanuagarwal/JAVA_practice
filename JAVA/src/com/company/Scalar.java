package com.company;

import javax.naming.directory.InvalidAttributesException;

class Parser {
//    void parser() {
//
//    }

}
class JsonParser extends Parser {

}

class CSVParser extends Parser{

}

class JsonLineParser extends Parser {

}
public class Scalar {
    public static Parser getParserFactory(String inputFileType) throws InvalidAttributesException {
        switch (inputFileType) {
            case "CSV":
                return new CSVParser();
            case "JSON":
                return new JsonParser();
            case "JSONLINES":
                return new JsonLineParser();
            default:
                throw new InvalidAttributesException("No valid parser for this input file");
        }
    }

    public static void main(String[] args) throws InvalidAttributesException {
        getParserFactory("CSV");
    }
}
