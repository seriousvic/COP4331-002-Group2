package JavaCartPro.src.controller;
import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class FinancialSummaryController {
    public void dashboardClick(AppData appData, User user, FinancialSummary financialSummary) {
        DataManager.saveData(appData);
        new DashboardView(appData, user);
        financialSummary.dispose();
    }
}
