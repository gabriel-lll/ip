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
      String task = scanner.nextLine();

      if (task.equals("bye")) {
        printDivider();
        System.out.println("Bye. Hope to see you again soon!");
        printDivider();
        break;
      } else if (task.equals("list")) {
        printDivider();
        taskList.listTasks();
        printDivider();
      } else {
        printDivider();
        taskList.addTask(task);
        printDivider();
      }
    }
  }
}
