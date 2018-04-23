Feature: Site Search

Scenario:
	Given We navigate to youtube1
	When We search for the word agile
	Then The first result for the search will be displayed1

Scenario:
	Given We navigate to youtube2
	When We search for the word cucumber
	Then The first result for the search will be displayed2

Scenario:
	Given We navigate to agiletrailblazers
	When We search agile word
	Then The results for the agile search

Scenario:
	Given We navigate to agiletrailblazerss
	When We contact with administrator in contact us
	Then Will be display success message

Scenario:
	Given We navigate to youtube3
	When We search for the word software
	Then The first result for the search will be displayed3

Scenario:
	Given We navigate to Spring boot youtube page
	When Wait ten seconds, search and click
	Then The result have content a specified info