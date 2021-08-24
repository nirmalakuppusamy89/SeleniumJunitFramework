package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    public void closeBrowser()
    {
     driver.quit();
    }
    public void waitForTime(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void forceWaitForTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

