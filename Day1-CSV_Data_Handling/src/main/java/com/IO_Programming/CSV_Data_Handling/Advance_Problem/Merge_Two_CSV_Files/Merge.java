package com.IO_Programming.CSV_Data_Handling.Advance_Problem.Merge_Two_CSV_Files;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Merge {

    public static void mergeCSV(String file1, String file2){
        String outputFile = "src/main/java/com/IO_Programming/CSV_Data_Handling/Advance_Problem/Merge_Two_CSV_Files/studentsMerged.csv";

        Map<String, String[]> studentData = new HashMap<>();

        try(CSVReader reader1 = new CSVReaderBuilder(new FileReader(file1)).withSkipLines(1).build();
            CSVReader reader2 = new CSVReaderBuilder(new FileReader(file2)).withSkipLines(1).build();
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile))){

            List<String[]> data1 = reader1.readAll();
            for(String[] row: data1){
                studentData.put(row[0], row);
            }

            List<String[]> data2 = reader2.readAll();
            for(String[] row: data2){
                String id = row[0];
                if(studentData.containsKey(id)){
                    studentData.put(row[0], row);
                    String[] details = studentData.get(id);
                    studentData.put(id, new String[]{details[0], details[1], details[2], row[1], row[2]});
                }
            }

            //write merged data to a new csv file
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks"}); //header
            for(String[] row: studentData.values()){
                writer.writeNext(row);
            }
            System.out.println("CSV files merged successfully into " + outputFile);
        } catch (IOException | CsvException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String file1 = "src/main/java/com/IO_Programming/CSV_Data_Handling/Advance_Problem/Merge_Two_CSV_Files/student1.csv";
        String file2 = "src/main/java/com/IO_Programming/CSV_Data_Handling/Advance_Problem/Merge_Two_CSV_Files/student2.csv";
        mergeCSV(file1, file2);
    }
}