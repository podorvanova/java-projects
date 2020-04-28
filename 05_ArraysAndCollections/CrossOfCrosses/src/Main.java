import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] array = new char[7][7];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || i + j == 6) {
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
    }
}
