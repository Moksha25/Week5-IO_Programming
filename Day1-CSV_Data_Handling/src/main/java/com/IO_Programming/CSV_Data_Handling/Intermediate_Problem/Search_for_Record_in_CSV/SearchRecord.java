package com.IO_Programming.CSV_Data_Handling.Intermediate_Problem.Search_for_Record_in_CSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class SearchRecord
{
    public static void searchRecord(String filepath, String key) {

        //Approach 1 -> Using streams
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filepath)).withSkipLines(1).build()) {

            List<String[]> filteredData = csvReader.readAll().stream().filter(row -> row[1].equalsIgnoreCase(key)).collect(Collectors.toList());

            if (filteredData.isEmpty()) {
                System.out.println("No record with name '" + key + "' found");
            } else {
                System.out.println("Record found for '" + key);
                filteredData.forEach(row -> System.out.println(row[2] + " " + row[3]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filepath = "src/main/java/com/IO_Programming/CSV_Data_Handling/Intermediate_Problem/Search_for_Record_in_CSV/employee.csv";
        String key = "ria";
        searchRecord(filepath, key);
    }
}
