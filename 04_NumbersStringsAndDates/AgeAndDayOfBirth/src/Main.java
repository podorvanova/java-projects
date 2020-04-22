import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        //Необходимый формат
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        //Текущий день
        Calendar today = Calendar.getInstance();
        //День рождения
        Calendar dayOfBirth = new GregorianCalendar(1996, 0,26);
        DateFormat dayOfWeek = new SimpleDateFormat("E");

        int age = 0;
        while (dayOfBirth.before(today)) {
            System.out.println(age + " - " + dateFormat.format(dayOfBirth.getTime()) + " - " + dayOfWeek.format(dayOfBirth.getTime()));
            dayOfBirth.add(Calendar.YEAR, 1);
            age++;
        }
    }
}