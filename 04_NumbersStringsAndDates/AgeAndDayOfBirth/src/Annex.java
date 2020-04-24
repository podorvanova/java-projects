import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Annex {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1996, 1, 26);
        LocalDate today = LocalDate.now();

        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter dayOfWeek = DateTimeFormatter.ofPattern("E");

        int age = 0;
        while (birthday.isBefore(today)) {
            System.out.println(age + " - " + birthday.format(fullDate) + " - " + birthday.format(dayOfWeek));
            birthday = birthday.plusYears(1);
            age++;
        }
    }
}
