package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        Select accountList = new Select(selectAccount);
        accountList.selectByVisibleText(accountNumber);
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

    public void enterDepositAmount(String amount){
        clickDepositButton();
        elementHelper.fillElement(amountEntered, amount);
        elementHelper.clickJSElement(clickDepositOrWithdrawal);
    }

    public void enterWithdrawalAmount(String amount){
        clickWithdrawalButton();
        elementHelper.fillElement(amountEntered, amount);
        elementHelper.clickJSElement(clickDepositOrWithdrawal);
    }

    public void validateSuccessfulDeposit(){
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Deposit Successful");
    }

    public void validateSuccessfulWithdrawal(){
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Transaction successful");
    }

    public void validateUnsuccessfulWithdrawal(){
        elementHelper.validateElementEqualsText(messageAfterDepositWithdrawal, "Transaction Failed. You can not withdraw amount more than the balance.");
    }

    public void validateUserLogin(String user){
        elementHelper.validateElementContainsText(welcomeMessage,"Welcome");
        elementHelper.validateElementContainsText(userName, user);
    }

    public void validateAccountSelection(String accountNumber) {
        elementHelper.validateElementContainsText(selectAccountDetails.get(0), accountNumber);
    }
}
