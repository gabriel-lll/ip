import java.io.IOException;
import java.util.Scanner;

public class NerpBot {
  private static void printDivider() {
      System.out.println("______________________________");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Storage storage = new Storage("data/nerpbot.txt");
    TaskList taskList;
    try {
      taskList = new TaskList(storage.load(), storage);
    } catch (IOException e) {
      System.out.println("Failed to load tasks: " + e.getMessage());
      taskList = new TaskList(storage);
    }

    printDivider();
    System.out.println("Hello! I'm NerpBot");
    System.out.println("What can I do for you?");
    printDivider();

    while (true) {
      String command = scanner.nextLine();
      String[] words = command.split(" ", 2);

      try {
        if (command.equals("bye")) {
          printDivider();
          System.out.println("Bye. Hope to see you again soon!");
          printDivider();
          break;
        } else if (command.equals("list")) {
          printDivider();
          taskList.listTasks();
          printDivider();
        } else if (words[0].equals("mark")) {
          printDivider();
          int idx = Integer.parseInt(words[1]) - 1;
          taskList.markTask(idx);
          printDivider();
        } else if (words[0].equals("unmark")) {
          printDivider();
          int idx = Integer.parseInt(words[1]) - 1;
          taskList.unmarkTask(idx);
          printDivider();
        } else if (words[0].equals("todo")) {
          if (words.length < 2 || words[1].isBlank()) {
            throw new NerpBotException("you didn't provide a description for the todo.");
          }
          printDivider();
          taskList.addTask(new ToDo(words[1]));
          printDivider();
        } else if (words[0].equals("deadline")) {
          printDivider();
          String[] parts = words[1].split(" /by ", 2);
          taskList.addTask(new Deadline(parts[0], parts[1]));
          printDivider();
        } else if (words[0].equals("event")) {
          printDivider();
          String[] parts = words[1].split(" /from | /to ", 3);
          taskList.addTask(new Event(parts[0], parts[1], parts[2]));
          printDivider();
        } else if (words[0].equals("delete")) {
          printDivider();
          int idx = Integer.parseInt(words[1]) - 1;
          taskList.deleteTask(idx);
          printDivider();
        } else {
          throw new NerpBotException("idk what that means.");
        }
      } catch (NerpBotException e) {
        printDivider();
        System.out.println(" Damn, " + e.getMessage());
        printDivider();
      } catch (Exception e) {
        printDivider();
        System.out.println(" Something went wrong: " + e.getMessage());
        printDivider();
      }
    }
  }
}
