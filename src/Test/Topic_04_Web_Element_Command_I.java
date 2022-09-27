package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Web_Element_Command_I {
    WebDriver driver;
    String projectPath = System.getProperty("user.id");
    TakesScreenshot srcShot;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        srcShot = ((TakesScreenshot)driver);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_(){
        //WebBrowser command/ method/ API
        //driver instance/ variable

        //WebElement command/ method/ API
        //1
        driver.findElement(By.name("login")).click();

        //2
        WebElement emailTextbox = driver.findElement(By.id("email"));
        emailTextbox.clear();
        emailTextbox.sendKeys("abc@gmail.com");
        emailTextbox.isDisplayed();

        WebElement element = driver.findElement(By.id(""));

        //Xóa dữ liệu trong editable field (textbox/ textarea/ dropdown)
        element.clear();//**

        //Nhập dữ liệu vào editable field (textbox/ textarea/ dropdown)
        element.sendKeys("...");
        element.sendKeys(Keys.ENTER);//**

        //Click vào button/ link/ radio/ checkbox/ image/...
        element.click();//**

        //trả về dữ liệu nằm trong attribute của element
        element.getAttribute("placeholder");
        element.getAttribute("value");//**
        //Email hoặc số điện thoại
        //abc@gmail.com

        //lấy thuộc tính của element: front/ size/ color/...
        element.getCssValue("background-color");//**
        //#4ab2f1
        //hexa
        //rgba

        //GUI
        element.getLocation();
        element.getRect();
        element.getSize();

        //Take screenshot ->Attach to HTML report
        element.getScreenshotAs(OutputType.FILE);//**
        element.getScreenshotAs(OutputType.BASE64);
        element.getScreenshotAs(OutputType.BYTES);

        //Tên thẻ HTML
        //Dùng By.id/ class/ css/ name
        //Đầu ra của step này là đầu vào của step kia
        element = driver.findElement(By.cssSelector("#save-info-button"));
        String saveButtonTagname = element.getTagName();

        driver.findElement(By.xpath("//"+ saveButtonTagname +"[@name='email']"));

        String addressName = "123 Le Duan";
        String cityName = "Ha Noi";

        //// nối chuỗi
        System.out.println(addressName + cityName);
        System.out.println(addressName.concat(cityName));
        System.out.println(addressName + "-" + cityName);

        //Lấy text của header/ link/ lable/ error/ success msg
        element.getText();//**

        //Kiểm tra 1 element có hiển thị hay ko (hiển thị: người dùng nhìn thấy được và thao tác được)
        element.isDisplayed();//**
        Assert.assertTrue(element.isDisplayed());//**

        //Kiểm tra 1 element có thao tác được hay ko (ko bị disable/ ko phải là readonly field)
        element.isEnabled();//**

        //Kiểm tra 1 element đã được chọn hay chưa (radio/ checkbox/ dropdown)
        element.isSelected();//**

        //Submit vào 1 form
        element.submit();


    }

    @Test
    public void TC_02_(){

    }

    @Test
    public void TC_03_(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
