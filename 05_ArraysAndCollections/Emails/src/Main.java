import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final HashSet<String> emailsList = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в список email-ов. Для просмотра списка введите LIST. Для выхода введите END.");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            final Matcher listMatcher = Pattern.compile("^LIST$").matcher(input);

            if (listMatcher.find()) {
                getEmailList();
            }
        }
    }

    public static void getEmailList () {
        if (emailsList.isEmpty()) {
            System.out.println("Список пуст. Введите ADD для добавления email-a.");
        } else {
            System.out.println("Список email-ов:");
            for (String email : emailsList) {
                System.out.println(email);
            }
        }
    }
}