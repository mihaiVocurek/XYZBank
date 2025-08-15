package tests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.CustomerTransactionsPage;
import pages.IndexPage;
import sharedData.SharedData;

public class ResetCustomerTransactionsTest extends SharedData {

    @Test
    public void testMethod(){

        openBrowser();

        String userFullName = "Hermoine Granger";

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin(userFullName);
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.clickTransactionsButton();

        CustomerTransactionsPage customerTransactionsPage = new CustomerTransactionsPage(getDriver());
        customerTransactionsPage.clickBackButton();

        customerAccountPage.validateUserLogin(userFullName);

        customerTransactionsPage.clickResetButton();
        customerTransactionsPage.validateEmptyTable();

        clearEnvironment();

    }

}
