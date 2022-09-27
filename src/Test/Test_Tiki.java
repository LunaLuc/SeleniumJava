package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_Tiki {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        // open chrome browse
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        // set timeout de tim element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://tiki.vn/");

    }

    @Test
    public void CheckIMG(){
        //click Login
        WebElement clickLogin = driver.findElement(By.xpath("//span[@class='Userstyle__NoWrap-sc-6e6am-12 gJAiTt']"));
        clickLogin.click();
        System.out.println("click Login");

        //click login by email
        WebElement loginToEmail = driver.findElement(By.xpath("//p[@class='login-with-email']"));
        loginToEmail.click();
        System.out.println("login by email");

        //input data to email and password
        WebElement inputEmail = driver.findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys("lalaa@gmail");
        System.out.println("input data to email");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("12345");
        System.out.println("input data to password");

        //click Login
        WebElement submitLogin = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        submitLogin.click();
        System.out.println("click login");

        //Verify error msg
        System.out.printf(getHTML5ValidationMessage(inputEmail));
        System.out.println("verify error msg");

    }
    public String getHTML5ValidationMessage(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
