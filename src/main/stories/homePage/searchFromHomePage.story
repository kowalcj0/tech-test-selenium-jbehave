Search Yell.com by profession and location

Meta:
@page home
@feature search

Narrative:

In order to show the business contact details
As a user
I want to search for an businesses in a given location

Scenario: Regular Search

Given I am on Yell.com
When I search for a <profession> in <location>
Then there are search results

Examples:
|profession     |   location    |
|plumber        |   Reading     |
|pianist        |   London      |