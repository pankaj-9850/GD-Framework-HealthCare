package com.QA.Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QA.Base.Baseclass;

public class Utils extends Baseclass{

	public void simpleclick(WebElement element) {
		element.click();
	}
	
	public void sendkeys(WebElement element,String value) {
	  element.sendKeys(value);
	}
	
	public void wait_singleele(WebElement element) {
		  
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	  wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void wait_multipleele(List <WebElement> element) {
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		  wait.until(ExpectedConditions.visibilityOfAllElements(element));
		}
	
	public void wait_eleTobeClickable(WebElement element) {
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		  wait.until(ExpectedConditions.elementToBeClickable(element));
		}
}
