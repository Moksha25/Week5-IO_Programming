package com.IO_Programming.CSV_Data_Handling.Basic_Problems.Read_CSV_File_and_Print_Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudent
{
    public static void main (String args[])
    {
        String filepath = "src/main/java/com/IO_Programming/CSV_Data_Handling/Basic_Problems/Read_CSV_File_and_Print_Data/student.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] columns = line.split(",");
                System.out.println("Id : " + columns[0] + ", Name : " + columns[1] + ", Age : " + columns[2] + ", Marks : " + columns[3]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
