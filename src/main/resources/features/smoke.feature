#Feature: Smoke
#
##  @smoke
##  Scenario Outline: Create application using Create strategy
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName      | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName |
##      | java8-maven-create   | Create           | Java         | java8           | Maven     | master     |
##      | java11-maven-create  | Create           | Java         | java11          | Maven     | master     |
##      | java8-gradle-create  | Create           | Java         | java8           | Gradle    | master     |
##      | java11-gradle-create | Create           | Java         | java11          | Gradle    | master     |
##      | dotnet-2-1-create    | Create           | DotNet       | dotnet-2.1      | dotnet    | master     |
##      | dotnet-3-1-create    | Create           | DotNet       | dotnet-3.1      | dotnet    | master     |
##      | python-3-8-create    | Create           | Python       | python-3.8      | Python    | master     |
##      | javascript-create    | Create           | JavaScript   | react           | NPM       | master     |
##      | go-beego             | Create           | Go           | beego           | Go        | master     |
##      | go-operator-sdk      | Create           | Go           | operator-sdk    | Go        | master     |
#
#  @smoke
#  Scenario Outline: Create library using Create strategy
#    Given User opens EDP Admin Console
#    When User clicks on Libraries tab
#    And User clicks 'Create' button
#    And User selects "<codebaseStrategy>" codebase integration strategy
#    And User clicks 'Proceed' button
#    Examples:
#      |  |