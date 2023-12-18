package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.*;

import java.util.ArrayList;
import java.util.List;

public class FileSearchVisitor implements FSVisitor {

    private List<File> files = new ArrayList<>();
    private String fileName;

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
    }

    public void visit(Directory dir) {
        return;
    }

    public void visit(File file) {
        if (fileName.equals(file.getName())) {
            files.add(file);
        }
    }

    public void visit(Link link) {
        return;
    }

    public List<File> getFiles() {
        return files;
    }

}
