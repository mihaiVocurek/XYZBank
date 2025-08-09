package tests;

import org.testng.annotations.Test;
import pages.BankManagerOpenAccountPage;
import pages.BankManagerPage;
import pages.IndexPage;
import sharedData.SharedData;

public class OpenAccountTest extends SharedData {

    @Test
    public void testMethod(){

        openBrowser();

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBankManagerMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(getDriver());
        bankManagerPage.interactWithOpenAccount();

        BankManagerOpenAccountPage bankManagerOpenAccountPage = new BankManagerOpenAccountPage(getDriver());
        bankManagerOpenAccountPage.chooseCustomerName("Hermoine Granger");
        bankManagerOpenAccountPage.chooseCurrency("Dollar");
        bankManagerOpenAccountPage.clickProcess();

        System.out.println(bankManagerOpenAccountPage.getAlertText());
        System.out.println(bankManagerOpenAccountPage.getNewAccountNumer());
        bankManagerOpenAccountPage.validateNewAccountCreated();
        bankManagerOpenAccountPage.dealAlertOk();

        clearEnvironment();

    }

}
