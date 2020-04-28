import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] colour = {"Красный", "Оранжевый", "Желтый", "Зеленый", "Голубой", "Синий", "Фиолетовый"};
        System.out.println(Arrays.toString(colour));

        for (int i = 0; i < colour.length / 2; i++) {
            String rememberColour = colour[i];
            colour[i] = colour[colour.length - i - 1];
            colour[colour.length - i - 1] = rememberColour;
        }
        System.out.println(Arrays.toString(colour));
    }
}
