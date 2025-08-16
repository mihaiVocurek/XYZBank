package tests;

import org.testng.annotations.Test;
import pages.BankManagerOpenAccountPage;
import pages.BankManagerPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class OpenAccountTest extends SharedData {

    @Test(groups = {Suite.SMOKE_SUITE, Suite.REGRESSION_SUITE, Suite.BANK_MANAGER_SUITE})
    public void testMethod(){

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBankManagerMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(getDriver());
        bankManagerPage.interactWithOpenAccount();

        BankManagerOpenAccountPage bankManagerOpenAccountPage = new BankManagerOpenAccountPage(getDriver());
        bankManagerOpenAccountPage.chooseCustomerName("Harry Potter");
        bankManagerOpenAccountPage.chooseCurrency("Dollar");
        bankManagerOpenAccountPage.clickProcess();
        bankManagerOpenAccountPage.validateNewAccountCreated();
        bankManagerOpenAccountPage.dealAlertOk();

    }
}