package edu.umb.cs680.hw17.fs.util;

import java.util.ArrayList;
import java.util.List;

import edu.umb.cs680.hw17.fs.*;


public class FileCrawlingVisitor implements FSVisitor {

    private List<File> files = new ArrayList<>();
    
    public void visit(Directory dir) {
        return;
    }

    public void visit(File file) {
        files.add(file);
    }

    public void visit(Link link) {
        return;
    }

    public List<File> getFiles() {
        return files;
    }

    
}
