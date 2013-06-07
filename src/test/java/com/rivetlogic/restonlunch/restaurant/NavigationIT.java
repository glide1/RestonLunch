package com.rivetlogic.restonlunch.restaurant;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class NavigationIT {

    private WebDriver driver;

    private final static String baseUrl = "http://localhost:8081";

    @Before
    public void setup() {

        driver = new FirefoxDriver(DesiredCapabilities.firefox());
        //driver = new PhantomJSDriver(DesiredCapabilities.phantomjs());

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @Test
    public void gotoPho75Test() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Restaurants")).click();
        driver.findElement(By.linkText("Pho 75")).click();
        driver.findElement(By.linkText("0")).click();
        driver.findElement(By.linkText("1"));
    }

    @After
    public void cleanup() {
        driver.close();
    }


}
