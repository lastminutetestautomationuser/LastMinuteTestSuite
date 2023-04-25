package com.au.qa.stepDefinitions;

import com.au.qa.pageObjects.CheckoutPage;
import com.au.qa.pageObjects.SearchPage;
import com.au.qa.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class CheckoutPageStepDefinition {

    public WebDriver driver;
    TestContextSetup testContextSetup;

    CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to Checkout with Passenger details (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void user_proceeds_to_checkout_with_passenger_details(String p1Title, String p1Mobile, String p1Gender, String p1DOB, String p2Title, String p2FirstName, String p2LastName, String p2Gender, String p2DOB) {
        checkoutPage.selectFirstPassengerTitle(p1Title);
        checkoutPage.enterPhoneNumber(p1Mobile);
        checkoutPage.selectFirstPassengerGender(p1Gender);
        checkoutPage.selectFirstPassengerDOB(p1DOB);
        checkoutPage.addNewTraveller();
        checkoutPage.selectSecondPassengerTitle(p2Title);
        checkoutPage.enterSecondPassengerName(p2FirstName, p2LastName);
        checkoutPage.selectSecondPassengerGender(p2Gender);
        checkoutPage.selectSecondPassengerDOB(p2DOB);
    }

    @And("^Payment details (.+) (.+) (.+)$")
    public void payment_details(String cardNumber, String expiry, String cvc) {
        checkoutPage.enterCreditCardDetails(cardNumber, expiry, cvc);
    }

    @And("^Billing Address details (.+) (.+) (.+) (.+) and complete booking$")
    public void billing_address_details_and_complete_booking(String address1, String city, String postCode, String state) throws InterruptedException {
        checkoutPage.enterBillingAddress(address1, city, postCode, state);
        checkoutPage.completeBooking();
        checkoutPage.validateFinalOutcome();
    }
}
