package nerpbot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Ui class handles all interactions with the user.
 */
public class Ui {
    private Stage helpStage;

    public String showWelcome() {
        return "Hello! I'm NerpBot :)\nWhat can I do for you?\nType 'help' if you're unsure what to say :D";
    }

    public String showHelp() {
        return "Opening help window... Type any message to continue chatting.";
    }

    public void showHelpWindow() {
        // This method would open a GUI help window in a full application.
        try {
            // Create help window if it doesn't exist
            if (helpStage == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HelpWindow.fxml"));
                Parent root = loader.load();

                helpStage = new Stage();
                helpStage.setTitle("NerpBot Help");
                helpStage.setScene(new Scene(root));
                helpStage.setResizable(false);
                helpStage.initModality(Modality.NONE); // Non-modal so user can interact with main window
            }

            if (!helpStage.isShowing()) {
                helpStage.show();
            } else {
                helpStage.toFront();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String showError(String message) {
        return "OOPSIE POOPSIE!!! " + message;
    }

    public String showExit() {
        return "Bye. Hope to see you again soon!";
    }
}
