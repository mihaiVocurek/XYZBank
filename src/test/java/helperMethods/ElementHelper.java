package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class ElementHelper {

    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSElement(WebElement element){
        waitVisibleElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void printTextElement(WebElement element){
        waitVisibleElement(element);
        System.out.println(element.getText());
    }

    public void fillElement(WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void pressElement(WebElement element, Keys keyValue){
        waitVisibleElement(element);
        element.sendKeys(keyValue);
    }

    public void clearElement(WebElement element){
        waitVisibleElement(element);
        element.clear();
    }

    public void clearFillElement(WebElement element, String value){
        clearElement(element);
        fillElement(element,value);
    }

    public void fillPressElement(WebElement element, String value, Keys keyValue){
        fillElement(element,value);
        pressElement(element,keyValue);
    }

    public void validateListSize(List<WebElement> elementList, int expectedSize){
        waitVisibleList(elementList);
        Assert.assertEquals(elementList.size(), expectedSize, "Actual element list size is " + elementList.size() + " which is different than " +expectedSize);
    }

    public void validateElementContainsText(WebElement element, String expectedText){
        waitVisibleElement(element);
        Assert.assertTrue(element.getText().contains(expectedText), "Actual element text " + element.getText() + " does not contain " + expectedText);
    }

    public void validateElementEqualsText(WebElement element, String expectedText){
        waitVisibleElement(element);
        Assert.assertEquals(element.getText(), expectedText, "Actual element text " + element.getText() + " is not equal to " + expectedText);
    }

    public void waitVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibleList(List<WebElement> elementList){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

}
