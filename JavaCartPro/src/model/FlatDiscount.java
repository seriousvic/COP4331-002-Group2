package JavaCartPro.src.model;

public class FlatDiscount implements Discount{

    double amount;

    public FlatDiscount(double dollarAmount) {
        amount = dollarAmount;
    }
    @Override
    public void applyDiscount(Transaction purchase) {
        if (purchase.getRevenue() - amount >= 0) {
            double newRevenue = purchase.getRevenue() - amount;
            purchase.setRevenue(newRevenue);
        }
        else {
            purchase.setRevenue(0);
        }
    }
}

