## Overview
Automated scripts for following scenarios:
```
Scenario #1
Feature: Unlogged customer is able to search for a job
Scenario: Search for a job matching given criteria
Given Customer is on "https://akamaicareers.inflightcloud.com/"
When Customer specifies “Find Your Career”: Senior Software Development Engineer in Test
And "Filter by country": Poland
Then Any job offers are found

Scenario #2
Feature: Customer is notified when no offers match given criteria
Scenario: Search for a job matching given criteria
Given Customer is on "https://akamaicareers.inflightcloud.com/"
When Customer specifies “Find Your Career”: XXX
Then Notification about no offers found is displayed: "We found 0 jobs based on your search criteria"
```

## Comments from author
##### Comment #1
Due to the test data Scenario #1 was failing so I decided to create Scenario #3:
```
Scenario #3
Feature: Unlogged customer is able to search for a job
Scenario: Search for a job matching given criteria
Given Customer is on "https://akamaicareers.inflightcloud.com/"
When Customer specifies “Find Your Career”: Senior Software Development Engineer in Test
And "Filter by country": United States
Then Any job offers are found
```
##### Comment #2
During implementing the test scripts I have noticed discrepancy between actual found job entries and number of the found entries in the result message. I have added the scenario to cover this test case.
```
Scenario #4
Feature: Unlogged customer is able to search for a job
Scenario: Search for a job matching given criteria and compare results count with the result message
Given Customer is on "https://akamaicareers.inflightcloud.com/"
When Customer specifies “Find Your Career”: Senior Software Development Engineer in Test
And "Filter by country": United States
Then Any job offers are found
And Jobs count of the message "We found 0 jobs based on your search criteria" matches the actual results count
```
