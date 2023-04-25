package com.au.qa.stepDefinitions;

import com.au.qa.pageObjects.SearchPage;
import com.au.qa.utils.TestContextSetup;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPageStepDefinition {

    public WebDriver driver;
    TestContextSetup testContextSetup;

    SearchPage searchPage;

    public SearchPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        this.searchPage = testContextSetup.pageObjectManager.getSearchPage();
    }

    /**
     *  Added the room filter conditions as per the scenario
     */

    @And("^User Added filters (.+) (.+) (.+)$")
    public void user_added_filters(String mealPlan, String amenity, String cancellationOption) throws Throwable {
        searchPage.searchPageSynchronization();
        searchPage.selectMealPlan(mealPlan);
        Assert.assertTrue(searchPage.isMealPlanSelected(mealPlan));
        Thread.sleep(1000);//TODO
        searchPage.selectCancellationOptions(cancellationOption);
        Assert.assertTrue(searchPage.isFullyRefundableSelected());
        Thread.sleep(1000);//TODO
        searchPage.selectAmenities(amenity);
        Assert.assertTrue(searchPage.isAmenitySelected(amenity));
        Thread.sleep(3000);//TODO
    }
}
