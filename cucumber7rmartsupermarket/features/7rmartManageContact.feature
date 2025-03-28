Feature: Manage Contact Us Page

	Scenario:Edit Contact Us information
		Given I am logged into the Admin login page
    And I navigated to the Contact Us page
		When I click on Edit Button
		And I Edit the phone number field and delivery time
		And I click on Update button
		Then I should see an alert as "Contact Updated Successfully"