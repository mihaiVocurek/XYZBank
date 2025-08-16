package helperMethods;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageHelper {

    private WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollPage(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll("+x+","+y+")","");
    }

    public void refreshWebpage(){
        driver.navigate().refresh();
        LoggerUtility.infoLog("The user refreshes the webpage");
    }
}
