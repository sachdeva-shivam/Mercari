package com.shiv.test.cucumber.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tier2CategoriesPage {

	private final WebDriver driver;

	@FindBy(xpath = "(//*[@ data-testid='category-list']//parent::main//div)[1]")
	private WebElement tier2CategoryText;

	@FindBy(xpath = "//*[@data-testid='category-list']//following-sibling::div[@role='listitem']")
	private List<WebElement> totalTier2Category;

	public Tier2CategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to select the tier2 category
	public void selectTier2Category(String category) {
		boolean isCategoryFound = false;
		for (WebElement searchTier2Category : totalTier2Category) {
	        if (searchTier2Category.getText().equals(category)) {
	            searchTier2Category.click();
	            isCategoryFound = true; // Set flag to true if category is found
	            break; // Stop iteration once found
	        }
	    }

	    // If no category was found, throw an exception after checking all elements
	    if (!isCategoryFound) {
	        throw new IllegalArgumentException("Unsupported category: " + category);
	    }
	}

	// Method to verify that the categories page is loaded
	public boolean isTier2CategoriesPageLoaded(String category) throws InterruptedException {
		Thread.sleep(2000);
		return tier2CategoryText.isDisplayed();
	}

}