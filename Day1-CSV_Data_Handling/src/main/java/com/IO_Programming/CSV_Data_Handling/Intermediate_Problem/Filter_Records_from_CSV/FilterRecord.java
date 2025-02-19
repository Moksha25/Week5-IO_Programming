package com.IO_Programming.CSV_Data_Handling.Intermediate_Problem.Filter_Records_from_CSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FilterRecord
{
    public static void main (String args[])
    {
        String filepath = "src/main/java/com/IO_Programming/CSV_Data_Handling/Intermediate_Problem/Filter_Records_from_CSV/record.csv";

        try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(filepath)).withSkipLines(1).build())
        {
           List<String[]> filteredData = csvReader.readAll().stream().filter(row -> Integer.parseInt(row[3]) > 80).collect(Collectors.toList());
           filteredData.forEach(row -> System.out.println(String.join(" ", row)));
        }
        catch (IOException | CsvException e)
        {
            e.printStackTrace();
        }
    }
}
