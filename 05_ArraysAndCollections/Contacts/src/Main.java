import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final HashMap<String, String> contactsList = new HashMap<>();
    private static final Pattern patternName = Pattern.compile("^[А-Я][а-я]*$");
    private static final Pattern patternTelephone = Pattern.compile("^((\\+7)|8)(\\s|-|\\()?[0-9]{3}(\\s|-|\\))?([0-9](\\s|-)?){7}$");

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в телефонную книгу. Для просмотра контактов введите LIST. Для выхода из приложения введите END.");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            Matcher matcherName = patternName.matcher(input);
            Matcher matcherTelephone = patternTelephone.matcher(input);

            if (input.equals("LIST")) {
                getContactsList();
            } else if (matcherName.find()) {
                String name = input;
                System.out.println("Введите телефон, чтобы добавить контакт.");
                while (true) {
                    String secondInput = scanner.nextLine();
                    matcherTelephone = patternTelephone.matcher(secondInput);
                    if (matcherTelephone.find()) {
                        String telephone = cleanTelephone(secondInput);
                        contactsList.put(telephone, name);
                        System.out.println("Контакт добавлен в телефонную книгу.");
                        break;
                    } else {
                        System.out.println("Неверный формат телефона. Номер должен начинать с '8' или '+7' и может содержать пробелы, тире и скобочки.");
                    }
                }
            } else if (matcherTelephone.find()) {
                String telephone = cleanTelephone(input);
                System.out.println("Введите имя, чтобы добавить контакт.");
                while (true) {
                    String secondInput = scanner.nextLine();
                    matcherName = patternName.matcher(secondInput);
                    if (matcherName.find()) {
                        String name = secondInput;
                        contactsList.put(telephone, name);
                        System.out.println("Контакт добавлен в телефонную книгу.");
                        break;
                    } else {
                        System.out.println("Неверный формат имени. Имя должно начинаться с заглавной буквы и может состоять только из кириллических символов.");
                    }
                }
            } else if (input.equals("END")) {
                scanner.close();
                break;
            } else {
                System.out.println("Команда не найдена. Введите команду еще раз.");
            }
        }
    }

    public static void getContactsList () {
        if (contactsList.isEmpty()) {
            System.out.println("Список контактов пуст. Введите номер телефона или имя для добавления.");
        } else {
            System.out.println("Список контактов:");
            List<Map.Entry<String, String>> entries = new ArrayList<>(contactsList.entrySet());
            entries.sort(Map.Entry.comparingByValue());
            for (Map.Entry<String, String> pair : entries) {
                System.out.println(pair.getValue() + ' ' + pair.getKey());
            }
        }
    }

    public static String cleanTelephone (String telephone) {
        String cleanTelephone = telephone.replaceAll("[^+0-9]", "");
        if (!telephone.startsWith("+7")) {
            cleanTelephone = "+7" + cleanTelephone.substring(1);
        }
        return cleanTelephone;
    }
}
