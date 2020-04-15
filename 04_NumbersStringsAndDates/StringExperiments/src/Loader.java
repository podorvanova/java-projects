
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        //Зарплата Васи
        int vasyaIncomeBeginIndex = text.indexOf('5');
        String vasyaIncome = text.substring(vasyaIncomeBeginIndex, 19);

        //Зарплата Маши
        int mashaIncomeEndIndex = text.lastIndexOf('0');
        String mashaPreIncome = text.substring(55, mashaIncomeEndIndex + 1);
        String mashaIncome = mashaPreIncome.trim();

        int sumIncome = Integer.parseInt(vasyaIncome) + Integer.parseInt(mashaIncome);
        System.out.println("Суммарный доход Васи и Маши: " + sumIncome + " рублей");
    }
}