package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class CustomerPage extends BasePage{

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userSelect")
    private WebElement selectUser;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//select/option[@ng-repeat]")
    private List<WebElement> allAvailableAccounts;

    public void chooseUserForLogin(String userFullName){
        Select userList = new Select(selectUser);
        int notFoundCounter = 0;
        for(int index = 0; index<allAvailableAccounts.size();index++)
        {
            if (Objects.equals(userFullName,allAvailableAccounts.get(index).getText()))
            {
                userList.selectByVisibleText(userFullName);
                LoggerUtility.infoLog("The user: " + userFullName + " is selected");
            }
            else notFoundCounter++;
        }
        if (notFoundCounter == allAvailableAccounts.size())
        {
            LoggerUtility.infoLog("The user: " + userFullName + " does not exist");
        }

    }

    public void clickLogin(){
        elementHelper.clickJSElement(loginButton);
        LoggerUtility.infoLog("The user logs in");
    }
}
