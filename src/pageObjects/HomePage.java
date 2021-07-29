package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// driver constructor 
	WebDriver driver;
	@FindBy(css="h4.product-name")
	List<WebElement> allProducts ;
	@FindBy(css="div.product-action button")
	List<WebElement> addButton;
	@FindBy(css="a.cart-Icon")
	WebElement cartIcon;
	@FindBy(css="div.cart-preview.active button")
	WebElement proceedToCheckOutBtn;
	
	String[] vegetablesNeeded = {"Brocolli", "Beetroot", "Tomato"};

//	
	// constructor name must have class name and it cannot have a return type
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(css="h4.product-name")
//	List<WebElement> ;
//	
//	 By allProducts = By.cssSelector("h4.product-name");
//	 By addButton = By.cssSelector("div.product-action button");
//	 By cartIcon = By.cssSelector("a.cart-icon");
//	 By proceedToCheckOutBtn = By.cssSelector("div.cart-preview.active button");
//	
	public void addThreeVegetables() {
		
		int j =0;
		// List<WebElement> productList = driver.findElements(allProducts);
		
		
		
		for (int i =0; i< allProducts.size(); i++) {
			
			String[] productName = allProducts.get(i).getText().split("-");
			String formattedProductName = productName[0].trim();
			// System.out.println(formattedProductName);
			
		    // convert vegetablesNeeded array to arraylist to be able to use contains method
			List<String> listOfVeg = Arrays.asList(vegetablesNeeded); 
			
			if(listOfVeg.contains(formattedProductName)) 
			{
				(addButton).get(i).click();
			}
			
			if(j == vegetablesNeeded.length) {
				break;
			}
			
		}
		
		
		
	}
	
	public void clickOnCartIcon() {
		cartIcon.click();
	}
	
	public void proceedToBasket() {
		proceedToCheckOutBtn.click();
	}
	
	
	
}
