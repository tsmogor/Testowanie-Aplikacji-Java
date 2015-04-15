Scenario: User searches for a single step
 
Given user is on Home page
When user opens Sport link
Then Sport page is shown

When user opens list channels and choose Fox channel
Then Fox page is shown

When user opens saturday's program list
Then showing a program on Saturday

When user search saturday's program at 8:05 pm
Then program at 8:05 pm is shown

When user searches Django
Then showing the search program
