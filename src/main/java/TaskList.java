import java.util.ArrayList;

public class TaskList {
  private final ArrayList<Task> tasks = new ArrayList<>();

  public void addTask(Task task) {
    tasks.add(task);
    System.out.println("Got it. I've added this task:");
    System.out.println("  " + task);
    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
  }

  public void markTask(int idx) {
    Task task = tasks.get(idx);
    task.markAsDone();

    System.out.println("Nice! I've marked this task as done:");
    System.out.println("  " + task);
  }

  public void unmarkTask(int idx) {
    Task task = tasks.get(idx);
    task.unmarkAsDone();

    System.out.println("OK, I've marked this task as not done yet:");
    System.out.println("  " + task);
  }

  public void listTasks() {
    System.out.println("Here are the tasks in your list:");
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println((i + 1) + "." + tasks.get(i));
    }
  }
}
