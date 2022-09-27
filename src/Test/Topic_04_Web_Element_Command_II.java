package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Web_Element_Command_II {
    WebDriver driver;
    String projectPath = System.getProperty("user.id");

    By emailTextboxBy = By.id("mail");
    By ageOver18RadioBy = By.id("over_18");
    By educationTextareaBy = By.id("edu");
    By user5TextBy = By.xpath("//h5[text()='Name: User5']");
    By passwordTextboxBy = By.id("password");
    By slider2By = By.id("slider-2");
    By developmentCheckbox = By.id("development");
    By javaCheckbox = By.id("java");

    @BeforeClass
    public void beforeClass(){
        // open chrome browse
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        // set timeout de tim element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

    }

    public void TC_01_is_Display(){
        // open application (AUT/SUT)
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.id("mail"));

        if (emailTextbox.isDisplayed()){
            emailTextbox.sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed");
        }else {
            System.out.println("Email textbox is not display");
        }

        WebElement ageOver18Radio = driver.findElement(By.id("over_18"));

        if (ageOver18Radio.isDisplayed()){
            ageOver18Radio.click();
            System.out.println("Age over 18 is displayed");
        }else {
            System.out.println("Age over 18 is not display");
        }

        WebElement educationTextarea = driver.findElement(By.id("edu"));

        if (educationTextarea.isDisplayed()){
            educationTextarea.sendKeys("Automation Testing");
            System.out.println("Education textarea is displayed");
        }else {
            System.out.println("Education textarea is not display");
        }

        WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));

        if (user5Text.isDisplayed()){
            System.out.println("User 5 text is displayed");
        }else {
            System.out.println("User 5 text is not display");
        }
    }

    @Test
    public void TC_02_Is_Display_Refactor(){
        // open application (AUT/SUT)
        driver.get("https://automationfc.github.io/basic-form/index.html");


        if (isElementDisplay(emailTextboxBy)){
            sendkeyToElement(emailTextboxBy, "Automation Testing");
        }

        if (isElementDisplay(ageOver18RadioBy)){
            clickToElement(ageOver18RadioBy);
        }

        if (isElementDisplay(educationTextareaBy)){
            sendkeyToElement(educationTextareaBy, "Automation Testing");
        }

        Assert.assertFalse(isElementDisplay(user5TextBy));
    }

    public boolean isElementDisplay(By by){
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()){
            System.out.println("Element ["+ by +"] is display");
            return true;
        }else {
            System.out.println("Element ["+ by +"] is not display");
            return false;
        }
    }

    public boolean isElementEnabled(By by){
        WebElement element = driver.findElement(by);
        if (element.isEnabled()){
            System.out.println("Element ["+ by +"] is enabled");
            return true;
        }else {
            System.out.println("Element ["+ by +"] is disabled");
            return false;
        }
    }

    public boolean isElementSelected(By by){
        WebElement element = driver.findElement(by);
        if (element.isSelected()){
            System.out.println("Element ["+ by +"] is selected");
            return true;
        }else {
            System.out.println("Element ["+ by +"] is deselected");
            return false;
        }
    }

    public void sendkeyToElement(By by, String value){
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(value);
    }

    public void clickToElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    @Test
    public void TC_03_Is_Enable(By by){
        // open application (AUT/SUT)
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Mong đợi 1 element enabled
        Assert.assertTrue(isElementEnabled(emailTextboxBy));
        Assert.assertTrue(isElementEnabled(ageOver18RadioBy));
        Assert.assertTrue(isElementEnabled(educationTextareaBy));

        //Mong đợi 1 element disable
        Assert.assertFalse(isElementEnabled(passwordTextboxBy));
        Assert.assertFalse(isElementEnabled(slider2By));
    }

    @Test
    public void TC_04_Is_Selected(){
        // open application (AUT/SUT)
        driver.get("https://automationfc.github.io/basic-form/index.html");

        clickToElement(ageOver18RadioBy);
        clickToElement(developmentCheckbox);

        Assert.assertTrue(isElementSelected(ageOver18RadioBy));
        Assert.assertTrue(isElementSelected(developmentCheckbox));
        Assert.assertFalse(isElementSelected(javaCheckbox));

        clickToElement(ageOver18RadioBy);
        clickToElement(developmentCheckbox);

        Assert.assertTrue(isElementSelected(ageOver18RadioBy));
        Assert.assertFalse(isElementSelected(developmentCheckbox));
        Assert.assertFalse(isElementSelected(javaCheckbox));
    }

    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}
