package tests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.IndexPage;
import sharedData.SharedData;

public class CheckBalanceAfterWithdrawalTest extends SharedData {

    @Test
    public void testMethod() {

        String userFullName = "Hermoine Granger";
        int withdrawalAmount = 75;

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin(userFullName);
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.clickWithdrawalButton();
        customerAccountPage.enterWithdrawalAmount(withdrawalAmount);
        customerAccountPage.validateSuccessfulWithdrawal();
        customerAccountPage.validateBalanceAfterWithdrawal(withdrawalAmount);
    }
}
