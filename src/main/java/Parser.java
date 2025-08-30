public class Parser {
  public static String getCommandWord(String input) {
    return input.split(" ")[0];
  }

  public static String getCommandArgs(String input) {
    String[] parts = input.split(" ", 2);
    return parts.length > 1 ? parts[1] : "";
  }
}
