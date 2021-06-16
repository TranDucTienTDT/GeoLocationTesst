package org.selenium4;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Map;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocationTest {
    protected static ChromeDriver driver;
    String URL = "https://maps.google.com/";

    @BeforeClass
    public void testSetUp() {
        /* System.setProperty("webdriver.chrome.driver", "C:\\EdgeDriver\\chromedriver.exe"); */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test_Selenium4_Geolocation() throws InterruptedException {
        Map< String,Object> coordinates =
                new HashMap< String,Object>();
        Map< String,Object> coordinates1 =
                new HashMap< String,Object>();

        /* Create a hashmap for latitude, longitude, and accuracy as needed by Google Maps */
        coordinates1.put("latitude", 10.78336657835731);
        coordinates1.put("longitude", 106.70208992062993);
        coordinates1.put("accuracy", 100);


        coordinates1.put("latitude", 10.7756037658568911);
        coordinates1.put("longitude", 106.70017143655485);
        coordinates1.put("accuracy", 100);

        /* Command to emulate Geolocation */
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates1);
        driver.navigate().to(URL);
        driver.manage().window().maximize();

        /* driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
        /* Not a good programming practice, added for demonstration */
        Thread.sleep(5000);

        //WebElement location_icon = driver.findElement(By.cssSelector(".icon-geolocate"));
        Thread.sleep(2000);
        //location_icon.click();

        Thread.sleep(6000);
        System.out.println("Geolocation testing with Selenium is complete");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}