import java.util.*;

public class Main {
    public static final char[] letters = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    public static final ArrayList<String> numbers = new ArrayList<String>(Arrays.asList("111", "222", "333", "444", "555", "666", "777", "888", "999"));
    public static final ArrayList<String> regions = new ArrayList<>();
    public static ArrayList<String> numberPlates = new ArrayList<>();

    public static void main(String[] args) {
        generateRegionNumbers();
        generateNumberPlates();

        System.out.println("Введите автомобильный номер:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        linearSearch(input);
        binarySearch(input);
        hashSetSearch(input);
        treeSetSearch(input);
    }

    public static void generateRegionNumbers() {
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

    public static void generateNumberPlates() {
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

    public static void linearSearch(String input) {
        String searchResult;
        long startTime = System.nanoTime();
        if (numberPlates.contains(input)) {
            searchResult = "найден";
        } else {
            searchResult = "не найден";
        }
        long endTime = System.nanoTime();
        System.out.println("Поиск перебором: номер " + searchResult + ", поиск занял " + (endTime - startTime) + " нс.");
    }

    public static void binarySearch(String input) {
        Collections.sort(numberPlates);
        String searchResult;
        long startTime = System.nanoTime();
        int searchIndex = Collections.binarySearch(numberPlates, input);
        long endTime = System.nanoTime();
        if (searchIndex == -1) {
            searchResult = "не найден";
        } else {
            searchResult = "найден";
        }
        System.out.println("Бинарный поиск: номер " + searchResult + ", поиск занял " + (endTime - startTime) + " нс.");
    }

    public static void hashSetSearch(String input) {
        Set<String> numberPlatesInHS = new HashSet<String>(numberPlates);
        String searchResult;
        long startTime = System.nanoTime();
        if (numberPlatesInHS.contains(input)) {
            searchResult = "найден";
        } else {
            searchResult = "не найден";
        }
        long endTime = System.nanoTime();
        System.out.println("Поиск в HashSet: номер " + searchResult + ", поиск занял " + (endTime - startTime) + " нс.");
    }

    public static void treeSetSearch(String input) {
        Set<String> numberPlatesInTS = new TreeSet<String>(numberPlates);
        String searchResult;
        long startTime = System.nanoTime();
        if (numberPlatesInTS.contains(input)) {
            searchResult = "найден";
        } else {
            searchResult = "не найден";
        }
        long endTime = System.nanoTime();
        System.out.println("Поиск в TreeSet: номер " + searchResult + ", поиск занял " + (endTime - startTime) + " нс.");
    }
}