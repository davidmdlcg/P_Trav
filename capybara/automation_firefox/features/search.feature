Feature: Site Search
Scenario:
  Given We navigate to youtube
  When We search for the word agile
  Then The results for the search will be displayed

Scenario:
  Given We navigate to Youtube
  When We search the Auron Play channel
  Then The channel will be contained a video of Next program

Scenario:
  Given We navigate to agiletrailblazers
  When We search agile word
  Then The results for the agile search

Scenario:
  Given We navigate to agiletrailblazerss
  When We search calidad software words
  Then The results for the calidad software search

Scenario:
  Given We navigate to agiletrailblazersss
  When We contact with administrator in contact us
  Then Will be display success message