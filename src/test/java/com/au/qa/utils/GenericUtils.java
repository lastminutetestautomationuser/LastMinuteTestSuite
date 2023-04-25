package com.au.qa.utils;

import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public String SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
		return parentWindow;
	}

	public String convertTheDate(String dateToFormat)
	{
		DateFormat originalFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date originalDate;
		try {
			originalDate = originalFormat.parse(dateToFormat);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		DateFormat formatter1 = new SimpleDateFormat("d MMM yyyy");
		return formatter1.format(originalDate);
	}

	public void implicitWait(int timeInSeconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}
	
}
