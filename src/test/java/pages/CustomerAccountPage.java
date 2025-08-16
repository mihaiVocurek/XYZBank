package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerAccountPage extends BasePage{

    public CustomerAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='btn logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[@class= 'fontBig ng-binding']")
    private WebElement userName;

    @FindBy(xpath = "//div/strong/span/..")
    private WebElement welcomeMessage;

    @FindBy(id = "accountSelect")
    private WebElement selectAccount;

    @FindBy(xpath = "//select/option")
    private List<WebElement> allUserAccounts;

    @FindBy(xpath = "//div/strong[@class='ng-binding']")
    private List<WebElement> selectAccountDetails;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    private WebElement transactionsButton;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    private WebElement depositButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement withdrawalButton;

    @FindBy(xpath = "//input[@ng-model='amount']")
    private WebElement amountEntered;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement clickDepositOrWithdrawal;

    @FindBy(xpath = "//span[@ng-show='message']")
    private WebElement messageAfterDepositWithdrawal;

    public void selectAccountNumber(String accountNumber){
        elementHelper.clickJSElement(selectAccount);
        int notFoundCounter = 0;
        Select accountList = new Select(selectAccount);
        for (int index = 0; index<allUserAccounts.size(); index++)
        {
            if (Objects.equals(accountNumber, allUserAccounts.get(index).getText()))
            {
                accountList.selectByValue("number:" + accountNumber);
                LoggerUtility.infoLog("User selects the account number: " + accountNumber + " for the logged in customer");
            } else notFoundCounter++;
        }
        if(notFoundCounter == allUserAccounts.size())
        {
            LoggerUtility.infoLog("This account number does not exist");
        }
    }

    public void clickTransactionsButton(){
        elementHelper.waitVisibleElement(transactionsButton);
        elementHelper.clickJSElement(transactionsButton);
        LoggerUtility.infoLog("User clicks on the Transactions button");
    }

    public void clickDepositButton(){
        elementHelper.clickJSElement(depositButton);
        LoggerUtility.infoLog("User clicks on the Deposit button");
    }

    public void clickWithdrawalButton(){
        elementHelper.clickJSElement(withdrawalButton);
        LoggerUtility.infoLog("User clicks on the Withdrawal button");
    }

    public void enterDepositAmount(int amount){
        elementHelper.fillElement(amountEntered, String.valueOf(amount));
        elementHelper.clickJSElement(clickDepositOrWithdrawal);
        LoggerUtility.infoLog("User deposits an amount of: " + amount);
    }

    public void enterWithdrawalAmount(int amount){
        elementHelper.fillElement(amountEntered, String.valueOf(amount));
        elementHelper.clickJSElement(clickDepositOrWithdrawal);
        LoggerUtility.infoLog("User withdraws an amount of: " + amount);
    }

    public void refreshTransactionsPage(){
        pageHelper.refreshWebpage();
    }

    public void validateSuccessfulDeposit(){
        elementHelper.waitVisibleElement(messageAfterDepositWithdrawal);
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Deposit Successful");
        LoggerUtility.infoLog("User validates the successful deposit");
    }

    public void validateSuccessfulWithdrawal(){
        elementHelper.waitVisibleElement(messageAfterDepositWithdrawal);
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Transaction successful");
        LoggerUtility.infoLog("User validates the successful withdrawal");
    }

    public void validateUnsuccessfulWithdrawal(){
        elementHelper.waitVisibleElement(messageAfterDepositWithdrawal);
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Transaction Failed. You can not withdraw amount more than the balance.");
        LoggerUtility.infoLog("User validates the unsuccessful withdrawal");
    }

    public void validateUserLogin(String user){
        elementHelper.waitVisibleElement(welcomeMessage);
        elementHelper.waitVisibleElement(userName);
        elementHelper.validateElementContainsText(welcomeMessage,"Welcome");
        elementHelper.validateElementContainsText(userName, user);
        LoggerUtility.infoLog("User validates the successful login of the user: " + user);
    }

    public void validateAccountSelection(String accountNumber) {
        elementHelper.waitVisibleList(selectAccountDetails);
        elementHelper.validateElementContainsText(selectAccountDetails.get(0), accountNumber);
        LoggerUtility.infoLog("User validates the selection of the account number: " + accountNumber);
    }

    public void validateBalanceAfterDeposit(int amount){
        elementHelper.waitVisibleList(selectAccountDetails);
        int balanceAfterDeposit = Integer.parseInt(selectAccountDetails.get(1).getText()) + amount;
        enterDepositAmount(amount);
        validateSuccessfulDeposit();
        Assert.assertEquals(balanceAfterDeposit,Integer.parseInt(selectAccountDetails.get(1).getText()));
        LoggerUtility.infoLog("User validates the new balance after a new deposit " + balanceAfterDeposit);
    }

    public void validateBalanceAfterWithdrawal(int amount){
        elementHelper.waitVisibleList(selectAccountDetails);
        int balanceAfterWithdrawal = Integer.parseInt(selectAccountDetails.get(1).getText()) - amount;
        enterWithdrawalAmount(amount);
        validateSuccessfulWithdrawal();
        Assert.assertEquals(balanceAfterWithdrawal,Integer.parseInt(selectAccountDetails.get(1).getText()));
        LoggerUtility.infoLog("User validates the new balance after a new withdrawal: " + balanceAfterWithdrawal);
    }

}
