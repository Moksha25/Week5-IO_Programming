package com.IO_Programming.CSV_Data_Handling.Advance_Problem.Convert_CSV_Data_into_Java_Objects;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Conversion {

    public static List<Student> readCSV(String filepath){
        List<Student> studentsList = new ArrayList<>();

        try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(filepath)).withSkipLines(1).build()){
            List<String[]> allData = csvReader.readAll();

            for(String[] row: allData){
                int id = Integer.parseInt(row[0]);
                String name = row[1];
                int age = Integer.parseInt(row[2]);
                double marks = Double.parseDouble(row[3]);

                studentsList.add(new Student(id, name, age, marks));
            }
        } catch (IOException | CsvException e){
            e.printStackTrace();
        }
        return studentsList;
    }

    public static void main(String[] args){
        String filepath = "src/main/java/com/IO_Programming/CSV_Data_Handling/Advance_Problem/Convert_CSV_Data_into_Java_Objects/student.csv";
        List<Student> students = readCSV(filepath);

        students.forEach(System.out::println);
    }
}