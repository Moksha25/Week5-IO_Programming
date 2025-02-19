package com.IO_Programming.CSV_Data_Handling.Basic_Problems.Write_Data_to_CSV_File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployee
{
    public static void main (String args[])
    {
        String filePath = "src/main/java/com/IO_Programming/CSV_Data_Handling/Basic_Problems/Write_Data_to_CSV_File/employee.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104, Mokshini,software,50000\n");
            writer.write("105,Bhavesh,dietition,58000\n");
            System.out.println("CSV file written successfully!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
