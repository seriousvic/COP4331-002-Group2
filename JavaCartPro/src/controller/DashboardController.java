package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class DashboardController {

    public void goToInventoryClick(User user, DashboardView dashboardView) {
        new InventoryView(user);
        dashboardView.dispose();
    }

    public void goToCartClick(User user, ShoppingCart shoppingCart, DashboardView dashboardView) {
        new ShoppingCartView(shoppingCart, user);
        dashboardView.dispose();
    }

    public void goToFinancialSummaryClick(User user, FinancialHistory financialHistory, DashboardView dashboardView) {
        new FinancialSummary(user, ((Seller) user).getFinancialHistory());
        dashboardView.dispose();
    }


}
