package helperMethods;

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
}
