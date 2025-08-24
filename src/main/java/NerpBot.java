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
      String[] words = command.split(" ", 2);

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
      } else if (words[0].equals("todo")) {
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
      } else {
        Task task = new Task(command);

        printDivider();
        taskList.addTask(task);
        printDivider();
      }
    }
  }
}
