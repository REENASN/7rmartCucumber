Feature: User Login
	@Smoke
  Scenario: Successful Login
    Given the user is on the 7rmartsupermarket login page
    When the user enters username as "admin" and password as "admin"
    And the user clicks on the Login button
    Then the user should be redirected to the Admin page
    
	Scenario: UnSuccessful Login
    Given the user is on the 7rmartsupermarket login page
    When the user enters invalid username as "abc123" and password as "abc456"
    And the user clicks on the Login button
    Then the user should not be redirected to the Admin page
    And Invalid Username/Password Alert should be displayed
    
  Scenario: verify LoginPage Loads correctly
    Given the user is on the 7rmartsupermarket login page
    Then the user can verify the loginpage is loaded correctly
    
  Scenario: After Successful Login verify ProfileName In Dashboard
    Given the user is on the 7rmartsupermarket login page
    When the user enters username as "admin" and password as "admin"
    And the user clicks on the Login button
    Then the user should be redirected to the Admin page
    And Admin user can verify the profile Name