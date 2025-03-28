Feature: Category Page Management
	Background:These are the common steps for every Scenario
		Given I am logged into the Admin login page
    And I navigated to the Category page
    
  @sanity  
  Scenario: Successfully add a new category
    When I click on the New Button
    And Filled the fields category,select groups,chose Image,select radio buttons
    And I click on the Red save Button
    Then I should see a confirmation message as "Category created successfully"

	Scenario: Search a category
    When I click on the Blue Search Button  
    And Fill the Category Field with the Category you wants to search
    And I click on Red Search button
    Then I should see the searched Category in the table below 
    
	Scenario: add an Existing category
    When I click on the New Button
    And Filled the fields category,select groups,chose Image,select radio buttons
    And I click on the Red save Button
    Then I should see a message as 'Category already exists'
    
 Scenario: Search a category and Delete it
    When I click on the Blue Search Button  
    And Fill the Category Field with the Category you wants to search
    And I click on Red Search button
    Then I should see the searched Category in the table below 
    When I click on the delete icon then I should see a POP up alert for delete confirmation and I click on OK button
    Then I should see a delete confirmation message as 'Category Deleted successfully'