package com.shiv.test.cucmber.guice.provider;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import javax.inject.Provider;
//import java.util.Optional;

import com.shiv.test.cucmber.testUtils.ConfigReader;

public class WebDriverProvider implements Provider<WebDriver> {

	ConfigReader cfr = new ConfigReader();
	
    @Override
    public WebDriver get() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        String browser = cfr.getProperty("browser");
//        		Optional.ofNullable(System.getProperty("browser")).orElse("");
        switch (browser.toLowerCase()) {
            case "ie":
            case "internet explorer":
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
            	WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "opera":
                options.setBinary("/path/to/your/opera/browser"); // Set path to Opera binary (if needed)
                driver = new ChromeDriver(options); // ChromeDriver works with Opera as well
                break;
            case "phantomjs":
            case "headless":
                options.addArguments("--headless"); // Headless mode
                options.addArguments("--disable-gpu"); // Disable GPU for headless mode
                driver = new ChromeDriver(options);
                break;
            case "edge":
            	WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;   
            case "remote":
                driver = new RemoteWebDriver(new DesiredCapabilities());
                break;
            default:
            	WebDriverManager.chromedriver().setup();
            	setChromeOptions(options);
                driver = new ChromeDriver(options);
        }
        return driver;
    }
    
    
    //Added just for chrome and for full mode only, but can add for different browser and other args
    private void setChromeOptions(ChromeOptions options) {
        // Fullscreen mode
            options.addArguments("--start-fullscreen");
    }
    
}

