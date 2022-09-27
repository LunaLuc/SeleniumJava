package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
    // khai bao bien dai dien Selenium driver
     WebDriver driver;

    @BeforeClass
    public void beforeClas(){
        // open chrome browse
        System.setProperty("webdriver.chrome.driver","C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        // set timeout de tim element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        // open application (AUT/SUT)
        driver.get("https://magento.com/tech-resources/customer/account/login");
    }

    public void TC_01(){
        // single element: webElement
        driver.findElement(By.className("")).click();
        driver.findElement(By.className("")).getText();

        // multiple element: list WebElements
        List<WebElement> buttons = driver.findElements(By.className(""));
        buttons.get(0).click();

    }
// bat bang class
    @Test
    public void TC_02_ID(){
        //driver.findElement(By.id("send2")).click();

        //verify email error msg xuat hien
        //Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
    }

    @Test
    public void TC_03_Xpath() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='send2']")).click();

        //verify email error msg xuat hien
        Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
    }

    @Test
    public void TC_04_Name(){
       // driver.navigate().refresh();
        //.findElement(By.)


    }

    @Test
    public void TC_05_Tagname(){
        driver.navigate().refresh();

        // hien thi tat ca cac duong link tai man hinh nay sau do get text
        List<WebElement> loginPageLinks = driver.findElements(By.tagName("a"));

        for (WebElement webElement: loginPageLinks) {
            System.out.println(webElement.getText());
        }
    }

    @Test
    public void TC_06_LinkText(){
        driver.navigate().refresh();

        driver.findElement(By.linkText("Forgot my password")).click();

        Assert.assertTrue(driver.findElement(By.id("email_address")).isDisplayed());
    }

    @Test
    public void TC_07_PartialLinkText(){
        driver.findElement(By.partialLinkText("Go back")).click();

        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
    }

    @Test
    public void TC_08_Css(){
        driver.findElement(By.cssSelector("#email")).sendKeys("phuong@gmail.com");
        driver.findElement(By.cssSelector("input[name='login[password]']")).sendKeys("12");
    }

    @Test
    public void TC_09_Xpath(){
        driver.navigate().refresh();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("phuong@gmail.com");
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("1245678");
    }

    @AfterClass
    public void afterClas(){
        //driver.quit();

    }
}
