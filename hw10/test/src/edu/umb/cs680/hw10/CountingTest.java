package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.util.CountingVisitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class CountingTest {

    private static FileSystem fs;
    private static Directory dir1, dir2, dir3, dir4;
    private static File f1, f2, f3, f4, f5;
    private static Link l1, l2;

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

    @Test
    public void counting_ShouldCountAllTypes() {
        Counting cmdCounting = new Counting(dir1);
        cmdCounting.execute();
        CountingVisitor visitor = cmdCounting.getVisitor();

        assertEquals(4, visitor.getDirNumber()); // 4 directories including root
        assertEquals(5, visitor.getFileNumber()); // 5 files
        assertEquals(1, visitor.getLinkNumber()); // 1 links
    }

    @Test
    public void counting_ShouldCountFilesCorrectly() {
        Counting cmdCounting = new Counting(dir1);
        cmdCounting.execute();
        CountingVisitor visitor = cmdCounting.getVisitor();
        assertEquals(5, visitor.getFileNumber());
    }

    @Test
    public void counting_ShouldCountDirectoriesCorrectly() {
        Counting cmdCounting = new Counting(dir1);
        cmdCounting.execute();
        CountingVisitor visitor = cmdCounting.getVisitor();
        assertEquals(4, visitor.getDirNumber());
    }

    @Test
    public void counting_ShouldCountLinksCorrectly() {
        Counting cmdCounting = new Counting(dir1);
        cmdCounting.execute();
        CountingVisitor visitor = cmdCounting.getVisitor();
        assertEquals(1, visitor.getLinkNumber());
    }

    @Test
    public void counting_OnEmptyDirectory() {
        Directory emptyDir = new Directory(dir1, "emptyDir", 0, LocalDateTime.now());
        Counting cmdCounting = new Counting(emptyDir );
        cmdCounting.execute();
        CountingVisitor visitor = cmdCounting.getVisitor();
        assertEquals(1, visitor.getDirNumber()); // Only the empty directory itself
        assertEquals(0, visitor.getFileNumber());
        assertEquals(0, visitor.getLinkNumber());
    }

}
