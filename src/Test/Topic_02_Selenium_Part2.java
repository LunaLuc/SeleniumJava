package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Part2 extends Selenium_Part2_Verify_Detail_Item {
    WebDriver driver;

    @BeforeClass
    public void beforeClas() {
        // open chrome browse
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        // set timeout de tim element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        // open application (AUT/SUT)
        driver.get("https://shopee.vn");
    }

    @Test
    public void ViewDetailMallPage() throws InterruptedException {
        // closed popup in homepage
        Thread.sleep(3000);
        ClosePopupInHomePage(driver);
        GotoMallPage(driver);
        GotoDetail(driver);
        Verify(driver);
        Thread.sleep(3000);
      }

    @AfterClass
    public void afterClas(){
        driver.quit();
    }
}

