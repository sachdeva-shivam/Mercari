package com.shiv.test.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.jspecify.annotations.Nullable;
import org.junit.Assert;

public class ProductPage {

	private final WebDriver driver;
	private Select select;

	@FindBy(xpath = "(//*[@data-testid='facet-item-dropdown'])[1]//select")
	private WebElement searchCategory1;

	@FindBy(xpath = "(//*[@data-testid='facet-item-dropdown'])[2]//select")
	private WebElement searchCategory2;

	@FindBy(xpath = "//*[@aria-label='検索キーワードを入力']")
	private WebElement searchBar;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to check the category for dropdown on item page for filters
	public void verifySelectSearchCondition(String categoryType, String category) throws InterruptedException {
		WebElement selectedOption;
		String selectedText = null;
		Thread.sleep(4000);
		switch (categoryType.toLowerCase()) {
		case "categorytier1":
			select = new Select(searchCategory1);
			selectedOption = select.getFirstSelectedOption();
			selectedText = selectedOption.getText();
			break;
		case "categorytier2":
			select = new Select(searchCategory2);
			selectedOption = select.getFirstSelectedOption();
			selectedText = selectedOption.getText();
			break;
		}
		Assert.assertEquals(category, selectedText);
		System.out.println("Selected Category: " + selectedText);
	}

	// Method to check the category for checkbox on item page for filters
	public void verifyCheckboxSearchCondition(String category) {
		WebElement searchCategory3 = driver.findElement(By.xpath("//*[text()='" + category + "']/../../preceding-sibling::input"));
		String isChecked = searchCategory3.getDomAttribute("aria-checked");
		Assert.assertEquals("true", isChecked);
		System.out.println("Element " + category + " is selected : " + isChecked);
	}
	
	public void clickSearchBarProductPage() {
		searchBar.click();
	}
	
	public void searchForKeyword(String keyword) {
		searchBar.sendKeys(keyword,Keys.RETURN);
	}
}