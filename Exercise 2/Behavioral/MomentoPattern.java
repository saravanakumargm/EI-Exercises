package Behavioral;
//Memento class
class TextEditorMemento {
    private String content;

    public TextEditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

//Originator class
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

//Caretaker class
class EditorHistory {
    private TextEditorMemento memento;

    public void saveState(TextEditor editor) {
        memento = editor.save();
    }

    public void restoreState(TextEditor editor) {
        editor.restore(memento);
    }
}

//Client
public class MomentoPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();


        editor.setContent("First version of the text.");
        System.out.println("Current Content: " + editor.getContent());
        history.saveState(editor);

        // Add more content and save the state again
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

/*
In this code, the TextEditor class saves its content at different points, and the
EditorHistory class manages the saved states. This pattern is useful for implementing
undo/redo functionality, enabling the restoration of previous states without modifying
the original object's implementation.
 */