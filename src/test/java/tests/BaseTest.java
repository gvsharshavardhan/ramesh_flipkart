package tests;

import config.PropertyConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
//        WebDriverManager.chromedriver().setup();
////        driver = new ChromeDriver();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setBrowserName(BrowserType.CHROME);
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);

        WebDriverManager.firefoxdriver().setup();
//        driver = new ChromeDriver();
        desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), desiredCapabilities);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyConfig.getPropValue("implicitTime")), TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}