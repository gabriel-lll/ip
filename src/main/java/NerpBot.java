import java.util.Scanner;

public class NerpBot {
    private static void printDivider() {
      System.out.println("______________________________");
    }
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String command;

      printDivider();
      System.out.println("Hello! I'm NerpBot");
      System.out.println("What can I do for you?");
      printDivider();

      while (true) {
        command = scanner.nextLine();
        if (command.equals("bye")) {
          printDivider();
          System.out.println("Bye. Hope to see you again soon!");
          printDivider();
          break;
        } else {
          printDivider();
          System.out.println(command);
          printDivider();
        }
      }
    }
}
