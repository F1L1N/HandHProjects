package com.example.user.app1;

public class Student {

    private long ID;
    private String name;
    private String surname;
    private String grade;
    private int date;

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGrade() {
        return grade;
    }

    public int getDate() {
        return date;
    }

    public Student(long ID, String name, String surname, String grade, int date) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.date = date;
    }

    public String toString() {
        return "--------------------\n" +
                "ID: " + ID + "\n" +
                "Surname: " + surname + "\n" +
                "Name: " + name + "\n" +
                "Grade: " + grade + "\n" +
                "Date: " + date + "\n";
    }
}
