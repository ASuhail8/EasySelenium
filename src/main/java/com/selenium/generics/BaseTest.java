package com.selenium.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;

	public static String chromeKey = "webdriver.chrome.driver";
	public static String chromeValue = "./drivers/chromedriver.exe";

	// Base Test Constructor
	public BaseTest() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\Abdulla Suhail\\work\\SuhailWorkSpace\\src\\Work\\src\\main\\java\\com\\selenium\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	//Method to initialize driver using before method
	@BeforeMethod
	public static void initialization() {
		System.setProperty(chromeKey, chromeValue);
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Method to close the driver using After method
	@AfterMethod
	public static void tearDown() {
		driver.close();
	}

}
