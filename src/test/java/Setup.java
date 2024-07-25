import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Setup {
    public static WebDriver driver=null;
    public static String browserName = null;
    public static String Url = null;


    @BeforeMethod
    public void setUp(){
        PropertiesConfig.getBrowser();
        PropertiesConfig.getURL();

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(Url);

        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(Url);

        }

    }


    @AfterMethod
    public void closeBrowsers(){
        if (driver != null) {
            driver.quit();
        }
    }
}
