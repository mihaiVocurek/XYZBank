package pages;

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
            } else notFoundCounter++;
        }
        if(notFoundCounter == allCustomerNames.size())
        {
            System.out.println("This customer name does not exist");
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
            } else notFoundCounter++;
        }
        if(notFoundCounter == allCurrencies.size())
        {
            System.out.println("This currency does not exist");
        }

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
