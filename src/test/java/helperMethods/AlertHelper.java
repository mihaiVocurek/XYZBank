package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void clickAlertOk(){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getNewCustomerAlertText(){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String getNewAccountAlertText(){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void validateSuccessfullyCreatedCustomer(){
        Assert.assertTrue(getNewCustomerAlertText().contains("Customer added successfully"));
    }

    public void validateSuccessfullyOpenedAccount(){
        Assert.assertTrue(getNewCustomerAlertText().contains("Account created successfully"));
    }

}
