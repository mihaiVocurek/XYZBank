package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class = 'btn home' and @ng-click='home()']")
    private WebElement homeButton;

    @FindBy(xpath = "//button[text() = 'Customer Login']")
    private WebElement elementCustomerLogin;

    @FindBy(xpath = "//button[text() = 'Bank Manager Login']")
    private WebElement elementBankManagerLogin;

    public void interactWithHomeButton(){
        elementHelper.clickJSElement(homeButton);
        LoggerUtility.infoLog("The user clicks on the Home button");
    }

    public void interactWithCustomerMenu(){
        elementHelper.clickJSElement(elementCustomerLogin);
        LoggerUtility.infoLog("The user clicks on the Customer Login button");
    }

    public void interactWithBankManagerMenu(){
        elementHelper.clickJSElement(elementBankManagerLogin);
        LoggerUtility.infoLog("The user clicks on the Bank Manager Login button");
    }

}
