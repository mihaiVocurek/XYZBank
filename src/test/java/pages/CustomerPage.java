package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends BasePage{

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userSelect")
    private WebElement selectUser;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public void chooseUserForLogin(String userFullName){
        Select userList = new Select(selectUser);
        userList.selectByVisibleText(userFullName);
    }

    public void clickLogin(){
        elementHelper.clickJSElement(loginButton);
    }
}
