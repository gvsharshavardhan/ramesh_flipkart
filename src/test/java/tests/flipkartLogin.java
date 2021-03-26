package tests;

import config.PropertyConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlipKartPage;

public class flipkartLogin extends BaseTest {
    FlipKartPage flipkartpage;

    @Test
    public void testFlipKartLaunch() throws Exception {
        flipkartpage = new FlipKartPage(driver);
        String url = PropertyConfig.getPropValue("url");
        flipkartpage.goTo(url);
        Assert.assertEquals(flipkartpage.getUrl(), url, "url is not as expected after launching!!");
    }

    @Test
    public void testVisibilityOfFlipkartLabel() throws Exception {
        flipkartpage = new FlipKartPage(driver);
        String url = PropertyConfig.getPropValue("url");
        flipkartpage.goTo(url);
        flipkartpage.clickBannerCloseButton();
        Assert.assertTrue(flipkartpage.isLogoDisplayed(), "logo is not displayed!!");
    }

    @Test
    public void testIncorrectUrl() throws Exception {
        flipkartpage = new FlipKartPage(driver);
        String url = PropertyConfig.getPropValue("incorrectUrl");
        Assert.assertTrue(flipkartpage.siteCannotBeReachedShouldBeDisplayed(), "wrong url worked!!");
    }

    @Test
    public void testVisibilityOfFlipKartElements() throws Exception {
        flipkartpage = new FlipKartPage(driver);
        String url = PropertyConfig.getPropValue("url");
        flipkartpage.goTo(url);
        flipkartpage.clickBannerCloseButton();
        Assert.assertTrue(flipkartpage.isExploreLinkVisible(), "explore link is not visible!!");
        Assert.assertTrue(flipkartpage.isPlusLabelPresent(), "plus label is not visible!!");
        Assert.assertTrue(flipkartpage.isSearchSubmitPresent(), "search submit is not visible!!");
    }

    @Test
    public void loginLogoutFlipkart() throws Exception {
        flipkartpage = new FlipKartPage(driver);
        String url = PropertyConfig.getPropValue("url");
        flipkartpage.goTo(url);
        flipkartpage.enterUsername(PropertyConfig.getPropValue("username"));
        flipkartpage.enterPassword(PropertyConfig.getPropValue("password"));
        flipkartpage.clickBannerLoginButton();
        flipkartpage.isMyUserNamePresent();
    }
}