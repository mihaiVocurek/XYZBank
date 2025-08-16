package tests;

import org.testng.annotations.Test;
import pages.BankManagerAddCustomerPage;
import pages.BankManagerPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class AddNewCustomerTest extends SharedData {

    @Test(groups = {Suite.SMOKE_SUITE, Suite.REGRESSION_SUITE, Suite.BANK_MANAGER_SUITE})
    public void testMethod(){

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBankManagerMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(getDriver());
        bankManagerPage.interactWithAddCustomer();

        BankManagerAddCustomerPage bankManagerAddCustomerPage = new BankManagerAddCustomerPage(getDriver());
        bankManagerAddCustomerPage.addNewCustomer("Gigi", "Babanu", "98765");
        bankManagerAddCustomerPage.validateNewCustomerAdded();
        bankManagerAddCustomerPage.dealAlertOk();

    }
}
