package exceptions;

/**
 * PROGRAM: UnknownStudentException
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class UnknownStudentException extends Exception {
    public UnknownStudentException() {
        super("Unknown student on the system");
    }
}
