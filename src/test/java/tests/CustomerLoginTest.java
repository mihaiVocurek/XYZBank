package tests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.IndexPage;
import sharedData.SharedData;

public class CustomerLoginTest extends SharedData {

    @Test
    public void testMethod() throws InterruptedException {

        openBrowser();

        String userFullName = "Harry Potter";
        String accountNumber = "1005";

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin(userFullName);
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.validateUserLogin(userFullName);
        customerAccountPage.selectAccountNumber(accountNumber);
        customerAccountPage.validateAccountSelection(accountNumber);

        customerAccountPage.clickDepositButton();
        customerAccountPage.enterDepositAmount("100");
        customerAccountPage.validateSuccessfulDeposit();

        customerAccountPage.clickWithdrawalButton();
        Thread.sleep(1000);
        customerAccountPage.enterWithdrawalAmount("50");
        customerAccountPage.validateSuccessfulWithdrawal();

        customerAccountPage.clickWithdrawalButton();
        customerAccountPage.enterWithdrawalAmount("2000");
        customerAccountPage.validateUnsuccessfulWithdrawal();


        clearEnvironment();
    }

}
