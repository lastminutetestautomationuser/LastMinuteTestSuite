package com.au.qa.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	/**
	 *  Page Object Manager to instantiate all the Page Object classes
	 */
	public HomePage homePage;
	public SignInPage signInPage;

	public SearchPage searchPage;

	public CheckoutPage checkoutPage;
	public RoomSelectPage roomSelectPage;
	public FlightSelectPage flightSelectPage;
	public WebDriver driver;

	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	public HomePage getHomePage()
	{
	 homePage = new HomePage(driver);
	 return homePage;
	}

	public SignInPage getSignInPage()
	{
		signInPage = new SignInPage(driver);
		return signInPage;
	}

	public SearchPage getSearchPage()
	{
		searchPage = new SearchPage(driver);
		return searchPage;
	}

	public CheckoutPage getCheckoutPage()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

	public RoomSelectPage getRoomSelectPage()
	{
		roomSelectPage = new RoomSelectPage(driver);
		return roomSelectPage;
	}

	public FlightSelectPage getFlightSelectPage()
	{
		flightSelectPage = new FlightSelectPage(driver);
		return flightSelectPage;
	}


}
