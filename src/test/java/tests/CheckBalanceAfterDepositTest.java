package tests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.IndexPage;
import sharedData.SharedData;

public class CheckBalanceAfterDepositTest extends SharedData {

    @Test
    public void testMethod() throws InterruptedException {

        openBrowser();

        String userFullName = "Hermoine Granger";
        int depositAmount = 100;

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin(userFullName);
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.enterDepositAmount(depositAmount);
        customerAccountPage.validateSuccessfulDeposit();
        customerAccountPage.validateBalanceAfterDeposit(depositAmount);

        clearEnvironment();

    }

}
