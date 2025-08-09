package tests;

import org.testng.annotations.Test;
import pages.BankManagerAddCustomerPage;
import pages.BankManagerPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AddNewCustomerTest extends SharedData {

    @Test
    public void testMethod(){

        openBrowser();

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBankManagerMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(getDriver());
        bankManagerPage.interactWithAddCustomer();

        BankManagerAddCustomerPage bankManagerAddCustomerPage = new BankManagerAddCustomerPage(getDriver());

        bankManagerAddCustomerPage.addNewCustomer("Gigi", "Babanu", "98765");
        System.out.println(bankManagerAddCustomerPage.getAlertText());

        bankManagerAddCustomerPage.validateNewCustomerAdded();
        System.out.println(bankManagerAddCustomerPage.getNewCustomerId());

        bankManagerAddCustomerPage.dealAlertOk();

        clearEnvironment();
    }

}
