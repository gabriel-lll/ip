package nerpbot;

import java.util.Scanner;

public class Ui {
  private final Scanner scanner = new Scanner(System.in);

  public void showLine() {
    System.out.println("______________________________");
  }

  public void showWelcome() {
    showLine();
    System.out.println("Hello! I'm nerpbot.NerpBot");
    System.out.println("What can I do for you?");
    showLine();
  }

  public void showError(String message) {
    System.out.println("OOPSIE POOPSIE!!! " + message);
  }

  public void showExit() {
    System.out.println("Bye. Hope to see you again soon!");
  }

  public String readCommand() {
    return scanner.nextLine();
  }
}
