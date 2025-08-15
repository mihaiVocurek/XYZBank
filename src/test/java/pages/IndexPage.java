package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    }

    public void interactWithCustomerMenu(){
        elementHelper.clickJSElement(elementCustomerLogin);
    }

    public void interactWithBankManagerMenu(){
        elementHelper.clickJSElement(elementBankManagerLogin);
    }

    public void refreshWebpage(){
        driver.navigate().refresh();
    }

}
