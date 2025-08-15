package tests;

import enums.transactionType;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.CustomerTransactionsPage;
import pages.IndexPage;
import sharedData.SharedData;

public class CheckDepositInTransactionsTest extends SharedData {

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
        customerAccountPage.selectAccountNumber("1003");
        customerAccountPage.clickDepositButton();
        customerAccountPage.enterDepositAmount(100);
        customerAccountPage.validateSuccessfulDeposit();

        customerAccountPage.clickTransactionsButton();

        CustomerTransactionsPage customerTransactionsPage = new CustomerTransactionsPage(getDriver());
        customerTransactionsPage.validateLatestTransaction(depositAmount, transactionType.Deposit);

    }

}
