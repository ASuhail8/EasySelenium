package com.selenium.tests;

import org.testng.annotations.Test;

import com.selenium.generics.BaseTest;
import com.selenium.pages.CheckboxDemoPage;
import com.selenium.pages.HomePage;
import com.selenium.pages.SimpleFormDemoPage;

public class homePageTest extends BaseTest {

	public homePageTest() {
		super();
	}

	HomePage homePage;
	SimpleFormDemoPage simpleFormPage;
	CheckboxDemoPage checkboxDemoPage;

	@Test
	public void checkHomePageToggle() {
		homePage = new HomePage();
		homePage = homePage.closePopUp();
		homePage.checkSeleniumToggle();
	}

	@Test
	public void enterMessage() {
		checkHomePageToggle();
		simpleFormPage = new SimpleFormDemoPage();
		homePage.selectDropdownMenus(prop.getProperty("simpleFormDemo"));
		simpleFormPage = simpleFormPage.enterMessage(prop.getProperty("msg"));
		simpleFormPage = simpleFormPage.clickShowMsgButton();
		simpleFormPage = simpleFormPage.checkYourMsg(prop.getProperty("msg"));
	}

	@Test
	public void checkBoxTest() {
		checkHomePageToggle();
		checkboxDemoPage = new CheckboxDemoPage();
		homePage.selectDropdownMenus(prop.getProperty("checkboxDemo"));
		checkboxDemoPage = checkboxDemoPage.clickOnCheckbox();
		checkboxDemoPage = checkboxDemoPage.verifySuccessMsg();
	}

}
