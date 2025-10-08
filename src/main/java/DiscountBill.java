import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountBill extends GroceryBill {
    private final boolean isBuyerRegular;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean isBuyerRegular) {
        super(clerk);
        this.isBuyerRegular = isBuyerRegular;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item i) {
        // Додаємо товар, дозволяючи батьківському класу GroceryBill обчислити повну суму
        super.add(i);

        // Облік знижок лише для постійних клієнтів
        if (isBuyerRegular) {
            double itemDiscount = i.getDiscount();
            if (itemDiscount > 0.0) {
                discountCount++;
                discountAmount += itemDiscount;
            }
        }
    }

    @Override
    public double getTotal() {
        double fullTotal = super.getTotal();

        if (isBuyerRegular) {
            double discountedTotal = fullTotal - discountAmount;
            return Math.rint(discountedTotal * 100.0) / 100.0;
        } else {
            return fullTotal;
        }
    }

    public int getDiscountCount() {
        return isBuyerRegular ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return isBuyerRegular
                ? Math.rint(discountAmount * 100.0) / 100.0
                : 0.0;
    }

    public double getDiscountPercent() {
        if (!isBuyerRegular) {
            return 0.0;
        }

        double fullTotal = super.getTotal();

        if (fullTotal == 0.0) {
            return 0.0;
        }

        double discountedTotal = fullTotal - discountAmount;

        BigDecimal totalBD = BigDecimal.valueOf(discountedTotal);
        BigDecimal originalBD = BigDecimal.valueOf(fullTotal);

        BigDecimal percent = BigDecimal.valueOf(100)
                .subtract(totalBD.multiply(BigDecimal.valueOf(100))
                        .divide(originalBD, 15, RoundingMode.HALF_UP));

        return percent.doubleValue();
    }
}