public abstract class Client {
    protected int balance = 0;

    public void depositCash(int cash) {
        if (cash > 0) {
            int depositCommission = getDepositCommission(cash);
            balance = balance + cash - depositCommission;
            System.out.println("Денежные средства в размере " + formatMoney(cash) + " зачислены.");
            if (depositCommission != 0) {
                System.out.println("Коммисия за пополнение составляет " + formatMoney(depositCommission) + ".");
            }
        } else {
            System.out.println("Сумма пополнения должна быть положительным числом.");
        }
    }

    protected abstract int getDepositCommission(int cash);

    public void withdrawCash(int cash) {
        if (cash > 0) {
            int withdrawalCommission = getWithdrawalCommission(cash);
            if (balance - cash - withdrawalCommission >= 0) {
                balance = balance - cash - withdrawalCommission;
                System.out.println("Денежные средства в размере " + formatMoney(cash) + " выведены.");
                if (withdrawalCommission != 0) {
                    System.out.println("Коммисия за снятие составляет " + formatMoney(withdrawalCommission) + ".");
                }
            } else {
                System.out.println("Вы не можете вывести сумму больше вашего остатка.");
            }
        } else {
            System.out.println("Сумма снятия наличных должна быть положительным числом.");
        }
    }

    protected abstract int getWithdrawalCommission(int cash);

    public void getBalance() {
        System.out.println("Баланс на счёте " + formatMoney(balance) + ".");
    }

    public abstract void getInformation();

    private String formatMoney(int money) {
        String formatMoney;
        if (money >= 100) {
            formatMoney = (money / 100 ) + " рублей " + (money % 100) + " копеек";
        } else {
            formatMoney = (money % 100) + " копеек";
        }
        return formatMoney;
    }
}
