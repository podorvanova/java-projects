import java.util.*;

public class Main {
    private static final HashMap<Integer, String> contactsList = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в телефонную книгу. Для просмотра контактов введите LIST. Для выхода из приложения введите END.");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("LIST")) {
                getContactsList();
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
            List<Map.Entry<Integer, String>> entries = new ArrayList<>(contactsList.entrySet());
            entries.sort(Map.Entry.comparingByValue());
            for (Map.Entry<Integer, String> pair : entries) {
                System.out.println(pair.getValue() + ' ' + pair.getKey());
            }
        }
    }
}
