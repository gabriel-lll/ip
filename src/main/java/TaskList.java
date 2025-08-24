import java.util.ArrayList;

public class TaskList {
  private final ArrayList<String> tasks = new ArrayList<>();

  public void addTask(String task) {
    tasks.add(task);
    System.out.println("added: " + task);
  }

  public void listTasks() {
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println((i + 1) + ". " + tasks.get(i));
    }
  }
}
