package nerpbot;

import nerpbot.task.Deadline;
import nerpbot.task.Event;
import nerpbot.task.ToDo;

import java.io.IOException;

public class NerpBot {
  private final Storage storage;
  private final TaskList taskList;
  private final Ui ui;

  /**
   * Constructor for NerpBot.
   *
   * @param filePath The file path where tasks are stored.
   */
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
   * The main run loop of NerpBot.
   * It reads user commands and executes them until the user decides to exit.
   */
  public void run() {
    ui.showWelcome();
    boolean isExit = false;

    while (!isExit) {
      try {
        String fullCommand = ui.readCommand();
        String commandWord = Parser.getCommandWord(fullCommand);
        String commandArgs = Parser.getCommandArgs(fullCommand);

        ui.showLine();

        switch (commandWord) {
          case "bye":
            ui.showExit();
            isExit = true;
            break;
          case "list":
            taskList.listTasks();
            break;
          case "mark":
            int idx = Integer.parseInt(commandArgs) - 1;
            taskList.markTask(idx);
            break;
          case "unmark":
            idx = Integer.parseInt(commandArgs) - 1;
            taskList.unmarkTask(idx);
            break;
          case "delete":
            idx = Integer.parseInt(commandArgs) - 1;
            taskList.deleteTask(idx);
            break;
          case "todo":
            if (commandArgs.isBlank()) {
              throw new NerpBotException("you didn't provide a description for the todo.");
            }
            taskList.addTask(new ToDo(commandArgs));
            break;
          case "deadline": {
            String[] parts = commandArgs.split(" /by ", 2);
            taskList.addTask(new Deadline(parts[0], parts[1]));
            break;
          }
          case "event": {
            String[] parts = commandArgs.split(" /from | /to ", 3);
            taskList.addTask(new Event(parts[0], parts[1], parts[2]));
            break;
          }
          default:
            throw new NerpBotException("idk what that means.");
        }
      } catch (Exception e) {
        ui.showError(e.getMessage());
      } finally {
        ui.showLine();
      }
    }
  }

  public static void main(String[] args) {
    new NerpBot("data/nerpbot.txt").run();
  }
}
