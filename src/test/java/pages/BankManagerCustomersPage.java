package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//button[@ng-click = 'deleteCust(cust)']")
    private List<WebElement> deleteButtons;

    public void fillCustomerName(String customerName){
        elementHelper.fillElement(searchCustomer, customerName);
    }

    public void clickSortFirstName(){
        elementHelper.clickJSElement(sortFirstName);
    }

    public void clickSortLastName(){
        elementHelper.clickJSElement(sortLastName);
    }

    public void clickSortPostCode(){
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


}
