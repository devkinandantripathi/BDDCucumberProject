Feature: Login Feature

  Background: Steps common for all scenarios
    Given User Launch chrome browser
    When User opens URL "https://magento.softwaretestingboard.com"
    And User Click on SignIn link
	
	@Sanity @Regression
  Scenario: Validate Successful Login With Valid Credentials
    Then User Enter EmailId as "admin223@gmail.com" and password is "admin@12345"
    And User Click on SignIn button
    #Then Page title should be ""
    #When User click on SignOut link
    #Then User page title should be ""
    #And User close the browser

	@Regression
  Scenario: Validate Successful Login With Valid Credentials Using Data Driven
    Then User Enter EmailId as "<email>" and password is "<password>"
    And User Click on SignIn button
    #Then Page title should be ""
    #When User click on SignOut link
    #Then User page title should be ""
    #And User close the browser

    Examples: 
      | email              | password    |
      | admin223@gmail.com | admin@12345 |
      | admin1@gmail.com   | admin@12345 |
