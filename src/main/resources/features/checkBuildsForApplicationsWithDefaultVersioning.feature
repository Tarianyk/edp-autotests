Feature: Check builds for applications added with default versioning

  @BuildAppsDefVers @BuildAppsDefVersCreate @BuildApps
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
    And User clicks 'Overview' tab
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName                 | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | codebaseJenkinsFolder           | createReleaseJob                               | buildJob                                     |
      | java8-maven-create-def-vers     | Create           | Java         | java8           | Maven     | master     | master            | default        | username | password | java8-maven-create-def-vers     | Create-release-java8-maven-create-def-vers     | MASTER-Build-java8-maven-create-def-vers     |
      | java11-maven-create-def-vers    | Create           | Java         | java11          | Maven     | master     | master            | default        | username | password | java11-maven-create-def-vers    | Create-release-java11-maven-create-def-vers    | MASTER-Build-java11-maven-create-def-vers    |
      | java8-gradle-create-def-vers    | Create           | Java         | java8           | Gradle    | master     | master            | default        | username | password | java8-gradle-create-def-vers    | Create-release-java8-gradle-create-def-vers    | MASTER-Build-java8-gradle-create-def-vers    |
      | java11-gradle-create-def-vers   | Create           | Java         | java11          | Gradle    | master     | master            | default        | username | password | java11-gradle-create-def-vers   | Create-release-java11-gradle-create-def-vers   | MASTER-Build-java11-gradle-create-def-vers   |
      | dotnet-2-1-create-def-vers      | Create           | DotNet       | dotnet-2.1      | dotnet    | master     | master            | default        | username | password | dotnet-2-1-create-def-vers      | Create-release-dotnet-2-1-create-def-vers      | MASTER-Build-dotnet-2-1-create-def-vers      |
      | dotnet-3-1-create-def-vers      | Create           | DotNet       | dotnet-3.1      | dotnet    | master     | master            | default        | username | password | dotnet-3-1-create-def-vers      | Create-release-dotnet-3-1-create-def-vers      | MASTER-Build-dotnet-3-1-create-def-vers      |
      | python-3-8-create-def-vers      | Create           | Python       | python-3.8      | Python    | master     | master            | default        | username | password | python-3-8-create-def-vers      | Create-release-python-3-8-create-def-vers      | MASTER-Build-python-3-8-create-def-vers      |
      | javascript-create-def-vers      | Create           | JavaScript   | react           | NPM       | master     | master            | default        | username | password | javascript-create-def-vers      | Create-release-javascript-create-def-vers      | MASTER-Build-javascript-create-def-vers      |
      | go-beego-create-def-vers        | Create           | Go           | beego           | Go        | master     | master            | default        | username | password | go-beego-create-def-vers        | Create-release-go-beego-create-def-vers        | MASTER-Build-go-beego-create-def-vers        |
      | go-operator-sdk-create-def-vers | Create           | Go           | operator-sdk    | Go        | master     | master            | default        | username | password | go-operator-sdk-create-def-vers | Create-release-go-operator-sdk-create-def-vers | MASTER-Build-go-operator-sdk-create-def-vers |

  @Smoke @BuildAppsDefVers
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

  @Smoke @BuildAppsDefVers
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
      | username | password | applicationName                 |
      | username | password | java8-maven-create-def-vers     |
      | username | password | java11-maven-create-def-vers    |
      | username | password | java8-gradle-create-def-vers    |
      | username | password | java11-gradle-create-def-vers   |
      | username | password | dotnet-2-1-create-def-vers      |
      | username | password | dotnet-3-1-create-def-vers      |
      | username | password | python-3-8-create-def-vers      |
      | username | password | javascript-create-def-vers      |
      | username | password | go-beego-create-def-vers        |
      | username | password | go-operator-sdk-create-def-vers |


  @smoke @BuildAppsDefVers
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
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName                   | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password |
      | java8-maven-mult-create-def-vers  | Create           | Java         | java8           | Maven     | master     | master            | default        | username | password |
      | java11-maven-mult-create-def-vers | Create           | Java         | java11          | Maven     | master     | master            | default        | username | password |

  @Smoke @BuildAppsDefVers
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
  @Smoke @BuildAppsDefVers
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
      | username | password | applicationName                   |
      | username | password | java8-maven-mult-create-def-vers  |
      | username | password | java11-maven-mult-create-def-vers |

  @smoke @BuildAppsDefVers
  Scenario Outline: Create application using Clone strategy (Gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Application tab
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
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request
    Examples:
      | applicationName                       | codebaseStrategy | repository            | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password |
      | java8-maven-clone-gitlab-def-vers     | Clone            | java8-gitlab          | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | default        | username | password |
      | java8-gradle-clone-gitlab-def-vers    | Clone            | java8-gradle-gitlab   | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Gradle    | master     | master            | default        | username | password |
      | java11-gradle-clone-gitlab-def-vers   | Clone            | java11-gitlab         | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Gradle    | master     | master            | default        | username | password |
      | java11-maven-clone-gitlab-def-vers    | Clone            | java11-maven-gitlab   | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Maven     | master     | master            | default        | username | password |
      | dotnet-3-1-clone-gitlab-def-vers      | Clone            | dotnet31-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-3.1      | dotnet    | master     | master            | default        | username | password |
      | dotnet-2-1-clone-gitlab-def-vers      | Clone            | dotnet21-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-2.1      | dotnet    | master     | master            | default        | username | password |
      | python-3-8-clone-gitlab-def-vers      | Clone            | python38-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Python       | python-3.8      | Python    | master     | master            | default        | username | password |
      | javascript-clone-gitlab-def-vers      | Clone            | javascript-gitlab     | gitlabRepositoryLogin | gitlabRepositoryPassword | JavaScript   | react           | NPM       | master     | master            | default        | username | password |
      | go-beego-clone-gitlab-def-vers        | Clone            | go-beego-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | beego           | Go        | master     | master            | default        | username | password |
      | go-operator-sdk-clone-gitlab-def-vers | Clone            | go-operatorsdk-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | operator-sdk    | Go        | master     | master            | default        | username | password |


  @Smoke @BuildAppsDefVers
  Scenario Outline: Check pipelines in Jenkins for added Applications using Clone strategy (Gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder                 | createReleaseJob                                     | buildJob                                           |
      | username | password | java8-maven-clone-gitlab-def-vers     | Create-release-java8-maven-clone-gitlab-def-vers     | MASTER-Build-java8-maven-clone-gitlab-def-vers     |
      | username | password | java8-gradle-clone-gitlab-def-vers    | Create-release-java8-gradle-clone-gitlab-def-vers    | MASTER-Build-java8-gradle-clone-gitlab-def-vers    |
      | username | password | java11-gradle-clone-gitlab-def-vers   | Create-release-java11-gradle-clone-gitlab-def-vers   | MASTER-Build-java11-gradle-clone-gitlab-def-vers   |
      | username | password | java11-maven-clone-gitlab-def-vers    | Create-release-java11-maven-clone-gitlab-def-vers    | MASTER-Build-java11-maven-clone-gitlab-def-vers    |
      | username | password | dotnet-3-1-clone-gitlab-def-vers      | Create-release-dotnet-3-1-clone-gitlab-def-vers      | MASTER-Build-dotnet-3-1-clone-gitlab-def-vers      |
      | username | password | dotnet-2-1-clone-gitlab-def-vers      | Create-release-dotnet-2-1-clone-gitlab-def-vers      | MASTER-Build-dotnet-2-1-clone-gitlab-def-vers      |
      | username | password | python-3-8-clone-gitlab-def-vers      | Create-release-python-3-8-clone-gitlab-def-vers      | MASTER-Build-python-3-8-clone-gitlab-def-vers      |
      | username | password | javascript-clone-gitlab-def-vers      | Create-release-javascript-clone-gitlab-def-vers      | MASTER-Build-javascript-clone-gitlab-def-vers      |
      | username | password | go-beego-clone-gitlab-def-vers        | Create-release-go-beego-clone-gitlab-def-vers        | MASTER-Build-go-beego-clone-gitlab-def-vers        |
      | username | password | go-operator-sdk-clone-gitlab-def-vers | Create-release-go-operator-sdk-clone-gitlab-def-vers | MASTER-Build-go-operator-sdk-clone-gitlab-def-vers |


  @Smoke @BuildAppsDefVers
  Scenario Outline: Delete added Applications using Clone strategy (Gitlab)
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
      | username | password | applicationName                       |
      | username | password | java8-maven-clone-gitlab-def-vers     |
      | username | password | java11-gradle-clone-gitlab-def-vers   |
      | username | password | dotnet-3-1-clone-gitlab-def-vers      |
      | username | password | python-3-8-clone-gitlab-def-vers      |
      | username | password | javascript-clone-gitlab-def-vers      |
      | username | password | go-beego-clone-gitlab-def-vers        |
      | username | password | go-operator-sdk-clone-gitlab-def-vers |
      | username | password | dotnet-2-1-clone-gitlab-def-vers      |

  @smoke @BuildAppsDefVers
  Scenario Outline: Create multi-module application using Clone strategy (Gitlab)
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
    And User checks 'Multi-module Project' checkbox
    And User clicks 'Proceed' button
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request
    Examples:
      | applicationName                         | codebaseStrategy | repository               | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password |
      | java8-maven-mult-clone-gitlab-def-vers  | Clone            | java8-multimodule-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | default        | username | password |
      | java11-maven-mult-clone-gitlab-def-vers | Clone            | java8-multimodule-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Maven     | master     | master            | default        | username | password |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Check pipelines in Jenkins for added multimodule Applications using Clone strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder                   | createReleaseJob                                       | buildJob                                             |
      | username | password | java8-maven-mult-clone-gitlab-def-vers  | Create-release-java8-maven-mult-clone-gitlab-def-vers  | MASTER-Build-java8-maven-mult-clone-gitlab-def-vers  |
      | username | password | java11-maven-mult-clone-gitlab-def-vers | Create-release-java11-maven-mult-clone-gitlab-def-vers | MASTER-Build-java11-maven-mult-clone-gitlab-def-vers |


  @Smoke @BuildAppsDefVers
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
      | username | password | applicationName                         |
      | username | password | java8-maven-mult-clone-gitlab-def-vers  |
      | username | password | java11-maven-mult-clone-gitlab-def-vers |
#
  @smoke @BuildAppsDefVers
  Scenario Outline: Create application using Clone strategy (Github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User enters "<repository>" in git repository url field
    And User checks 'Codebase Authentication' check-box
    And User enters "<repositoryLogin>" for Github in repository login field
    And User enters "<repositoryPassword>" for Github in repository password field
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
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request
    Examples:
      | applicationName                       | codebaseStrategy | repository            | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password |
      | java8-maven-clone-github-def-vers     | Clone            | java8-mavem-github    | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            | default        | username | password |
      | java8-gradle-clone-github-def-vers    | Clone            | java8-gradle-github   | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Gradle    | master     | master            | default        | username | password |
      | java11-maven-clone-github-def-vers    | Clone            | java11-mavem-github   | githubRepositoryLogin | githubRepositoryPassword | Java         | java11          | Maven     | master     | master            | default        | username | password |
      | java11-gradle-clone-github-def-vers   | Clone            | java11-gradle-github  | githubRepositoryLogin | githubRepositoryPassword | Java         | java11          | Gradle    | master     | master            | default        | username | password |
      | go-beego-clone-github-def-vers        | Clone            | go-beego-github       | githubRepositoryLogin | githubRepositoryPassword | Go           | beego           | Go        | master     | master            | default        | username | password |
      | go-operator-sdk-clone-github-def-vers | Clone            | go-operatorsdk-github | githubRepositoryLogin | githubRepositoryPassword | Go           | operator-sdk    | Go        | master     | master            | default        | username | password |
      | python-3-8-clone-github-def-vers      | Clone            | python38-github       | githubRepositoryLogin | githubRepositoryPassword | Python       | python-3.8      | Python    | master     | master            | default        | username | password |
      | javascript-clone-github-def-vers      | Clone            | javascript-github     | githubRepositoryLogin | githubRepositoryPassword | JavaScript   | react           | NPM       | master     | master            | default        | username | password |
      | dotnet-3-1-clone-github-def-vers      | Clone            | dotnet31-github       | githubRepositoryLogin | githubRepositoryPassword | DotNet       | dotnet-3.1      | dotnet    | master     | master            | default        | username | password |
      | dotnet-2-1-clone-github-def-vers      | Clone            | dotnet21-github       | githubRepositoryLogin | githubRepositoryPassword | DotNet       | dotnet-2.1      | dotnet    | master     | master            | default        | username | password |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Check pipelines in Jenkins for added Applications using Clone strategy (Github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder                 | createReleaseJob                                     | buildJob                                           |
      | username | password | java8-maven-clone-github-def-vers     | Create-release-java8-maven-clone-github-def-vers     | MASTER-Build-java8-maven-clone-github-def-vers     |
      | username | password | java8-gradle-clone-github-def-vers    | Create-release-java8-gradle-clone-github-def-vers    | MASTER-Build-java8-gradle-clone-github-def-vers    |
      | username | password | java11-maven-clone-github-def-vers    | Create-release-java11-maven-clone-github-def-vers    | MASTER-Build-java11-maven-clone-github-def-vers    |
      | username | password | java11-gradle-clone-github-def-vers   | Create-release-java11-gradle-clone-github-def-vers   | MASTER-Build-java11-gradle-clone-github-def-vers   |
      | username | password | go-beego-clone-github-def-vers        | Create-release-go-beego-clone-github-def-vers        | MASTER-Build-go-beego-clone-github-def-vers        |
      | username | password | go-operator-sdk-clone-github-def-vers | Create-release-go-operator-sdk-clone-github-def-vers | MASTER-Build-go-operator-sdk-clone-github-def-vers |
      | username | password | python-3-8-clone-github-def-vers      | Create-release-python-3-8-clone-github-def-vers      | MASTER-Build-python-3-8-clone-github-def-vers      |
      | username | password | javascript-clone-github-def-vers      | Create-release-javascript-clone-github-def-vers      | MASTER-Build-javascript-clone-github-def-vers      |
      | username | password | dotnet-3-1-clone-github-def-vers      | Create-release-dotnet-3-1-clone-github-def-vers      | MASTER-Build-dotnet-3-1-clone-github-def-vers      |
      | username | password | dotnet-2-1-clone-github-def-vers      | Create-release-dotnet-2-1-clone-github-def-vers      | MASTER-Build-dotnet-2-1-clone-github-def-vers      |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Delete added Applications using Clone strategy (Github)
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
      | username | password | applicationName                       |
      | username | password | java8-maven-clone-github-def-vers     |
      | username | password | java8-gradle-clone-github-def-vers    |
      | username | password | java11-maven-clone-github-def-vers    |
      | username | password | java11-gradle-clone-github-def-vers   |
      | username | password | go-beego-clone-github-def-vers        |
      | username | password | go-operator-sdk-clone-github-def-vers |
      | username | password | python-3-8-clone-github-def-vers      |
      | username | password | javascript-clone-github-def-vers      |
      | username | password | dotnet-3-1-clone-github-def-vers      |
      | username | password | dotnet-2-1-clone-github-def-vers      |

  @smoke @BuildAppsDefVers
  Scenario Outline: Create multi-module application using Clone strategy (Github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User enters "<repository>" in git repository url field
    And User checks 'Codebase Authentication' check-box
    And User enters "<repositoryLogin>" for Github in repository login field
    And User enters "<repositoryPassword>" for Github in repository password field
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
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName                         | codebaseStrategy | repository                | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password |
      | java8-maven-mult-clone-github-def-vers  | Clone            | java8-multimodule-github  | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            | default        | username | password |
      | java11-maven-mult-clone-github-def-vers | Clone            | java11-multimodule-github | githubRepositoryLogin | githubRepositoryPassword | Java         | java11          | Maven     | master     | master            | default        | username | password |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Check pipelines in Jenkins for added multimodule Applications using Clone strategy (Github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder                   | createReleaseJob                                       | buildJob                                             |
      | username | password | java8-maven-mult-clone-github-def-vers  | Create-release-java8-maven-mult-clone-github-def-vers  | MASTER-Build-java8-maven-mult-clone-github-def-vers  |
      | username | password | java11-maven-mult-clone-github-def-vers | Create-release-java11-maven-mult-clone-github-def-vers | MASTER-Build-java11-maven-mult-clone-github-def-vers |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Delete added multimodule Applications using Clone strategy (Github)
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
      | username | password | applicationName                         |
      | username | password | java8-maven-mult-clone-github-def-vers  |
      | username | password | java11-maven-mult-clone-github-def-vers |
#
  @smoke @BuildAppsDefVers
  Scenario Outline: Create application using Import strategy (gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User selects "<gitServer>" git server
    And User enters "<relativePath>" repository relative path
    And User clicks 'Proceed' button
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User clicks 'Proceed' button
    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request
    Examples:
      | applicationName  | codebaseStrategy | gitServer | relativePath          | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password |
      | java8-gradle     | Import           | git-epam  | java8-gradle-gitlab   | Java         | java8           | Gradle    | master     | master            | gitlab                | default        | username | password |
      | java8-maven      | Import           | git-epam  | java8-gitlab          | Java         | java8           | Maven     | master     | master            | gitlab                | default        | username | password |
      | java11-gradle    | Import           | git-epam  | java11-gitlab         | Java         | java11          | Gradle    | master     | master            | gitlab                | default        | username | password |
      | java11-maven     | Import           | git-epam  | java11-maven-gitlab   | Java         | java11          | Maven     | master     | master            | gitlab                | default        | username | password |
      | dotnet-3-1       | Import           | git-epam  | dotnet31-gitlab       | DotNet       | dotnet-3.1      | dotnet    | master     | master            | gitlab                | default        | username | password |
      | dotnet-2-1       | Import           | git-epam  | dotnet21-gitlab       | DotNet       | dotnet-2.1      | dotnet    | master     | master            | gitlab                | default        | username | password |
      | python-3-8       | Import           | git-epam  | python38-gitlab       | Python       | python-3.8      | Python    | master     | master            | gitlab                | default        | username | password |
      | javascript-react | Import           | git-epam  | javascript-gitlab     | JavaScript   | react           | NPM       | master     | master            | gitlab                | default        | username | password |
      | go-beego         | Import           | git-epam  | go-beego-gitlab       | Go           | beego           | Go        | master     | master            | gitlab                | default        | username | password |
      | go-operator-sdk  | Import           | git-epam  | go-operatorsdk-gitlab | Go           | operator-sdk    | Go        | master     | master            | gitlab                | default        | username | password |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Check pipelines in Jenkins for added Applications using Import strategy (Gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder | createReleaseJob                | buildJob                      |
      | username | password | java8-gradle          | Create-release-java8-gradle     | MASTER-Build-java8-gradle     |
      | username | password | java8-maven           | Create-release-java8-maven      | MASTER-Build-java8-maven      |
      | username | password | java11-gradle         | Create-release-java11-gradle    | MASTER-Build-java11-gradle    |
      | username | password | java11-maven          | Create-release-java11-maven     | MASTER-Build-java11-maven     |
      | username | password | dotnet-3-1            | Create-release-dotnet-3-1       | MASTER-Build-dotnet-3-1       |
      | username | password | dotnet-2-1            | Create-release-dotnet-2-1       | MASTER-Build-dotnet-2-1       |
      | username | password | python-3-8            | Create-release-python-3-8       | MASTER-Build-python-3-8       |
      | username | password | javascript-react      | Create-release-javascript-react | MASTER-Build-javascript-react |
      | username | password | go-beego              | Create-release-go-beego         | MASTER-Build-go-beego         |
      | username | password | go-operator-sdk       | Create-release-go-operator-sdk  | MASTER-Build-go-operator-sdk  |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Delete added Applications using Import strategy (Gitlab)
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
      | username | password | applicationName  |
      | username | password | java8-gradle     |
      | username | password | java8-maven      |
      | username | password | java11-gradle    |
      | username | password | java11-maven     |
      | username | password | dotnet-3-1       |
      | username | password | dotnet-2-1       |
      | username | password | python-3-8       |
      | username | password | javascript-react |
      | username | password | go-beego         |
      | username | password | go-operator-sdk  |

  @smoke @BuildAppsDefVers
  Scenario Outline: Create multi-module application using Import strategy (gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User selects "<gitServer>" git server
    And User enters "<relativePath>" repository relative path
    And User clicks 'Proceed' button
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User checks 'Multi-module Project' checkbox
    And User clicks 'Proceed' button
    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName          | codebaseStrategy | gitServer | relativePath              | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password |
      | java8-maven-multimodule  | Import           | git-epam  | java8-multimodule-gitlab  | Java         | java8           | Maven     | master     | master            | gitlab                | default        | username | password |
      | java11-maven-multimodule | Import           | git-epam  | java11-multimodule-gitlab | Java         | java11          | Maven     | master     | master            | gitlab                | default        | username | password |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Check pipelines in Jenkins for added multimodule Applications using Import strategy (Gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder    | createReleaseJob                        | buildJob                              |
      | username | password | java8-maven-multimodule  | Create-release-java8-maven-multimodule  | MASTER-Build-java8-maven-multimodule  |
      | username | password | java11-maven-multimodule | Create-release-java11-maven-multimodule | MASTER-Build-java11-maven-multimodule |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Delete added multimodule Applications using Import strategy (Gitlab)
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
      | username | password | applicationName          |
      | username | password | java8-maven-multimodule  |
      | username | password | java11-maven-multimodule |
#
  @smoke @BuildAppsDefVers
  Scenario Outline: Create application using Import strategy (github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User selects "<gitServer>" git server
    And User enters "<relativePath>" relative path for github repository
    And User clicks 'Proceed' button
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User clicks 'Proceed' button
    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
#    And User clicks on Application tab
#    And User clicks 'delete codebase' button
#    And User enters "<applicationName>" in confirmation name field
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request
    Examples:
      | applicationName          | codebaseStrategy | gitServer | relativePath          | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password |
      | java-maven-java8         | Import           | github    | java8-mavem-github    | Java         | java8           | Maven     | master     | master            | github                | default        | username | password |
      | java-gradle-java8        | Import           | github    | java8-gradle-github   | Java         | java8           | Gradle    | master     | master            | github                | default        | username | password |
      | java-maven-java11        | Import           | github    | java11-mavem-github   | Java         | java11          | Maven     | master     | master            | github                | default        | username | password |
      | java-gradle-java11       | Import           | github    | java11-gradle-github  | Java         | java11          | Gradle    | master     | master            | github                | default        | username | password |
      | python-python-python-3-8 | Import           | github    | python38-github       | Python       | python-3.8      | Python    | master     | master            | github                | default        | username | password |
      | javascript-npm-react     | Import           | github    | javascript-github     | JavaScript   | react           | NPM       | master     | master            | github                | default        | username | password |
      | dotnet-dotnet-dotnet-3-1 | Import           | github    | dotnet31-github       | DotNet       | dotnet-3.1      | dotnet    | master     | master            | gitlab                | default        | username | password |
      | dotnet-dotnet-dotnet-2-1 | Import           | github    | dotnet21-github       | DotNet       | dotnet-2.1      | dotnet    | master     | master            | gitlab                | default        | username | password |
      | go-go-beego              | Import           | github    | go-beego-github       | Go           | beego           | Go        | master     | master            | gitlab                | default        | username | password |
      | go-go-operator-sdk       | Import           | github    | go-operatorsdk-github | Go           | operator-sdk    | Go        | master     | master            | gitlab                | default        | username | password |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Check pipelines in Jenkins for added Applications using Import strategy (Github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder    | createReleaseJob                        | buildJob                              |
      | username | password | java-maven-java8         | Create-release-java-maven-java8         | MASTER-Build-java-maven-java8         |
      | username | password | java-gradle-java8        | Create-release-java-gradle-java8        | MASTER-Build-java-gradle-java8        |
      | username | password | java-maven-java11        | Create-release-java-maven-java11        | MASTER-Build-java-maven-java11        |
      | username | password | java-gradle-java11       | Create-release-java-gradle-java11       | MASTER-Build-java-gradle-java11       |
      | username | password | python-python-python-3-8 | Create-release-python-python-python-3-8 | MASTER-Build-python-python-python-3-8 |
      | username | password | javascript-npm-react     | Create-release-javascript-npm-react     | MASTER-Build-javascript-npm-react     |
      | username | password | dotnet-dotnet-dotnet-3-1 | Create-release-dotnet-dotnet-dotnet-3-1 | MASTER-Build-dotnet-dotnet-dotnet-3-1 |
      | username | password | dotnet-dotnet-dotnet-2-1 | dotnet-dotnet-dotnet-2-1                | MASTER-Build-dotnet-dotnet-dotnet-2-1 |
      | username | password | go-go-beego              | Create-release-go-go-beego              | MASTER-Build-go-go-beego              |
      | username | password | go-go-operator-sdk       | Create-release-go-go-operator-sdk       | MASTER-Build-go-go-operator-sdk       |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Delete added Applications using Import strategy (Github)
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
      | username | password | applicationName          |
      | username | password | java-maven-java8         |
      | username | password | java-gradle-java8        |
      | username | password | java-maven-java11        |
      | username | password | java-gradle-java11       |
      | username | password | python-python-python-3-8 |
      | username | password | javascript-npm-react     |
      | username | password | dotnet-dotnet-dotnet-3-1 |
      | username | password | dotnet-dotnet-dotnet-2-1 |
      | username | password | go-go-beego              |
      | username | password | go-go-operator-sdk       |


  @smoke @BuildAppsDefVers
  Scenario Outline: Create multi-module application using Import strategy (github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Application tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User selects "<gitServer>" git server
    And User enters "<relativePath>" relative path for github repository
    And User clicks 'Proceed' button
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User checks 'Multi-module Project' checkbox
    And User clicks 'Proceed' button
    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
    And User selects "<versioningType>" codebase versioning type
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User sends request to get ac-creator secret
    And User sends request to get admin-console-client secret
    And User sends request to get token
    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName               | codebaseStrategy | gitServer | relativePath              | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password |
      | java-maven-java8-multimodule  | Import           | github    | java8-multimodule-github  | Java         | java8           | Maven     | master     | master            | github                | default        | username | password |
      | java-maven-java11-multimodule | Import           | github    | java11-multimodule-github | Java         | java11          | Maven     | master     | master            | github                | default        | username | password |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Check pipelines in Jenkins for added multimodule Applications using Import strategy (Github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks 'Jenkins' link
    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
    And User sees success status for "<createReleaseJob>" create release job
    And User sees success status for "<buildJob>" build job
    Examples:
      | username | password | codebaseJenkinsFolder         | createReleaseJob                             | buildJob                                   |
      | username | password | java-maven-java8-multimodule  | Create-release-java-maven-java8-multimodule  | MASTER-Build-java-maven-java8-multimodule  |
      | username | password | java-maven-java11-multimodule | Create-release-java-maven-java11-multimodule | MASTER-Build-java-maven-java11-multimodule |

  @Smoke @BuildAppsDefVers
  Scenario Outline: Delete added multimodule Applications using Import strategy (Github)
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
      | username | password | applicationName               |
      | username | password | java-maven-java8-multimodule  |
      | username | password | java-maven-java11-multimodule |