package nerpbot;

import nerpbot.task.Deadline;
import nerpbot.task.Event;
import nerpbot.task.ToDo;

import java.io.IOException;

/**
 * Represents the main chatbot class that handles user interaction,
 * command parsing, and overall application flow.
 */
public class NerpBot {
    private final Storage storage;
    private final TaskList taskList;
    private final Ui ui;

    public NerpBot(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        TaskList tempTaskList;
        try {
            tempTaskList = new TaskList(storage.load(), storage);
        } catch (IOException e) {
            ui.showError(e.getMessage());
            tempTaskList = new TaskList(storage);
        }
        this.taskList = tempTaskList;
    }

    /**
     * Processes the user's input and returns the chatbot's response.
     *
     * @param input The user's command as a string.
     * @return The chatbot's response.
     */
    public String getResponse(String input) {
        ui.showWelcome();

        try {
            String commandWord = Parser.getCommandWord(input);
            String commandArgs = Parser.getCommandArgs(input);

            switch (commandWord) {
                case "bye":
                    return ui.showExit();
                case "list":
                    return taskList.listTasks();
                case "mark": {
                    int idx = Integer.parseInt(commandArgs) - 1;
                    return taskList.markTask(idx);
                }
                case "unmark": {
                    int idx = Integer.parseInt(commandArgs) - 1;
                    return taskList.unmarkTask(idx);
                }
                case "delete": {
                    int idx = Integer.parseInt(commandArgs) - 1;
                    return taskList.deleteTask(idx);
                }
                case "todo": {
                    if (commandArgs.isBlank()) {
                        throw new NerpBotException("you didn't provide a description for the todo.");
                    }
                    return taskList.addTask(new ToDo(commandArgs));
                }
                case "deadline": {
                    String[] parts = commandArgs.split(" /by ", 2);
                    return taskList.addTask(new Deadline(parts[0], parts[1]));
                }
                case "event": {
                    String[] parts = commandArgs.split(" /from | /to ", 3);
                    return taskList.addTask(new Event(parts[0], parts[1], parts[2]));
                }
                case "find": {
                    if (commandArgs.isBlank()) {
                        throw new NerpBotException("you didn't provide a keyword to search for.");
                    }
                    return taskList.findTasks(commandArgs);
                }
                default:
                    throw new NerpBotException("idk what that means.");
            }
        } catch (Exception e) {
            return ui.showError(e.getMessage());
        }
    }
}
