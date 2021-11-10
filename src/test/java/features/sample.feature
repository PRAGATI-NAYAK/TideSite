Feature: Showing product results 

Scenario Outline: checking if product conatins AntiBacterial 

	Given start chrome browser 
	And navigates to the site "<url>"
	When enters "<name>" in search box and clicks on search 
	Then it should find any product name having "<name>" 
	
	Examples:
	|url	|name	|
	|https://tide.com/en-us/shop	|Antibacterial	|