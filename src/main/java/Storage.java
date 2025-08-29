import java.io.*;
import java.util.ArrayList;

public class Storage {
  private final String filePath;

  public Storage(String filePath) {
    this.filePath = filePath;
  }

  public void save(ArrayList<Task> tasks) throws IOException {
    // Better to take in ArrayList<Task> as a parameter than TaskList
    // to reduce coupling between classes
    FileWriter fileWriter = new FileWriter(filePath);
    for (Task task : tasks) {
      fileWriter.write(task.saveFormat() + System.lineSeparator());
    }
    fileWriter.close();
  }

  public ArrayList<Task> load() throws IOException {
    ArrayList<Task> tasks = new ArrayList<>();
    File file = new File(filePath);

    if (!file.exists()) {
      file.getParentFile().mkdirs(); // create /data directory if it does not exist
      file.createNewFile(); // create nerpbot.txt file if it does not exist
      return tasks;
    }

    // read from file and populate tasks
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;
    while ((line = br.readLine()) != null) {
      tasks.add(Task.fromSaveFormat(line));
    }
    br.close();
    return tasks;
  }
}
