package enums;

/**
 * PROGRAM: OptionsMenuMain
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public enum OptionsMenuMain {

    STUDENT_CREATE("Create student"),
    STUDENT_DELETE("Delete student"),
    STUDENT_LIST("List student"),
    EXIT("Exit");

    private final String DESCRIPTION;

    // Constructor del enum
    OptionsMenuMain(String description) {
        this.DESCRIPTION = description;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public static void viewMenu() {
        System.out.println(System.lineSeparator() + "STUDENTS" + System.lineSeparator());
        for (OptionsMenuMain optionMenu : OptionsMenuMain.values()) {
            System.out.println(optionMenu.ordinal() + 1 + ". " + optionMenu.getDESCRIPTION());
        }
        System.out.println(System.lineSeparator() + "Choose an option: ");
    }
}
