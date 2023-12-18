package edu.umb.cs680.hw09;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.fs.*;
import edu.umb.cs680.hw09.fs.util.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class DirectoryTest {

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

        l1 = new Link(dir4, "rm.md", 0, LocalDateTime.of(12, 12, 12, 12, 12), f1 );
        dir4.appendChild(l1);

        fs.appendRootDir(dir1);
        dir1 = fs.getRootDirs().get(0);
    }

    private String[] dirToStringArray(Directory dir) {
        return new String[] { dir.getName(), Integer.toString(dir.getSize()), dir.getParentName(),
                dir.getCreationTime() };
    }

    @Test
    public void verifyDirectoryAttributes() {
        assertArrayEquals(new String[] { "repo", "0", "root", "0012-12-12T12:12:12" }, dirToStringArray(dir1));
        assertArrayEquals(new String[] { "src", "0", "repo", "0012-12-12T12:12:12" }, dirToStringArray(dir2));
        assertArrayEquals(new String[] { "test", "0", "repo", "0012-12-12T12:12:12" }, dirToStringArray(dir3));
        assertArrayEquals(new String[] { "src", "0", "test", "0012-12-12T12:12:12" }, dirToStringArray(dir4));

    }

    @Test
    public void countChildren_ShouldReturnCorrectNumber() {
        assertEquals(3, dir1.countChildren());
        assertEquals(2, dir2.countChildren());
        assertEquals(1, dir3.countChildren());
        assertEquals(3, dir4.countChildren());
    }

    @Test
    public void getTotalSize_ShouldReturnCorrectSize() {
        assertEquals(1665, dir1.getTotalSize());
        assertEquals(666, dir2.getTotalSize());
        assertEquals(666, dir3.getTotalSize());
        assertEquals(666, dir4.getTotalSize());
    }

    @Test
    public void getSubDirectories_ShouldReturnCorrectSubDirectories() {
        assertEquals(2, dir1.getSubDirectories().size());
        assertEquals(0, dir2.getSubDirectories().size());
        assertEquals(1, dir3.getSubDirectories().size());
        assertEquals(0, dir4.getSubDirectories().size());
    }

    @Test
    public void getFiles_ShouldReturnCorrectFiles() {
        assertEquals(1, dir1.getFiles().size());
        assertEquals(2, dir2.getFiles().size());
        assertEquals(0, dir3.getFiles().size());
        assertEquals(2, dir4.getFiles().size());
    }

    @Test
    public void appendChild_ShouldNotAlterExistingStructure() {
        Directory newDir = new Directory(dir1, "newDir", 0, LocalDateTime.now());
        dir1.appendChild(newDir);
        assertEquals(4, dir1.countChildren());
        dir1.getChildren().remove(newDir);
    }

    @Test
    public void isDirectory_ShouldReturnTrueForDirectory() {
        assert(dir1.isDirectory());
        assert(dir2.isDirectory());
        assert(dir3.isDirectory());
        assert(dir4.isDirectory());
    }

}
