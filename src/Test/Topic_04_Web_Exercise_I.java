package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Web_Exercise_I {
    WebDriver driver;

    By EmployeeIDBy = By.xpath("//div[@class ='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']");
    By FirstNameBy = By.xpath("//input[@name='firstName']");
    By LastNameBy = By.xpath("//input[@name='lastName']");


    @BeforeClass
    public void beforeClass(){
        // open chrome browse
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        // set timeout de tim element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_TextBox(){
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Step1
        // enter data to username
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // enter data to password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //click login
        WebElement clickLogin = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        clickLogin.click();
        System.out.println("Login success");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Step2
        //tap to Add Employee
        WebElement tapAddEmployee = driver.findElement(By.xpath("//a[text()='Add Employee']"));
        tapAddEmployee.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Direct to Add Employee");

        //fill data to Employee: FisrtName, LastName
        WebElement Fisrtname = driver.findElement(By.xpath("//input[@name='firstName']"));
        Fisrtname.sendKeys("Tran1");

        WebElement Lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
        Lastname.sendKeys("Hung1");

        //Get data from EmployeeID
        Assert.assertTrue(isElementDisplay(EmployeeIDBy));

        System.out.println("Fill data to fields");

        //Step3
        //Save data entered
        WebElement SaveData = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        SaveData.click();
        System.out.println("Login success");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Save data success");


        //step4
        //Verify data
        //WebElement getFirstName = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']"));
        //Assert.assertEquals(getFirstName.getText(),"Tran1 Hung1");
        //WebElement getLastName = driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-name']//h6[contains(text(),'Hung1')]"));
        //Assert.assertEquals(getLastName.getText(), "Hung1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Step5
        //verify textbox: FirstName, LastName, EmployeeID is disabled
        Assert.assertTrue(isElementEnabled(FirstNameBy));
        Assert.assertTrue(isElementEnabled(LastNameBy));
        Assert.assertTrue(isElementEnabled(EmployeeIDBy));
    }

    //verify display for element
    public boolean isElementDisplay(By by){
        WebElement element= driver.findElement(by);
        if (element.isDisplayed()){
            System.out.println("Element ["+ by +"] is display");
            return true;
        }else {
            System.out.println("Element ["+ by +"] is not display");
            return false;
        }
    }

    //verify element enabled or disabled
    public  boolean isElementEnabled(By by){
        WebElement element = driver.findElement(by);
        if (element.isEnabled()){
            System.out.println("Element ["+ by +"] is enabled");
            return true;
        }else {
            System.out.println("Element ["+ by +"] is disabled");
            return false;
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}