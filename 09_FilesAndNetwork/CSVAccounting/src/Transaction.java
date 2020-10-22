import java.util.Date;

public class Transaction {
    private final String accountType;
    private final String accountNumber;
    private final String currency;
    private final Date transactionDate;
    private final String transactionReferenceNumber;
    private final String companyName;
    private final Double income;
    private final Double expenses;

    public Transaction(String accountType,
                       String accountNumber,
                       String currency,
                       Date transactionDate,
                       String transactionReferenceNumber,
                       String companyName,
                       Double income,
                       Double expenses) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.transactionReferenceNumber = transactionReferenceNumber;
        this.companyName = companyName;
        this.income = income;
        this.expenses = expenses;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Double getExpenses() { return expenses; }

    public Double getIncome() { return income; }
}
