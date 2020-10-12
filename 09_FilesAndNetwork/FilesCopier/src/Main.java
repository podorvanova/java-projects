import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) {
        try {
            String toCopyFolder = args[0];
            String folderWithCopy = args[1];

            if (!new File(toCopyFolder).exists()) {
                throw new FileNotFoundException("Неправильный формат пути до папки, которую нужно скопировать.");
            }
            if (!new File(folderWithCopy).exists()) {
                throw new FileNotFoundException("Неправильный формат пути до папки в которую нужно скопировать файлы.");
            }

            Path toCopyFolderPath = Paths.get(toCopyFolder);
            Path folderWithCopyPath = Paths.get(folderWithCopy);

            Files.walkFileTree(toCopyFolderPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Files.createDirectories(folderWithCopyPath.resolve(toCopyFolderPath.relativize(dir)));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.copy(file, folderWithCopyPath.resolve(toCopyFolderPath.relativize(file)));
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}