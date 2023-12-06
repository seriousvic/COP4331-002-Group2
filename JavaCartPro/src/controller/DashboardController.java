package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class DashboardController {

    public void goToInventoryClick(User user, DashboardView dashboardView) {
        dashboardView.dispose();
        new InventoryView(user);
    }

    public void goToCartClick(User user, ShoppingCart shoppingCart, DashboardView dashboardView) {
        dashboardView.dispose();
        new ShoppingCartView(shoppingCart, user);
    }

    public void goToFinancialSummaryClick(User user, FinancialHistory financialHistory, DashboardView dashboardView) {
        dashboardView.dispose();
        new FinancialSummary(user, ((Seller) user).getFinancialHistory());
    }


}
