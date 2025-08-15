package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FirefoxBrowser implements Browser{

    private WebDriver driver;
    private FirefoxOptions firefoxOptions;

    @Override
    public void openBrowser() {
        configureBrowser();

        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public void configureBrowser() {

        boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("window-size=1920,1080");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-extensions");
        if (cicd){
            firefoxOptions.addArguments("--headless=new");
        }
        firefoxOptions.addArguments("--incognito");
    }

    public WebDriver getDriver(){
        return driver;
    }

}
