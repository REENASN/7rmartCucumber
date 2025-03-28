Feature: SubCategory Page management

	Background: These are the common steps for every Scenario
		Given I am logged into the Admin login page
    And I navigated to the Sub Category page
    
  @sanity 
	Scenario: Successfully Add a new SubCategorys
		When I click on the New button in Sub Category Page
		And Selected the Category Field from dropdown as "Toys" and filled SubCategory Field as "Soft Toys5263" and chosen an Image
		And I clicked the Save Button in SubCategory Page
		Then I should see a confirmation message as "Sub Category created successfully" in SubCategory Page
		
	Scenario: Search for a SubCategory
		When I click on the Search Button in Sub Category Page
		And I Selected the Category Field from dropdown as as "Toys" and filled Subcategory Field and "Soft Toys"
		And I clicked the  Red Search Button in Sub Category Page
		Then I should see the searched Sub Category and its details in the search results
		
	Scenario: Delete A Subcategory
		When I click on the Blue Search Button in Sub Category Page
    And I Selected the Category Field from dropdown as as "Toys" and filled Subcategory Field as "Soft Toys5263" I wants to delete
    And I click on Red Search button in Sub Category Page then I can see the searched Category in the below table
    When I click on the delete icon then in the subCategory page then I should see a POP up alert for delete confirmation and I click on OK button
    Then I should see a delete confirmation message as 'User Deleted successfully'in the Subcategory page.