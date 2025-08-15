package pages;

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

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//tr[@id='anchor0']/td")
    private List<WebElement> firstTableLine;

    public void clickBackButton(){
        elementHelper.clickJSElement(backButton);
    }

    public void clickResetButton(){
        elementHelper.clickJSElement(resetButton);
    }

    public void sortTransactionsByDateTime(){
        elementHelper.clickJSElement(dateTimeButton);
    }

    public void validateEmptyTable(){
        elementHelper.waitVisibleList(tableRows);
        Assert.assertTrue(tableRows.isEmpty());
    }

    public void validateLatestTransaction(int amount, transactionType transaction){
        elementHelper.waitVisibleList(firstTableLine);
        sortTransactionsByDateTime();
        Assert.assertEquals(amount,Integer.parseInt(firstTableLine.get(1).getText()),"The amounts do not match");
        if(transaction == transactionType.Deposit)
        {
            Assert.assertEquals(firstTableLine.get(2).getText(), "Credit", "Transaction Type is incorrect");
        } else if(transaction == transactionType.Withdrawal)
            {
                Assert.assertEquals(firstTableLine.get(2).getText(), "Debit", "Transaction Type is incorrect");
            }
    }
}
