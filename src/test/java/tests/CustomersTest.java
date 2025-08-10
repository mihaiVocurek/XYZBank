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
        bankManagerCustomersPage.clickSortByFirstName();
        bankManagerCustomersPage.validateOrderByFirstNameDescending();
        bankManagerCustomersPage.clickSortByFirstName();
        bankManagerCustomersPage.validateOrderByFirstNameAscending();

        bankManagerCustomersPage.clickSortByLastName();
        bankManagerCustomersPage.validateOrderByLastNameDescending();
        bankManagerCustomersPage.clickSortByLastName();
        bankManagerCustomersPage.validateOrderByLastNameAscending();

        bankManagerCustomersPage.clickSortByPostCode();
        bankManagerCustomersPage.validateOrderByPostCodeDescending();
        bankManagerCustomersPage.clickSortByPostCode();
        bankManagerCustomersPage.validateOrderByPostCodeAscending();

        bankManagerCustomersPage.searchCustomerName("Longbottom");
        bankManagerCustomersPage.validateSearchedCustomer("Longbottom",true);
    }

}
