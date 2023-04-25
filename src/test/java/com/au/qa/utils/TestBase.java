package com.au.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

	public WebDriver driver;

	private String getCurrentUser(){
		return System.getProperty("user.name");
	}
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("AppURL");
		String browser = properties.getProperty("Browser");
		if(driver == null)
		{

			switch(browser)
			{
				case "firefox":
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//firefox//geckodriver.exe");
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					firefoxOptions.addArguments("user-data-dir=C:\\Users\\" + getCurrentUser() + "\\AppData\\Local\\Mozilla\\Firefox\\Profiles");
					driver = new FirefoxDriver(firefoxOptions);
					break;
				case "edge":
					//TODO Yet to implement this logic
					break;
				default:
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("user-data-dir=C:\\Users\\" + getCurrentUser() + "\\AppData\\Local\\Google\\Chrome\\User Data");
					driver = new ChromeDriver(chromeOptions);// driver gets the life
					break;
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get(url);
		}
		
		return driver;
		
	}
}

