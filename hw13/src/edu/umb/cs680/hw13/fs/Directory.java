package edu.umb.cs680.hw13.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(children, new AlphabeticalComparator());
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

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        LinkedList<FSElement> sorted = new LinkedList<>(children);
        Collections.sort(sorted, comparator);
        return sorted;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        LinkedList<Directory> sorted = new LinkedList<>(getSubDirectories());
        Collections.sort(sorted, comparator);
        return sorted;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
        LinkedList<File> sorted = new LinkedList<>(getFiles());
        Collections.sort(sorted, comparator);
        return sorted;
    }

    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement child : children) {
            child.accept(v);
        }
    }
}
