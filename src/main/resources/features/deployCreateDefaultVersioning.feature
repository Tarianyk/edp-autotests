Feature: Deploy Applications added with default versioning type

  @DeployCreateDefVers
  Scenario Outline: Create application using Create strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User clicks 'Proceed' button
    And User enters "<applicationName>" in application name field
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User clicks 'Proceed' button
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
#    And User sends request to get ac-creator secret
#    And User sends request to get admin-console-client secret
#    And User sends request to get token
#    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName                 | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password |
      | java8-maven-create-def-vers     | Create           | Java         | java8           | Maven     | master     | master            | default        | username | password |
      | java11-maven-create-def-vers    | Create           | Java         | java11          | Maven     | master     | master            | default        | username | password |
      | java8-gradle-create-def-vers    | Create           | Java         | java8           | Gradle    | master     | master            | default        | username | password |
      | java11-gradle-create-def-vers   | Create           | Java         | java11          | Gradle    | master     | master            | default        | username | password |
      | dotnet-2-1-create-def-vers      | Create           | DotNet       | dotnet-2.1      | dotnet    | master     | master            | default        | username | password |
      | dotnet-3-1-create-def-vers      | Create           | DotNet       | dotnet-3.1      | dotnet    | master     | master            | default        | username | password |
      | python-3-8-create-def-vers      | Create           | Python       | python-3.8      | Python    | master     | master            | default        | username | password |
      | javascript-create-def-vers      | Create           | JavaScript   | react           | NPM       | master     | master            | default        | username | password |
      | go-beego-create-def-vers        | Create           | Go           | beego           | Go        | master     | master            | default        | username | password |
      | go-operator-sdk-create-def-vers | Create           | Go           | operator-sdk    | Go        | master     | master            | default        | username | password |

  @DeployCreateDefVers
  Scenario Outline: Check pipelines in Jenkins for added Applications using Create strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder           | createReleaseJob                               | buildJob                                     |
      | username | password | java8-maven-create-def-vers     | Create-release-java8-maven-create-def-vers     | MASTER-Build-java8-maven-create-def-vers     |
      | username | password | java11-maven-create-def-vers    | Create-release-java11-maven-create-def-vers    | MASTER-Build-java11-maven-create-def-vers    |
      | username | password | java8-gradle-create-def-vers    | Create-release-java8-gradle-create-def-vers    | MASTER-Build-java8-gradle-create-def-vers    |
      | username | password | java11-gradle-create-def-vers   | Create-release-java11-gradle-create-def-vers   | MASTER-Build-java11-gradle-create-def-vers   |
      | username | password | dotnet-2-1-create-def-vers      | Create-release-dotnet-2-1-create-def-vers      | MASTER-Build-dotnet-2-1-create-def-vers      |
      | username | password | dotnet-3-1-create-def-vers      | Create-release-dotnet-3-1-create-def-vers      | MASTER-Build-dotnet-3-1-create-def-vers      |
      | username | password | python-3-8-create-def-vers      | Create-release-python-3-8-create-def-vers      | MASTER-Build-python-3-8-create-def-vers      |
      | username | password | javascript-create-def-vers      | Create-release-javascript-create-def-vers      | MASTER-Build-javascript-create-def-vers      |
      | username | password | go-beego-create-def-vers        | Create-release-go-beego-create-def-vers        | MASTER-Build-go-beego-create-def-vers        |
      | username | password | go-operator-sdk-create-def-vers | Create-release-go-operator-sdk-create-def-vers | MASTER-Build-go-operator-sdk-create-def-vers |

  @DeployCreateDefVers
  Scenario Outline: Add CD pipeline for added applications using Create strategy
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
    Then User sees success status for "<cdPipelineName>" cd pipeline name

    Examples:
      | username | password | cdPipelineName                       | applicationName                 | dockerStream                           | stageName | stageDescription | qualityGateType | stepName | stageName1 | stageDescription1 | qualityGateType1 | stepName1 |
      | username | password | java8-maven-create-def-vers-pipe     | java8-maven-create-def-vers     | java8-maven-create-def-vers-master     | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | java11-maven-create-def-vers-pipe    | ava11-maven-create-def-vers     | java11-maven-create-def-vers-master    | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | java8-gradle-create-def-vers-pipe    | java8-gradle-create-def-vers    | java8-gradle-create-def-vers-master    | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | java11-gradle-create-def-vers-pipe   | java11-gradle-create-def-vers   | java11-gradle-create-def-vers-master   | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | dotnet-2-1-create-def-vers-pipe      | dotnet-2-1-create-def-vers      | dotnet-2-1-create-def-vers-master      | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | dotnet-3-1-create-def-vers-pipe      | dotnet-3-1-create-def-vers      | dotnet-3-1-create-def-vers-master      | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | python-3-8-create-def-vers-pipe      | python-3-8-create-def-vers      | python-3-8-create-def-vers             | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | javascript-create-def-vers-pipe      | javascript-create-def-vers      | javascript-create-def-vers-master      | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | go-beego-create-def-vers-pipe        | go-beego-create-def-vers        | go-beego-create-def-vers-master        | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |
      | username | password | go-operator-sdk-create-def-vers-pipe | go-operator-sdk-create-def-vers | go-operator-sdk-create-def-vers-master | sit       | sit              | manual          | sit      | qa         | petclinic qa      | manual           | qa        |

  @DeployCreateDefVers
  Scenario Outline: Deploy sit for added applications using Create strategy
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
    And User clicks 'Input requested' button
    And User selects "<applicationVersion>" application version for deploy
    Then User clicks 'Proceed' button in version info popup
    And User clicks Proceed' button to promote image
    And User opens "<codebaseJenkinsFolder>" cd pipeline overview
    And User sees success status for "<cdPipelineStage>" cd pipeline stage

    Examples:
      | username | password | codebaseJenkinsFolder                | applicationVersion | cdPipelineStage |
      | username | password | java8-maven-create-def-vers-pipe     | latest             | sit             |
      | username | password | java11-maven-create-def-vers-pipe    | latest             | sit             |
      | username | password | java8-gradle-create-def-vers-pipe    | latest             | sit             |
      | username | password | java11-gradle-create-def-vers-pipe   | latest             | sit             |
      | username | password | dotnet-2-1-create-def-vers-pipe      | latest             | sit             |
      | username | password | dotnet-3-1-create-def-vers-pipe      | latest             | sit             |
      | username | password | python-3-8-create-def-vers-pipe      | latest             | sit             |
      | username | password | javascript-create-def-vers-pipe      | latest             | sit             |
      | username | password | go-beego-create-def-vers-pipe        | latest             | sit             |
      | username | password | go-operator-sdk-create-def-vers-pipe | latest             | sit             |

  @Smoke
  Scenario Outline: Delete added Applications using Create strategy
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User clicks on Application tab
#    And User clicks 'delete codebase' button
#    And User enters "<applicationName>" in confirmation name field
#    And User clicks 'Delete confirmation' button
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request
#
    Examples:
      | applicationName                 |
      | java8-maven-create-def-vers     |
      | java11-maven-create-def-vers    |
      | java8-gradle-create-def-vers    |
      | java11-gradle-create-def-vers   |
      | dotnet-2-1-create-def-vers      |
      | dotnet-3-1-create-def-vers      |
      | python-3-8-create-def-vers      |
      | javascript-create-def-vers      |
      | go-beego-create-def-vers        |
      | go-operator-sdk-create-def-vers |


  Scenario Outline: Create multi-module application using Create strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User clicks 'Proceed' button
    And User enters "<applicationName>" in application name field
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User checks 'Multi-module Project' checkbox
    And User clicks 'Proceed' button
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
#    And User sends request to get ac-creator secret
#    And User sends request to get admin-console-client secret
#    And User sends request to get token
#    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName                   | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password |
      | java8-maven-mult-create-def-vers  | Create           | Java         | java8           | Maven     | master     | master            | default        | username | password |
      | java11-maven-mult-create-def-vers | Create           | Java         | java11          | Maven     | master     | master            | default        | username | password |

  @Smoke
  Scenario Outline: Check pipelines in Jenkins for added multimodule Applications using Create strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder             | createReleaseJob                                 | buildJob                                       |
      | username | password | java8-maven-mult-create-def-vers  | Create-release-java8-maven-mult-create-def-vers  | MASTER-Build-java8-maven-mult-create-def-vers  |
      | username | password | java11-maven-mult-create-def-vers | Create-release-java11-maven-mult-create-def-vers | MASTER-Build-java11-maven-mult-create-def-vers |
#
#
  @Smoke
  Scenario Outline: Delete added multimodule Applications using Create strategy
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User clicks on Application tab
#    And User clicks 'delete codebase' button
#    And User enters "<applicationName>" in confirmation name field
#    And User clicks 'Delete confirmation' button
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName                   |
      | java8-maven-mult-create-def-vers  |
      | java11-maven-mult-create-def-vers |

