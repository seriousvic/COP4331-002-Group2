package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

/**
 * controller for the dashboard
 */
public class DashboardController {
    /**
     * function to go to inventory screen
     * @param appData data stored by the program
     * @param user user viewing the inventory
     * @param dashboardView dashboard screen
     */
    public void goToInventoryClick(AppData appData, User user, DashboardView dashboardView) {
        DataManager.saveData(appData);
        new InventoryView(appData, user);
        dashboardView.dispose();
    }

    /**
     * function to go to the shopping cart
     * @param appData data stored by the program
     * @param user customer going to shopping cart
     * @param shoppingCart customer's shopping cart
     * @param dashboardView dashboard screen
     */
    public void goToCartClick(AppData appData, User user, ShoppingCart shoppingCart, DashboardView dashboardView) {
        DataManager.saveData(appData);
        new ShoppingCartView(appData, shoppingCart, user);
        dashboardView.dispose();
    }

    /**
     * function to go to a seller's financial summary
     * @param appData data stored by the program
     * @param user seller viewing financial summary
     * @param financialHistory seller's financial history
     * @param dashboardView dashboard screen
     */
    public void goToFinancialSummaryClick(AppData appData, User user, FinancialHistory financialHistory, DashboardView dashboardView) {
        DataManager.saveData(appData);
        new FinancialSummary(appData, user, ((Seller) user).getFinancialHistory());
        dashboardView.dispose();
    }

    /**
     * function to display product list screen
     * @param appData data stored by the program
     * @param user user viewing the product list
     * @param dashboardView dashboard screen
     */
    public void goToListProductClick(AppData appData, User user, DashboardView dashboardView) {
        DataManager.saveData(appData);
        new ListProductView(appData, user);
    }

    /**
     * function to log out
     * @param dashboardView dashboard screen
     */
    public void logoutClick(DashboardView dashboardView) {
        new ShoppingCartApp().setVisible(true);
        dashboardView.dispose();
    }
}
