package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class DashboardController {

    public void goToInventoryClick(User user) {

        new InventoryView(user);
    }

    public void goToCartClick(User user, ShoppingCart shoppingCart) {
        new ShoppingCartView(shoppingCart, user);
    }

    public void goToFinancialSummaryClick(User user, FinancialHistory financialHistory) {
        new FinancialSummary(user, ((Seller) user).getFinancialHistory());
    }


}
