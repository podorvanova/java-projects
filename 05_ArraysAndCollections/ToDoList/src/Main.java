import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в ToDoList! Для просмотра списка дел введите LIST. Для выхода введите END.");
        ArrayList<String> toDoList = new ArrayList<>();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();

            if (command.equals("LIST")) {
                getList(toDoList);
            } else if (command.equals("ADD")) {
                addToList(toDoList, scanner);
            }
        }
    }

    public static void getList (ArrayList<String> toDoList) {
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст. Введите ADD для добавления дела.");
        } else {
            System.out.println("Список дел:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    public static void addToList (ArrayList<String> toDoList, Scanner scanner) {
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
}
