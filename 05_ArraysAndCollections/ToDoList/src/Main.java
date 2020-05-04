import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final List<String> toDoList = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в ToDoList! Для просмотра списка дел введите LIST. Для выхода введите END.");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            final Matcher listMatcher = Pattern.compile("^LIST$").matcher(input);
            final Matcher addMatcher = Pattern.compile("^ADD ([0-9]+ )?([А-Яа-я\\s]*)$").matcher(input);
            final Matcher editMatcher = Pattern.compile("^EDIT ([0-9]+) ([А-Яа-я\\s]*)$").matcher(input);
            final Matcher deleteMatcher = Pattern.compile("^DELETE ([0-9]+)$").matcher(input);
            final Matcher endMatcher = Pattern.compile("^END$").matcher(input);

            if (listMatcher.find()) {
                getList();
            } else if (addMatcher.find()) {
                String toDoElement = addMatcher.group(2);
                if (addMatcher.group(1) != null) {
                    int index = Integer.parseInt(addMatcher.group(1).trim());
                    addToList(index, toDoElement);
                } else {
                    addToList(toDoList.size() + 1, toDoElement);
                }
            } else if (editMatcher.find()) {
                int index = Integer.parseInt(editMatcher.group(1));
                String toDoElement = editMatcher.group(2);
                editItem(index, toDoElement);
            } else if (deleteMatcher.find()) {
                int index = Integer.parseInt(deleteMatcher.group(1));
                deleteItem(index);
            } else if (endMatcher.find()) {
                scanner.close();
                break;
            } else {
                System.out.println("Команда не найдена. Введите команду еще раз.");
            }
        }
    }

    public static void getList () {
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст. Введите ADD для добавления дела.");
        } else {
            System.out.println("Список дел:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    public static void addToList (int index, String toDoElement) {
        toDoList.add(index - 1, toDoElement);
        System.out.println("Дело \"" + toDoElement + "\" добавлено в Список дел.");
    }

    public static void editItem (int index, String toDoElement) {
        String previousElement = toDoList.get(index - 1);
        toDoList.set(index - 1, toDoElement);
        System.out.println("Дело \"" + previousElement + "\" было заменено на дело \"" + toDoElement + "\".");
    }

    public static void deleteItem (int index) {
        String deletedItem = toDoList.get(index - 1);
        toDoList.remove(index - 1);
        System.out.println("Дело \"" + deletedItem + "\" было удалено из Списка дел.");
    }
}