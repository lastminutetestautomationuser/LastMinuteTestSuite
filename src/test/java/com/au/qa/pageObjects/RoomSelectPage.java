package com.au.qa.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RoomSelectPage {
    public WebDriver driver;

    public RoomSelectPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By reserveARoomButton = By.xpath("//button[@data-stid='sticky-button']");
    By roomListElements = By.xpath("//div[contains(@data-stid,'property-offer-')]");
    By reserveButtonElements = By.xpath("//button[@data-stid='submit-hotel-reserve']");

    public void roomSelectPageSynchronization()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(reserveARoomButton));
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    private void scrollAndClickElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(3000);//TODO
            element.click();
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    /**
     *  List all the hotels after applying the required filter
     *  validate each hotel to see if required roomType and bedType is available, if available book that hotel and exit the loop
     */
    public void selectDesiredRoom(List<WebElement> hotelsList, String roomType, String bedType) {
        try
        {
            boolean isRequiredHotelFound = false;
            String ParentWindow = driver.getWindowHandle();
            for (WebElement hotel: hotelsList)
            {
                hotel.click();
                SwitchWindowToChild();
                roomSelectPageSynchronization();
                driver.findElement(reserveARoomButton).click();
                List<WebElement> roomsList = driver.findElements(roomListElements);
                List<WebElement> reserveButtons = driver.findElements(reserveButtonElements);
                for(int i=0; i < roomsList.size(); i++)
                {
                    String roomFacilities = roomsList.get(i).getText();
                    if(roomFacilities.contains(roomType)  && roomFacilities.contains(bedType))
                    {
                        isRequiredHotelFound = true;
                        reserveButtons.get(i).sendKeys(Keys.RETURN);
                        Thread.sleep(2000);//TODO
                        break;
                    }
                }
                if(isRequiredHotelFound)
                {
                    break;
                }
                driver.close();
                driver.switchTo().window(ParentWindow);
            }
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    private void SwitchWindowToChild()
    {
        try {
            Set<String> s1 = driver.getWindowHandles();
            Iterator<String> i1 = s1.iterator();
            String parentWindow = i1.next();
            String childWindow = i1.next();
            driver.switchTo().window(childWindow);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }
}
