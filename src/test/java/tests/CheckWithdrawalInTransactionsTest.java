package tests;

import enums.transactionType;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.CustomerTransactionsPage;
import pages.IndexPage;
import sharedData.SharedData;

public class CheckWithdrawalInTransactionsTest extends SharedData {

    @Test
    public void testMethod() {

        int depositAmount = 100;
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
        indexPage.refreshWebpage();
        customerAccountPage.clickTransactionsButton();

        CustomerTransactionsPage customerTransactionsPage = new CustomerTransactionsPage(getDriver());
        customerTransactionsPage.validateLatestTransaction(withdrawalAmount, transactionType.Withdrawal);

    }

}
