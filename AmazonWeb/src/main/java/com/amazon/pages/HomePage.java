package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amazon.base.page.BasePage;

public class HomePage extends BasePage {

	
	private final By DDL_ACCOUNT = By.id("nav-link-accountList");
	private final By DDL_DEPARTMENT = By.id("nav-link-shopall");

	private final By BTN_CART = By.id("nav-cart-count");

	private final By ELECTRONICS_COMPUTERS_OFFICE = By.cssSelector("span[data-nav-panelkey='ElectronicsComputersPanel']");

	private final By CAMERAS_PHOTOS = By.cssSelector("a[href='/Camera-Photo-Film-Canon-Sony/b/ref=nav_shopall_p?ie=UTF8&node=502394']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void navigateToHomePage(String url) {
		navigateToURL(url);
	}

	public void clickAccount() {
		System.out.println("Navigate to: Account...");
		clickElement(DDL_ACCOUNT);
	}

	public void moveToDepartment() {
		System.out.println("Mouseover to: Department link...");
		moveToElement(DDL_DEPARTMENT);
	}

	public void moveToElectonics() {
		System.out.println("Mouseover to: 'Electronics, Computers & Office'...");
		moveToElement(ELECTRONICS_COMPUTERS_OFFICE);
	}

	public void moveAndClickToCameras() {
		System.out.println("Click at: 'Camera, Photo & Video...'");
		clickElement(CAMERAS_PHOTOS);
	}

	public void navigateToCart() {
		System.out.println("Navigate to: Cart...");
		clickElement(BTN_CART);

	}
}
