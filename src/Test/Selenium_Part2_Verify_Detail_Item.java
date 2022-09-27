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

public class Selenium_Part2_Verify_Detail_Item {
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
    public void ClosePopupInHomePage(WebDriver driver) throws InterruptedException {
        //open and close pop-up in home page
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = (WebElement) jse.executeScript("return document.querySelector(\"#main > div > div:nth-child(4) > div > div > shopee-banner-popup-stateful\").shadowRoot.querySelector(\"div > div > div > div > div\")");

        System.out.println("find element");

        Thread.sleep(5000);

        boolean present;
        try {
            WebElement element1 = element;
            present = true;
            System.out.println(present);

            jse.executeScript("arguments[0].click();", element);

            System.out.println("click element");
        } catch (NoSuchElementException e) {
            present = false;
            System.out.println(present);
        }
    }

    public void GotoMallPage(WebDriver driver) throws InterruptedException {
        // click and navigate to Shopee Mall
        WebElement clickItem = driver.findElement(By.xpath("//a[text()='Shopee Mall']"));

        clickItem.click();
        Thread.sleep(2000);

        // close pop-up in Mall page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = (WebElement) js.executeScript("return document.querySelector(\"#main > div > div.dYFPlI.A\\\\+KelN > div > div.container.ofs-page__container > shopee-banner-popup-stateful\").shadowRoot.querySelector(\"div > div > div > div > div\")");
        System.out.println("find element Shopee Mall");

        Thread.sleep(3000);

        boolean present;
        try {
            WebElement element1 = element;
            present = true;
            System.out.println(present);

            js.executeScript("arguments[0].click();", element);

            System.out.println("click element shopee mall");
        } catch (NoSuchElementException e) {
            present = false;
            System.out.println(present);
        }
    }

    public void GotoDetail(WebDriver driver) throws InterruptedException {
        // click view detail a item
        List<WebElement> shopee = driver.findElements(By.xpath("(//div[@class='EZnxXG _1AISrj'])[1]//parent::div[@class='w+5rrL G4-Lxi']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        System.out.println("find element item");
        for (int i = 0; i <= shopee.size(); i++)
        {
            if (i == 0) {
                System.out.println(i);
                shopee.get(i).click();
                System.out.println("pass");
                //driver.navigate().back();
                Thread.sleep(2000);
            }
        }
    }

    public void Verify(WebDriver driver) throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mini-vouchers__label']")).isDisplayed());
        System.out.println("verify text");
        Thread.sleep(2000);
    }

    @AfterClass
    public void afterClas(){
        driver.quit();

    }
}
