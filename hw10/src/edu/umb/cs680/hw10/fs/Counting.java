package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.CountingVisitor;

public class Counting  implements FSCommand{

    private CountingVisitor v = new CountingVisitor();
    private FSElement element;

    public Counting(FSElement element) {
        this.element = element;
    }
    
    public void execute() {
        element.accept(v);
    }

    public CountingVisitor getVisitor() {
        return v;
    }
}

