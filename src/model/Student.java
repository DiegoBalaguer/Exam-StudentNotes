package model;

import java.util.ArrayList;

/**
 * PROGRAM: Student
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        setName(name);
        setGrade(grade);
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }
    public double getGrade() {
        return grade;
    }
    private void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        } else {
            this.grade = grade;
        }
    }
    public ArrayList<String> listStudent() {
        ArrayList<String> list = new ArrayList<>();

        list.add(this.name);
        list.add(String.valueOf(this.grade));

        return list;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
