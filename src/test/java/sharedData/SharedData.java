package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clearEnvironment(){
        driver.quit();
    }

}
