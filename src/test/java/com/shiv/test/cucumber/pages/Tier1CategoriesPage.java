package com.shiv.test.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tier1CategoriesPage {

	private final WebDriver driver;

	@FindBy(xpath = "//*[@data-testid='category-list']//following-sibling::div[@role='listitem']")
	private List<WebElement> totalTier1Category;

	public Tier1CategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to select the tier1 category
	public void selectTier1Category(String category) {
		boolean isCategoryFound = false;
		for (WebElement searchTier1Category : totalTier1Category) {
	        if (searchTier1Category.getText().equals(category)) {
	            searchTier1Category.click();
	            isCategoryFound = true; // Set flag to true if category is found
	            break; // Stop iteration once found
	        }
	    }

	    // If no category was found, throw an exception after checking all elements
	    if (!isCategoryFound) {
	        throw new IllegalArgumentException("Unsupported category: " + category);
	    }
	}
}