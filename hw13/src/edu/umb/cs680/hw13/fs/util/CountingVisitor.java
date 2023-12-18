package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.*;

public class CountingVisitor implements FSVisitor{

    private int dirNumber, fileNumber, linkNumber;
    
    public void visit(Directory dir) {
        dirNumber++;
    }
    public void visit(File file) {
        fileNumber++;
    }
    public void visit(Link link) {
        linkNumber++;
    }
    public int getFileNumber() {
        return fileNumber;
    }
    public int getLinkNumber() {
        return linkNumber;
    }
    public int getDirNumber() {
        return dirNumber;
    }
}
