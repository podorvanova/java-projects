import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ncase {
    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.print("Введите размерность массива: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            int demention = Integer.parseInt(input);

            if (demention < 0) {
                System.out.println("Размерность массива не может быть отрицательной");
                continue;
            }

            char[][] array = new char[demention][demention];

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (i == j || i + j == demention - 1) {
                        array[i][j] = 'X';
                    } else {
                        array[i][j] = ' ';
                    }
                }
            }

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
            break;
        }
    }
}
