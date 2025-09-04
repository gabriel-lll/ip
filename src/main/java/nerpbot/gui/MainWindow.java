package nerpbot.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import nerpbot.NerpBot;

/**
 * Controller for the MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private NerpBot nerpBot;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.jpeg"));
    private final Image botImage = new Image(this.getClass().getResourceAsStream("/images/DaNerpBot.jpeg"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setNerpBot(NerpBot nerpBot) {
        this.nerpBot = nerpBot;
    }

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = nerpBot.getResponse(input);  // You need to implement this method
        dialogContainer.getChildren().addAll(DialogBox.getUserDialog(input, userImage), DialogBox.getNerpBotDialog(response, botImage));
        userInput.clear();
    }
}
