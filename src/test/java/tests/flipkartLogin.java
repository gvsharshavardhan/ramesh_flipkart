package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class flipkartLogin extends BaseTest {
    String url = "https://www.flipkart.com/";
    By closebbutton = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
    By logo = By.cssSelector("[title='Flipkart']");

    @Test
    public void testFlipKartLaunch() throws InterruptedException {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "url is not as expected after launching!!");
    }

    @Test
    public void testVisibilityOfFlipkartLabel() {
        driver.get(url);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(closebbutton)).click();
        boolean isdisplayed = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
        Assert.assertTrue(isdisplayed, "logo is not displayed!!");
    }
}