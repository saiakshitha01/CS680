package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.*;
import java.util.ArrayList;
import java.util.List;

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
