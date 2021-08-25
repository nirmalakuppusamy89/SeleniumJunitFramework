package tests;

import functionLibrary.CommonFunctions;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NextRegistrationTests extends CommonFunctions {

    private static Logger LOGGER = LoggerFactory.getLogger(NextRegistrationTests.class);

    @Before
    public void beforeTest()
    {
        openBrowser();
        driver.get("https://www.next.co.uk/");

    }
    @Test
    public void RegisterAndVerifyUserLogIn()
    {
        LOGGER.info("verify user clicks my account button");
        driver.findElement(By.xpath("/html/body/header/div[2]/section/section[3]/ul/li[1]/a")).click();

        LOGGER.info("user clicks register now button");
        driver.findElement(By.xpath("//*[@id=\"sec\"]/div/a")).click();

        forceWaitForTime(3);
        String actualQuickSignUpText = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
        LOGGER.info("verifying valid register page");
        Assert.assertTrue(actualQuickSignUpText.contains("Quick Secure Sign Up"));

//
//        LOGGER.info("User clicks the dropdown");
//        driver.findElement(By.xpath("//*[@id=\"Title\"]")).click();
//
//        LOGGER.info("User choose the Title ");
//        driver.findElement(By.xpath("//*[@id=\"Title\"]/option[3]")).click();

        LOGGER.info("Selecting title from dropdown");
        Select dropdownTitle = new Select(driver.findElement(By.name("Title")));
        dropdownTitle.selectByValue("Mrs");

        String firstName = "firstname" + RandomStringUtils.randomAlphabetic(10);
        String lastName =  "lastname" + RandomStringUtils.randomAlphabetic(10);
        String email = "email_" +  RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
        String password = "1234" + RandomStringUtils.randomAlphabetic(8);
        String dateOfBirth = "01 01 89";
        String contactTelephone = "07" + RandomStringUtils.randomNumeric(9);
        String houseNumber = RandomStringUtils.randomNumeric(2);

        LOGGER.info("User fills in the first name");
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys(firstName);

        LOGGER.info("User fills in the last name");
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys(lastName);

        LOGGER.info("User fills in the Email");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);


        LOGGER.info("User fills in the password");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);


        LOGGER.info("User fills in the Date of Birth");
        driver.findElement(By.xpath("//*[@id=\"DobDate\"]")).sendKeys(dateOfBirth);


        LOGGER.info("User fills in the contact telephone");
        driver.findElement(By.xpath("//*[@id=\"PhoneNumber\"]")).sendKeys(contactTelephone);

        LOGGER.info("User fills in the house number");
        driver.findElement(By.xpath("//*[@id=\"HouseNumberOrName\"]")).sendKeys(houseNumber);


        LOGGER.info("User fills the postcode");
        driver.findElement(By.xpath("//*[@id=\"Postcode\"]")).sendKeys("E12 6TY");

        LOGGER.info("User clicks the find button");
        driver.findElement(By.xpath("//*[@id=\"SearchPostcode\"]")).click();
        forceWaitForTime(3);

        LOGGER.info("User selects the address");
        Select postcodeDropDown = new Select(driver.findElement(By.name("UserAddress.AddressListSelection")));
        postcodeDropDown.selectByValue("2");

        LOGGER.info("User clicks great register my account button");
        driver.findElement(By.xpath("//*[@id=\"SignupButton\"]")).click();

        forceWaitForTime(3);
        LOGGER.info("Getting register successful alert");
        String actualSuccessfulRegistrationText = driver.findElement(
                By.xpath("//*[@id=\"welcome-wrapper\"]/div/div[2]/div/p[1]")).getText();
        LOGGER.info("Verifying the successful registration text");
        Assert.assertEquals(actualSuccessfulRegistrationText, "Thank you for registering.");






    }





    @After
    public void afterTest()
    {
        closeBrowser();

    }

}
