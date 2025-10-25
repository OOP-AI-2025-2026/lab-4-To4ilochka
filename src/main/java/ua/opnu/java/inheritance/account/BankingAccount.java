package ua.opnu.java.inheritance.account;

import java.util.LinkedList;
import java.util.List;

public class BankingAccount {
    private int balance;
    private List<String> historyTransaction;
    private List<String> historyBalance;

    public BankingAccount(Startup s) {
        this.balance = s.balance();
        this.historyTransaction = new LinkedList();
        this.historyBalance = new LinkedList();
        this.historyTransaction.add(this.valueToHistory(s.balance()));
        this.historyBalance.add(this.toString());
    }

    public void debit(Debit d) {
        this.balance += d.balance();
        this.historyTransaction.add(this.valueToHistory(d.balance()));
        this.historyBalance.add(this.toString());
    }

    public void credit(Credit c) {
        this.balance += c.balance();
        this.historyTransaction.add(this.valueToHistory(c.balance()));
        this.historyBalance.add(this.toString());
    }

    public int getBalance() {
        return this.balance;
    }

    public boolean equals(Object o) {
        if (o instanceof BankingAccount) {
            return this.getBalance() == ((BankingAccount)o).getBalance();
        } else {
            return false;
        }
    }

    private String valueToHistory(int value) {
        int absValue = Math.abs(value);
        return (value < 0 ? "(-" : "") + absValue / 100 + "." + absValue % 100 / 10 + absValue % 100 % 10 + (value < 0 ? ")" : " ");
    }

    public String toString() {
        int absBalance = Math.abs(this.balance);
        String var10000 = this.balance < 0 ? "-" : "";
        return var10000 + "$" + absBalance / 100 + "." + absBalance % 100 / 10 + absBalance % 100 % 10;
    }
}
