package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public void accept(FSVisitor v) {
        v.visit(this);
    }
}
