package com.IO_Programming.CSV_Data_Handling.Intermediate_Problem.Sort_CSV_Records_by_Column;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SortRecord {

    public static void SortAndPrintTopSalaries(String filepath){
        try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(filepath)).withSkipLines(1).build()){
            List<String[]> allData = csvReader.readAll();

            allData.sort((a,b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

            System.out.println("---Top 5 highest-paid employees---");
            for(int i = 0; i < Math.min(5, allData.size()); i++){
                System.out.println("-> " + allData.get(i)[1]);
            }
        } catch (IOException | CsvException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filepath = "src/main/java/com/IO_Programming/CSV_Data_Handling/Intermediate_Problem/Sort_CSV_Records_by_Column/employee.csv";
        SortAndPrintTopSalaries(filepath);
    }
}