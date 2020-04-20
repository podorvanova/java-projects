import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите номер телефона: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String phone = reader.readLine();
        String cleanPhone;

        if (phone.charAt(0) == '8') {
            cleanPhone = '7' + phone.substring(1).replaceAll("[^0-9]", "");
        } else {
            cleanPhone = phone.replaceAll("[^0-9]", "");
        }

        System.out.print("Введенный номер очищен. Результат очистки: ");
        System.out.println(cleanPhone);
    }
}
