package com.amazon.actions;

import org.openqa.selenium.WebDriver;

import com.amazon.models.Product;
import com.amazon.pages.CameraPhotoPage;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductPage;

public class ShoppingActions {
	HomePage onHomePage;
	LoginPage onLoginPage;
	CameraPhotoPage onCameraPhotoPage;
	ProductPage onProductPage;
	CartPage onCartPage;

	public ShoppingActions(WebDriver driver) {
		onHomePage = new HomePage(driver);
		onLoginPage = new LoginPage(driver);
		onCameraPhotoPage = new CameraPhotoPage(driver);
		onProductPage = new ProductPage(driver);
		onCartPage = new CartPage(driver);
	}

	public void login(String url, String email, String password) {
		onHomePage.navigateToHomePage(url);
		onHomePage.clickAccount();
		onLoginPage.login(email, password);
		System.out.println("Login as: "+email+"/"+ "****");

	}

	public void navigateToPageBestSeller() {
		onHomePage.moveToDepartment();
		onHomePage.moveToElectonics();
		onHomePage.moveAndClickToCameras();
		onCameraPhotoPage.clickToBestSellers();
		onCameraPhotoPage.clickToDigitalCameras();

	}

	public void navigateToProduct(int n) {
		onCameraPhotoPage.clickNthCamera(n);
		onProductPage.getProductTitle();
	}

	public Product addCart(Product product, String n) {
		product.setQuantity(onProductPage.selectNthQuantity(n));
		onProductPage.clickAddCart();
		onProductPage.doNotAcceptOptions();
		return product;
	}

	public void navigateToCartAndDeleteAll() {
		onHomePage.navigateToCart();
		onCartPage.clearCart();
	}
}