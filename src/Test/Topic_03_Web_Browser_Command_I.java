package Test;
        import org.openqa.selenium.Dimension;
        import org.openqa.selenium.Point;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

        import java.util.concurrent.TimeUnit;

public class Topic_03_Web_Browser_Command_I {

    WebDriver driver;
    String projectPath = System.getProperty("user.id");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laphuong\\Downloads\\auto\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Browser(){
        // open page Url
        driver.get("https://www.facebook.com/");

        //close 1 tab is active
        //handle windows/tab
        driver.close();

        // close browser
        driver.quit();

        //get current id of the active tab/ window
        driver.getWindowHandle();

        //get all id of all active tabs/ window
        driver.getWindowHandles();

        //return url of current page
        String homePageUrl = driver.getCurrentUrl();

        //return HTML source of current page
        String homePageSource = driver.getPageSource();;

        //return title of current page
        String homePageTitle = driver.getTitle();

        //Get/Delete cookie of page
        //Build framework: share state of Class
        //Get cookie after login -> truyền vào các class khác -> Reduce time login cho từng class
        driver.manage().deleteAllCookies();

        //Build framework: Get ra log của browser
        driver.manage().logs().getAvailableLogTypes();

        //chờ cho việc tìm element (findElement/ findElements)
        //WebDriverWait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //chờ cho 1 page được load thành công(Option)
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        //chờ chp 1 script được execute thành công(Option)
        driver.manage().timeouts().setScriptTimeout(15,TimeUnit.SECONDS);

        //Mở browser full màn hình
        driver.manage().window().fullscreen();

        //Maximize màn hình
        driver.manage().window().maximize();

        //lấy ra vị trí hiện tại của browser
        driver.manage().window().getPosition();

        //set vào cho browser tại vị trí nào đó
        //driver.manage().window().getPosition(new Point(0, 0));

        //Lấy ra kích thước hiện tại của browser(rộng/cao)
        driver.manage().window().getSize();
        //driver.manage().window().getSize(new Dimension(1920, 1080));

        //Back to page
        driver.navigate().back();

        //Forward to page
        driver.navigate().forward();

        //Tải lại trang
        driver.navigate().refresh();

        //keep history
        driver.navigate().to("https://www.facebook.com/");
    }

    @AfterClass
    public void afterClas(){

        driver.quit();
    }

}

