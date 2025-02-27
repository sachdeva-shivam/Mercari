package com.shiv.test.cucumber.pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercariPage {

	public final WebDriver driver;

	@FindBy(xpath = "//*[@placeholder='なにをお探しですか？']")
	private WebElement searchBar;

	@FindBy(xpath = "//*[text()='カテゴリーからさがす']")
	private WebElement selectCategory;

	@FindBy(xpath = "//div[text()='Books']")
	private WebElement tier2Category;

	@FindBy(xpath = "//div[text()='Computers & Technology']")
	private WebElement tier3Category;

	@FindBy(xpath = "//*[@data-location='search_result:navigation_top:logo']")
	private WebElement topPage;
	
	@FindBy(xpath = "//*[contains(@href,\"order=desc&sort=score\")]")
	private List<WebElement> totalBrowsingHistory;
	
	@FindBy(xpath = "(//*[contains(@href,\"order=desc&sort=score\")])[1]/p")
	private WebElement latestBrowsingHistory;
	
	public MercariPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	// Method to navigate to the Mercari top page
	public void navigateToMercariTopPage() {
		driver.get("https://jp.mercari.com/");
	}

	// click on search bar
	public void clickSearchBar() {
		searchBar.click();
	}

	// click main category
	public void selectCategory() {
		selectCategory.click();
	}

	// to check if main category page is loaded
	public boolean isCategoriesPageLoaded() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getCurrentUrl().contains("/categories");
	}

	// to navigate to top page by clicking mercari logo
	public void navigateToMercariTopPageClickingLogo() {
		topPage.click();
	}
	
	// to count the Search Browsing History
	public void verifyBrowsingHistoryCount(int count) {
		int size = totalBrowsingHistory.size();
		Assert.assertEquals("Total Count of Browsing History is: "+size, count, size);
	}
	
	// to verify latest browsing history
	public void verifyLatestBrowsingHistory(String history) {
		latestBrowsingHistory.getText().equals(history);
	}

	// to click latest browsing history
	public void clickLatestBrowsingHistory() {
		latestBrowsingHistory.click();
	}
}