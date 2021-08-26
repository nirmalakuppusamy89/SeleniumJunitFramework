package tests;

import functionLibrary.CommonFunctions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkyScannerFlightSearchTests extends CommonFunctions {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkyScannerFlightSearchTests.class);

    @Before
    public void beforeTest()
    {
        openBrowser();
        driver.get("https://www.skyscanner.net/");

    }

    @Test
    public void defaultFlightSearch()
    {

        LOGGER.info("Clicking cookies button");
        driver.findElement(By.xpath("//*[@id=\"cookie-banner-root\"]/div[1]/div/div[2]/button[1]")).click();
        forceWaitForTime(3);

        String expectedSearchText = "India";
        LOGGER.info("Entering actual destination country text");
        driver.findElement(By.xpath("//*[@id=\"fsc-destination-search\"]")).sendKeys(expectedSearchText);

        LOGGER.info("User clicks search flights button");
        driver.findElement(By.xpath("//*[@id=\"flights-search-controls-root\"]/div/div/form/div[3]/button")).click();
        forceWaitForTime(3);

        LOGGER.info("Getting destination country value");
        String actualSearchPageText = driver.findElement(
                By.xpath("//*[@id=\"flights-search-summary-root\"]/div/section/div[2]/div/div[1]/span[4]")).getText();
        forceWaitForTime(3);
        LOGGER.info("Verifying the search result page text");
        Assert.assertEquals(expectedSearchText, actualSearchPageText);

    }
    @Test
    public void defaultHotelSearch()
    {

        LOGGER.info("Clicking cookies button");
        driver.findElement(By.xpath("//*[@id=\"cookie-banner-root\"]/div[1]/div/div[2]/button[1]")).click();
        forceWaitForTime(3);

        LOGGER.info("User clicks the hotels option");
        driver.findElement(By.xpath("//*[@id=\"skhot\"]")).click();
        forceWaitForTime(3);

        String expectedSearchText = "London";
        LOGGER.info("Entering actual place of stay search text");
        driver.findElement(By.xpath("//*[@id=\"destination-autosuggest\"]")).sendKeys(expectedSearchText);

        forceWaitForTime(3);
        LOGGER.info("User clicks search hotels button");
        driver.findElement(By.xpath("//*[@id=\"search-controls\"]/div[2]/button")).click();
        forceWaitForTime(10);

        LOGGER.info("Getting hotel place search value");
        String actualSearchPageText = driver.findElement(
                By.xpath("//*[@id=\"searchResultCardsContainer\"]/div[1]/div/div[2]/p[1]")).getText();
        forceWaitForTime(3);
        LOGGER.info("Verifying the search result page text");
        Assert.assertTrue(actualSearchPageText.contains(expectedSearchText));


    }

    @After
    public void afterTest()
    {
        closeBrowser();

    }

}
