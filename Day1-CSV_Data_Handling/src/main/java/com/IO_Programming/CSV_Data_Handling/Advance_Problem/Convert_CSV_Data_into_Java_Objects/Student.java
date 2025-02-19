package com.IO_Programming.CSV_Data_Handling.Advance_Problem.Convert_CSV_Data_into_Java_Objects;

public class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks){
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + "'" +
                ", Age=" + age +
                ", Marks=" + marks +
                "}";
    }
}