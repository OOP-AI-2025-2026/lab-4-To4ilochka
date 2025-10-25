package ua.opnu.java.inheritance.bill;

public class Item {
    private String name;
    private final double price;
    private final double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }
}
