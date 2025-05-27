package application;

import exceptions.UnknownStudentException;
import model.Student;
import utils.ConsoleUtils;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * PROGRAM: ApplicationWorkers
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class ApplicationWorkers {

    private static List<Student> studentsDB;

    public ApplicationWorkers(List<Student> studentsDB) {
        this.studentsDB = studentsDB;
    }

    public void createStudent() {
        System.out.println(System.lineSeparator() + "CREATE STUDENT.................." + System.lineSeparator());

        String name = enterStudentName();
        Double grade = enterStudentGrade();
        addStudent(name, grade);
    }

    private void addStudent(String name, Double grade) {
        studentsDB.add(new Student(name, grade));
        System.out.println("New student registered into the system.");
    }

    public void removeStudentByName() {
        System.out.println(System.lineSeparator() + "DELETE STUDENT.................." + System.lineSeparator());
        try {
            Student student = searchStudentByName(enterStudentName());
            removeStudent(student);
        } catch (UnknownStudentException e) {
            System.err.println("Error: " + e);
        }
    }

    private void removeStudent(Student student) {
        studentsDB.remove(student);
        System.out.println(
                "The student is deleted from the system: " + System.lineSeparator() + student);
    }

    private Student searchStudentByName(String studentSearch) throws UnknownStudentException {
        for (Student student : studentsDB) {
            if (student.getName().equalsIgnoreCase(studentSearch)) {
                return student;
            }
        }
        throw new UnknownStudentException();
    }

    public void showListStudents() {
        System.out.println(System.lineSeparator() + "STUDENTS LIST WITH ID..................");

        System.out.println(makeHeadLineStudents());
        for (Student student : studentsDB) {
            System.out.println(makeLineStudents(student.listStudent()));
        }

        double promedio = 0;
        for (Student student : studentsDB) {
            promedio += student.getGrade();
        }
        promedio /= studentsDB.size();
        System.out.println("Promedio: " + promedio);
    }

    private String makeHeadLineStudents() {
        ArrayList<String> dataLine = new ArrayList<>();

        dataLine.add("Name");
        dataLine.add("Grade");

        return makeLineStudents(dataLine);
    }

    private String makeLineStudents(ArrayList<String> dataLine) {
        int i = 0;

        return StringUtils.formatToChars(dataLine.get(i++), 15) + " \t " +
                StringUtils.formatToChars(dataLine.get(i), 6);
    }

    private String enterStudentName() {
        return ConsoleUtils.readRequiredString("Type student's name: ");
    }

    private Double enterStudentGrade() {
        return ConsoleUtils.readRequiredDouble("Type student's grade: ");
    }

}
