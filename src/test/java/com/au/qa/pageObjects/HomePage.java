package com.au.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;

    }

    By packagesTab = By.xpath("//span[contains(text(),'Packages') and @class='uitk-tab-text']");

    By leavingFromButton = By.xpath("//button[@aria-label='Leaving from']");
    By leavingFromInput = By.id("location-field-origin");
    By selectTheSource = By.xpath("//button[@data-stid='location-field-origin-result-item-button']");

    By goingToButton = By.xpath("//button[@aria-label='Going to']");
    By goingToInput = By.id("location-field-destination");
    By selectTheDestination = By.xpath("//button[@data-stid='location-field-destination-result-item-button']");

    By departingButton = By.id("d1-btn");

    By returningButton = By.id("d2-btn");

    By closeDatePicker = By.xpath("//button[@data-stid='apply-date-picker']");

    By searchButton = By.xpath("//button[text()='Search']");



    /**
     *  Select Packages tab as we are looking for both flight & accommodation deals
     */
    public void selectPackagesTab()
    {
        try {
            driver.findElement(packagesTab).click();
        } catch (Exception exception)
        {
            Assert.fail(exception.getMessage());
        }
    }

    /**
     *  entering the source details into the application
     */
    public void enterTheSourceDetails(String source)
    {
        try
        {
            driver.findElement(leavingFromButton).click();
            driver.findElement(leavingFromInput).sendKeys(source);
            driver.findElement(selectTheSource).click();
        } catch (Exception exception)
        {
            Assert.fail(exception.getMessage());
        }
    }

    /**
     *  entering the destination details into the application
     */
    public void enterTheDestinationDetails(String destination)
    {
        try
        {
            driver.findElement(goingToButton).click();
            driver.findElement(goingToInput).sendKeys(destination);
            driver.findElement(selectTheDestination).click();
        } catch (Exception exception){
            Assert.fail(exception.getMessage());
        }

    }

    /**
     *  entering the checkIn date details into the application
     */
    public void selectCheckInDate(String checkInDate)
    {
        try
        {
            driver.findElement(departingButton).click();
            driver.findElement(By.xpath("//button[@aria-label='" + checkInDate + "']")).click();
        }catch (Exception exception)
        {
            Assert.fail(exception.getMessage());
        }

    }

    /**
     *  entering the checkOut date details into the application
     */
    public void selectCheckOutDate(String checkOutDate)
    {
        try
        {
            driver.findElement(By.xpath("//button[@aria-label='" + checkOutDate + "']")).click();
            driver.findElement(closeDatePicker).click();
        } catch (Exception exception)
        {
            Assert.fail(exception.getMessage());
        }

    }

    /**
     *  click on search button after providing all the required input values
     */
    public void clickOnSearchButton()
    {
        try
        {
            driver.findElement(searchButton).click();
        } catch (Exception exception)
        {
            Assert.fail(exception.getMessage());
        }

    }
}
