package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeBrowser implements Browser{

    private WebDriver driver;
    private ChromeOptions chromeOptions;

    @Override
    public void openBrowser() {
        configureBrowser();

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public void configureBrowser() {

        boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        if (cicd){
            chromeOptions.addArguments("--headless=new");
        }
        chromeOptions.addArguments("--incognito");
    }

    public WebDriver getDriver(){
        return driver;
    }

}
