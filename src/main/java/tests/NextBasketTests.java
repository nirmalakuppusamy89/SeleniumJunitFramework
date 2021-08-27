package tests;

import functionLibrary.CommonFunctions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NextBasketTests extends CommonFunctions {

    private static final Logger LOGGER = LoggerFactory.getLogger(NextBasketTests.class);

    @Before
    public void beforeTest()
    {
         openBrowser();
         driver.get("https://www.next.co.uk/");

    }

    @Test
    public void verifyAddAnItemToBag()
    {
        LOGGER.info("User searching in next website");
        driver.findElement(By.id("sli_search_1")).sendKeys("T-Shirt");

        LOGGER.info("User clicks search button");
        driver.findElement(By.xpath("//*[@id=\"newsearch\"]/input[4]")).click();

        LOGGER.info("Getting the search text value ");
        String actualSearchText =  driver.findElement(
                By.xpath("//*[@id=\"ResultHeader\"]/div[1]/h1/div")).getText();
        String expectedText = "T-Shirt";

        LOGGER.info("Verifying the search text");
        Assert.assertEquals(expectedText, actualSearchText);
        String expectedProductName = driver.findElement(
                By.xpath("//*[@id=\"i1\"]/section/div[1]/h2/a/span")).getText();

        LOGGER.info("Selecting and opening the first item from the search results");
        driver.findElement(By.xpath("//*[@id=\"i1\"]/section/div[1]/h2/a/span")).click();

        LOGGER.info("Getting the selected item name");
        String actualItemName = driver.findElement(
                By.xpath("//h1[contains(text(),'Curved Hem T-Shirt')]")).getText();

        LOGGER.info("Verifying the selected item name");
        Assert.assertTrue(actualItemName.contains(expectedText));

        LOGGER.info("Clicking on the size dropdown");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-955-639\"]/a")).click();

        LOGGER.info("Selecting the right size");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-955-639\"]/div/ul/li[3]/a")).click();


        LOGGER.info("Clicking the add to bag button");
        waitForTime(3);
        driver.findElement(By.xpath("//a[contains(text(),'ADD TO BAG')]")).click();

        LOGGER.info("Clicking the basket icon");
        driver.findElement(By.id("gel-bag-summary")).click();

        LOGGER.info("Clicking view/edit bag button");
        driver.findElement(By.xpath("/html/body/header/div[2]/section/div[4]/div[3]/a[1]")).click();

        String actualProductName = driver.findElement(By.xpath("//*[@id=\"1\"]/td[2]/div/h3")).getText();
        Assert.assertEquals(expectedProductName, actualProductName);


    }

    @Test
    public void verifyAddMultipleItemToBag()
    {

        LOGGER.info("User searching in next website");
        driver.findElement(By.id("sli_search_1")).sendKeys("T-Shirt");

        LOGGER.info("User clicks search button");
        driver.findElement(By.xpath("//*[@id=\"newsearch\"]/input[4]")).click();

        LOGGER.info("Getting the search text value ");
        String actualSearchText =  driver.findElement(
                By.xpath("//*[@id=\"ResultHeader\"]/div[1]/h1/div")).getText();
        String expectedText = "T-Shirt";

        LOGGER.info("Verifying the search text");
        Assert.assertEquals(expectedText, actualSearchText);
        String expectedFirstProductName = driver.findElement(
                By.xpath("//*[@id=\"i1\"]/section/div[1]/h2/a/span")).getText();

        LOGGER.info("Selecting and opening the first item from the search results");
        driver.findElement(By.xpath("//*[@id=\"i1\"]/section/div[1]/h2/a/span")).click();

        LOGGER.info("Getting the selected item name");
        String actualItemName = driver.findElement(
                By.xpath("//*[@id=\"Style384105\"]/section/div[2]/div[1]/h1")).getText();

        LOGGER.info("Verifying the selected item name");
        Assert.assertTrue(actualItemName.contains(expectedText));

        LOGGER.info("Clicking on the size dropdown");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-955-639\"]/a")).click();

        waitForTime(3);
        LOGGER.info("Selecting the right size");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-955-639\"]/div/ul/li[3]/a")).click();

        LOGGER.info("Clicking the add to bag button first item");
        waitForTime(3);
        driver.findElement(By.xpath("//a[contains(text(),'ADD TO BAG')]")).click();


        //  Second item steps
        LOGGER.info("User searching in next website second time");
        driver.findElement(By.id("sli_search_1")).sendKeys("T-Shirt");

        LOGGER.info("User clicks search button for second time");
        driver.findElement(By.xpath("//*[@id=\"newsearch\"]/input[4]")).click();

        String expectedSecondProductName = driver.findElement(
                By.xpath("//*[@id=\"i4\"]/section/div[1]/h2/a/span")).getText();

        waitForTime(3);
        LOGGER.info("Selecting and opening the second item from the search results");
        driver.findElement(By.xpath("//*[@id=\"i4\"]/section/div[2]/a/img")).click();

        LOGGER.info("Clicking on the size dropdown");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-124-922\"]/a")).click();

        forceWaitForTime(2);

        LOGGER.info("Selecting the right size");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-124-922\"]/div/ul/li[3]/a")).click();

        LOGGER.info("Clicking the add to bag button for second item");
        waitForTime(3);
        driver.findElement(
                By.xpath("//a[contains(text(),'ADD TO BAG')]")).click();

        LOGGER.info("Clicking the basket icon");
        driver.findElement(By.id("gel-bag-summary")).click();

        LOGGER.info("Clicking view/edit bag button");
        driver.findElement(By.xpath("/html/body/header/div[2]/section/div[4]/div[3]/a[1]")).click();

        waitForTime(3);
        LOGGER.info("Getting the firstActualProduct name");
        String actualFirstProductName = driver.findElement(
                By.xpath("/html/body/section[1]/section[1]/div[1]/section/div[2]/div[4]/div[2]/table/tbody/tr[2]/td[2]/div/h3")).getText();

        LOGGER.info("Verifying the firstProductName added to basket " +
                "expected: " + expectedFirstProductName +
                " actual: " + actualFirstProductName);
        Assert.assertEquals(expectedFirstProductName, actualFirstProductName);

        LOGGER.info("Getting the secondActualProduct name");
        String actualSecondProductName = driver.findElement(
                By.xpath("/html/body/section[1]/section[1]/div[1]/section/div[2]/div[4]/div[2]/table/tbody/tr[1]/td[2]/div/h3")).getText();
        LOGGER.info("Verifying the secondProductName added to basket " +
                "expected: " + expectedSecondProductName +
                " actual: " + actualSecondProductName);
        Assert.assertEquals(expectedSecondProductName, actualSecondProductName);

    }

    @Test
    public void verifyUpdateItemInBag()
    {

        LOGGER.info("User searching in next website");
        driver.findElement(By.id("sli_search_1")).sendKeys("T-Shirt");

        LOGGER.info("User clicks search button");
        driver.findElement(By.xpath("//*[@id=\"newsearch\"]/input[4]")).click();

        LOGGER.info("Getting the search text value ");
        String actualSearchText =  driver.findElement(By.xpath("//*[@id=\"ResultHeader\"]/div[1]/h1/div")).getText();
        String expectedText = "T-Shirt";

        LOGGER.info("Verifying the search text");
        Assert.assertEquals(expectedText, actualSearchText);

        LOGGER.info("Selecting and opening the first item from the search results");
        driver.findElement(By.xpath("//*[@id=\"i1\"]/section/div[1]/h2/a/span")).click();

        LOGGER.info("Getting the selected item name");
        String actualItemName = driver.findElement(By.xpath("//h1[contains(text(),'Curved Hem T-Shirt')]")).getText();

        LOGGER.info("Verifying the selected item name");
        Assert.assertTrue(actualItemName.contains(expectedText));

        LOGGER.info("Clicking on the size dropdown");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-955-639\"]/a")).click();

        LOGGER.info("Selecting the right size");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-955-639\"]/div/ul/li[3]/a")).click();


        LOGGER.info("Clicking the add to bag button");
        waitForTime(3);
        driver.findElement(By.xpath("//a[contains(text(),'ADD TO BAG')]")).click();

        LOGGER.info("Clicking the basket icon");
        driver.findElement(By.id("gel-bag-summary")).click();

        LOGGER.info("Clicking view/edit bag button");
        driver.findElement(By.xpath("/html/body/header/div[2]/section/div[4]/div[3]/a[1]")).click();

        waitForTime(3);

        LOGGER.info("Clicking the quantity dropdown");
        driver.findElement(By.xpath(
                "/html/body/section[1]/section[1]/div[1]/section/div[2]/div[4]/div/table/tbody/tr/td[4]/div/a")).click();

        LOGGER.info("Updating the quantity of item for added item in basket ");
        driver.findElement(By.xpath(
                "/html/body/section[1]/section[1]/div[1]/section/div[2]/div[4]/div/table/tbody/tr/td[4]/div/div/ul/li[3]/a")).click();

        forceWaitForTime(5);
        String actualQuantityText = driver.findElement(By.xpath("//*[@id=\"title\"]/p")).getText();
        LOGGER.info("Verifying the selected item name " + "actual: " + actualQuantityText);
        Assert.assertTrue(actualQuantityText.contains("Your bag contains 3 item"));

    }

    @Test
    public void verifyRemoveAnItemFromBag()
    {

        LOGGER.info("User searching in next website");
        driver.findElement(By.id("sli_search_1")).sendKeys("T-Shirt");

        LOGGER.info("User clicks search button");
        driver.findElement(By.xpath("//*[@id=\"newsearch\"]/input[4]")).click();

        LOGGER.info("Getting the search text value ");
        String actualSearchText =  driver.findElement(
                By.xpath("//*[@id=\"ResultHeader\"]/div[1]/h1/div")).getText();
        String expectedText = "T-Shirt";

        LOGGER.info("Verifying the search text");
        Assert.assertEquals(expectedText, actualSearchText);

        LOGGER.info("Selecting and opening the first item from the search results");
        driver.findElement(By.xpath("//*[@id=\"i1\"]/section/div[1]/h2/a/span")).click();

        LOGGER.info("Getting the selected item name");
        String actualItemName = driver.findElement(
                By.xpath("//h1[contains(text(),'Curved Hem T-Shirt')]")).getText();

        LOGGER.info("Verifying the selected item name");
        Assert.assertTrue(actualItemName.contains(expectedText));

        LOGGER.info("Clicking on the size dropdown");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-955-639\"]/a")).click();

        LOGGER.info("Selecting the right size");
        driver.findElement(By.xpath("//*[@id=\"dk_container_Size-955-639\"]/div/ul/li[3]/a")).click();


        LOGGER.info("Clicking the add to bag button");
        waitForTime(3);
        driver.findElement(By.xpath("//a[contains(text(),'ADD TO BAG')]")).click();

        LOGGER.info("Clicking the basket icon");
        driver.findElement(By.id("gel-bag-summary")).click();

        LOGGER.info("Clicking view/edit bag button");
        driver.findElement(By.xpath("/html/body/header/div[2]/section/div[4]/div[3]/a[1]")).click();

        LOGGER.info("clicking remove item from the basket");
        driver.findElement(By.xpath("//a[contains(text(),'Remove Item')]")).click();
        forceWaitForTime(5);

        String actualQuantityText = driver.findElement(By.xpath("//*[@id=\"title\"]/p")).getText();
        LOGGER.info("Verifying the selected item name " + "actual: " + actualQuantityText);
        Assert.assertTrue(actualQuantityText.contains("Your bag contains 0 item"));

    }

    @After
    public void afterTest()
    {
        closeBrowser();

    }
}
