package tests;

import org.testng.annotations.Test;
import pages.BankManagerCustomersPage;
import pages.BankManagerPage;
import pages.IndexPage;
import sharedData.SharedData;

public class CustomersTest extends SharedData {

    @Test
    public void testMethod(){
        openBrowser();

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBankManagerMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(getDriver());
        bankManagerPage.interactWithCustomers();

        BankManagerCustomersPage bankManagerCustomersPage = new BankManagerCustomersPage(getDriver());
        bankManagerCustomersPage.deleteCustomer("Albus","Dumbledore","E55656");
    }

}
