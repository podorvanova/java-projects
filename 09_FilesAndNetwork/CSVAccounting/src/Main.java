import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            if (!new File("../files/movementList.csv").exists()) {
                throw new FileNotFoundException("Файл не найден.");
            } else {
                List<String> lines = Files.readAllLines(Paths.get("../files/movementList.csv"));
                lines.remove(0);

                double income = 0;
                double expenses = 0;
                HashMap<String, Double> companyTotalExpenses = new HashMap<>();

                for (String line : lines) {
                    // Splitting by comma, unless in quotes. Found on https://stackabuse.com/regex-splitting-by-character-unless-in-quotes/
                    String[] components = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                    if (components.length != 8) {
                        throw new IllegalArgumentException("Неверный формат записи: " + line);
                    }

                    // Record formatting (replacing comma with dot, removing extra quotes)
                    if (components[6].contains(",") || components[6].contains("\"")) {
                        components[6] = components[6].replace(",", ".");
                        components[6] = components[6].replaceAll("\"", "");
                    }
                    if (components[7].contains(",") || components[6].contains("\"")) {
                        components[7] = components[7].replace(",", ".");
                        components[7] = components[7].replaceAll("\"", "");
                    }

                    income += Double.parseDouble(components[6]);
                    expenses += Double.parseDouble(components[7]);

                    // Company name parsing
                    String companyName;
                    Matcher matcherCompanyName = Pattern.compile("^(.*[\\w|\\d])([\\s]{8,})([0-9]{2}.[0-9]{2}.[0-9]{2})").matcher(components[5].substring(29));
                    if (matcherCompanyName.find()) {
                        companyName = matcherCompanyName.group(1);
                    } else {
                        throw new IllegalArgumentException("Имя компании не определено.");
                    }

                    if (!companyTotalExpenses.containsKey(companyName)) {
                        companyTotalExpenses.put(companyName, Double.parseDouble(components[7]));
                    } else {
                        companyTotalExpenses.replace(companyName, companyTotalExpenses.get(companyName) + Double.parseDouble(components[7]));
                    }
                }
                System.out.println("Сумма расходов: " + income + " руб.");
                System.out.println("Сумма доходов: " + expenses + " руб.\n");
                System.out.println("Суммы расходов по организациям:");
                for (String key : companyTotalExpenses.keySet()) {
                    System.out.println(key + " - " + companyTotalExpenses.get(key) + " руб.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
