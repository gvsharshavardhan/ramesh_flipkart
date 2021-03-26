package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartPage {

    private WebDriver driver;
    private By closebbutton = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
    private By logo = By.cssSelector("[title='Flipkart']");
    private By PlusLabel = By.xpath("//*[.='Plus']");
    private By ExlporeLink = By.xpath("//a[contains(.,'Explore') and contains(.,'Plus')]");
    private By SearchSubmitButton = By.cssSelector("button[type='submit']");
    private By CannotReachSiteLocator = By.cssSelector("[jsselect='heading']");
    private By BannerLoginButton = By.xpath("//span[contains(.,'Login')]/ancestor::button");
    private By BannerUsernameField = By.cssSelector("div._2QfC02 input[type='text']");
    private By BannerPasswordFiled = By.cssSelector("div._2QfC02 input[type='password']");
    private By UsernameLocator = By.xpath("//div[@class='exehdJ' and .='Gurram Ramesh']");
    private By ElectronicsLocator = By.xpath("//p[.='Electronics']/preceding-sibling::img");


    public FlipKartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickBannerCloseButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(closebbutton)).click();
    }

    public boolean isLogoDisplayed() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public boolean isExploreLinkVisible() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(ExlporeLink)).isDisplayed();
    }

    public boolean isPlusLabelPresent() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(PlusLabel)).isDisplayed();
    }

    public boolean isSearchSubmitPresent() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(SearchSubmitButton)).isDisplayed();
    }

    public boolean siteCannotBeReachedShouldBeDisplayed() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(CannotReachSiteLocator)).isDisplayed();
    }

    public void clickBannerLoginButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(BannerLoginButton)).click();
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(BannerUsernameField)).sendKeys(username);
    }

    public void enterPassword(String username) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(BannerPasswordFiled)).sendKeys(username);
    }

    public boolean isMyUserNamePresent() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(UsernameLocator)).isDisplayed();
    }

    public void hoverOverElectronics() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement electronicsElement = driver.findElement(ElectronicsLocator);
        actions.moveToElement(electronicsElement).perform();
        Thread.sleep(10000);
    }
}