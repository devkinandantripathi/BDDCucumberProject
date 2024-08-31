Feature: Create An Account

	@Sanity 
  Scenario: Create new Account
    Given User Launch browser
    #When User opens URL "https://magento.softwaretestingboard.com"
    And User Click on createAccount link
    And User enter firstname as "admin" and lastName as "admin"
    Then User Enter EmailId as "admin223@gmail.com" and password "admin@12345"
    And User Enter Confirm Password as "admin@123456"
    And User Click on create Account button
    #And User close the browser
