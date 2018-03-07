package IO_FIles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by JMYE on 3/31/17.
 */
public class FileSearch {
    String path;
    String regex;
    String zipFileName;
    Pattern pattern;
    List<File> zipFiles = new ArrayList<>();

    public static void main(String[] args) {
        FileSearch test = new FileSearch();
        test.setPath(args[0]);
        test.setRegex(args[1]);
        test.setZipFileName(args[2]);

        try {
            test.walkDirectory(test.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processFile(File file) {
        try {
            if (searchFile(file)) {
                addFileToZip(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean searchFile(File file) throws IOException {
        return searchFileJava7(file);
    }
    public void addFileToZip(File file) {
//        if (getZipFileName() != null) {
//            zipFiles.add(file);
//        }
        System.out.println("addFileToZip: " + file);
    }

    public void zipFilesJava7() throws IOException {
        try (ZipOutputStream out =
                    new ZipOutputStream(new FileOutputStream(getZipFileName()))) {
            File baseDir = new File(getPath());
            for (File file: zipFiles) {
                // fileName must be a relative path, not a absolute one
                String fileName = getRelativeFilename(file, baseDir);
                ZipEntry zipEntry = new ZipEntry(fileName);
                zipEntry.setTime(file.lastModified());
                out.putNextEntry(zipEntry);
                Files.copy(file.toPath(), out);
                out.closeEntry();
            }
        }
    }


    public String getRelativeFilename(File file, File baseDir) {
        String fileName = file.getAbsolutePath().substring((int) baseDir.getAbsoluteFile().length());
//        fileName = fileName.replace('\\','/');
        while (fileName.startsWith("/")) {
            fileName = fileName.substring(1);
        }
        return fileName;
    }

    public void walkDirectory(String path) throws IOException {
        walkDirsJava7(path);
        zipFilesJava7();
    }

    public void walkDirsJava7(String path) throws IOException {
        System.out.println(path);
        Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                processFile(file.toFile());
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public boolean searchFileJava6(File file) throws FileNotFoundException {
        boolean found = false;
        Scanner scanner = new Scanner(file, "UTF-8");
        while (scanner.hasNextLine()) {
            found = searchText(scanner.nextLine());
            if (found) {break;}
        }
        scanner.close();
        return found;
    }

    public boolean searchFileJava7(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath(),
                StandardCharsets.UTF_8);
        for (String line : lines) {
            if (searchText(line)) {
                return true;
            }
        }
        return false;
    }


    public boolean searchText(String text) {
        return (this.getRex() == null) ? true:
                this.pattern.matcher(text).matches();
    }
    public String getRex() {
        return regex;
    }
    public void setRegex(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }
    public String getZipFileName() {
        return zipFileName;
    }
    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }


}
