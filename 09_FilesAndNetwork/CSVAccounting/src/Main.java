import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static final int ACCOUNT_TYPE = 0;
    private static final int ACCOUNT_NUMBER = 1;
    private static final int CURRENCY = 2;
    private static final int TRANSACTION_DATE = 3;
    private static final int TRANSACTION_REFERENCE_NUMBER = 4;
    private static final int COMPANY_NAME = 5;
    private static final int INCOME = 6;
    private static final int EXPENSES = 7;

    private static final Path FILE_PATH = Paths.get("../files/movementList.csv");

    private static final Pattern COMPANY_NAME_PATTERN = Pattern.compile("^(.*[\\w|\\d])([\\s]{8,})([0-9]{2}.[0-9]{2}.[0-9]{2})");
    private static final String DATE_FORMAT = "dd.MM.yyyy";

    public static void main(String[] args) {
        try {
            List<Transaction> transactions = getTransactionsFromFile();

            System.out.println("Сумма расходов: " + getTotalExpenses(transactions) + " руб.");
            System.out.println("Сумма доходов: " + getTotalIncome(transactions) + " руб.\n");

            System.out.println("Сумма расходов по организациям:");
            HashMap<String, Double> companyTotalExpenses = getExpensesByCompanies(transactions);
            for (String key : companyTotalExpenses.keySet()) {
                System.out.println(key + " - " + companyTotalExpenses.get(key) + " руб.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static List<Transaction> getTransactionsFromFile() throws IOException {
        if (!new File("../files/movementList.csv").exists()) {
            throw new FileNotFoundException("Файл не найден.");
        } else {
            return Files.readAllLines(FILE_PATH).stream().skip(1)
                    // Splitting by comma, unless in quotes. Found on https://stackabuse.com/regex-splitting-by-character-unless-in-quotes/
                    .map(e -> e.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"))
                    .map(components -> {
                        if (components.length != 8) {
                            throw new IllegalArgumentException("Неверный формат записи: " + Arrays.toString(components));
                        }

                        // Income and expenses formatting (replacing comma with dot, removing extra quotes)
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
                        Matcher matcherCompanyName = COMPANY_NAME_PATTERN.matcher(components[COMPANY_NAME].substring(29));
                        if (matcherCompanyName.find()) {
                            companyName = matcherCompanyName.group(1);
                        } else {
                            throw new IllegalArgumentException("Имя компании не определено.");
                        }

                        try {
                            return new Transaction(
                                    components[ACCOUNT_TYPE],
                                    components[ACCOUNT_NUMBER],
                                    components[CURRENCY],
                                    (new SimpleDateFormat(DATE_FORMAT)).parse(components[TRANSACTION_DATE]),
                                    components[TRANSACTION_REFERENCE_NUMBER],
                                    companyName,
                                    Double.parseDouble(components[INCOME]),
                                    Double.parseDouble(components[EXPENSES])
                            );
                        } catch (ParseException e) {
                            throw new IllegalArgumentException("Дата в некорректном формате.");
                        }
                    }).collect(Collectors.toList());
        }
    }

    private static HashMap<String, Double> getExpensesByCompanies(List<Transaction> transactions) {
        HashMap<String, Double> companyTotalExpenses = new HashMap<>();

        for (Transaction transaction : transactions) {
            if (!companyTotalExpenses.containsKey(transaction.getCompanyName())) {
                companyTotalExpenses.put(transaction.getCompanyName(), transaction.getExpenses());
            } else {
                companyTotalExpenses.replace(
                        (transaction.getCompanyName()),
                        companyTotalExpenses.get((transaction.getCompanyName())) + transaction.getExpenses()
                );
            }
        }
        return companyTotalExpenses;
    }

    private static Double getTotalExpenses(List<Transaction> transactions) {
        return transactions.stream().mapToDouble(Transaction::getExpenses).sum();
    }

    private static Double getTotalIncome(List<Transaction> transactions) {
        return transactions.stream().mapToDouble(Transaction::getIncome).sum();
    }
}
