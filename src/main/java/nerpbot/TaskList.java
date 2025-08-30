package nerpbot;

import nerpbot.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
  private final ArrayList<Task> tasks;
  private final Storage storage;

  public TaskList(Storage storage) {
    this.tasks = new ArrayList<>();
    this.storage = storage;
  }

  public TaskList(ArrayList<Task> tasks, Storage storage) {
    this.tasks = tasks;
    this.storage = storage;
  }

  public void addTask(Task task) throws IOException {
    tasks.add(task);
    System.out.println("Got it. I've added this task:");
    System.out.println("  " + task);
    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    storage.save(tasks);
  }

  public void deleteTask(int idx) throws IOException {
    Task task = tasks.remove(idx);
    System.out.println("Noted. I've removed this task:");
    System.out.println("  " + task);
    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    storage.save(tasks);
  }

  public void markTask(int idx) throws IOException {
    Task task = tasks.get(idx);
    task.markAsDone();

    System.out.println("Nice! I've marked this task as done:");
    System.out.println("  " + task);
    storage.save(tasks);
  }

  public void unmarkTask(int idx) throws IOException {
    Task task = tasks.get(idx);
    task.unmarkAsDone();

    System.out.println("OK, I've marked this task as not done yet:");
    System.out.println("  " + task);
    storage.save(tasks);
  }

  public void listTasks() {
    System.out.println("Here are the tasks in your list:");
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println((i + 1) + "." + tasks.get(i));
    }
  }
}
