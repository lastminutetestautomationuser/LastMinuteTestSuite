package com.au.qa.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    final String MALE_GENDER_VALUE = "Male";
    final String FEMALE_GENDER_VALUE = "Female";
    final String HYPHEN_VALUE = String.valueOf('-');
    final String ADD_NEW_TRAVELLER = "Add a new traveller";
    final String EXPECTED_ERROR = "Sorry, there's an issue with the payment information below.";
    By firstPassengerTitleSelect = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[0].titleIdAndName']");
    By phoneNumber = By.name("tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[0].phoneNumber");

    By firstPassengerMaleRadioButton = By.xpath("//input[@id='maleRadio0']");
    By firstPassengerFemaleRadioButton = By.xpath("//input[@id='femaleRadio0']");
    By firstPassengerDayOfDOB = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[0].dateOfBirth.day']");
    By firstPassengerMonthOfDOB = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[0].dateOfBirth.month']");
    By firstPassengerYearOfDOB = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[0].dateOfBirth.year']");
    By AddNewSecondPassengerSelect = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[1].travelerName']");
    By secondPassengerFirstName = By.xpath("//input[@id='firstname[1]']");
    By secondPassengerLastName = By.xpath("//input[@id='lastname[1]']");
    By secondPassengerMaleRadioButton = By.xpath("//input[@id='maleRadio1']");
    By secondPassengerFemaleRadioButton = By.xpath("//input[@id='femaleRadio1']");
    By secondPassengerTitleSelect = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[1].titleIdAndName']");
    By secondPassengerDayOfDOB = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[1].dateOfBirth.day']");
    By secondPassengerMonthOfDOB = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[1].dateOfBirth.month']");
    By secondPassengerYearOfDOB = By.xpath("//select[@name='tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[1].dateOfBirth.year']");
    By creditCardNumberInput = By.id("creditCardInput");
    By creditCardSecurityCodeInput = By.id("new_cc_security_code");
    By creditCardExpiryMonthSelect = By.name("expiration_month");
    By creditCardExpiryYearSelect = By.name("expiration_year");

    By streetInput = By.xpath("//input[@name='street']");
    By cityInput = By.xpath("//input[@data-tealeaf-name='city']");
    By postCodeInput = By.xpath("//input[@data-tealeaf-name='zipcode']");
    By stateInput = By.xpath("//input[@data-tealeaf-name='state']");
    By errorAlertMessage = By.xpath("//div[@class='alert-message no-outline']");

    By completeBookingButton = By.id("complete-booking");
    private void selectDropDownByVisibleText(WebElement element, String visibleText) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    private void selectDropDownByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void selectFirstPassengerTitle(String title) {
        try {
            selectDropDownByVisibleText(driver.findElement(firstPassengerTitleSelect), title);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void enterPhoneNumber(String mobileNumber) {
        try {
            driver.findElement(phoneNumber).sendKeys(mobileNumber);
        }
        catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void selectSecondPassengerTitle(String title) {
        try {
            selectDropDownByVisibleText(driver.findElement(secondPassengerTitleSelect), title);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void selectFirstPassengerGender(String gender) {
        try {
            if (gender.equalsIgnoreCase(MALE_GENDER_VALUE)) {
                driver.findElement(firstPassengerMaleRadioButton).click();
            } else if (gender.equalsIgnoreCase(FEMALE_GENDER_VALUE)) {
                driver.findElement(firstPassengerFemaleRadioButton).click();
            }
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }

    }

    public void selectFirstPassengerDOB(String dateOfBirth)
    {
        try {
            String[] dateOfBirthSplit = dateOfBirth.split(HYPHEN_VALUE);
            selectDropDownByVisibleText(driver.findElement(firstPassengerDayOfDOB), dateOfBirthSplit[0]);
            selectDropDownByValue(driver.findElement(firstPassengerMonthOfDOB), dateOfBirthSplit[1]);
            selectDropDownByVisibleText(driver.findElement(firstPassengerYearOfDOB), dateOfBirthSplit[2]);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void addNewTraveller()
    {
        try {
            selectDropDownByVisibleText(driver.findElement(AddNewSecondPassengerSelect), ADD_NEW_TRAVELLER);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void enterSecondPassengerName(String firstName, String lastName)
    {
        try {
            driver.findElement(secondPassengerFirstName).sendKeys(firstName);
            driver.findElement(secondPassengerLastName).sendKeys(lastName);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void selectSecondPassengerGender(String gender) {
        try {
            if (gender.equalsIgnoreCase(MALE_GENDER_VALUE)) {
                driver.findElement(secondPassengerMaleRadioButton).click();
            } else if (gender.equalsIgnoreCase(FEMALE_GENDER_VALUE)) {
                driver.findElement(secondPassengerFemaleRadioButton).click();
            }
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void selectSecondPassengerDOB(String dateOfBirth)
    {
        try {
            String[] dateOfBirthSplit = dateOfBirth.split(HYPHEN_VALUE);
            selectDropDownByVisibleText(driver.findElement(secondPassengerDayOfDOB), dateOfBirthSplit[0]);
            selectDropDownByValue(driver.findElement(secondPassengerMonthOfDOB), dateOfBirthSplit[1]);
            selectDropDownByVisibleText(driver.findElement(secondPassengerYearOfDOB), dateOfBirthSplit[2]);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void enterCreditCardDetails(String cardNumber, String expiry, String securityCode)
    {
        try {
            driver.findElement(creditCardNumberInput).sendKeys(cardNumber);
            String[] cardExpirySplit = expiry.split(HYPHEN_VALUE);
            selectDropDownByValue(driver.findElement(creditCardExpiryMonthSelect), cardExpirySplit[0]);
            selectDropDownByVisibleText(driver.findElement(creditCardExpiryYearSelect), cardExpirySplit[1]);
            driver.findElement(creditCardSecurityCodeInput).sendKeys(securityCode);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void enterBillingAddress(String streetValue, String cityValue, String postCodeValue, String stateValue)
    {
        try {
            driver.findElement(streetInput).sendKeys(streetValue);
            driver.findElement(cityInput).sendKeys(cityValue);
            driver.findElement(postCodeInput).sendKeys(postCodeValue);
            driver.findElement(stateInput).sendKeys(stateValue);
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }



    public void completeBooking() {
        try {
            WebElement element = driver.findElement(completeBookingButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }

    public void validateFinalOutcome()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorAlertMessage));
            Assert.assertTrue(driver.findElement(errorAlertMessage).getText().contains(EXPECTED_ERROR));
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }
}
