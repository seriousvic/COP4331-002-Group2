package JavaCartPro.src.controller;
import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

/**
 * controller for the financial summary class
 */
public class FinancialSummaryController {
    /**
     * function to return to dashboard
     * @param appData data stored by the program
     * @param user user returning to dashboard
     * @param financialSummary financial summary page
     */
    public void dashboardClick(AppData appData, User user, FinancialSummary financialSummary) {
        DataManager.saveData(appData);
        new DashboardView(appData, user);
        financialSummary.dispose();
    }
}
