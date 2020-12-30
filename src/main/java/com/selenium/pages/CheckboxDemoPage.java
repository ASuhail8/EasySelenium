package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.generics.BaseTest;

public class CheckboxDemoPage extends BaseTest {

	public CheckboxDemoPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "isAgeSelected")
	private WebElement checkBox;

	@FindBy(id = "txtAge")
	private WebElement successMsg;

	public CheckboxDemoPage clickOnCheckbox() {
		checkBox.click();
		return new CheckboxDemoPage();
	}

	public CheckboxDemoPage verifySuccessMsg() {
		String success = successMsg.getText();
		Assert.assertEquals("Success - Check box is checked", success);
		return new CheckboxDemoPage();
	}
}
