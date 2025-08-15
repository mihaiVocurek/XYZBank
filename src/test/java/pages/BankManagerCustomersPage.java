package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankManagerCustomersPage extends BasePage{

    public BankManagerCustomersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    private WebElement searchCustomer;

    @FindBy(xpath = "//table/thead//td[1]/a")
    private WebElement sortFirstName;

    @FindBy(xpath = "//table/thead//td[2]/a")
    private WebElement sortLastName;

    @FindBy(xpath = "//table/thead//td[3]/a")
    private WebElement sortPostCode;

    @FindBy(xpath = "//table/tbody//td")
    private List<WebElement> allCustomerInfo;

    @FindBy(xpath = "//table/tbody//td[1]")
    private List<WebElement> allCustomerFirstNames;

    @FindBy(xpath = "//table/tbody//td[2]")
    private List<WebElement> allCustomerLastNames;

    @FindBy(xpath = "//table/tbody//td[3]")
    private List<WebElement> allCustomerPostCodes;

    @FindBy(xpath = "//table/tbody//span")
    private List<WebElement> allVisibleAccountNumbers;

    @FindBy(xpath = "//button[@ng-click = 'deleteCust(cust)']")
    private List<WebElement> deleteButtons;

    public void searchCustomerName(String customerName){
        elementHelper.fillElement(searchCustomer, customerName);
    }

    public void clickSortByFirstName(){
        elementHelper.clickJSElement(sortFirstName);
    }

    public void clickSortByLastName(){
        elementHelper.clickJSElement(sortLastName);
    }

    public void clickSortByPostCode(){
        elementHelper.clickJSElement(sortPostCode);
    }

    public void deleteCustomer(String firstNameValue, String lastNameValue, String postCodeValue){
        int indexDelete = 0;
        for(int index = 0; index < allCustomerInfo.size(); index++){
            if(index % 5 == 0){
                if(allCustomerInfo.get(index).getText().equals(firstNameValue) && allCustomerInfo.get(index+1).getText().equals(lastNameValue)
                    && allCustomerInfo.get(index+2).getText().equals(postCodeValue) )
                {
                    elementHelper.clickJSElement(deleteButtons.get(indexDelete));
                } else indexDelete++;
            }
        }
    }

    private ArrayList<String> sortWebElementListAscending(List<WebElement> elements){
        ArrayList<String> sortedValues = elementHelper.getElementsInListAsText(elements);
        Collections.sort(sortedValues);
        return sortedValues;
    }

    private ArrayList<String> sortWebElementListDescending(List<WebElement> elements){
        ArrayList<String> sortedValues = elementHelper.getElementsInListAsText(elements);
        Collections.sort(sortedValues, Collections.reverseOrder());
        return sortedValues;
    }

    public void validateOrderByFirstNameAscending(){
        elementHelper.waitVisibleList(allCustomerFirstNames);
        elementHelper.validateTableOrder(allCustomerFirstNames,sortWebElementListAscending(allCustomerFirstNames));
    }

    public void validateOrderByFirstNameDescending(){
        elementHelper.waitVisibleList(allCustomerFirstNames);
        elementHelper.validateTableOrder(allCustomerFirstNames,sortWebElementListDescending(allCustomerFirstNames));
    }

    public void validateOrderByLastNameAscending(){
        elementHelper.waitVisibleList(allCustomerLastNames);
        elementHelper.validateTableOrder(allCustomerLastNames,sortWebElementListAscending(allCustomerLastNames));
    }

    public void validateOrderByLastNameDescending(){
        elementHelper.waitVisibleList(allCustomerLastNames);
        elementHelper.validateTableOrder(allCustomerLastNames,sortWebElementListDescending(allCustomerLastNames));
    }

    public void validateOrderByPostCodeAscending(){
        elementHelper.waitVisibleList(allCustomerPostCodes);
        elementHelper.validateTableOrder(allCustomerPostCodes,sortWebElementListAscending(allCustomerPostCodes));
    }

    public void validateOrderByPostCodeDescending(){
        elementHelper.waitVisibleList(allCustomerPostCodes);
        elementHelper.validateTableOrder(allCustomerPostCodes,sortWebElementListDescending(allCustomerPostCodes));
    }

    public void validateSearchedCustomer(String customerName, boolean isLastName){
        elementHelper.waitVisibleList(allCustomerInfo);
        if(isLastName)
        {
            elementHelper.validateElementContainsText(allCustomerInfo.get(1),customerName);
        } else elementHelper.validateElementContainsText(allCustomerInfo.get(0),customerName);
    }

    public void validateAccountNumberForCustomer(int accountNumber){
        elementHelper.waitVisibleList(allVisibleAccountNumbers);
        for(int index = 0; index < allVisibleAccountNumbers.size();index++)
        {
            if (Integer.parseInt(allVisibleAccountNumbers.get(index).getText()) == accountNumber)
            {
                elementHelper.validateElementContainsText(allVisibleAccountNumbers.get(index), String.valueOf(accountNumber));
            }
        }
    }
}
