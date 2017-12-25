package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.amazon.base.page.BasePage;
import com.amazon.models.Product;

public class ProductPage extends BasePage {
	private final By PRODUCT_TITLE = By.id("productTitle");
	private final By ADD_CART = By.id("add-to-cart-button");
	private final By ADD_CART_UBB = By.id("add-to-cart-button-ubb");
	private final By QUANTITY = By.id("quantity");
	private final By NO_THANKS = By.id("siNoCoverage-announce");
	private final By ADD_LIST = By.id("add-to-wishlist-button-submit");

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public String getProductTitle() {
		System.out.println("Title which displayed: + " + getElementText(PRODUCT_TITLE));
		return getElementText(PRODUCT_TITLE);
	}

	public int selectNthQuantity(String n) {
		int count = 1;
		if (checkElementExist(QUANTITY)) {

			if (!selectValueFromDDL(QUANTITY, n)) {
				selectLastValueFromDDL(QUANTITY);
			}
			count = Integer.parseInt(getSelectedDDLValue(QUANTITY));
		}
		return count;
	}

	public double expectedPrice(Product product) {
		return product.getPrice() * Integer.parseInt(getElementText(QUANTITY));
	}

	public void clickAddCart() {
		if (!checkElementExist(ADD_LIST)) {
			try {
				clickElement(ADD_CART);
			} catch (NoSuchElementException e) {
				clickElement(ADD_CART_UBB);
			}
		} else {
			System.out.println("ERROR! Test will fail due to: This product is not for sale");
		}
	}

	public void doNotAcceptOptions() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(NO_THANKS);
	}
}
