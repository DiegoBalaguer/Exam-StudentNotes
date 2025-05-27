package application;

import enums.OptionsMenuMain;
import model.Student;
import utils.ConsoleUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * PROGRAM: ApplicationController
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class ApplicationController {

    private static List<Student> studentsDB;
    private ApplicationWorkers applicationManager;

    public void run() {
        studentsDB = new ArrayList<Student>();
        applicationManager = new ApplicationWorkers(studentsDB);
        menu();
        ConsoleUtils.closeScanner();
    }

    private void menu() {
        do {
            OptionsMenuMain.viewMenu();
            int answer = ConsoleUtils.readRequiredInt("");
            try {
                OptionsMenuMain idMenu = OptionsMenuMain.values()[answer - 1];
                if (idMenu == OptionsMenuMain.EXIT) {
                    return;
                }
                else menuOptionsWithoutStudents(idMenu);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: The value is wrong.");
            }
        } while (true);
    }

    private void menuOptionsWithoutStudents(OptionsMenuMain idMenu) {
        switch (idMenu) {
            case STUDENT_CREATE -> applicationManager.createStudent();
            default -> {
                if (studentsDB.isEmpty()) {
                    System.out.println("No students registered into the system.");
                } else menuOptionsWithStudents(idMenu);
            }
        }
    }

    private void menuOptionsWithStudents(OptionsMenuMain idMenu) {
        switch (idMenu) {
            case STUDENT_DELETE -> applicationManager.removeStudentByName();
            case STUDENT_LIST -> applicationManager.showListStudents();
            default -> System.out.println("Error: The value is wrong.");
        }
    }
}
