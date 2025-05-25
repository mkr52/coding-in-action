package com.mkr.oodpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

interface FileSystemElement {
    String getName();
}

class File implements FileSystemElement {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }


    @Override
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}

class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }
}
public class VisitorDemo {

    public static void main(String[] args) {
        var directory1 = new Directory(("directory1"));
        var file1 = new File("file1.txt", 100);
        directory1.addElement(file1);

        var directory2 = new Directory(("directory2"));
        var file2 = new File("file2.txt", 100);
        directory1.addElement(file2);

        directory1.addElement(directory2);
    }
}
