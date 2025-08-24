import java.util.Scanner;

public class NerpBot {
  private static void printDivider() {
      System.out.println("______________________________");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TaskList taskList = new TaskList();

    printDivider();
    System.out.println("Hello! I'm NerpBot");
    System.out.println("What can I do for you?");
    printDivider();

    while (true) {
      String command = scanner.nextLine();
      String[] words = command.split(" ");

      if (command.equals("bye")) {
        printDivider();
        System.out.println("Bye. Hope to see you again soon!");
        printDivider();
        break;
      } else if (command.equals("list")) {
        printDivider();
        taskList.listTasks();
        printDivider();
      } else if (words[0].equals("mark")){
        printDivider();
        int idx = Integer.parseInt(words[1]) - 1;
        taskList.markTask(idx);
        printDivider();
      } else if (words[0].equals("unmark")){
        printDivider();
        int idx = Integer.parseInt(words[1]) - 1;
        taskList.unmarkTask(idx);
        printDivider();
      } else {
        Task task = new Task(command);

        printDivider();
        taskList.addTask(task);
        printDivider();
      }
    }
  }
}
