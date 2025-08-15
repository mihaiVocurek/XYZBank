package tests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerPage;
import pages.IndexPage;
import sharedData.SharedData;

public class CustomerLoginTest extends SharedData {

    @Test
    public void testMethod() {

        String userFullName = "Ron Weasly";
        String accountNumber = "1009";

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithCustomerMenu();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.chooseUserForLogin(userFullName);
        customerPage.clickLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(getDriver());
        customerAccountPage.validateUserLogin(userFullName);
        customerAccountPage.selectAccountNumber(accountNumber);
        customerAccountPage.validateAccountSelection(accountNumber);
    }
}