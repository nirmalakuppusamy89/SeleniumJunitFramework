package tests;

import functionLibrary.CommonFunctions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdmiralAutoQuoteTests extends CommonFunctions {

    private static Logger LOGGER = LoggerFactory.getLogger(AdmiralAutoQuoteTests.class);

    @Before
    public void beforeTest()
    {
        openBrowser();
        LOGGER.info("User opens admiral wesite");
        driver.get("https://www.admiral.com");

    }


    @Test
    public void verifyFindTheCarFeature()
    {
        LOGGER.info("clicking accept cookies button");
        driver.findElement(By.id("ccc-recommended-settings")).click();

        forceWaitForTime(3);

        LOGGER.info("clicking the get a quote button");
        driver.findElement(By.xpath("//a[contains(@class, 'button button--hero button--green')]")).click();

        forceWaitForTime(10);
        LOGGER.info("Verifing the header text");
        String actualHeaderText = driver.findElement(
                By.xpath("//*[@id=\"ng-app\"]/header/div[2]/h1")).getText();
        Assert.assertTrue(actualHeaderText.contains("MultiCover Insurance"));

        LOGGER.info("Clicking the registration number");
        driver.findElement(By.xpath("//*[@id=\"registrationNr\"]")).getText();

        LOGGER.info("Entering the car registration number");
        driver.findElement(By.xpath("//input[@id='registrationNr']")).sendKeys("EY53 UOE");

        LOGGER.info("Clicking the find car button");
        driver.findElement(By.xpath("//button[contains(text(),'Find car')]")).click();
        forceWaitForTime(3);
        LOGGER.info("Getting registration number");
        String actualRegistrationNumber = driver.findElement(
                By.xpath("//*[@id=\"ng-app\"]/div[2]/div/main/div[2]/div[2]/div/span/div/h3")).getText();
        LOGGER.info("verifying the registration number");
        Assert.assertTrue(actualRegistrationNumber.contains("EY53 UOE"));

    }


    @After
    public void afterTest()
    {
        closeBrowser();

    }

}
