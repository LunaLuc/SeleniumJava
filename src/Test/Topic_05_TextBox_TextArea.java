package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_05_TextBox_TextArea {
    //Biến toàn cục/ global variable: cho toàn Class/ tất  cả function/block code
    WebDriver driver;
    String loginURL = "https://demo.guru99.com/v4/";
    String loginPageUrl, getUsername, getPassword, name, gender, dateOfBirthInput,dateOfBirthOutput, adrressInput,adrressOutput, city, state, pin, phone, email, password;
    String customerID, editAddressInput, editAddressOutput, editCity, editState, editPin, editPhone, editEmail;

    JavascriptExecutor jsExecutor;
    By nameTextboxBy = By.name("name");
    By genderRadioBy = By.xpath("//input[@value='f']");
    By dateOfBirthBy = By.name("dob");
    By adrressAreaBy = By.name("addr");
    By cityTexboxBy = By.name("city");
    By stateTexboxBy = By.name("state");
    By pinTextboxBy = By.name("pinno");
    By phoneTextboxBy = By.name("telephoneno");
    By emailTextboxBy = By.name("emailid");
    By passwordTextboxBy = By.name("password");

    @BeforeClass
    public void beforeClass(){
        // open chrome browse
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        //ép kiểu tường minh
        jsExecutor = (JavascriptExecutor) driver;

        //create customer data
        name="Mina Kim";
        gender="female";
        dateOfBirthInput ="02/03/2000";
        dateOfBirthOutput ="2000-02-03";
        adrressInput ="56 Duy Tan";
        adrressOutput ="56 Duy Tan";
        city ="Ha Noi";
        state ="Thanh Ha";
        pin ="234411";
        phone ="0203445601";
        password = "456765";
        email ="mina" + getRandomNumber() + "@mail.net";

        //edit customer data
        editAddressInput ="56 Nam Tu Liem";
        editAddressOutput ="56 Nam Tu Liem";
        editCity ="Da Nang";
        editState="Cau Giay";
        editPin="980766";
        editPhone="0203445699";
        editEmail="rose" + getRandomNumber() + "@mail.net";

        // set timeout de tim element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        //open url
        driver.get("https://demo.guru99.com/v4/");

    }

     @Test
     public void TC_01_Register() throws InterruptedException{
        loginPageUrl = driver.getCurrentUrl();

         WebElement clickHere = driver.findElement(By.xpath("//a[text()='here']"));
         clickHere.click();

         //access to iframe
         driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
         System.out.println("switch to the iframe1");

         driver.switchTo().frame("ad_iframe");
         System.out.println("switch to the iframe2");
         Thread.sleep(1000);

//         WebDriverWait wait = new WebDriverWait(driver, 10);
//         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='dismiss-button']")));
//         System.out.println("wait element");

//         if(driver.findElement(By.xpath("//div[@id ='dismiss-button']")).isDisplayed()){
//
//             driver.findElement(By.xpath("//div[@id ='dismiss-button']")).click();
//             System.out.println("click button");
//         }else {
//             System.out.println("button is not exits");
//         }

//          try{
//              driver.findElement(By.xpath("//div[@class='ns-hbn35-e-14 button-common close-button']"));
//              System.out.println("close button is displayed");
//              driver.findElement(By.xpath("//div[@class='ns-hbn35-e-14 button-common close-button']")).click();
//              System.out.println("click close button ");
//          }catch (NoSuchElementException e){
//              driver.findElement(By.xpath("//div[@class='btn skip']"));
//              Thread.sleep(3000);
//              System.out.println("X button is displayed");
//              driver.findElement(By.xpath("//div[@class='btn skip']")).click();
//              System.out.println("click x button");
//          }

//         if(isElementPresent(By.xpath("//div[@aria-label='Close ad']"))==true){
//             System.out.println("close button is displayed");
//             System.out.println(isElementPresent(By.xpath("//div[@aria-label='Close ad']")));
////              driver.findElement(By.xpath("//div[@class='ns-hbn35-e-14 button-common close-button']")).click();
//             driver.findElement(By.xpath("//div[@aria-label='Close ad']")).click();
//             System.out.println("click close button ");
//         }
//         else {
//              System.out.println("X button is displayed");
//              driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
//              System.out.println("click x button");
//         }

         //return iframe
         driver.switchTo().defaultContent();
         System.out.println("return iframe");

         driver.navigate().refresh();
         Thread.sleep(1000);
         WebElement clickHere1 = driver.findElement(By.xpath("//a[text()='here']"));
         clickHere1.click();

         //Created acct
         WebElement inputEmail = driver.findElement(By.name("emailid"));
         inputEmail.sendKeys(email);

         WebElement clickSubmit = driver.findElement(By.xpath("//input[@name='btnLogin']"));
         clickSubmit.click();

         //Biến cục bộ
         //Chỉ dùng trong phạm vi  1 function/block code
         getUsername = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
         System.out.println("getUsername");

         getPassword = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
         System.out.println("get password");
         Thread.sleep(2000);

     }

    protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            System.out.println(e);
            return false;
        }
    }

    @Test
    public void TC_02_Login(){
        //1
        //driver.navigate().back();
        //driver.navigate().back();

        //2
        //driver.get(loginURL);

        //3
        driver.get(loginPageUrl);

        WebElement inputUserID = driver.findElement(By.name("uid"));
        inputUserID.sendKeys(getUsername);

        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys(getPassword);

        WebElement clickLogin = driver.findElement(By.name("btnLogin"));
        clickLogin.click();
        System.out.println("login success");

        WebElement verifyText = driver.findElement(By.xpath("//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
        Assert.assertTrue(verifyText.isDisplayed());
        System.out.println("text is displayed");

    }

    @Test
    public void TC_03_New_Customer() throws InterruptedException {
        WebElement clickNewCustomer = driver.findElement(By.xpath("//a[text()='New Customer']"));
        clickNewCustomer.click();

        //input data to fields
        driver.findElement(nameTextboxBy).sendKeys(name);
        driver.findElement(genderRadioBy).click();

        jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", driver.findElement(dateOfBirthBy));
        Thread.sleep(1000);

        driver.findElement(dateOfBirthBy).sendKeys(dateOfBirthInput);
        driver.findElement(adrressAreaBy).sendKeys(adrressInput);
        driver.findElement(cityTexboxBy).sendKeys(city);
        driver.findElement(stateTexboxBy).sendKeys(state);
        driver.findElement(pinTextboxBy).sendKeys(pin);
        driver.findElement(phoneTextboxBy).sendKeys(phone);
        driver.findElement(emailTextboxBy).sendKeys(email);
        driver.findElement(passwordTextboxBy).sendKeys(password);

        System.out.println("fill data to fields");

        //click submit create cus
        driver.findElement(By.name("sub")).click();

        WebElement verifyTitle = driver.findElement(By.xpath("//p[@class='heading3' and text()=\"Customer Registered Successfully!!!\"]"));
        Assert.assertTrue(verifyTitle.isDisplayed());
        System.out.println("create acct successful");

        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), gender);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dateOfBirthOutput);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), adrressOutput);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phone);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), email);


        customerID = driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText();

        System.out.println("verify data entered");
    }

    @Test
    public void TC_04_Edit_Customer() throws InterruptedException {
        //open edit tab
        WebElement clickEdit = driver.findElement(By.xpath("//a[text()='Edit Customer']"));
        clickEdit.click();

        //fill data to access page
        driver.findElement(By.name("cusid")).sendKeys(customerID);
        driver.findElement(By.name("AccSubmit")).click();
        System.out.println("driect to edit page");
        Thread.sleep(2000);

        //verify data entered
//        Assert.assertEquals(driver.findElement(nameTextboxBy).getAttribute("value"), name);
//        Assert.assertEquals(driver.findElement(genderRadioBy).getAttribute("value"), gender);
//        Assert.assertEquals(driver.findElement(dateOfBirthBy).getAttribute("value"), dateOfBirthInput);
//        Assert.assertEquals(driver.findElement(adrressAreaBy).getAttribute("value"), adrressInput);
//        Assert.assertEquals(driver.findElement(cityTexboxBy).getAttribute("value"), city);
//        Assert.assertEquals(driver.findElement(stateTexboxBy).getAttribute("value"), state);
//        Assert.assertEquals(driver.findElement(pinTextboxBy).getAttribute("value"), pin);
//        Assert.assertEquals(driver.findElement(phoneTextboxBy).getAttribute("value"), phone);
//        Assert.assertEquals(driver.findElement(emailTextboxBy).getAttribute("value"), email);
//        System.out.println("data is matched");

        //edit data
        driver.findElement(adrressAreaBy).clear();
        driver.findElement(adrressAreaBy).sendKeys(editAddressInput);

        driver.findElement(cityTexboxBy).clear();
        driver.findElement(cityTexboxBy).sendKeys(editCity);

        driver.findElement(stateTexboxBy).clear();
        driver.findElement(stateTexboxBy).sendKeys(editState);

        driver.findElement(pinTextboxBy).clear();
        driver.findElement(pinTextboxBy).sendKeys(editPin);

        driver.findElement(phoneTextboxBy).clear();
        driver.findElement(phoneTextboxBy).sendKeys(editPhone);

        driver.findElement(emailTextboxBy).clear();
        driver.findElement(emailTextboxBy).sendKeys(editEmail);

        //click submit
        driver.findElement(By.name("sub")).click();

        WebElement verifyTitle = driver.findElement(By.xpath("//p[@class='heading3' and text()=\"Customer detail updated Successfully!!!\"]"));
        Assert.assertTrue(verifyTitle.isDisplayed());
        System.out.println("edit cus success");

        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText(), customerID);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), gender);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dateOfBirthOutput);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), editAddressOutput);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), editCity);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), editState);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), editPin);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), editPhone);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editEmail);
    }

    public int getRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @FindBy(css = "")
    private WebElement webElement;
}
