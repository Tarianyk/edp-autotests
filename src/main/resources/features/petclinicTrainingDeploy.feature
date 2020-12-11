Feature: Smoke

#  @smoke
#  Scenario Outline: Get access into Admin Console
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User enters "<firstName>" first name
#    And User enters "<lastName>" last name
#    And User clicks 'Submit' button
#    Examples:
#      | username | password | firstName | lastName |
#      | username | password | firstName | lastName |

  @Smoke
  Scenario Outline: Add Petclinic BE application using Clone Strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User enters "<repository>" in git repository url field
    And User checks 'Codebase Authentication' check-box
    And User enters "<repositoryLogin>" for Gitlab in repository login field
    And User enters "<repositoryPassword>" for Gitlab in repository password field
    And User clicks 'Proceed' button
    And User enters "<applicationName>" in application name field
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User clicks 'Proceed' button
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User checks 'Need Route' checkbox
    And User enters "<routeName>" in route name field
    And User enters "<routePath>" in route path field
    And User clicks 'Proceed' button
    And User checks 'Need Database' checkbox
    And User selects "<databaseType>" database type
    And User selects "<databaseVersion>" database version
    And User enters "<databaseCapacity>" database capacity
    And User selects "<capacityUnit>" capacity unit
    And User selects "<persistentStorage>" persistent storage
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch

    Examples:
      | applicationName | codebaseStrategy | repository         | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | routeName | routePath | databaseType | databaseVersion | databaseCapacity | capacityUnit | persistentStorage |
      | petclinic-be    | Clone            | petclinicBe-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | default        | username | password | petclinic | /api      | PostgreSQL   | postgres:9.6    | 1                | Gi           | efs               |

  @Smoke
  Scenario Outline: Add Petclinic FE application using Clone Strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User enters "<repository>" in git repository url field
    And User checks 'Codebase Authentication' check-box
    And User enters "<repositoryLogin>" for Gitlab in repository login field
    And User enters "<repositoryPassword>" for Gitlab in repository password field
    And User clicks 'Proceed' button
    And User enters "<applicationName>" in application name field
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User clicks 'Proceed' button
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User checks 'Need Route' checkbox
    And User enters "<routeName>" in route name field
    And User enters "<routePath>" in route path field
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch

    Examples:
      | applicationName | codebaseStrategy | repository         | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | routeName | routePath |
      | petclinic-fe    | Clone            | petclinicFe-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | JavaScript   | react           | NPM       | master     | master            | default        | username | password | petclinic | /         |

  @Smoke
  Scenario Outline: Add Petclinic autotests using Clone Strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Autotests tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User enters "<repository>" in git repository url field
    And User checks 'Codebase Authentication' check-box
    And User enters "<repositoryLogin>" for Gitlab in repository login field
    And User enters "<repositoryPassword>" for Gitlab in repository password field
    And User clicks 'Proceed' button
    And User enters "<applicationName>" in application name field
    And User enters "<defaultBranchName>" default branch name
    And User enters "<autotestDescription>" autotest description
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User selects "<testReportFramework>" test report framework
    And User clicks 'Proceed' button
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    Examples:
      | applicationName     | codebaseStrategy | repository                 | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | autotestDescription | testReportFramework |
      | petclinic-autotests | Clone            | petclinic-autotests-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | default        | username | password | test                | allure              |

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
#      | username | password | codebaseJenkinsFolder | createReleaseJob            | buildJob                  |
#      | username | password | petclinic-be          | Create-release-petclinic-be | MASTER-Build-petclinic-be |
#      | username | password | petclinic-fe          | Create-release-petclinic-fe | MASTER-Build-petclinic-fe |

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
    And User selects "<applicationName1>" application by checkbox
    And User selects "<dockerStream1>" docker stream
    And User clicks 'Proceed' button
    And User clicks 'Add CD pipeline stage' button
    And User enters "<stageName>" cd pipeline stage name
    And User enters "<stageDescription>" description
    And User selects "<qualityGateType>" quality gate type
    And User enters "<stepName>" step name
    And User selects "<autotest>" autotest
    And User selects "<autotestsBranch>" autotests branch
    And User clicks 'Add' button
    And User clicks 'Add CD pipeline stage' button
    And User enters "<stageName1>" cd pipeline stage name
    And User enters "<stageDescription1>" description
    And User selects "<qualityGateType1>" quality gate type
    And User enters "<stepName1>" step name
    And User clicks 'Add' button
    And User clicks 'Proceed' button
#    And User clicks 'Services' section
    And User clicks 'Create' button

    Examples:
      | username | password | cdPipelineName | applicationName | dockerStream        | applicationName1 | dockerStream1       | stageName | stageDescription | qualityGateType | stepName | autotest            | autotestsBranch | stageName1 | stageDescription1 | qualityGateType1 | stepName1 |
      | username | password | petclinic      | petclinic-be    | petclinic-be-master | petclinic-fe     | petclinic-fe-master | sit       | petclinic        | autotests       | sit      | petclinic-autotests | master          | qa         | petclinic         | manual           | qa        |

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
#    And User clicks progress bar

    Examples:
      | username | password | codebaseJenkinsFolder | createReleaseJob            | buildJob                  |
      | username | password | petclinic-cd-pipeline | Create-release-petclinic-be | MASTER-Build-petclinic-be |
#  @smoke
#  Scenario Outline: Create application using Create strategy Full
#    Given User opens EDP Admin Console
#    When User clicks on Application tab
#    And User clicks 'Create' button
#    And User selects "<codebaseStrategy>" codebase integration strategy
#    And User clicks 'Proceed' button
#    And User enters "<applicationName>" in application name field
#    And User enters "<defaultBranchName>" default branch name
#    And User selects "<codeLanguage>" application code language
#    And User selects "<languageVersion>" language version
#    And User selects "<buildTool>" build tool
#    And User clicks 'Proceed' button
#    And User selects "<versioningType>" codebase versioning type
#    And User selects "<deploymentScript>" deployment script
#    And User checks 'Integrate with Jira' checkbox
#    And User selects "<jiraServer>" Jira Server
#    And User specify "<commitMessagePattern>" the pattern to validate commit message
#    And User specify "<jiraTicketPattern>" the  pattern to find a Jira ticket number in a commit message
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
#    And User clicks 'Create' button
#    And User enters "<newBranchName>" branch name
#    And User clicks 'Proceed' button
#    And User sees success status in Branches section for "<branchName>" branch
#    And User sees success status in Branches section for "<newBranchName>" branch
#    And User clicks on Continuous Delivery tab
##    And User clicks 'Create' button
#    And User clicks 'Create' button in CD pipeline tab
#    And User enters "<cdPipelineName>" cd pipeline name
#    And User clicks 'Proceed' button
#    And User select "<applicationName>" application by checkbox
#    And User selects "<dockerStream>" docker stream
#    And User clicks 'Proceed' button
#    And User clicks 'Add CD pipeline stage' button
#    And User enters "<stageName>" cd pipeline stage name
#    And User enters "<stageDescription>" description
#    And User selects "<qualityGateType>" quality gate type
#    And User enters "<stepName>" step name
##    And User selects "<autotest>" autotest
##    And User selects "<autotestsBranch>" autotests branch
#    And User clicks 'Add' button
#    And User clicks 'Proceed' button
#    And User clicks 'Services' section
#    And User clicks 'Create' button
#   And User deletes "<applicationName>" codebase by request



#    Examples:
#      | applicationName      | codebaseStrategy | codeLanguage | languageVersion | buildTool | versioningType | deploymentScript   | jiraServer | commitMessagePattern   | jiraTicketPattern | routeName | routePath | databaseType | databaseVersion | databaseCapacity | capacityUnit | persistentStorage | newBranchName | branchName | cdPipelineName          | stageName | stageDescription | qualityGateType | stepName | autotest    | autotestsBranch | defaultBranchName | dockerStream         |
#      | dk-java8-auto        | Create           | Java         | java8           | Maven     | default        | helm-chart         | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | java11-maven-create  | Create           | Java         | java11          | Maven     | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | java8-gradle-create  | Create           | Java         | java8           | Gradle    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | java11-gradle-create | Create           | Java         | java11          | Gradle    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | dotnet-2-1-create    | Create           | DotNet       | dotnet-2.1      | dotnet    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | dotnet-3-1-create    | Create           | DotNet       | dotnet-3.1      | dotnet    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | python-3-8-create    | Create           | Python       | python-3.8      | Python    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | javascript-create    | Create           | JavaScript   | react           | NPM       | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | go-beego             | Create           | Go           | beego           | Go        | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#      | go-operator-sdk      | Create           | Go           | operator-sdk    | Go        | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |

