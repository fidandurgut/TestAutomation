package com.amazon.base.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.models.Product;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		}

	public void waitUntilElementToBeClickable(By selector) {
		wait.until(ExpectedConditions.elementToBeClickable(selector));
	}

	public void clickElement(By selector) {
		WebElement element = getElement(selector);
		waitUntilElementToBeClickable(selector);
		element.click();
		}

	public WebElement getElement(By selector) {
		return driver.findElement(selector);
		}

	public void clearInputBox(WebElement element) {
		element.clear();
		}

	public void sendKeys(By selector, String text) {
		WebElement element = getElement(selector);
		clearInputBox(element);
		element.sendKeys(text);
		}

	public void navigateToURL(String url) {
		driver.navigate().to(url);
		}

	public void moveAndClickElement(By selector) {
		WebElement element = driver.findElement(selector);
		actions = new Actions(driver);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			actions.moveToElement(element).perform();
			actions.click(element).perform();
			}
		catch (Exception e) {
			e.printStackTrace();
			}
		}

	public void moveToElement(By selector) {
		WebElement element = driver.findElement(selector);
		actions = new Actions(driver);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			actions.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
			}
		}

	public void clickToNthElement(By selector, int n) {
		try {
			WebElement element = driver.findElements(selector).get(n - 1);
			waitUntilElementToBeClickable(selector);
			element.click();
		} catch (Exception e) {
			System.out.format("There is %d 'th element\n", n);
		}
		}

	public Product getNthProductInfo(By selector, int n) {
		WebElement element = driver.findElements(selector).get(n-1);
		WebElement productTitle = element.findElement(By.cssSelector(".p13n-sc-truncated-hyphen.p13n-sc-truncated"));
		String title = productTitle.getAttribute("title");
		System.out.println("Getting the title of the entity= + " + title);
		WebElement productPrice = element.findElement(By.className("p13n-sc-price"));
		String text = productPrice.getText();
		double price = Double.parseDouble(text.substring(1));
		System.out.println("Getting the price of the entity= + " + price);
		return new Product(price, title);
		}

	public String getElementText(By selector) {
		WaitUntilElementIsPresent(selector);
		try {
			return driver.findElement(selector).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}

	public void WaitUntilElementIsPresent(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public boolean selectValueFromDDL(By selector, String n) {
		waitUntilElementToBeClickable(selector);
		Select dropdown = new Select(getElement(selector));
		List<WebElement> options = dropdown.getOptions();
		String optionText = "";

		for (WebElement option : options) {
			optionText = option.getText().trim();
			
			if (optionText.equals(n)) {
				try {
					dropdown.selectByVisibleText(optionText);
					return true;
					} catch (Exception e) {
					System.out.format("There is %d 'th element\n", n);
					}
				}
			}
		return false;
		}

	public void selectLastValueFromDDL(By selector) {
		waitUntilElementToBeClickable(selector);
		Select dropdown = new Select(getElement(selector));
		List<WebElement> options = dropdown.getOptions();

		String optionText = options.get(options.size() - 1).getText().trim();
		dropdown.selectByVisibleText(optionText);
		}

	public String getSelectedDDLValue(By selector) {
		waitUntilElementToBeClickable(selector);
		Select dropdown = new Select(getElement(selector));
		return dropdown.getFirstSelectedOption().getText().trim();
		}

	public boolean checkElementExist(By selector) {
		return driver.findElements(selector).size() > 0;
		}

	public int elementCount(By selector) {
		return driver.findElements(selector).size();
		}
}
