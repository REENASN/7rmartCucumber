Feature: After successful login,Verify the hompage and its functions are working

  Scenario: After successful login Verify HomePage Loads correctly by using PageTitle Verification
    Given the user is navigated to the Home page
    Then the Admin user can verify the HomePage Title
    
  @sanity  
	Scenario: Verify that admin is able to navigate to Admin Users page from HomePage
    Given the user is navigated to the Home page
    When the user click on the moreinfo in the Admin Users Tile 
    Then the user should be redirected to the Admin Users Page
    
    