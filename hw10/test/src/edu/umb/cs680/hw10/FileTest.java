package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class FileTest {

    private static FileSystem fs;
    private static Directory dir1, dir2, dir3, dir4;
    private static File f1, f2, f3, f4, f5;
    private static Link l1;

    @BeforeAll
    public static void setUpFS() {
        fs = FileSystem.getFileSystem();
        fs.getRootDirs().clear();
        dir1 = new Directory(null, "repo", 0, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        dir2 = new Directory(dir1, "src", 0, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        dir3 = new Directory(dir1, "test", 0, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        dir4 = new Directory(dir3, "src", 0, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        f1 = new File(dir1, "readme.md", 333, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        dir1.appendChild(dir2);
        dir1.appendChild(dir3);
        dir1.appendChild(f1);
        dir3.appendChild(dir4);

        f2 = new File(dir2, "A.java", 333, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        f3 = new File(dir2, "B.java", 333, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        dir2.appendChild(f2);
        dir2.appendChild(f3);

        f4 = new File(dir4, "ATest.java", 333, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        f5 = new File(dir4, "BTest.java", 333, LocalDateTime.of(12, 12, 12, 12, 12, 12));
        dir4.appendChild(f4);
        dir4.appendChild(f5);

        l1 = new Link(dir4, "rm.md", 0, LocalDateTime.of(12, 12, 12, 12, 12), f1);
        dir4.appendChild(l1);

        fs.appendRootDir(dir1);
        dir1 = fs.getRootDirs().get(0);
    }

    private String[] fileToStringArray(File file) {
        return new String[] { file.getName(), Integer.toString(file.getSize()), file.getParentName(),
                file.getCreationTime() };
    }

    @Test
    public void verifyFileAttributes() {
        assertArrayEquals(new String[] { "readme.md", "333", "repo", "0012-12-12T12:12:12" }, fileToStringArray(f1));
        assertArrayEquals(new String[] { "A.java", "333", "src", "0012-12-12T12:12:12" }, fileToStringArray(f2));
        assertArrayEquals(new String[] { "B.java", "333", "src", "0012-12-12T12:12:12" }, fileToStringArray(f3));
        assertArrayEquals(new String[] { "ATest.java", "333", "src", "0012-12-12T12:12:12" }, fileToStringArray(f4));
        assertArrayEquals(new String[] { "BTest.java", "333", "src", "0012-12-12T12:12:12" }, fileToStringArray(f5));

    }

    @Test
    public void isDirectory_ShouldReturnFalseForFile() {
        assertFalse(f1.isDirectory());
        assertFalse(f2.isDirectory());
        assertFalse(f3.isDirectory());
        assertFalse(f4.isDirectory());
        assertFalse(f5.isDirectory());
    }

}
