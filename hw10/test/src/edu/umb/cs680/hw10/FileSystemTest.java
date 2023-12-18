package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class FileSystemTest {

    private static FileSystem fs1, fs2;
    private static Directory rootDir;

    @BeforeAll
    public static void setUp() {
        fs1 = FileSystem.getFileSystem();
        rootDir = new Directory(null, "root", 0, LocalDateTime.now());
        fs1.appendRootDir(rootDir);
    }

    @Test
    public void fileSystem_IsSingleton() {
        fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    public void appendRootDir_ShouldIncreaseRootDirsSize() {
        int initialSize = fs1.getRootDirs().size();
        Directory newRootDir = new Directory(null, "newRoot", 0, LocalDateTime.now());
        fs1.appendRootDir(newRootDir);
        assertEquals(initialSize + 1, fs1.getRootDirs().size());
        fs1.getRootDirs().remove(newRootDir); // Cleanup to maintain original state
    }

    @Test
    public void getRootDirs_ShouldReturnRootDirectories() {
        assertTrue(fs1.getRootDirs().contains(rootDir));
    }

}
