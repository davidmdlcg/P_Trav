Feature: Shoot many times
    As a player
    I want to be able to shoot many times until i run out of bullets
    So that i have limited tries.

    Background: game start
		Given I wait for the "AndroidLauncher" screen to appear
        Given the game has started
        
	Scenario: Shoot once
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
		
	Scenario: Shoot twice
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
	
	Scenario: Shoot three times
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
		
	Scenario: Shoot four times
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
		Then I click on screen 95% from the left and 95% from the top
		Then I wait
		Then I click on screen 95% from the left and 95% from the top
		Then I wait