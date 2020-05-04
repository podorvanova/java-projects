import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> toDoList = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в ToDoList! Для просмотра списка дел введите LIST. Для выхода введите END.");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
            if (command.equals("LIST")) {
                getList();
            } else if (command.equals("ADD")) {
                addToList(scanner);
            } else if (command.equals("EDIT")) {
                editItem(scanner);
            } else if (command.equals("DELETE")) {
                deleteItem(scanner);
            } else if (command.equals("END")) {
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

    public static void addToList (Scanner scanner) {
        String toDo;
        if (scanner.hasNextInt()) {
            int index = scanner.nextInt();
            toDo = scanner.nextLine().trim();
            toDoList.add(index - 1, toDo);
        } else {
            toDo = scanner.nextLine().trim();
            toDoList.add(toDo);
        }
        System.out.println("Дело \"" + toDo + "\" добавлено в Список дел.");
    }

    public static void editItem (Scanner scanner) {
        int index = scanner.nextInt();
        String toDo = scanner.nextLine().trim();
        String previousToDo = toDoList.get(index - 1);
        toDoList.set(index - 1, toDo);
        System.out.println("Дело \"" + previousToDo + "\" было заменено на дело \"" + toDo + "\".");
    }

    public static void deleteItem (Scanner scanner) {
        int index = scanner.nextInt();
        String deletedItem = toDoList.get(index - 1);
        toDoList.remove(index - 1);
        System.out.println("Дело \"" + deletedItem + "\" было удалено из Списка дел.");
    }
}
