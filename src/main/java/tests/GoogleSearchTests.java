package tests;

import functionLibrary.CommonFunctions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;

public class GoogleSearchTests extends CommonFunctions {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleSearchTests.class);

    @Before
    public void beforeTest()
    {
        openBrowser();
        driver.get("https://www.google.co.uk/");

    }

    @Test
    public void verifyGoogleSearch() {

        LOGGER.info("User clicks on the google cookies agree button");
        driver.findElement(By.xpath("//div[contains(text(),'I agree')]")).click();
        forceWaitForTime(3);

        LOGGER.info("User searching software testing");
        String searchText = "software testing";
        int nbOfResultsToSearch = 5;
        driver.findElement(By.cssSelector("input[name=q]")).sendKeys(searchText);
        driver.findElement(By.cssSelector("input[name=q]")).sendKeys(Keys.ENTER);
        forceWaitForTime(2);
        LOGGER.info("Getting all search results from google search results page");
        List<WebElement> searchResultList = driver.findElements(By.cssSelector("a h3"));
        LOGGER.info("Verifying my search text found in the search results");
        Assert.assertTrue(searchText + " wasn't found in the first " + nbOfResultsToSearch + " results.",
                        isInResults(searchResultList, searchText, nbOfResultsToSearch));

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    public boolean isInResults(List<WebElement> searchResultList, String searchText, int nbOfResultsToSearch)
    {
        forceWaitForTime(2);
        return IntStream.range(0, Math.min(searchResultList.size(), nbOfResultsToSearch))
                .anyMatch(index -> searchResultList.get(index).getText().toLowerCase().contains(searchText));
    }

    @After
    public void afterTest()
    {
        closeBrowser();

    }


}
