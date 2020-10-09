import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private final static String[] SIZE_ABBREVIATION = {"б", "Кб", "Мб", "Гб", "Тб"};

    public static void main(String[] args) {
        try {
            String input = args[0];
            if (!new File(input).exists()) {
                throw new IllegalArgumentException("Неправильный формат пути до папки.");
            }
            Path path = Paths.get(input);
            long filesSize = Files.walk(path).mapToLong(f -> f.toFile().length()).sum();
            System.out.println("Размер папки " + input + " составляет " + getHumanReadableSize(filesSize) + ".");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getHumanReadableSize (long size) {
        for (int i = 0; i < SIZE_ABBREVIATION.length; i++) {
            double value = ((double) size) / Math.pow(1000, i);
            if (value < 1000) {
                return Math.round(value * 100) / 100. + " " + SIZE_ABBREVIATION[i];
            }
        }
        return "больше 9223372 Тб";
    }
}
