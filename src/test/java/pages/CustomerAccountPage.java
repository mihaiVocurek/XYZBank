package pages;

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

    @FindBy(xpath = "//div/strong/span")
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
            } else notFoundCounter++;
        }
        if(notFoundCounter == allUserAccounts.size())
        {
            System.out.println("This account number does not exist");
        }
    }

    public void clickTransactionsButton(){
        elementHelper.clickJSElement(transactionsButton);
    }

    public void clickDepositButton(){
        elementHelper.clickJSElement(depositButton);
    }

    public void clickWithdrawalButton(){
        elementHelper.clickJSElement(withdrawalButton);
    }

    public void enterDepositAmount(int amount){
        clickDepositButton();
        elementHelper.fillElement(amountEntered, String.valueOf(amount));
        elementHelper.clickJSElement(clickDepositOrWithdrawal);
    }

    public void enterWithdrawalAmount(int amount){
        clickWithdrawalButton();
        elementHelper.fillElement(amountEntered, String.valueOf(amount));
        elementHelper.clickJSElement(clickDepositOrWithdrawal);
    }

    public void validateSuccessfulDeposit(){
        elementHelper.waitVisibleElement(messageAfterDepositWithdrawal);
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Deposit Successful");
    }

    public void validateSuccessfulWithdrawal(){
        elementHelper.waitVisibleElement(messageAfterDepositWithdrawal);
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Transaction successful");
    }

    public void validateUnsuccessfulWithdrawal(){
        elementHelper.waitVisibleElement(messageAfterDepositWithdrawal);
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Transaction Failed. You can not withdraw amount more than the balance.");
    }

    public void validateUserLogin(String user){
        elementHelper.waitVisibleElement(welcomeMessage);
        elementHelper.waitVisibleElement(userName);
        elementHelper.validateElementContainsText(welcomeMessage,"Welcome");
        elementHelper.validateElementContainsText(userName, user);
    }

    public void validateAccountSelection(String accountNumber) {
        elementHelper.waitVisibleList(selectAccountDetails);
        elementHelper.validateElementContainsText(selectAccountDetails.get(0), accountNumber);
    }

    public void validateBalanceAfterDeposit(int amount){
        elementHelper.waitVisibleList(selectAccountDetails);
        int initialDepositValue = Integer.parseInt(selectAccountDetails.get(1).getText());
        enterDepositAmount(amount);
        validateSuccessfulDeposit();
        Assert.assertEquals(amount+initialDepositValue,Integer.parseInt(selectAccountDetails.get(1).getText()));
    }

    public void validateBalanceAfterWithdrawal(int amount){
        elementHelper.waitVisibleList(selectAccountDetails);
        int initialWithdrawalValue = Integer.parseInt(selectAccountDetails.get(1).getText());
        enterWithdrawalAmount(amount);
        validateSuccessfulWithdrawal();
        Assert.assertEquals(initialWithdrawalValue - amount,Integer.parseInt(selectAccountDetails.get(1).getText()));
    }

}
