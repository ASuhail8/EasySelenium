package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.generics.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(id = "site-name")
	private WebElement seleniumToggleLabel;

	@FindBy(id = "at-cv-lightbox-close")
	private WebElement closePopUp;

	@FindBy(xpath = "(//li[@class='dropdown']//a[@class='dropdown-toggle'])[1]")
	private WebElement inputFormsDropdown;

	private static final String dropdownMenus = "//li[@class='dropdown open']//ul[@class='dropdown-menu']//li//a[contains(text(),'%s')]";

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Check selenium toggle Label
	 * 
	 * @return HomePage
	 */
	public HomePage checkSeleniumToggle() {
		verifyElement(seleniumToggleLabel);
		return new HomePage();
	}

	/**
	 * CLick no thanks
	 * 
	 * @return HomePage
	 */
	public HomePage closePopUp() {
		closePopUp.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new HomePage();
	}

	
	public void getdropdownMenus(String menus) {
		String xpath = String.format(dropdownMenus, menus);
		driver.findElement(By.xpath(xpath)).click();
	}

	public void selectDropdownMenus(String ddm) {
		inputFormsDropdown.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getdropdownMenus(ddm);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
