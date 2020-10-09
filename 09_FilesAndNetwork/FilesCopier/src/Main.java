import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;

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

            Files.walk(toCopyFolderPath).forEach(f -> {
                Path endDestinationPath = Paths.get(folderWithCopy, f.toString().substring(toCopyFolder.length()));
                try {
                    if (!f.toString().equals(toCopyFolder))
                        Files.copy(f, endDestinationPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}