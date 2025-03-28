Feature: Admin Panel management
	
	Background: These are the common steps for every Scenario
		Given I am logged into the Admin login page
    And I navigated to the Admin Users page
  
 	@sanity 
  Scenario: Successfully add a new user
    When I click on the New Button
    And Filled the following details username,password and select usertype
      | Field    | Value        |
      | Username | adminuser123 |
      | Password | Admin123!    |
      | UserType | Admin        |
    And I click on the save Button
    Then I should see a confirmation message "User created successfully"

  #Scenario Outline: Successfully add new users - Data driven testing
    #When I click on the New Button
    #And the Admin user enters "<Username>","<Password>" and "<UserType>"
    #And I click on the save Button
    #Then I should see a confirmation message "User created successfully"
#
    #Examples: 
      #| Username   | Password | UserType |
      #| Saira      | Saira123 | Admin    |
      #| JackThaims | jack345  | Staff    |
      #| AnnThomas  | ann1234  | Admin    |
      #
      
	Scenario: Successfully add a new user using random name and password
    When I click on the New Button
    And Filled the details username,password and select usertype 
    And I click on the save Button
    Then I should see a confirmation message "User created successfully"

	Scenario: Successfully add a new user using Faker class
    When I click on the New Button
    And Filled the details username,password using Faker class and select usertype 
    And I click on the save Button
    Then I should see a confirmation message "User created successfully"
    
    
  Scenario: Search for a valid admin user
    When I click on the Search button
    And I enter username as "adminuser123" and UserType as "Admin"
    And click on Red serach button
    Then I should see the searched users full data in the search results
    
	Scenario: Search for an INnvalid user
    When I click on the Search button
    And I enter username as "ASigv123" and UserType as "Admin"
    And click on Red serach button
    Then I should see the message as 'RESULT NOT FOUND'	

  Scenario: Admin changes User status
    When I click on the Search button
    And I enter username as "adminuser123" and UserType as "Admin"
    And click on Red serach button
    And click on Status badge
    Then I should see a status change confirmation message as 'User Status Changed Successfully'
    
  Scenario: Admin deletes an existing user
    When I click on the Search button
    And I enter username as "adminuser123" and UserType as "Admin"
    And click on Red serach button
    And click on the delete icon and I should see a POP up alert for delete confirmation and I click on OK button
    Then I should see a delete confirmation message "User Deleted successfully"
    
	Scenario: verify that Admin table is displayed or not
    Then I should see the users data table

	Scenario: verify that Admin able to logout from Admin users page and navigated back to LoginPage
    When I click on Admin Icon
    And I click on Logout
    Then the user should get logged out and Navigated back to Login Page