package nerpbot;

/**
 * Ui class handles all interactions with the user.
 */
public class Ui {
    public String showWelcome() {
        return "Hello! I'm nerpbot.NerpBot\nWhat can I do for you?";
    }

    public String showError(String message) {
        return "OOPSIE POOPSIE!!! " + message;
    }

    public String showExit() {
        return "Bye. Hope to see you again soon!";
    }
}
