import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.print("Введите ФИО: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            final String text = reader.readLine();

            if (text.length() > 64) {
                System.out.println("ФИО не может превышать 64 символа");
                continue;
            }

            final String regex = "([А-Я][а-я]*) ([А-Я][а-я]*) ([А-Я][а-я]*)";
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(text);

            if (!matcher.find()) {
                System.out.println("Фамилия, имя и отчество введены в неверном формате.\n" +
                        "ФИО должно состоять из трех слов, начинающихся с заглавной буквы.");
                continue;
            }
            String familyName = matcher.group(1);
            String givenName = matcher.group(2);
            String middleName = matcher.group(3);

            System.out.println("Фамилия: " + familyName);
            System.out.println("Имя: " + givenName);
            System.out.println("Отчество: " + middleName);
            break;
        }
    }
}