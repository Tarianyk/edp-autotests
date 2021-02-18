Feature: Autotests provisioning with EDP versioning type

  @AddAutotestsEdpVers @AddAutotests @AddCodebase
  Scenario Outline: Add autotests using Clone Strategy (gitlab)
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
    And User enters "<startVersion>" start version
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
      | applicationName                        | codebaseStrategy | repository          | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | autotestDescription | testReportFramework | startVersion |
      | java8-clone-autotests-gitlab-edp-vers  | Clone            | java8-gitlab        | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | edp            | username | password | test                | allure              | 1.2.3        |
      | java11-clone-autotests-gitlab-edp-vers | Clone            | java11-maven-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Maven     | master     | master            | edp            | username | password | test                | allure              | 1.2.3        |

  @AddAutotestsEdpVers @AddAutotests @AddCodebase
  Scenario Outline: Add autotests using Clone Strategy (github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Autotests tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User enters "<repository>" in git repository url field
    And User checks 'Codebase Authentication' check-box
    And User enters "<repositoryLogin>" for Github in repository login field
    And User enters "<repositoryPassword>" for Github in repository password field
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
    And User enters "<startVersion>" start version
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
      | applicationName                        | codebaseStrategy | repository          | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | autotestDescription | testReportFramework | startVersion |
      | java8-clone-autotests-github-edp-vers  | Clone            | java8-mavem-github  | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            | edp            | username | password | test                | allure              | 1.2.3        |
      | java11-clone-autotests-github-edp-vers | Clone            | java11-mavem-github | githubRepositoryLogin | githubRepositoryPassword | Java         | java11          | Maven     | master     | master            | edp            | username | password | test                | allure              | 1.2.3        |


  @AddAutotestsEdpVers @AddAutotests @AddCodebase
  Scenario Outline: Create autotest using Import strategy (gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Autotests tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User selects "<gitServer>" git server
    And User enters "<relativePath>" repository relative path
    And User clicks 'Proceed' button
    And User enters "<defaultBranchName>" default branch name
    And User enters "<autotestDescription>" autotest description
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User clicks 'Proceed' button
    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
    And User selects "<versioningType>" codebase versioning type
    And User enters "<startVersion>" start version
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
      | applicationName | codebaseStrategy | gitServer | relativePath        | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | autotestDescription | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | java8-maven     | Import           | git-epam  | java8-gitlab        | Java         | java8           | Maven     | master     | master            | test                | gitlab                | edp            | username | password | 1.2.3        |
      | java11-maven    | Import           | git-epam  | java11-maven-gitlab | Java         | java8           | Maven     | master     | master            | test                | gitlab                | edp            | username | password | 1.2.3        |

  @AddAutotestsEdpVers @AddAutotests @AddCodebase
  Scenario Outline: Create autotest using Import strategy (github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    And User clicks on Autotests tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User selects "<gitServer>" git server
    And User enters "<relativePath>" relative path for github repository
    And User clicks 'Proceed' button
    And User enters "<defaultBranchName>" default branch name
    And User enters "<autotestDescription>" autotest description
    And User selects "<codeLanguage>" application code language
    And User selects "<languageVersion>" language version
    And User selects "<buildTool>" build tool
    And User clicks 'Proceed' button
    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
    And User selects "<versioningType>" codebase versioning type
    And User enters "<startVersion>" start version
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
      | applicationName   | codebaseStrategy | gitServer | relativePath        | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | autotestDescription | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | java-maven-java8  | Import           | github    | java8-mavem-github  | Java         | java8           | Maven     | master     | master            | test                | github                | edp            | username | password | 1.2.3        |
      | java-maven-java11 | Import           | github    | java11-mavem-github | Java         | java11          | Maven     | master     | master            | test                | github                | edp            | username | password | 1.2.3        |

