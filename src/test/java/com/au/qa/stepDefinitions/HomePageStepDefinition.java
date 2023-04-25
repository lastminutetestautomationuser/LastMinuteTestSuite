package com.au.qa.stepDefinitions;

import com.au.qa.pageObjects.HomePage;
import com.au.qa.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageStepDefinition {
    public WebDriver driver;
    TestContextSetup testContextSetup;
    HomePage homePage;

    public HomePageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();

    }

    @Given("^The user is in lastminute homepage as logged in member$")
    public void the_user_is_in_lastminute_homepage_as_logged_in_member() throws Throwable {
        homePage.selectPackagesTab();

    }

    /**
     *  Search for flight & accommodation as per the input details provided
     */
    @When("^User search for flights and accommodation (.+) (.+) (.+) and (.+)$")
    public void user_search_for_flights_and_accommodation_and(String from, String to, String checkIn, String checkOut) throws InterruptedException {
        homePage.enterTheSourceDetails(from);
        homePage.enterTheDestinationDetails(to);
        Thread.sleep(2000);//TODO
        homePage.selectCheckInDate(testContextSetup.genericUtils.convertTheDate(checkIn));
        Thread.sleep(500);//TODO
        homePage.selectCheckOutDate(testContextSetup.genericUtils.convertTheDate(checkOut));
        Thread.sleep(2000);//TODO
        homePage.clickOnSearchButton();
    }
}
