import java.io.File;
import java.util.Scanner;

public class Main {
    private final static String[] SIZE_ABBREVIATION = {"б", "Кб", "Мб", "Гб", "Тб"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите путь до папки. Для выхода из приложения введите END.");
                String input = scanner.nextLine();
                if (input.equals("END")) {
                    scanner.close();
                    break;
                }
                if (!new File(input).exists()) {
                    throw new IllegalArgumentException("Неправильный формат пути до папки.");
                }
                File file = new File(input);
                System.out.println("Размер папки " + input + " составляет " + getHumanReadableSize(getFolderSize(file)) + ".");
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
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
