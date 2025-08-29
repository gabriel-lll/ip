public class Task {
  protected String description;
  protected boolean isDone;

  public Task(String description) {
    this.description = description;
    this.isDone = false;
  }

  public String getStatusIcon() {
    return (isDone ? "X" : " "); // mark done task with X
  }

  public void markAsDone() {
    isDone = true;
  }

  public void unmarkAsDone() {
    isDone = false;
  }

  public String saveFormat() {
    return (isDone ? "1" : "0") + " | " + description;
  }

  public static Task fromSaveFormat(String data) {
    String[] parts = data.split(" \\| ");
    String type = parts[0];
    boolean isDone = parts[1].equals("1");
    String description = parts[2];

    Task task;

    switch (type) {
      case "T":
        task = new ToDo(description);
        break;
      case "D":
        String by = parts[3];
        task = new Deadline(description, by);
        break;
      case "E":
        String from = parts[3];
        String to = parts[4];
        task = new Event(description, from, to);
        break;
      default:
        return null;
    }

    if (isDone) {
      task.markAsDone();
    }

    return task;
  }

  @Override
  public String toString() {
    return "[" + getStatusIcon() + "] " + description;
  }
}
