package com.au.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {
    public WebDriver driver;

    By signInButton = By.xpath("//button[contains(text(),'Sign in')]");
    By signInLink = By.linkText("Sign in");
    By signInEmailAddress = By.id("loginFormEmailInput");
    By signInPassword = By.id("loginFormPasswordInput");
    By loginSubmitButton = By.id("loginFormSubmitButton");

    public SignInPage(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     *  Sign in login into the application, however, cannot run it as the application has the additional validations to avoid login through automated tests
     */
    public void signInToApplication(String userName, String password)
    {
        try
        {
            driver.findElement(signInButton).click();
            driver.findElement(signInLink).click();
            driver.findElement(signInEmailAddress).clear();
            driver.findElement(signInEmailAddress).sendKeys(userName);
            driver.findElement(signInPassword).clear();
            driver.findElement(signInPassword).sendKeys(password);
            driver.findElement(loginSubmitButton).click();
        } catch (Exception exception)
        {
            Assert.fail(exception.getMessage());
        }

    }
}
