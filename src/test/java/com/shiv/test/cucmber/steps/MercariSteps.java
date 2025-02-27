package com.shiv.test.cucmber.steps;

import java.time.Duration;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shiv.test.cucumber.pages.MercariPage;
import com.shiv.test.cucumber.pages.ProductPage;
import com.shiv.test.cucumber.pages.Tier1CategoriesPage;
import com.shiv.test.cucumber.pages.Tier2CategoriesPage;
import com.shiv.test.cucumber.pages.Tier3CategoriesPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MercariSteps {

	private MercariPage mercariPage;
	private Tier1CategoriesPage tier1CategoriesPage;
	private Tier2CategoriesPage tier2CategoriesPage;
	private Tier3CategoriesPage tier3CategoriesPage;
	private ProductPage productPage;
	private static final Logger logger = LoggerFactory.getLogger(MercariSteps.class);

	@Inject
	public MercariSteps(final WebDriver driver) {
		this.mercariPage = new MercariPage(driver);
	}

	@Given("User navigate to Mercari top page")
	public void navigateToMercariTopPage() {
		mercariPage.navigateToMercariTopPage();
		logger.info("Navigated to Mercari top page");
	}

	@When("User click on the search bar")
	public void clickSearchBar() {
		mercariPage.clickSearchBar();
	}

	@When("User Select Main Category")
	public void mainCategory() {
		mercariPage.selectCategory();
	}

	@When("User select {string} as the tier 1 category")
	public void selectTier1Category(String category) throws InterruptedException {
		tier1CategoriesPage = new Tier1CategoriesPage(mercariPage.getDriver()); // Initialize CategoriesPage
		if (mercariPage.isCategoriesPageLoaded()) {
			tier1CategoriesPage.selectTier1Category(category);
			logger.info("Selected category: {}", category);
		} else {
			throw new RuntimeException("Categories page is not loaded.");
		}
	}

	@When("User select {string} as the tier 2 category") 
	public void selectTier2Category(String category) throws InterruptedException {
		tier2CategoriesPage = new Tier2CategoriesPage(mercariPage.getDriver());    		
		if (tier2CategoriesPage.isTier2CategoriesPageLoaded(category)) {
			tier2CategoriesPage.selectTier2Category(category);
			logger.info("Selected category: {}", category);
		} else {
			throw new RuntimeException("Sub Categories page is not loaded.");
		}
	}

	@When("User select {string} as the tier 3 category")
	public void selectTier3Category(String category) throws InterruptedException {
		tier3CategoriesPage = new Tier3CategoriesPage(mercariPage.getDriver()); // Initialize CategoriesPage
		if (tier3CategoriesPage.isTier3CategoriesPageLoaded(category)) {
			tier3CategoriesPage.selectTier3Category(category);
			logger.info("Selected category: {}", category);
		} else {
			throw new RuntimeException("Sub Categories page is not loaded.");
		}
	}

	@Then("Verify select box search condition {string} {string} should be set correctly")
	public void verifySearchDropDownConditionSetCorrectly(String categoryType, String categoryName) throws InterruptedException {
		productPage = new ProductPage(mercariPage.getDriver());
		productPage.verifySelectSearchCondition(categoryType, categoryName);
	}

	@Then("Verify check box search condition {string} should be set correctly")
	public void verifySearchCheckBoxConditionSetCorrectly(String categoryName) {
		productPage = new ProductPage(mercariPage.getDriver());
		productPage.verifyCheckboxSearchCondition(categoryName);
	}
	
	@Then("User verify browsing history count {int}")
	public void verifyBrowsingHistoryCount(int count) {
		mercariPage.verifyBrowsingHistoryCount(count);	
	}
	
    @When("User verify the latest browsing history is {string}")
    public void userVerifyLatestBrowsingHistory(String history) {
        mercariPage.verifyLatestBrowsingHistory(history);
    }
    
    @Then("User click the latest browsing history")
    public void userClickLatestBrowsingHistory() {
        mercariPage.clickLatestBrowsingHistory();
    }
    
    @When("User click on the search bar from Product Page")
	public void clickSearchBarProductPage() {
    	productPage = new ProductPage(mercariPage.getDriver());
    	productPage.clickSearchBarProductPage();
	}
    
    @When("User search for {string}")
    public void i_search_for(String keyword) {
    	productPage = new ProductPage(mercariPage.getDriver());
    	productPage.searchForKeyword(keyword);
    }

    @Then("User go back to the Mercari top page")
    public void i_go_back_to_the_mercari_top_page() {
        mercariPage.navigateToMercariTopPage();
    }
    
    @Then("User wait for {long} mseconds")
    public void userWait(long sec) throws InterruptedException {
    	Thread.sleep(sec);
    }
    
}