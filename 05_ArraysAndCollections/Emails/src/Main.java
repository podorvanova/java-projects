import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final HashSet<String> emailsList = new HashSet<>();
    private static final Pattern addCommandPattern = Pattern.compile("^ADD (.*)$");
    private static final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9.-]+@[a-zA-Z0-9-]+\\.[a-z]+$");

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в список email-ов. Для просмотра списка введите LIST. Для выхода введите END.");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            final Matcher addCommandMatcher = addCommandPattern.matcher(input);

            if (input.equals("LIST")) {
                getEmailList();
            } else if (addCommandMatcher.find()) {
                String email = addCommandMatcher.group(1);
                final Matcher emailMatcher = emailPattern.matcher(email);
                if (emailMatcher.find()) {
                    addEmail(email);
                } else {
                    System.out.println("Некорректный email. Адрес электронный почты должен иметь вид username@hostname.");
                }
            } else if (input.equals("END")) {
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