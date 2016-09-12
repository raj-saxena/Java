package com.xyz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestChromeBrowser {

    public static final String DRIVER_PATH = "./chromedriver";
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("*******************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGooglePageTitleInIEBrowser() {
        driver.navigate().to("http://www.google.com");
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }

}