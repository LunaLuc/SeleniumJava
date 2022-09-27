package Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Xpath {
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
        driver.get("https://www.google.com.vn/?hl=vi");
    }

    @Test
    public void TC_00_Xpath_Search(){
        WebElement inputGoogle = driver.findElement(By.xpath("//input[@name='q']"));
        // input in search textbox
        inputGoogle.sendKeys("Luc Anh Phuong");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // tap enter
        inputGoogle.sendKeys(Keys.ENTER);
    }

    @Test
    public void TC_01_Xpath_verifyResult(){
        driver.navigate().refresh();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement tapResult = driver.findElement(By.xpath("//h3[contains(text(),'Anh Phương: Mệt mỏi, áp lực khi bị gắn mác')]"));
        tapResult.click();
    }

    @Test
    public void TC_02_Xpath_tapGmail(){
        driver.navigate().refresh();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement tapGmail = driver.findElement(By.xpath("//a[text()='Gmail']"));

        // navigate to Gmail link
        tapGmail.click();
    }
    @Test
    public void TC_03_Xpath_tapHinhAnh(){
        driver.navigate().refresh();
        WebElement tapHinhAnh = driver.findElement(By.xpath("//a[text()='Hình ảnh']"));

        // navigate to HinhAnh link
        tapHinhAnh.click();
    }
    @Test
    public void TC_04_Xpath_openDriver(){
        driver.navigate().refresh();
        WebElement openDriver = driver.findElement(By.xpath("//a[@class='gb_A']"));

        //open application Google
        openDriver.click();
    }
    @Test
    public void TC_04_tapLogin(){
        driver.navigate().refresh();
        WebElement tapLogin = driver.findElement(By.xpath("//a[text()='Đăng nhập']"));

        // navigation to Login link
        tapLogin.click();
    }
    @Test
    public void TC_05_tapTool(){
        driver.navigate().refresh();
        WebElement tapTool = driver.findElement(By.xpath("//div[@class='Umvnrc']"));

        //open other tool
        tapTool.click();
    }

}
