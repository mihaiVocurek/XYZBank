package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;


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

    @FindBy(xpath = "//select/option[@ng-repeat]")
    private List<WebElement> allCustomerNames;

    @FindBy(xpath = "//select[@id = 'currency']/option[@value != '']")
    private List<WebElement> allCurrencies;

    public void chooseCustomerName(String customerFullName){
        Select customerList = new Select(selectCustomerName);
        int notFoundCounter=0;
        for (int index = 0; index<allCustomerNames.size();index++)
        {
            if (Objects.equals(customerFullName,allCustomerNames.get(index).getText()))
            {
                customerList.selectByVisibleText(customerFullName);
                LoggerUtility.infoLog("User chooses the customer name: " + customerFullName + " from the list");
            } else notFoundCounter++;
        }
        if(notFoundCounter == allCustomerNames.size())
        {
            LoggerUtility.infoLog("This customer name does not exist");
        }

    }

    public void chooseCurrency(String currencyValue){
        Select currencyList = new Select(selectCurrency);
        int notFoundCounter = 0;
        for(int index = 0; index<allCurrencies.size();index++)
        {
            if (Objects.equals(currencyValue,allCurrencies.get(index).getText()))
            {
                currencyList.selectByValue(currencyValue);
                LoggerUtility.infoLog("User chooses the currency: " + currencyValue + " from the list");
            } else notFoundCounter++;
        }
        if(notFoundCounter == allCurrencies.size())
        {
            LoggerUtility.infoLog("This currency does not exist");
        }

    }

    public void clickProcess(){
        elementHelper.clickJSElement(processButton);
        LoggerUtility.infoLog("User clicks on the Process button");
    }

    public void dealAlertOk(){
        alertHelper.clickAlertOk();
        LoggerUtility.infoLog("User deals with the alert presence");
    }

    public String getAlertText(){
        LoggerUtility.infoLog("User gets the alert text: " + alertHelper.getNewAccountAlertText());
        return alertHelper.getNewAccountAlertText();
    }

    public void validateNewAccountCreated(){
        alertHelper.validateSuccessfullyOpenedAccount();
        LoggerUtility.infoLog("User validates the successful creation of a new account");
    }

    public int getNewAccountNumer(){
        String alertMessage = alertHelper.getNewAccountAlertText();
        LoggerUtility.infoLog("User gets the number of the newly created account: " + alertMessage.substring(alertMessage.indexOf(":")+1));
        return Integer.parseInt(alertMessage.substring(alertMessage.indexOf(":")+1));
    }

}
