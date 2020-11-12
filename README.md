## Setup environment
* JDK, maven, Intelij IDEA, allure

## Running Tests
* mvn clean test - run all suite on default browser (CHROME)
* mvn allure:serve - open html report in the browser
* mvn allure:report - create html report in allure/allure-report directory

## Tests cases
* Navigation tests:
1. Navigate to link - open the link and check the title is correct
2. Navigate to destination: type the destination im search field and check the 3 words sequences
3. Change the map tile and check the 3 words sequences is different
4. Return to previous tile and check 3 words matched the first search result
* Search tests (parametrized tests)
1. Type 3 words in search field and check possible options: 
    * number of possible options (3)
    * uniqueness of words sequences
    * uniqueness of addresses, connected with sequences
2. Type 3 words with grammar mistake and check unique suggestions


