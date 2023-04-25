package com.au.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FlightSelectPage {
    public WebDriver driver;

    public FlightSelectPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By firstAvailableFlight = By.xpath("//button[contains(@stid, 'FLIGHTS_DETAILS_AND_FARES-index-1')]");
    By confirmFlight = By.xpath("//button[@stid='select-button']");
    By gotoCheckOut = By.xpath("//button[@data-stid='goto-checkout-button']");

    public void selectFlight() {
        try {
            waitForElementTobeClickable(driver.findElement(firstAvailableFlight));
            Thread.sleep(1000);//TODO
            driver.findElement(firstAvailableFlight).click();
            waitForElementTobeClickable(driver.findElement(confirmFlight));
            Thread.sleep(1000);//TODO
            driver.findElement(confirmFlight).click();
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void proceedWithCheckOut() {
        try {
            waitForElementTobeClickable(driver.findElement(gotoCheckOut));
            Thread.sleep(1000);//TODO
            driver.findElement(gotoCheckOut).click();
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void waitForElementTobeClickable(WebElement element)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }
}
