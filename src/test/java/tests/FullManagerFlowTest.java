package tests;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;
import suite.Suite;

public class FullManagerFlowTest extends SharedData {

    @Test(groups = {Suite.SANITY_SUITE, Suite.REGRESSION_SUITE, Suite.BANK_MANAGER_SUITE})
    public void testMethod(){

        String customerFirstName = "Fane";
        String customerLastName = "Babanu";
        String customerPostalCode = "L100";
        String currencyForAccount = "Rupee";

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBankManagerMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(getDriver());
        bankManagerPage.interactWithAddCustomer();

        BankManagerAddCustomerPage bankManagerAddCustomerPage = new BankManagerAddCustomerPage(getDriver());
        bankManagerAddCustomerPage.addNewCustomer(customerFirstName, customerLastName, customerPostalCode);
        bankManagerAddCustomerPage.validateNewCustomerAdded();
        int customerId = bankManagerAddCustomerPage.getNewCustomerId();
        bankManagerAddCustomerPage.dealAlertOk();

        BankManagerOpenAccountPage bankManagerOpenAccountPage = new BankManagerOpenAccountPage(getDriver());
        bankManagerPage.interactWithOpenAccount();
        bankManagerOpenAccountPage.chooseCustomerName(customerFirstName + " " + customerLastName);
        bankManagerOpenAccountPage.chooseCurrency(currencyForAccount);
        bankManagerOpenAccountPage.clickProcess();
        bankManagerOpenAccountPage.validateNewAccountCreated();
        int accountNumber = bankManagerOpenAccountPage.getNewAccountNumer();
        bankManagerOpenAccountPage.dealAlertOk();

        BankManagerCustomersPage bankManagerCustomersPage = new BankManagerCustomersPage(getDriver());
        bankManagerPage.interactWithCustomers();
        bankManagerCustomersPage.searchCustomerName(customerLastName);
        bankManagerCustomersPage.validateSearchedCustomer(customerLastName,true);
        bankManagerCustomersPage.validateAccountNumberForCustomer(accountNumber);

    }

}
