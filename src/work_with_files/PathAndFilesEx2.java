package work_with_files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("C:\\Users\\Papa Kolya\\Desktop\\M");
        Path directoryPath2 = Paths.get("C:\\Users\\Papa Kolya\\Desktop\\B");

//        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
//        Files.copy(directoryPath2, directoryPath.resolve("B"));
//        System.out.println("Done");

//        Files.move(filePath, directoryPath.resolve("test15.txt"), StandardCopyOption.REPLACE_EXISTING);
//        Files.move(Paths.get("test10.txt"), Paths.get("test10.txt"));

//        Files.delete(Paths.get("test5.txt"));
//        Files.delete(directoryPath); // DirectoryNotEmptyException
    }
}
