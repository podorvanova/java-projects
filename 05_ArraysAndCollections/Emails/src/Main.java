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
            final Matcher addMatcher = Pattern.compile("^ADD (.*)$").matcher(input);
            final Matcher endMatcher = Pattern.compile("^END$").matcher(input);

            if (listMatcher.find()) {
                getEmailList();
            } else if (addMatcher.find()) {
                String email = addMatcher.group(1);
                final Matcher emailValidated = Pattern.compile("^[a-zA-Z0-9.-]+@[a-zA-Z0-9-]+\\.[a-z]+$").matcher(email);
                if (emailValidated.find()) {
                    addEmail(email);
                } else {
                    System.out.println("Некорректный email. Адрес электронный почты должен иметь вид username@hostname.");
                }
            } else if (endMatcher.find()) {
                scanner.close();
                break;
            } else {
                System.out.println("Команда не найдена. Введите команду еще раз.");
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

    public static void addEmail (String email) {
        emailsList.add(email);
        System.out.println(email + " добавлен в список.");
    }
}