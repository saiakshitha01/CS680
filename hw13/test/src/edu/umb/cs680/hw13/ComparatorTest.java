package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.fs.*;
import edu.umb.cs680.hw13.fs.util.CountingVisitor;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import java.time.LocalDateTime;

public class ComparatorTest {

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
    public void alphabeticalComparator_ShouldReturnChildrenSortedAlphabetically() {
        LinkedList<FSElement> actual = dir3.getChildren(new AlphabeticalComparator());
        List<FSElement> expected = Arrays.asList(dir4);
        assertIterableEquals(expected, actual);
    }

    @Test
    public void alphabeticalComparator_ShouldReturnSubDirectoriesSortedAlphabetically() {
        LinkedList<Directory> actual = dir3.getSubDirectories(new AlphabeticalComparator());
        List<Directory> expected = Arrays.asList(dir4);
        assertIterableEquals(expected, actual);
    }

    @Test
    public void alphabeticalComparator_ShouldReturnFilesSortedAlphabetically() {
        LinkedList<File> actual = dir3.getFiles(new AlphabeticalComparator());
        List<File> expected = Arrays.asList();
        assertIterableEquals(expected, actual);
    }

    @Test
    public void sizeComparator_ShouldReturnChildrenSortedSize() {
        LinkedList<FSElement> actual = dir3.getChildren(new SizeComparator());
        List<FSElement> expected = Arrays.asList(dir4);
        assertIterableEquals(expected, actual);
    }

    @Test
    public void sizeComparator_ShouldReturnSubDirectoriesSortedSize() {
        LinkedList<Directory> actual = dir3.getSubDirectories(new SizeComparator());
        List<Directory> expected = Arrays.asList(dir4);
        assertIterableEquals(expected, actual);
    }

    @Test
    public void sizeComparator_ShouldReturnFilesSortedSize() {
        LinkedList<File> actual = dir3.getFiles(new SizeComparator());
        List<File> expected = Arrays.asList();
        assertIterableEquals(expected, actual);
    }

    @Test
    public void reverseAlphaComparator_ShouldReturnChildrenSortedreverseAlpha() {
        LinkedList<FSElement> actual = dir3.getChildren(new ReverseAlphabeticalComparator());
        List<FSElement> expected = Arrays.asList(dir4);
        assertIterableEquals(expected, actual);
    }

    @Test
    public void reverseAlphaComparator_ShouldReturnSubDirectoriesSortedReverseAlpha() {
        LinkedList<Directory> actual = dir3.getSubDirectories(new ReverseAlphabeticalComparator());
        List<Directory> expected = Arrays.asList(dir4);
        assertIterableEquals(expected, actual);
    }

    @Test
    public void reverseAlphaComparator_ShouldReturnFilesSortedReverseAlphabetically() {
        LinkedList<File> actual = dir3.getFiles(new ReverseAlphabeticalComparator());
        List<File> expected = Arrays.asList();
        assertIterableEquals(expected, actual);
    }




}
