package com.au.qa.stepDefinitions;

import com.au.qa.pageObjects.FlightSelectPage;
import com.au.qa.pageObjects.RoomSelectPage;
import com.au.qa.pageObjects.SearchPage;
import com.au.qa.utils.TestContextSetup;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class FlightSelectPageStepDefinition {
    public WebDriver driver;
    TestContextSetup testContextSetup;
    FlightSelectPage flightSelectPage;

    public FlightSelectPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        this.flightSelectPage = testContextSetup.pageObjectManager.getFlightSelectPage();
    }

    /**
     *  Select the flight details as per the requirement
     */
    @And("^User Selected flights$")
    public void user_selected_flights() throws InterruptedException {
        flightSelectPage.selectFlight();//Selected Source to destination Flight
        flightSelectPage.selectFlight();//Selected return flight
        flightSelectPage.proceedWithCheckOut();
    }
}
