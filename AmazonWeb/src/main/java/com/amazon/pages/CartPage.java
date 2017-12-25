package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.base.page.BasePage;

public class CartPage extends BasePage {
	private final By PRICE_TEXT = By.cssSelector(".a-color-price.hlb-price");
	private final By DELETE_ADDED_PRODUCT = By.cssSelector("input[value='Delete']");
	
	private final By ITEM_GRID = By.cssSelector(".sc-list-body.sc-java-remote-feature");

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public double totolPrice(){
	String text=getElementText(PRICE_TEXT);
	return	 Double.parseDouble(text.substring(1));
	}
	
	public void clearCart(){
		int count= elementCount(DELETE_ADDED_PRODUCT);
		for(int i=0;i<count;i++){
			clickElement(DELETE_ADDED_PRODUCT);
			
		}
	}
		public double getPriceFromCart(String title){
			WaitUntilElementIsPresent(ITEM_GRID);
			List<WebElement> elements=driver.findElement(ITEM_GRID).findElements(By.cssSelector(".a-row.a-spacing-base.a-spacing-top-base"));
			double price=0;
			for(WebElement e:elements){
				

				if(e.getText().contains(title)){
				;

					String value=getElementText(By.cssSelector(".a-spacing-small"));
					price = Double.parseDouble(value.substring(1));
					break;
					}
				
			}
			System.out.println("price: "+price);
			return price;
			
			}	
		
		
public int getCountFromCart(String title){
	WaitUntilElementIsPresent(ITEM_GRID);
	List<WebElement> elements=driver.findElement(ITEM_GRID).findElements(By.cssSelector(".a-row.a-spacing-base.a-spacing-top-base"));
	int quantity=0;
	for(WebElement e:elements){
		
		if(e.getText().contains(title)){
		

			String value=getElementText(By.cssSelector(".a-dropdown-prompt"));
			quantity = Integer.parseInt((value));
			break;
			}
		
	}
	System.out.println("quantity: "+quantity);
	return quantity;
	
	}	

public double getTotalCount(String title){
	return  getPriceFromCart(title)*getCountFromCart(title);
}
}
