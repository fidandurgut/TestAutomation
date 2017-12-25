package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amazon.base.page.BasePage;
import com.amazon.models.Product;

public class CameraPhotoPage extends BasePage{
	
	private final By CAMERA_BEST_SELLERS = By.cssSelector("a[href='/gp/bestsellers/electronics/502394/ref=sv_camera_1']");
	private final By LEFT_MENU_DIGITAL_CAMERAS = By.cssSelector("a[href='https://www.amazon.com/Best-Sellers-Electronics-Digital-Cameras/zgbs/electronics/281052/ref=zg_bs_nav_e_2_502394']");
	private final By CAMERA_SELECTOR = By.cssSelector("#zg_centerListWrapper .zg_itemImmersion");
	
	public CameraPhotoPage(WebDriver driver) {
		super(driver);
	}

	public void clickToBestSellers() {
		System.out.println("Navigate to: BestSellers...");
		clickElement(CAMERA_BEST_SELLERS);
	}

	public void clickToDigitalCameras() {
		System.out.println("Navigate to: Dijital cameras...");
		clickElement(LEFT_MENU_DIGITAL_CAMERAS);
	}
	
	public void clickNthCamera(int n) {
		System.out.format("Click: %d'th camera\n...", n);
		clickToNthElement(CAMERA_SELECTOR, n);
	}
	
	public Product getNthCamerasDetails(int n) {
		System.out.format("Initialize: Details of %d'th camera\n", n);
		return getNthProductInfo(CAMERA_SELECTOR, n);
	}
}
