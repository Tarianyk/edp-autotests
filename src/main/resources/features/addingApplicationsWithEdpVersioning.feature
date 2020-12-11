Feature: Smoke

  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
###    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName                 | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-create-edp-vers     | Create           | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java11-maven-create-edp-vers    | Create           | Java         | java11          | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java8-gradle-create-edp-vers    | Create           | Java         | java8           | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | java11-gradle-create-edp-vers   | Create           | Java         | java11          | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-2-1-create-edp-vers      | Create           | DotNet       | dotnet-2.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-3-1-create-edp-vers      | Create           | DotNet       | dotnet-3.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |
      | python-3-8-create-edp-vers      | Create           | Python       | python-3.8      | Python    | master     | master            | edp            | username | password | 1.2.3        |
      | javascript-create-edp-vers      | Create           | JavaScript   | react           | NPM       | master     | master            | edp            | username | password | 1.2.3        |
      | go-beego-create-edp-vers        | Create           | Go           | beego           | Go        | master     | master            | edp            | username | password | 1.2.3        |
      | go-operator-sdk-create-edp-vers | Create           | Go           | operator-sdk    | Go        | master     | master            | edp            | username | password | 1.2.3        |


  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
###    And User deletes "<applicationName>" codebase by request

    Examples:
      | applicationName                   | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-mult-create-edp-vers  | Create           | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java11-maven-mult-create-edp-vers | Create           | Java         | java11          | Maven     | master     | master            | edp            | username | password | 1.2.3        |


  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
    Examples:
      | applicationName                       | codebaseStrategy | repository            | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-clone-gitlab-edp-vers     | Clone            | java8-gitlab          | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java11-gradle-clone-gitlab-edp-vers   | Clone            | java11-gitlab         | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-3-1-clone-gitlab-edp-vers      | Clone            | dotnet31-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-3.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |
      | python-3-8-clone-gitlab-edp-vers      | Clone            | python38-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Python       | python-3.8      | Python    | master     | master            | edp            | username | password | 1.2.3        |
      | javascript-clone-gitlab-edp-vers      | Clone            | javascript-gitlab     | gitlabRepositoryLogin | gitlabRepositoryPassword | JavaScript   | react           | NPM       | master     | master            | edp            | username | password | 1.2.3        |
      | go-beego-clone-gitlab-edp-vers        | Clone            | go-beego-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | beego           | Go        | master     | master            | edp            | username | password | 1.2.3        |
      | go-operator-sdk-clone-gitlab-edp-vers | Clone            | go-operatorsdk-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | operator-sdk    | Go        | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-2-1-clone-gitlab-edp-vers      | Clone            | go-operatorsdk-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-2.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |

  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
    Examples:
      | applicationName                         | codebaseStrategy | repository    | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-mult-clone-gitlab-edp-vers  | Clone            | java8-gitlab  | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java11-maven-mult-clone-gitlab-edp-vers | Clone            | java11-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Maven     | master     | master            | edp            | username | password | 1.2.3        |

  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
    Examples:
      | applicationName                   | codebaseStrategy | repository         | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-clone-github-edp-vers | Clone            | java8-mavem-github | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | python-3-8-clone-github-edp-vers  | Clone            | python38-github    | githubRepositoryLogin | githubRepositoryPassword | Python       | python-3.8      | Python    | master     | master            | edp            | username | password | 1.2.3        |
      | javascript-clone-github-edp-vers  | Clone            | javascript-github  | githubRepositoryLogin | githubRepositoryPassword | JavaScript   | react           | NPM       | master     | master            | edp            | username | password | 1.2.3        |

  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
    Examples:
      | applicationName                        | codebaseStrategy | repository         | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-mult-clone-github-edp-vers | Clone            | java8-mavem-github | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |

  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
    Examples:
      | applicationName            | codebaseStrategy | gitServer | relativePath          | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | java11-gradle              | Import           | git-epam  | java11-gitlab         | Java         | java11          | Gradle    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | test-springboot-helloworld | Import           | git-epam  | java8-gitlab          | Java         | java8           | Maven     | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | dotnet-dotnet-dotnet-3-1   | Import           | git-epam  | dotnet31-gitlab       | DotNet       | dotnet-3.1      | dotnet    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | python-python-python-3-8   | Import           | git-epam  | python38-gitlab       | Python       | python-3.8      | Python    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | edp-react-helloworld       | Import           | git-epam  | javascript-gitlab     | JavaScript   | react           | NPM       | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | go-go-beego                | Import           | git-epam  | go-beego-gitlab       | Go           | beego           | Go        | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | go-go-operator-sdk         | Import           | git-epam  | go-operatorsdk-gitlab | Go           | operator-sdk    | Go        | master     | master            | gitlab                | edp            | username | password | 1.2.3        |

  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
    Examples:
      | applicationName            | codebaseStrategy | gitServer | relativePath | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | test-springboot-helloworld | Import           | git-epam  | java8-gitlab | Java         | java8           | Maven     | master     | master            | gitlab                | edp            | username | password | 1.2.3        |

  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
    Examples:
      | applicationName           | codebaseStrategy | gitServer | relativePath       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | edp-springboot-helloworld | Import           | github    | java8-mavem-github | Java         | java8           | Maven     | master     | master            | github                | edp            | username | password | 1.2.3        |
      | python-3-8                | Import           | github    | python38-github    | Python       | Python-3.8      | Python    | master     | master            | github                | edp            | username | password | 1.2.3        |
      | edp-javascript-project    | Import           | github    | javascript-github  | JavaScript   | react           | NPM       | master     | master            | github                | edp            | username | password | 1.2.3        |

  @smoke
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
    And User enters "<startVersion>" start version
    And User clicks 'Proceed' button
    And User clicks 'Proceed' button
    And User clicks 'Create' button
    And User clicks 'Continue' button in confirmation popup
    Then User sees success status for "<applicationName>" application name
    And User clicks "<applicationName>" application name
    And User sees success status in Branches section for "<branchName>" branch
    And User clicks on Application tab
    And User clicks 'delete codebase' button
    And User enters "<applicationName>" in confirmation name field
    And User clicks 'Delete confirmation' button
    Examples:
      | applicationName           | codebaseStrategy | gitServer | relativePath       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | edp-springboot-helloworld | Import           | github    | java8-mavem-github | Java         | java8           | Maven     | master     | master            | github                | edp            | username | password | 1.2.3        |
