package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BankManagerOpenAccountPage extends BasePage{

    public BankManagerOpenAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userSelect")
    private WebElement selectCustomerName;

    @FindBy(id = "currency")
    private WebElement selectCurrency;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement processButton;

    public void chooseCustomerName(String customerFullName){
        Select customerList = new Select(selectCustomerName);
        customerList.selectByVisibleText(customerFullName);
    }

    public void chooseCurrency(String currencyValue){
        Select currencyList = new Select(selectCurrency);
        currencyList.selectByVisibleText(currencyValue);
    }

    public void clickProcess(){
        elementHelper.clickJSElement(processButton);
    }

    public void dealAlertOk(){
        alertHelper.clickAlertOk();
    }

    public String getAlertText(){
        return alertHelper.getNewAccountAlertText();
    }

    public void validateNewAccountCreated(){
        alertHelper.validateSuccessfullyOpenedAccount();
    }

    public int getNewAccountNumer(){
        String alertMessage = alertHelper.getNewAccountAlertText();
        return Integer.parseInt(alertMessage.substring(alertMessage.indexOf(":")+1));
    }

}
