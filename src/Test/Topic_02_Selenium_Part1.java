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

public class Topic_02_Selenium_Part1 {
    static WebDriver driver;

    @BeforeClass
    public void beforeClas(){
        // open chrome browse
        System.setProperty("webdriver.chrome.driver","C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        // set timeout de tim element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        // open application (AUT/SUT)
        driver.get("https://shopee.vn");
    }

//    @Test
//    public void TC_01_SearchMulti01() throws InterruptedException {
//        Actions a = new Actions(driver);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        a.moveByOffset(1700,300).click().build().perform();
//        System.out.println("click offset");
//        Thread.sleep(2000);
//
//        WebElement clickMall = driver.findElement(By.xpath("//div[@class='_9FdTU0']//a"));
//
//        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class='sQ9tKt']")));
//        System.out.println("Scroll mall button");
//
//        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clickMall)).click();
//
//        System.out.println("click mall button");
//
//        Thread.sleep(5000);
//
//
//    }

    @Test
    public static void getXpath_fromShadow(WebDriver driver) throws InterruptedException {
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

//    @Test
//    public void checkMall() throws InterruptedException {
//        getXpath_fromShadow(driver);
//
//        Thread.sleep(5000);
//    }

    @AfterClass
    public void AfterClass(){
        driver.quit();
    }

}
