import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Name {
    public static int spaceCount(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    /* Метод проверяет, что строка состоит из символов русского алфавита.
       Кода символов от 'А' до 'я' последовательны в таблице символов Юникод.
       Кода символов 'Ё' и 'ё' лежат вне промежутка от 'А' до 'я'.
     */
    public static boolean isTextRussian(String text) {
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) < 'А' || text.charAt(i) > 'я') && text.charAt(i) != 'Ё' && text.charAt(i) != 'ё') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.print("Введите ФИО: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String text = reader.readLine();

            if (text.length() > 64) {
                System.out.println("ФИО не может превышать 64 символа");
                continue;
            }

            int spaceCount = spaceCount(text);
            if (spaceCount != 2) {
                System.out.println("В ФИО должно быть 2 пробела");
                continue;
            }

            String familyName = text.substring(0, text.indexOf(' '));
            String givenName = text.substring(text.indexOf(' ') + 1, text.lastIndexOf(' '));
            String middleName = text.substring(text.lastIndexOf(' ') + 1);

            if (Character.isLowerCase(familyName.charAt(0)) ||
                    Character.isLowerCase(givenName.charAt(0)) ||
                    Character.isLowerCase(middleName.charAt(0))) {
                System.out.println("Фамилия, имя и отчество должны начинаться с заглавной буквы");
                continue;
            }

            if (!isTextRussian(familyName) || !isTextRussian(givenName) || !isTextRussian(middleName)) {
                System.out.println("ФИО должно содержать только символы русского алфавита");
                continue;
            }

            System.out.println("Фамилия: " + familyName);
            System.out.println("Имя: " + givenName);
            System.out.println("Отчество: " + middleName);
            break;
        }
    }
}