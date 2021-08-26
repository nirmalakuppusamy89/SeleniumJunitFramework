package tests;

import functionLibrary.CommonFunctions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NextCountryDropDownTests extends CommonFunctions {

    private static final Logger LOGGER = LoggerFactory.getLogger(NextCountryDropDownTests.class);

    @Before
    public void beforeTest()
    {
        openBrowser();
        driver.get("https://www.next.co.uk/");

    }
    @Test
    public void verifyUserSelectedCountry() {

        LOGGER.info("User clicks the headerFlagSelector");
        driver.findElement(By.id("headerFlagSelector")).click();

        forceWaitForTime(5);
        LOGGER.info("User clicks the dropDown");
        driver.findElement(
                By.xpath("//header/div[2]/section[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]\n")).click();

        forceWaitForTime(3);
        LOGGER.info("User selects different country");
        driver.findElement(By.xpath("//*[@id=\"dk_container_countrySelectorDropdown\"]/div/ul/li[72]/a")).click();

        forceWaitForTime(2);
        LOGGER.info("Clicking the shop now button");
        driver.findElement(By.xpath("//*[@id=\"btnFlagSelectorShopNow\"]")).click();

        LOGGER.info("Verifying the current Url = .us");
        forceWaitForTime(3);
        String actualCurrentUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualCurrentUrl.contains(".us"));
    }

    @After
    public void afterTest()
    {
        closeBrowser();

    }

}
