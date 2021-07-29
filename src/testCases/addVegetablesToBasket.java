package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.CartPage;

public class addVegetablesToBasket {
	@Test
	public void addVegetables() throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	HomePage greenKartHome = new HomePage(driver);
	CartPage gkCartPage = new CartPage(driver);
	greenKartHome.addThreeVegetables();
	greenKartHome.clickOnCartIcon();
	greenKartHome.proceedToBasket();
	
	gkCartPage.checkLogoText();
	Thread.sleep(3000);
	gkCartPage.checkProductsInCart();
	Thread.sleep(3000);
	gkCartPage.checkTotalInCart();
	
	
	
	}

}
