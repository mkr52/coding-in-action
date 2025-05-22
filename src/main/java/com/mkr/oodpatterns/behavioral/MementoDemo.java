package com.mkr.oodpatterns.behavioral;

// Memento class
class TextDocumentState {
    private String state;

    public TextDocumentState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
class TextDocument {
    private String text = "";
    private TextDocumentState state = new TextDocumentState(text);

    public void write(String text) {
        this.text += text;
    }

    public void print() {
        System.out.println(text);
    }

    public void save() {
        state.setState(text);
    }

    public void undo() {
        text = state.getState();
    }
}

public class MementoDemo {

    public static void main(String[] args) {
        var textDoc = new TextDocument();
        textDoc.write("Hello, World! ");
        textDoc.save();
        textDoc.print();
        textDoc.write("How are you?");
        textDoc.print();
        textDoc.undo();
        textDoc.print();
    }
}
