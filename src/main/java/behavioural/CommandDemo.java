package behavioural;

public class CommandDemo {

  public static void main(String[] args) {
    TextFile textFile = new TextFile();
    Command writeCommand = new WriteCommand(textFile, "Hello");
    Command undoCommand = new UndoCommand(textFile);

    TextEditor textEditor = new TextEditor();
    textEditor.setCommand(writeCommand);
    textEditor.executeCommand();

    textEditor.setCommand(undoCommand);
    textEditor.executeCommand();
    // can store command history in stack for undo and redo
  }
}

/*
    Use Command Pattern when you want to parameterize objects with operations
 * - Supporting Logging and Transactional Systems: When you need to support logging changes so that they can be reapplied in case of a system crash
 * - Supporting Undo/Redo
 */

// Declare the command interface with a single execution method.
interface Command {
  void execute();
}

class TextFile {

  private StringBuilder text = new StringBuilder();

  public void write(String text) {
    this.text.append(text);
    System.out.println("Text after write: " + text);
  }

  public void undo() {
    if (text.length() <= 0) return;
    text.deleteCharAt(text.length() - 1);
    System.out.println("Text after undo: " + text);
  }
}

// extracting requests into concrete command classes that implement the command
// interface
class WriteCommand implements Command {

  private TextFile textFile;
  private String text;

  public WriteCommand(TextFile textFile, String text) {
    this.textFile = textFile;
    this.text = text;
  }

  @Override
  public void execute() {
    textFile.write(text);
  }
}

class UndoCommand implements Command {

  private TextFile textFile;

  public UndoCommand(TextFile textFile) {
    this.textFile = textFile;
  }

  @Override
  public void execute() {
    textFile.undo();
  }
}

class TextEditor {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void executeCommand() {
    command.execute();
  }
}
