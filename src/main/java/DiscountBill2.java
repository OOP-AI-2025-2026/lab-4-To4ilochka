import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountBill2 {
    private final GroceryBill baseBill;
    private final boolean isBuyerRegular;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean isBuyerRegular) {
        this.baseBill = new GroceryBill(clerk);
        this.isBuyerRegular = isBuyerRegular;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item i) {
        this.baseBill.add(i);

        if (isBuyerRegular) {
            double itemDiscount = i.getDiscount();
            if (itemDiscount > 0.0) {
                discountCount++;
                discountAmount += itemDiscount;
            }
        }
    }

    public double getTotal() {
        double fullTotal = this.baseBill.getTotal();

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

        double fullTotal = this.baseBill.getTotal();

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

    public Employee getClerk() {
        return this.baseBill.getClerk();
    }
}