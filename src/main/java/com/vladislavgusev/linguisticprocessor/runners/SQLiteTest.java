package com.vladislavgusev.linguisticprocessor.runners;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CSVTest {
    private static final String PATH = "src\\main\\resources\\tables\\file.csv";

    public static void main(String[] args) throws IOException {

        Reader in = new FileReader(PATH);

        CSVParser parser = CSVParser.parse(in, CSVFormat.DEFAULT.withHeader());

        System.out.println(parser.getRecords());

        parser.getRecords().forEach(record -> {
            System.out.println(record.toString());
            System.out.println(record.toMap());
        });
    }
}
