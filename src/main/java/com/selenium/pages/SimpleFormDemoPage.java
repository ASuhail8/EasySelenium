package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.generics.BaseTest;

public class SimpleFormDemoPage extends BaseTest {
	
	@FindBy(id="user-message")
	private WebElement enterMsg;
	
	@FindBy(xpath="//form[@id='get-input']//button")
	private WebElement showMsgButton;
	
	@FindBy(xpath="//div[@id='user-message']//span[@id='display']")
	private WebElement yourMsg;
	
	public SimpleFormDemoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SimpleFormDemoPage enterMessage(String msg) {
		enterMsg.sendKeys(msg);
		return new SimpleFormDemoPage();
	}
	
	public SimpleFormDemoPage clickShowMsgButton() {
		showMsgButton.click();
		return new SimpleFormDemoPage();
	}
	
	public SimpleFormDemoPage checkYourMsg(String msg) {
		String yourMessage = yourMsg.getText();
		Assert.assertEquals(yourMessage, msg);
		return new SimpleFormDemoPage();
	} 

}
