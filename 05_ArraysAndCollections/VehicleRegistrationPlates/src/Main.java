import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final char[] letters = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    public static final ArrayList<String> numbers = new ArrayList<String>(Arrays.asList("111", "222", "333", "444", "555", "666", "777", "888", "999"));
    public static final ArrayList<String> regions = new ArrayList<>();
    public static ArrayList<String> numberPlates = new ArrayList<>();

    public static void main(String[] args) {
        generateRegionNumbers();
        generateNumberPlates();
    }

    public static void generateRegionNumbers () {
        String regionNumber;
        for (int i = 1; i <= 199; i++) {
            if (i < 10) {
                regionNumber = '0' + Integer.toString(i);
            } else {
                regionNumber = Integer.toString(i);
            }
            regions.add(regionNumber);
        }
    }
    public static void generateNumberPlates () {
        String numberPlate;
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < numbers.size(); j++) {
                for (int k = 0; k < letters.length; k++) {
                    for (int l = 0; l < letters.length; l++) {
                        for (int m = 0; m < regions.size(); m++) {
                            numberPlate = letters[i] + numbers.get(j) + letters[k] + letters[l] + regions.get(m);
                            numberPlates.add(numberPlate);
                        }
                    }
                }
            }
        }
    }
}
