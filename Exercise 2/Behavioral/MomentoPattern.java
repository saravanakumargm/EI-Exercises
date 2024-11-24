package Behavioral;

import java.util.Stack;

// Memento class
class TextEditorMemento {
    private String content;

    public TextEditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Originator class
class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // Saving current state of the text editor
    public TextEditorMemento save() {
        return new TextEditorMemento(content);
    }

    // Restore the state from the Memento
    public void restore(TextEditorMemento memento) {
        this.content = memento.getContent();
    }
}

// Caretaker class
class EditorHistory {
    private Stack<TextEditorMemento> mementos = new Stack<>();

    public void saveState(TextEditor editor) {
        mementos.push(editor.save());
    }

    public void restoreState(TextEditor editor) {
        if (!mementos.isEmpty()) {
            TextEditorMemento memento = mementos.pop();
            editor.restore(memento);
        } else {
            System.out.println("No states to restore.");
        }
    }
}

// Client
public class MomentoPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        // Set and save the first version
        editor.setContent("First version of the text.");
        System.out.println("Current Content: " + editor.getContent());
        history.saveState(editor);

        // Set and save the second version
        editor.setContent("Second version of the text.");
        System.out.println("Current Content: " + editor.getContent());
        history.saveState(editor);

        // Modify the content again
        editor.setContent("Third version of the text.");
        System.out.println("Current Content: " + editor.getContent());

        // Restore to the previous version (second version)
        history.restoreState(editor);
        System.out.println("After Restore: " + editor.getContent());

        // Restore to the first version
        history.restoreState(editor);
        System.out.println("After Restore Again: " + editor.getContent());
    }
}
