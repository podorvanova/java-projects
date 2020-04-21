import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        int sumIncome = 0;
        while (matcher.find()) {
            String income = matcher.group();
            sumIncome += Integer.parseInt(income);
        }

        System.out.println("Суммарный доход Васи, Пети и Маши: " + sumIncome + " рублей");
    }
}