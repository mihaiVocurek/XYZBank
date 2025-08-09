package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankManagerAddCustomerPage extends BasePage{

    public BankManagerAddCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addCustomerButton;

    public void addNewCustomer(String firstNameValue, String lastNameValue, String postCodeValue){
        elementHelper.fillElement(firstName,firstNameValue);
        elementHelper.fillElement(lastName,lastNameValue);
        elementHelper.fillElement(postCode,postCodeValue);
        elementHelper.clickJSElement(addCustomerButton);
    }

    public void dealAlertOk(){
        alertHelper.clickAlertOk();
    }

    public String getAlertText(){
        return alertHelper.getNewCustomerAlertText();
    }

    public void validateNewCustomerAdded(){
        alertHelper.validateSuccessfullyCreatedCustomer();
    }

    public int getNewCustomerId(){
        String alertMessage = alertHelper.getNewCustomerAlertText();
        return Integer.parseInt(alertMessage.substring(alertMessage.indexOf(":")+1));
    }

}
