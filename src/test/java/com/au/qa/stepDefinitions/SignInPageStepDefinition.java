package com.au.qa.stepDefinitions;

import com.au.qa.pageObjects.SignInPage;
import com.au.qa.utils.TestContextSetup;
import org.openqa.selenium.WebDriver;

public class SignInPageStepDefinition {
    public WebDriver driver;
    TestContextSetup testContextSetup;
    SignInPage signInPage;

    public SignInPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        this.signInPage = testContextSetup.pageObjectManager.getSignInPage();
    }

    /**
     *  Login not used as the application has additional validation to avoid logins through automation. Used browser cookies to access the application
     */
}
