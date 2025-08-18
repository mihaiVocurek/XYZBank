package tests;

import enums.TransactionType;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.CustomerTransactionsPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class CheckDepositInTransactionsTest extends SharedData {

    @Test(groups = {Suite.SANITY_SUITE, Suite.REGRESSION_SUITE, Suite.CUSTOMER_SUITE})
    public void testMethod() {

        int depositAmount = 100;
        int withdrawalAmount = 50;

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin("Hermoine Granger");
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.selectAccountNumber("1003");
        customerAccountPage.clickDepositButton();
        customerAccountPage.enterDepositAmount(100);
        customerAccountPage.validateSuccessfulDeposit();

        customerAccountPage.clickLogoutButton();
        customerPage.chooseUserForLogin("Hermoine Granger");
        customerPage.clickLogin();
        customerAccountPage.selectAccountNumber("1003");

        customerAccountPage.clickTransactionsButton();

        CustomerTransactionsPage customerTransactionsPage = new CustomerTransactionsPage(getDriver());
        customerTransactionsPage.validateLatestTransaction(depositAmount, TransactionType.Deposit);

    }
}