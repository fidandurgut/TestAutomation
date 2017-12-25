package com.amazon.shopping.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.actions.ShoppingActions;
import com.amazon.base.test.BaseTest;
import com.amazon.models.Product;
import com.amazon.pages.CameraPhotoPage;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;

public class ShoppingTest extends BaseTest {
	CameraPhotoPage onCameraPhotoPage;
	ProductPage onProductPage;
	CartPage onCartPage;
	ShoppingActions onShoppingActions;
	HomePage onHomePage;

	@BeforeTest
	public void setUp() {
		System.out.println("Initialize browser...");
		onCameraPhotoPage = new CameraPhotoPage(driver);
		onProductPage = new ProductPage(driver);
		onCartPage = new CartPage(driver);
		onShoppingActions = new ShoppingActions(driver);
		onHomePage = new HomePage(driver);
		onShoppingActions.login(URL, EMAIL, PASSWORD);
	}

	@Test
	public void testAmazonEndToEnd() {
		System.out.println("Test BEGINING:..");
		onShoppingActions.navigateToPageBestSeller();
		Product product = onCameraPhotoPage.getNthCamerasDetails(5);
		onShoppingActions.navigateToProduct(5);
		Assert.assertEquals(product.getTitle(), onProductPage.getProductTitle());
		onShoppingActions.addCart(product, "8");
		onHomePage.navigateToCart();
		Assert.assertEquals(product.getTotalPrice(), onCartPage.getTotalCount(product.getTitle()));
		System.out.println("Test PASSED:..");
	}

	@AfterTest(alwaysRun = true)
	public void TearDown() {
		onShoppingActions.navigateToCartAndDeleteAll();
	}
}
