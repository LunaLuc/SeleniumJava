package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_Web_Browser_Command_II {
    WebDriver driver;
    String projectPath = System.getProperty("user.id");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_Url(){
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//div[@id='pageFooterChildren']//a[text()='Sign Up']")).click();

        String registerPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(registerPageUrl, "https://www.facebook.com/reg/");

        driver.findElement(By.xpath("//a[text()='Log In']")).click();

        String loginPAgeUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPAgeUrl, "https://www.facebook.com/login/");
    }

    @Test
    public void TC_02_Title(){
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//div[@id='pageFooterChildren']//a[text()='Sign Up']")).click();

        driver.findElement(By.xpath("//a[text()='Log In']")).click();

        driver.navigate().back();

        String registerPageTitle = driver.getTitle();
        Assert.assertEquals(registerPageTitle,"Sign up for Facebook | Facebook");

    }

    @Test
    public void TC_03_Navigation(){
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//div[@id='pageFooterChildren']//a[text()='Sign Up']")).click();

        driver.findElement(By.xpath("//a[text()='Log In']")).click();

        driver.navigate().back();

        String registerPageTitle = driver.getTitle();
        Assert.assertEquals(registerPageTitle,"Sign up for Facebook | Facebook");

        String registerPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(registerPageUrl, "https://www.facebook.com/reg/");

        driver.navigate().forward();
    }

    @Test
    public void TC_04_Page_Source(){
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//div[@id='pageFooterChildren']//a[text()='Sign Up']")).click();

        String registerPageSource = driver.getPageSource();
        Assert.assertTrue(registerPageSource.contains("Create a new account"));

        driver.findElement(By.xpath("//a[text()='Log In']")).click();

        String loginPageSource = driver.getPageSource();
        Assert.assertTrue(loginPageSource.contains("Log in to Facebook"));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
