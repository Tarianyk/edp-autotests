Feature: Petclinic deploy

#  @Smoke
#  Scenario Outline: Add Petclinic BE application using Clone Strategy
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User clicks on Application tab
#    And User clicks 'Create' button
#    And User selects "<codebaseStrategy>" codebase integration strategy
#    And User enters "<repository>" in git repository url field
##    And User checks 'Codebase Authentication' check-box
##    And User enters "<repositoryLogin>" for Gitlab in repository login field
##    And User enters "<repositoryPassword>" for Gitlab in repository password field
#    And User clicks 'Proceed' button
#    And User enters "<applicationName>" in application name field
#    And User enters "<defaultBranchName>" default branch name
#    And User selects "<codeLanguage>" application code language
#    And User selects "<languageVersion>" language version
#    And User selects "<buildTool>" build tool
#    And User clicks 'Proceed' button
#    And User selects "<versioningType>" codebase versioning type
#    And User clicks 'Proceed' button
#    And User checks 'Need Route' checkbox
#    And User enters "<routeName>" in route name field
#    And User enters "<routePath>" in route path field
#    And User clicks 'Proceed' button
#    And User checks 'Need Database' checkbox
#    And User selects "<databaseType>" database type
#    And User selects "<databaseVersion>" database version
#    And User enters "<databaseCapacity>" database capacity
#    And User selects "<capacityUnit>" capacity unit
#    And User selects "<persistentStorage>" persistent storage
#    And User clicks 'Create' button
#    And User clicks 'Continue' button in confirmation popup
#    Then User sees success status for "<applicationName>" application name
#    And User clicks "<applicationName>" application name
#    And User sees success status in Branches section for "<branchName>" branch
#
#    Examples:
#      | applicationName | codebaseStrategy | repository       | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | routeName | routePath | databaseType | databaseVersion | databaseCapacity | capacityUnit | persistentStorage |
#      | petclinic       | Clone            | petclinic-deploy | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | default        | username | password | petclinic | /         | PostgreSQL   | postgres:9.6    | 1                | Gi           | efs               |
#
#  @Smoke
#  Scenario Outline: Check pipelines in Jenkins
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User clicks 'Jenkins' link
#    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
#    And User sees success status for "<createReleaseJob>" create release job
#    And User sees success status for "<buildJob>" build job
#    Examples:
#      | username | password | codebaseJenkinsFolder | createReleaseJob         | buildJob               |
#      | username | password | petclinic             | Create-release-petclinic | MASTER-Build-petclinic |
#
  @Smoke
  Scenario Outline: Add CD pipeline for petclinic application
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Continuous Delivery tab
    And User clicks 'Create' button in CD pipeline tab
    And User enters "<cdPipelineName>" cd pipeline name
    And User clicks 'Proceed' button
    And User selects "<applicationName>" application by checkbox
    And User selects "<dockerStream>" docker stream
    And User clicks 'Proceed' button
    And User clicks 'Add CD pipeline stage' button
    And User enters "<stageName>" cd pipeline stage name
    And User enters "<stageDescription>" description
    And User selects "<qualityGateType>" quality gate type
    And User enters "<stepName>" step name
#    And User clicks 'Add' button
#    And User clicks 'Add CD pipeline stage' button
#    And User enters "<stageName1>" cd pipeline stage name
#    And User enters "<stageDescription1>" description
#    And User selects "<qualityGateType1>" quality gate type
#    And User enters "<stepName1>" step name
    And User clicks 'Add' button
    And User clicks 'Proceed' button
#    And User clicks 'Services' section
    And User clicks 'Create' button

    Examples:
      | username | password | cdPipelineName | applicationName | dockerStream     | stageName | stageDescription | qualityGateType | stepName | stageName1 | stageDescription1 | qualityGateType1 | stepName1 |
      | username | password | petclinic-pipe | petclinic       | petclinic-master | sit       | petclinic sit    | manual          | sit      | qa         | petclinic qa      | manual           | qa        |


  @Smoke
  Scenario Outline: Deploy sit for petclinic
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User clicks 'sit' job
    And User clicks 'Build with Parameters' button
    And User clicks 'Build' button
    And User opens 'job info' page
    And User clicks progress bar
    And User clicks 'Input requeted' button
    And User selects "<applicationVersion>" application version for deploy
    Then User clicks 'Proceed' button in version info popup

    Examples:
      | username | password | codebaseJenkinsFolder      | applicationVersion            | buildJob                  |
      | username | password | petclinic-pipe-cd-pipeline | master-2.4.0.build-shapshot-1 | MASTER-Build-petclinic-be |


