package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

public class FileSearch  implements FSCommand{

    private FileSearchVisitor v;
    private FSElement element;

    public FileSearch(FSElement element, String fileName) {
        this.element = element;
        this.v = new FileSearchVisitor(fileName);
    }
    
    public void execute() {
        element.accept(v);
    }

    public FileSearchVisitor getVisitor() {
        return v;
    }
}

