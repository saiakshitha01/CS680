package edu.umb.cs680.hw17.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public FSElement getTarget() {
        return target;
    }

    public void accept(FSVisitor v) {
        v.visit(this);
    }

}
