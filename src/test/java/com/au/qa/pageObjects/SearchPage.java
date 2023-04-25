package com.au.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    final String refundable_Value = "refundable";

    public SearchPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By searchByPropertyName = By.xpath("//button[contains(@aria-label, 'Marriott')]");

    By breakfastIncluded = By.xpath("//input[@value='FREE_BREAKFAST' and @type='checkbox']");
    By freeBreakfastSelected = By.xpath("//input[@value='FREE_BREAKFAST' and @type='checkbox' and contains(@class, 'checked')]");

    By lunchIncluded = By.xpath("//input[@value='HALF_BOARD' and @type='checkbox']");
    By lunchSelected = By.xpath("//input[@value='HALF_BOARD' and @type='checkbox' and contains(@class, 'checked')]");

    By dinnerIncluded = By.xpath("//input[@value='FULL_BOARD' and @type='checkbox']");
    By dinnerSelected = By.xpath("//input[@value='FULL_BOARD' and @type='checkbox' and contains(@class, 'checked')]");

    By allInclusiveIncluded = By.xpath("//input[@value='ALL_INCLUSIVE' and @type='checkbox']");
    By allInclusiveSelected = By.xpath("//input[@value='ALL_INCLUSIVE' and @type='checkbox' and contains(@class, 'checked')]");

    By fullyRefundable = By.xpath("//input[@value='FREE_CANCELLATION' and @type='checkbox']");
    By fullyRefundableSelected = By.xpath("//input[@value='FREE_CANCELLATION' and @type='checkbox' and contains(@class, 'checked')]");

    By seeMoreAmenities = By.xpath("//button[@aria-label='See more amenities']");

    By kitchenIncluded = By.xpath("//input[@value='KITCHEN_KITCHENETTE' and @type='checkbox']");
    By kitchenSelected = By.xpath("//input[@value='KITCHEN_KITCHENETTE' and @type='checkbox' and contains(@class, 'checked')]");

    By parkingIncluded = By.xpath("//input[@value='PARKING' and @type='checkbox']");
    By parkingSelected = By.xpath("//input[@value='PARKING' and @type='checkbox' and contains(@class, 'checked')]");

    By spaIncluded = By.xpath("//input[@value='SPA_ON_SITE' and @type='checkbox']");
    By spaSelected = By.xpath("//input[@value='SPA_ON_SITE' and @type='checkbox' and contains(@class, 'checked')]");


    By poolIncluded = By.xpath("//input[@value='POOL' and @type='checkbox']");
    By poolSelected = By.xpath("//input[@value='POOL' and @type='checkbox' and contains(@class, 'checked')]");

    By openHotelInformation = By.xpath("//a[@data-stid='open-hotel-information']");

    /**
     *  select the mealPlan as per the input provided
     */
    public void selectMealPlan(String mealPlan)
    {
        try {
            if (!isMealPlanSelected(mealPlan)) {
                switch (mealPlan) {
                    case "Breakfast":
                        scrollAndClickElement(driver.findElement(breakfastIncluded));
                        break;
                    case "Lunch":
                        scrollAndClickElement(driver.findElement(lunchIncluded));
                        break;
                    case "Dinner":
                        scrollAndClickElement(driver.findElement(dinnerIncluded));
                        break;
                    case "All-inclusive":
                        scrollAndClickElement(driver.findElement(allInclusiveIncluded));
                        break;
                    default:
                        //Do Nothing
                        break;
                }
            }
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }

    }

    /**
     *  validate if the mealPlan is selected as per the input provided
     */
    public boolean isMealPlanSelected(String mealPlan)
    {
        switch (mealPlan)
        {
            case "Breakfast":
                return driver.findElements(freeBreakfastSelected).size() != 0;
            case "Lunch":
                return driver.findElements(lunchSelected).size() != 0;
            case "Dinner":
                return driver.findElements(dinnerSelected).size() != 0;
            case "All-inclusive":
                return driver.findElements(allInclusiveSelected).size() != 0;
            default:
                return false;//default value
        }
    }


    public void searchPageSynchronization()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(searchByPropertyName));
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    /**
     *  Scroll into the element when the element is outside the current visible scope
     */
    private void scrollAndClickElement(WebElement element)
    {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    /**
     *  Filtering conditions as per the input
     */
    public void selectCancellationOptions(String cancellationOption)
    {
        try {
            if (cancellationOption.equalsIgnoreCase(refundable_Value)) {
                scrollAndClickElement(driver.findElement(fullyRefundable));
            } else {
                //Invalid input, cancellation policy not applicable
            }
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }

    }

    public boolean isFullyRefundableSelected()
    {
        return driver.findElements(fullyRefundableSelected).size() != 0;
    }

    private void seeMoreAmenities()
    {
        try {
            scrollAndClickElement(driver.findElement(seeMoreAmenities));
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }


    public void selectAmenities(String amenity)
    {
        try {
            seeMoreAmenities();
            if (!isAmenitySelected(amenity)) {
                switch (amenity) {
                    case "Kitchen":
                        scrollAndClickElement(driver.findElement(kitchenIncluded));
                        break;
                    case "Parking":
                        scrollAndClickElement(driver.findElement(parkingIncluded));
                        break;
                    case "Spa":
                        scrollAndClickElement(driver.findElement(spaIncluded));
                        break;
                    case "Pool":
                        scrollAndClickElement(driver.findElement(poolIncluded));
                        break;
                    default:
                        //Do Nothing
                        break;
                }
            }
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public boolean isAmenitySelected(String amenity)
    {
        switch (amenity)
        {
            //Implemented a few for now for this assignment, can be included full list
            case "Kitchen":
                return driver.findElements(kitchenSelected).size() != 0;
            case "Parking":
                return driver.findElements(parkingSelected).size() != 0;
            case "Spa":
                return driver.findElements(spaSelected).size() != 0;
            case "Pool":
                return driver.findElements(poolSelected).size() != 0;
            default:
                return false;//default value
        }
    }

    public List<WebElement> getAllTheHotelsListed()
    {
        return driver.findElements(openHotelInformation);
    }
}
