package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children = new LinkedList<FSElement>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public void appendChild(FSElement child) {
        children.add(child);
    }

    public int countChildren() {
        return children.size();
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement child : children) {
            if (child.isDirectory()) {
                totalSize += ((Directory) child).getTotalSize();
            } else {
                totalSize += child.getSize();
            }
        }
        return totalSize;
    }

    public LinkedList<FSElement> getChildren() {
        return children;
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement child : children) {
            if (child.isDirectory()) {
                dirs.add((Directory) child);
            }
        }
        return dirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement child : children) {
            if (!child.isDirectory() && child instanceof File) {
                files.add((File) child);
            }
        }
        return files;
    }

    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement child : children) {
            child.accept(v);
        }
    }
}
