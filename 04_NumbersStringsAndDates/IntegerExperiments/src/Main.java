public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(1010104));
        System.out.println(sumDigitsStar(102012));

    }

    public static Integer sumDigits(Integer number) {
        String numberString = number.toString();
        int sumDigits = 0;
        for (int i = 0; i < numberString.length(); i++) {
            char symbol = numberString.charAt(i);
            sumDigits += Integer.parseInt(String.valueOf(symbol));
        }
        return sumDigits;
    }

    public static Integer sumDigitsStar(Integer number) {
        String numberString = number.toString();
        int sumDigits = 0;
        for (int i = 0; i < numberString.length(); i++) {
            char symbol = numberString.charAt(i);
            sumDigits += Character.getNumericValue(symbol);
        }
        return sumDigits;
    }
}
