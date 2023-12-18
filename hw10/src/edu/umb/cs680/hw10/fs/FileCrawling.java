package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.FileCrawlingVisitor;

public class FileCrawling  implements FSCommand{

    private FileCrawlingVisitor v = new FileCrawlingVisitor();
    private FSElement element;

    public FileCrawling(FSElement element) {
        this.element = element;
    }
    
    public void execute() {
        element.accept(v);
    }

    public FileCrawlingVisitor getVisitor() {
        return v;
    }
}
