package com.amazon.base.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.amazon.base.utils.PropertyUtils;

public class BaseTest {

	public static WebDriver driver;
	public static String EMAIL;
	public static String PASSWORD;
	public static String URL;


	@BeforeSuite(alwaysRun = true)
	@Parameters("browser")
	public void initializeDrivers(@Optional("chrome") String browser) throws Exception {
	
			EMAIL = PropertyUtils.getInstance().readProperty("email");
			PASSWORD = PropertyUtils.getInstance().readProperty("password");
			URL = PropertyUtils.getInstance().readProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeDriverService service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(".\\drivers\\chromedriver.exe")).usingAnyFreePort().build();
			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities);
			options.addArguments("--disable-extensions");
			options.addArguments("-incognito");
			options.addArguments("--disable-popup-blocking");
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			driver = new ChromeDriver(service, options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			driver = new FirefoxDriver(firefoxOptions);
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Browser is not correct");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}



	@AfterSuite(alwaysRun = true)
	public void finalizeTests() {
		driver.close();
		driver.quit();
		driver = null;
		killChromeDriverProcess();
	}

	public void killChromeDriverProcess() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}