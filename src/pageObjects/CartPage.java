package pageObjects;

import pageObjects.HomePage;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(css ="div.brand.greenLogo")
	WebElement logo;
	@FindBy(css="p.product-name")
	List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void checkLogoText() {
		//System.out.println(logo.getText());
		Assert.assertEquals(logo.getText(), "GREENKART");
		

		}
	
	public void checkProductsInCart() {
		
		HomePage hp = new HomePage(driver);
		List<String> list = Arrays.asList(hp.vegetablesNeeded);
		int j= 0;
		for(int i = 0; i < cartProducts.size(); i++) 
		{
			//System.out.println(cartProducts.get(i).getText());
			String[] cartProds = cartProducts.get(i).getText().split("-");
			String formattedCartProds = cartProds[0].trim();
			
//			
		   if(list.contains(formattedCartProds))
			{
				System.out.println("They match");
			} else {
				System.out.println("They do not match");
			}
		    j++;
		   if(j == list.size()) {
			   break;
		   }
						
		}
		
	}
	
	public void checkTotalInCart() {
		// get price of items from table #productCartTables td:nth-child(4) p.amount
		
//		WebElement pricelabel = driver.findElement(By.cssSelector("p.amount"));
//		System.out.println(pricelabel.getText());
		int j=0;
		int total = 0;
	
		List<WebElement> prices = driver.findElements(By.cssSelector("td:nth-child(4) p.amount"));
		//prices.get(i).getText();
	    for(int i =0; i < prices.size(); i++)
	    {
	    	System.out.println(prices.get(i).getText());
	    	
	    	int price = Integer.parseInt(prices.get(i).getText());
	    	 total += price;
	    	j++;
	    	
	    	 if (j==3) {
	 	    	break;
	 	    }
	    }
	    System.out.println(total);
	    WebElement totalAmount = driver.findElement(By.className("totAmt"));
	    System.out.println(totalAmount.getText());
	    int tot = Integer.parseInt(totalAmount.getText());
	    
	    if(tot == total) {
	    	Assert.assertTrue(true);
	    	//System.out.println("the totals match");
	    } else  {
	    	Assert.assertTrue(false);

	    	//System.out.println("the totals do not match");

	    }
	}
	

}
