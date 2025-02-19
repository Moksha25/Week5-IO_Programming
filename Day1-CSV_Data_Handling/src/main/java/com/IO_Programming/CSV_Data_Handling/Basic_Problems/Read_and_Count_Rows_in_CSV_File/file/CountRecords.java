package com.IO_Programming.CSV_Data_Handling.Basic_Problems.Read_and_Count_Rows_in_CSV_File.file;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CountRecords
{
    public static void main (String []args)
    {
        String filepath = "src/main/java/com/IO_Programming/CSV_Data_Handling/Basic_Problems/Read_and_Count_Rows_in_CSV_File/file/record.csv";

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filepath)).withSkipLines(1).build())
        {
            List<String[]> alldata = csvReader.readAll();

            System.out.println("NUmber of records in file : " + alldata.size());
        }
        catch (IOException | CsvException e)
        {
            e.printStackTrace();
        }
    }
}
