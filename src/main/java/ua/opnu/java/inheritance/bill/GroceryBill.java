package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private final Employee clerk;
    private final List<Item> receipt;
    private double total;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.receipt = new ArrayList<>();
        this.total = 0.0F;
    }

    public void add(Item i) {
        this.receipt.add(i);
        this.total += i.getPrice();
    }

    public double getTotal() {
        return Math.rint(this.total * (double)100.0F) / (double)100.0F;
    }

    public Employee getClerk() {
        return this.clerk;
    }
}
