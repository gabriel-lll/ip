package nerpbot;

/**
 * Ui class handles all interactions with the user.
 */
public class Ui {
    public String showWelcome() {
        return "Hello! I'm NerpBot :)\nWhat can I do for you?\nType 'help' if you're unsure what to say :D";
    }

    public String showHelp() {
        return "Opening help window... Type any message to continue chatting.";
    }

    public void showHelpWindow() {
        // This method would open a GUI help window in a full application.
    }

    public String showError(String message) {
        return "OOPSIE POOPSIE!!! " + message;
    }

    public String showExit() {
        return "Bye. Hope to see you again soon!";
    }
}
