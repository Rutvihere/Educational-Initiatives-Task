import java.util.ArrayList;
import java.util.List;

// Memento
class CodeSnapshot {
    private final String code;
    private final int lineNumber;

    public CodeSnapshot(String code, int lineNumber) {
        this.code = code;
        this.lineNumber = lineNumber;
    }

    public String getCode() {
        return code;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}

// Originator
class CodeEditor {
    private String code;
    private int currentLine;

    public void writeCode(String code, int lineNumber) {
        this.code = code;
        this.currentLine = lineNumber;
        System.out.println("Writing code: " + code + " at line " + lineNumber);
    }

    public CodeSnapshot createSnapshot() {
        return new CodeSnapshot(code, currentLine);
    }

    public void restore(CodeSnapshot snapshot) {
        this.code = snapshot.getCode();
        this.currentLine = snapshot.getLineNumber();
        System.out.println("Restored to: " + code + " at line " + currentLine);
    }
}

// Caretaker
class DebugHistory {
    private final List<CodeSnapshot> history = new ArrayList<>();

    public void save(CodeSnapshot snapshot) {
        history.add(snapshot);
    }

    public CodeSnapshot undo() {
        if (!history.isEmpty()) {
            int lastIndex = history.size() - 1;
            CodeSnapshot lastSnapshot = history.get(lastIndex);
            history.remove(lastIndex);
            return lastSnapshot;
        }
        return null;
    }
}

// Client code
public class TimeTravelingDebugger {
    public static void main(String[] args) {
        CodeEditor editor = new CodeEditor();
        DebugHistory debugger = new DebugHistory();

        editor.writeCode("int x = 5;", 1);
        debugger.save(editor.createSnapshot());

        editor.writeCode("x += 3;", 2);
        debugger.save(editor.createSnapshot());

        editor.writeCode("System.out.println(x);", 3);
        debugger.save(editor.createSnapshot());

        System.out.println("\nDebug session:");
        editor.restore(debugger.undo());
        editor.restore(debugger.undo());
    }
}