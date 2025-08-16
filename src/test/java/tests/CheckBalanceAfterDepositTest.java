package tests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class CheckBalanceAfterDepositTest extends SharedData {

    @Test(groups = {Suite.SANITY_SUITE, Suite.REGRESSION_SUITE, Suite.CUSTOMER_SUITE})
    public void testMethod() {

        String userFullName = "Hermoine Granger";
        int depositAmount = 100;

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin(userFullName);
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.clickDepositButton();
        customerAccountPage.enterDepositAmount(depositAmount);
        customerAccountPage.validateSuccessfulDeposit();
        customerAccountPage.validateBalanceAfterDeposit(depositAmount);
    }
}
