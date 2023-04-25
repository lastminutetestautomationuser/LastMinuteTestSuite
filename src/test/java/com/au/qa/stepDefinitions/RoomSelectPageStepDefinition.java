package com.au.qa.stepDefinitions;

import com.au.qa.pageObjects.HomePage;
import com.au.qa.pageObjects.RoomSelectPage;
import com.au.qa.pageObjects.SearchPage;
import com.au.qa.utils.TestContextSetup;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RoomSelectPageStepDefinition {
    public WebDriver driver;
    TestContextSetup testContextSetup;
    RoomSelectPage roomSelectPage;
    
    SearchPage searchPage;

    public RoomSelectPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        this.roomSelectPage = testContextSetup.pageObjectManager.getRoomSelectPage();
        this.searchPage = testContextSetup.pageObjectManager.getSearchPage();
        this.driver = testContextSetup.driver;
    }

    /**
     *  Get all the hotels after the filter condition
     *  Go to each hotel and see if the required roomType and bedType available
     *  Look for hotel until it is found with the required combination
     *
     */
    @And("^User selected (.+) (.+) room$")
    public void user_selected_room(String roomType, String bedType) throws InterruptedException {
        List<WebElement> hotelsList = searchPage.getAllTheHotelsListed();
        roomSelectPage.selectDesiredRoom(hotelsList, roomType, bedType);
    }
}
