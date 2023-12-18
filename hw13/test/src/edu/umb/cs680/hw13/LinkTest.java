package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.fs.*;
import edu.umb.cs680.hw13.fs.util.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class LinkTest {
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

        l1 = new Link(dir4, "rm.md", 0, LocalDateTime.of(12, 12, 12, 12, 12, 12), f1 );
        dir4.appendChild(l1);

        fs.appendRootDir(dir1);
        dir1 = fs.getRootDirs().get(0);
    }

    @Test
    public void verifyLinkCreation() {
        assertNotNull(l1);
        assertEquals("rm.md", l1.getName());
        assertEquals(0, l1.getSize()); 
        assertEquals("0012-12-12T12:12:12", l1.getCreationTime());
    }

    @Test
    public void linkShouldNotBeDirectory() {
        assertFalse(l1.isDirectory());
    }

    @Test
    public void getTarget_ShouldReturnCorrectTarget() {
        assertSame(f1, l1.getTarget());
    }

    @Test
    public void linkTargetShouldBeFile() {
        assertTrue(l1.getTarget() instanceof File);
    }

}
