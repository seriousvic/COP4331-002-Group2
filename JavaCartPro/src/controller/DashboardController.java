package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class DashboardController {

    public void goToInventoryClick(AppData appData, User user, DashboardView dashboardView) {
        new InventoryView(appData, user);
        dashboardView.dispose();
    }

    public void goToCartClick(AppData appData, User user, ShoppingCart shoppingCart, DashboardView dashboardView) {
        new ShoppingCartView(appData, shoppingCart, user);
        dashboardView.dispose();
    }

    public void goToFinancialSummaryClick(AppData appData, User user, FinancialHistory financialHistory, DashboardView dashboardView) {
        new FinancialSummary(appData, user, ((Seller) user).getFinancialHistory());
        dashboardView.dispose();
    }

    public void goToListProductClick(AppData appData, User user, DashboardView dashboardView) {
        new ListProductView(appData, user);
    }
}
