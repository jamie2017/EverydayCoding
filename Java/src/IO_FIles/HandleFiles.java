package IO_FIles;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by JMYE on 3/31/17.
 */
public class HandleFiles {
    public void processFile(File file) {
        System.out.println(file.toString());
    }
    public void walkDirsJava6(String path) throws IOException {
        File dir = new File(path);
        File[] files = dir.listFiles();

        for (File file: files) {
            if (file.isDirectory()) {
                System.out.println(" >>\n" +file.toString());
                walkDirsJava6(file.getAbsolutePath());
            } else {
                processFile(file);
            }
        }
    }

    public void walkDirsJava7(String path) throws IOException {
        Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                processFile(file.toFile());
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void walkDirsJava8(String path) throws IOException {
        Files.walk(Paths.get(path))
                .forEach(f -> processFile(f.toFile()));
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/JMYE/Google Drive/PureJava/src";
        HandleFiles test = new HandleFiles();
        test.walkDirsJava8(path);
    }

}
