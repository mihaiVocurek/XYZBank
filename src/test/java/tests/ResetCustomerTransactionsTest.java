package tests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.CustomerTransactionsPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class ResetCustomerTransactionsTest extends SharedData {

    @Test(groups = {Suite.SANITY_SUITE, Suite.REGRESSION_SUITE, Suite.CUSTOMER_SUITE})
    public void testMethod(){

        String userFullName = "Hermoine Granger";

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin(userFullName);
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.validateUserLogin(userFullName);
        customerAccountPage.clickTransactionsButton();

        CustomerTransactionsPage customerTransactionsPage = new CustomerTransactionsPage(getDriver());
        customerTransactionsPage.clickBackButton();

        customerAccountPage.clickTransactionsButton();
        customerTransactionsPage.clickResetButton();
        customerTransactionsPage.validateEmptyTable();
    }
}
