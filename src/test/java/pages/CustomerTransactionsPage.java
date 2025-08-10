package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import sharedData.SharedData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    public void pressBackButton(){
        elementHelper.clickJSElement(backButton);
    }

    public void pressResetButton(){
        elementHelper.clickJSElement(resetButton);
    }

    public void validateEmptyTable(){
        Assert.assertTrue(tableRows.isEmpty());
    }

}
