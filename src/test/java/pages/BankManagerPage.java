package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankManagerPage extends BasePage{

    public BankManagerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@ng-class = 'btnClass1' and @ng-click='addCust()']")
    private WebElement addCustomerTab;

    @FindBy(xpath = "//button[@ng-class = 'btnClass2' and @ng-click='openAccount()']")
    private WebElement openAccountTab;

    @FindBy(xpath = "//button[@ng-class = 'btnClass3' and @ng-click='showCust()']")
    private WebElement customersTab;

    public void interactWithAddCustomer(){
        elementHelper.clickJSElement(addCustomerTab);
    }

    public void interactWithOpenAccount(){
        elementHelper.clickJSElement(openAccountTab);
    }

    public void interactWithCustomers(){
        elementHelper.clickJSElement(customersTab);
    }

}
