package ua.opnu.lab.account;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int startBalance = getBalance();
        this.minBalance = startBalance;
        this.maxBalance = startBalance;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateMinMax();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMax();
    }

    private void updateMinMax() {
        int current = getBalance();
        if (current < minBalance) {
            minBalance = current;
        }
        if (current > maxBalance) {
            maxBalance = current;
        }
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
