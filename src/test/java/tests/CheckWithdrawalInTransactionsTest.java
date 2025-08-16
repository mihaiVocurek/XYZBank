package tests;

import enums.transactionType;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.CustomerTransactionsPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class CheckWithdrawalInTransactionsTest extends SharedData {

    @Test(groups = {Suite.SANITY_SUITE, Suite.REGRESSION_SUITE, Suite.CUSTOMER_SUITE})
    public void testMethod() {

        int withdrawalAmount = 50;

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin("Hermoine Granger");
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.selectAccountNumber("1001");

        customerAccountPage.clickWithdrawalButton();
        customerAccountPage.enterWithdrawalAmount(50);
        customerAccountPage.validateSuccessfulWithdrawal();
        customerAccountPage.refreshTransactionsPage();
        customerAccountPage.clickTransactionsButton();

        CustomerTransactionsPage customerTransactionsPage = new CustomerTransactionsPage(getDriver());
        customerTransactionsPage.validateLatestTransaction(withdrawalAmount, transactionType.Withdrawal);

    }

}
