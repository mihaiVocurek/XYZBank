package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import enums.transactionType;

import java.util.List;

public class CustomerTransactionsPage extends BasePage {

    public CustomerTransactionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@ng-show='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[@ng-click='back()']")
    private WebElement backButton;

    @FindBy(xpath = "//button[@ng-click='reset()']")
    private WebElement resetButton;

    @FindBy(xpath = "//table/thead//td[1]/a")
    private WebElement dateTimeButton;

    @FindBy(xpath = "//button[@ng-click='scrollRight()']")
    private WebElement nextButton;

    @FindBy(xpath = "//button[@ng-click='scrollLeft()']")
    private WebElement previousButton;

    @FindBy(xpath = "//button[@ng-click='scrollTop()']")
    private WebElement topButton;

    @FindBy(xpath = "//thead")
    private WebElement tableHead;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//tr[@id='anchor0']/td")
    private List<WebElement> firstTableLine;

    public void clickBackButton(){
        elementHelper.clickJSElement(backButton);
        LoggerUtility.infoLog("User clicks the Back button");
    }

    public void clickResetButton(){
        elementHelper.clickJSElement(resetButton);
        LoggerUtility.infoLog("User clicks the Reset button");
    }

    public void sortTransactionsByDateTime(){
        elementHelper.clickJSElement(dateTimeButton);
        LoggerUtility.infoLog("User clicks the Date-Time button");
    }

    public void validateEmptyTable(){
        elementHelper.waitVisibleElement(tableHead);
        Assert.assertTrue(tableRows.isEmpty());
        LoggerUtility.infoLog("User validates the table is empty");
    }

    public void validateLatestTransaction(int amount, transactionType transaction){
        elementHelper.waitVisibleList(firstTableLine);
        sortTransactionsByDateTime();
        Assert.assertEquals(amount,Integer.parseInt(firstTableLine.get(1).getText()),"The amounts do not match");
        if(transaction == transactionType.Deposit)
        {
            Assert.assertEquals(firstTableLine.get(2).getText(), "Credit", "Transaction Type is incorrect");
            LoggerUtility.infoLog("User validates the latest Deposit transaction of: " + amount);
        } else if(transaction == transactionType.Withdrawal)
            {
                Assert.assertEquals(firstTableLine.get(2).getText(), "Debit", "Transaction Type is incorrect");
                LoggerUtility.infoLog("User validates the latest Withdrawal transaction of: " + amount);
            }
    }
}
