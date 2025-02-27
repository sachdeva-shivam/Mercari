@Mercari
Feature: Mercari Search Functionality

@Mercari002 @Regression
  Scenario: Search conditions are set correctly
    Given User navigate to Mercari top page
    When User click on the search bar
    Then User Select Main Category
    And User select "本・雑誌・漫画" as the tier 1 category
    And User select "本" as the tier 2 category
    And User select "コンピュータ・IT" as the tier 3 category
    Then Verify select box search condition "categorytier1" "本・雑誌・漫画" should be set correctly
    And Verify select box search condition "categorytier2" "本" should be set correctly
    And Verify check box search condition "コンピュータ・IT" should be set correctly

@Mercari002 @Regression
  Scenario: Search conditions are set correctly from the latest browsing history
    Given User navigate to Mercari top page
    When User click on the search bar
    Then User Select Main Category
    And User select "CD・DVD・ブルーレイ" as the tier 1 category
    And User select "DVD" as the tier 2 category
    And User select "TVドラマ" as the tier 3 category
    Then User wait for 2000 mseconds
    Then User click on the search bar from Product Page
    Then User Select Main Category
    And User select "本・雑誌・漫画" as the tier 1 category
    And User select "本" as the tier 2 category
    And User select "コンピュータ・IT" as the tier 3 category
    Then User wait for 2000 mseconds
    And User go back to the Mercari top page
    Then User click on the search bar
    Then User wait for 2000 mseconds    
    Then User verify browsing history count 2
    Then User verify the latest browsing history is "コンピュータ・IT"
    Then User click the latest browsing history
    Then Verify select box search condition "categorytier1" "本・雑誌・漫画" should be set correctly
    And Verify select box search condition "categorytier2" "本" should be set correctly
    And Verify check box search condition "コンピュータ・IT" should be set correctly
    Then User click on the search bar from Product Page
    When User search for "javascript"   
    And User go back to the Mercari top page
    Then User wait for 2000 mseconds
    Then User click on the search bar
    Then User verify browsing history count 3
    And User verify the latest browsing history is "javascript, コンピュータ・IT"
  
    