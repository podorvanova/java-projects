import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final int COMPANY_NAME = 5;
    private static final int INCOME = 6;
    private static final int EXPENSES = 7;

    public static void main(String[] args) {
        try {
            if (!new File("../files/movementList.csv").exists()) {
                throw new FileNotFoundException("Файл не найден.");
            } else {
                HashMap<String, Double> companyTotalExpenses = new HashMap<>();

                Pattern companyNamePattern = Pattern.compile("^(.*[\\w|\\d])([\\s]{8,})([0-9]{2}.[0-9]{2}.[0-9]{2})");

                Path filePath = Paths.get("../files/movementList.csv");

                IncomeAndExpenses result = Files.readAllLines(filePath).stream().skip(1)
                        // Splitting by comma, unless in quotes. Found on https://stackabuse.com/regex-splitting-by-character-unless-in-quotes/
                        .map(e -> e.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"))
                        .peek(components -> {
                            if (components.length != 8) {
                                throw new IllegalArgumentException("Неверный формат записи: " + Arrays.toString(components));
                            }

                            // Record formatting (replacing comma with dot, removing extra quotes)
                            if (components[INCOME].contains(",") || components[INCOME].contains("\"")) {
                                components[INCOME] = components[INCOME].replace(",", ".");
                                components[INCOME] = components[INCOME].replaceAll("\"", "");
                            }
                            if (components[EXPENSES].contains(",") || components[EXPENSES].contains("\"")) {
                                components[EXPENSES] = components[EXPENSES].replace(",", ".");
                                components[EXPENSES] = components[EXPENSES].replaceAll("\"", "");
                            }

                            // Company name parsing
                            String companyName;
                            Matcher matcherCompanyName = companyNamePattern.matcher(components[COMPANY_NAME].substring(29));
                            if (matcherCompanyName.find()) {
                                companyName = matcherCompanyName.group(1);
                            } else {
                                throw new IllegalArgumentException("Имя компании не определено.");
                            }

                            if (!companyTotalExpenses.containsKey(companyName)) {
                                companyTotalExpenses.put(companyName, Double.parseDouble(components[EXPENSES]));
                            } else {
                                companyTotalExpenses.replace(
                                        companyName,
                                        companyTotalExpenses.get(companyName) + Double.parseDouble(components[EXPENSES])
                                );
                            }
                        })
                        // Uses IncomeAndExpenses object - a pair of income and expenses
                        .reduce(
                                new IncomeAndExpenses(0.0, 0.0),
                                (incomeAndExpenses, components) ->
                                        new IncomeAndExpenses(
                                                incomeAndExpenses.income + Double.parseDouble(components[INCOME]),
                                                incomeAndExpenses.expenses + Double.parseDouble(components[EXPENSES])
                                        ),
                                IncomeAndExpenses::sum
                        );

                System.out.println("Сумма расходов: " + result.expenses + " руб.");
                System.out.println("Сумма доходов: " + result.income + " руб.\n");
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
