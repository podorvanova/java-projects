import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Name {
    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.print("Введите ФИО: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String text = reader.readLine();

            if (text.length() > 64) {
                System.out.println("ФИО не может превышать 64 символа");
                continue;
            }

            String familyName = text.substring(0, text.indexOf(' '));
            String givenName = text.substring(text.indexOf(' ') + 1, text.lastIndexOf(' '));
            String middleName = text.substring(text.lastIndexOf(' ') + 1);

            System.out.println("Фамилия: " + familyName);
            System.out.println("Имя: " + givenName);
            System.out.println("Отчество: " + middleName);
            break;
        }
    }
}