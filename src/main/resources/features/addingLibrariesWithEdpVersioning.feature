Feature: Libraries provisioning with EDP versioning type

  @AddLibEdpVers @AddLibEdpVersCreate @AddCodebase @AddLib
  Scenario Outline: Create library using Create strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
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
      | applicationName                   | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-lib-create-edp-vers   | Create           | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java8-gradle-lib-create-edp-vers  | Create           | Java         | java8           | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | java11-maven-lib-create-edp-vers  | Create           | Java         | java11          | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java11-gradle-lib-create-edp-vers | Create           | Java         | java11          | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | javascript-lib-create-edp-vers    | Create           | JavaScript   | react           | NPM       | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-2-1-lib-create-edp-vers    | Create           | DotNet       | dotnet-2.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-3-1-lib-create-edp-vers    | Create           | DotNet       | dotnet-3.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |
      | python-lib-create-edp-vers        | Create           | Python       | python-3.8      | Python    | master     | master            | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersCreate @AddCodebase @AddLib
  Scenario Outline: Create Terraform library using Create strategy
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User clicks 'Proceed' button
    And User enters "<applicationName>" in application name field
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
    And User selects "<buildTool>" build tool
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
      | applicationName               | codebaseStrategy | codeLanguage | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | terraform-lib-create-edp-vers | Create           | Terraform    | Terraform | master     | master            | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersClone @AddCodebase @AddLib
  Scenario Outline: Create library using Clone strategy (Gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
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
      | applicationName                         | codebaseStrategy | repository          | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-lib-clone-gitlab-edp-vers   | Clone            | java8-gitlab        | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java8-gradle-lib-clone-gitlab-edp-vers  | Clone            | java8-gradle-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | java11-gradle-lib-clone-gitlab-edp-vers | Clone            | java11-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | java11-maven-lib-clone-gitlab-edp-vers  | Clone            | java11-maven-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-3-1-lib-clone-gitlab-edp-vers    | Clone            | dotnet31-gitlab     | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-3.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-2-1-lib-clone-gitlab-edp-vers    | Clone            | dotnet21-gitlab     | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-2.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |
      | python-3-8-lib-clone-gitlab-edp-vers    | Clone            | python38-gitlab     | gitlabRepositoryLogin | gitlabRepositoryPassword | Python       | python-3.8      | Python    | master     | master            | edp            | username | password | 1.2.3        |
      | javascript-lib-clone-gitlab-edp-vers    | Clone            | javascript-gitlab   | gitlabRepositoryLogin | gitlabRepositoryPassword | JavaScript   | react           | NPM       | master     | master            | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersClone @AddCodebase @AddLib
  Scenario Outline: Create Terraform library using Clone strategy (Gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
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
    And User selects "<buildTool>" build tool
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
      | applicationName                     | codebaseStrategy | repository       | repositoryLogin       | repositoryPassword       | codeLanguage | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | terraform-lib-clone-gitlab-edp-vers | Clone            | terraform-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Terraform    | Terraform | master     | master            | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersClone @AddCodebase @AddLib
  Scenario Outline: Create library using Clone strategy (Github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
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
      | applicationName                         | codebaseStrategy | repository           | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | java8-maven-lib-clone-github-edp-vers   | Clone            | java8-mavem-github   | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java8-gradle-lib-clone-github-edp-vers  | Clone            | java8-gradle-github  | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | java11-maven-lib-clone-github-edp-vers  | Clone            | java11-mavem-github  | githubRepositoryLogin | githubRepositoryPassword | Java         | java11          | Maven     | master     | master            | edp            | username | password | 1.2.3        |
      | java11-gradle-lib-clone-github-edp-vers | Clone            | java11-gradle-github | githubRepositoryLogin | githubRepositoryPassword | Java         | java11          | Gradle    | master     | master            | edp            | username | password | 1.2.3        |
      | python-3-8-lib-clone-github-edp-vers    | Clone            | python38-github      | githubRepositoryLogin | githubRepositoryPassword | Python       | python-3.8      | Python    | master     | master            | edp            | username | password | 1.2.3        |
      | javascript-lib-clone-github-edp-vers    | Clone            | javascript-github    | githubRepositoryLogin | githubRepositoryPassword | JavaScript   | react           | NPM       | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-3-1-lib-clone-github-edp-vers    | Clone            | dotnet31-github      | githubRepositoryLogin | githubRepositoryPassword | DotNet       | dotnet-3.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |
      | dotnet-2-1-lib-clone-github-edp-vers    | Clone            | dotnet21-github      | githubRepositoryLogin | githubRepositoryPassword | DotNet       | dotnet-2.1      | dotnet    | master     | master            | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersClone @AddCodebase @AddLib
  Scenario Outline: Create Tettaform library using Clone strategy (Github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
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
    And User selects "<buildTool>" build tool
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
      | applicationName                     | codebaseStrategy | repository       | repositoryLogin       | repositoryPassword       | codeLanguage | buildTool | branchName | defaultBranchName | versioningType | username | password | startVersion |
      | terraform-lib-clone-github-edp-vers | Clone            | terraform-github | githubRepositoryLogin | githubRepositoryPassword | Terraform    | Terraform | master     | master            | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersImport @AddCodebase @AddLib1
  Scenario Outline: Create library using Import strategy (gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
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
      | applicationName  | codebaseStrategy | gitServer | relativePath        | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | java8-gradle     | Import           | git-epam  | java8-gradle-gitlab | Java         | java8           | Gradle    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | java8-maven      | Import           | git-epam  | java8-gitlab        | Java         | java8           | Maven     | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | java11-gradle    | Import           | git-epam  | java11-gitlab       | Java         | java11          | Gradle    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | java11-maven     | Import           | git-epam  | java11-maven-gitlab | Java         | java11          | Maven     | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | dotnet-3-1       | Import           | git-epam  | dotnet31-gitlab     | DotNet       | dotnet-3.1      | dotnet    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | dotnet-2-1       | Import           | git-epam  | dotnet21-gitlab     | DotNet       | dotnet-2.1      | dotnet    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | python-3-8       | Import           | git-epam  | python38-gitlab     | Python       | python-3.8      | Python    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | javascript-react | Import           | git-epam  | javascript-gitlab   | JavaScript   | react           | NPM       | master     | master            | gitlab                | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersImport @AddCodebase @AddLib1
  Scenario Outline: Create Terraform library using Import strategy (gitlab)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User selects "<gitServer>" git server
    And User enters "<relativePath>" repository relative path
    And User clicks 'Proceed' button
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
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
      | applicationName | codebaseStrategy | gitServer | relativePath     | codeLanguage | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | terraform       | Import           | git-epam  | terraform-gitlab | Terraform    | Terraform | master     | master            | gitlab                | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersImport @AddCodebase @AddLib1
  Scenario Outline: Create library using Import strategy (github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
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
      | applicationName          | codebaseStrategy | gitServer | relativePath         | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | java-maven-java8         | Import           | github    | java8-mavem-github   | Java         | java8           | Maven     | master     | master            | github                | edp            | username | password | 1.2.3        |
      | java-gradle-java8        | Import           | github    | java8-gradle-github  | Java         | java8           | Gradle    | master     | master            | github                | edp            | username | password | 1.2.3        |
      | java-maven-java11        | Import           | github    | java11-mavem-github  | Java         | java11          | Maven     | master     | master            | github                | edp            | username | password | 1.2.3        |
      | java-gradle-java11       | Import           | github    | java11-gradle-github | Java         | java11          | Gradle    | master     | master            | github                | edp            | username | password | 1.2.3        |
      | python-python-python-3-8 | Import           | github    | python38-github      | Python       | python-3.8      | Python    | master     | master            | github                | edp            | username | password | 1.2.3        |
      | javascript-npm-react     | Import           | github    | javascript-github    | JavaScript   | react           | NPM       | master     | master            | github                | edp            | username | password | 1.2.3        |
      | dotnet-dotnet-dotnet-3-1 | Import           | github    | dotnet31-github      | DotNet       | dotnet-3.1      | dotnet    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |
      | dotnet-dotnet-dotnet-2-1 | Import           | github    | dotnet21-github      | DotNet       | dotnet-2.1      | dotnet    | master     | master            | gitlab                | edp            | username | password | 1.2.3        |

  @AddLibEdpVers @AddLibEdpVersImport @AddCodebase @AddLib1
  Scenario Outline: Create Terraform library using Import strategy (github)
    Given User opens EDP Admin Console
    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks 'login' button
    When User clicks on Libraries tab
    And User clicks 'Create' button
    And User selects "<codebaseStrategy>" codebase integration strategy
    And User selects "<gitServer>" git server
    And User enters "<relativePath>" relative path for github repository
    And User clicks 'Proceed' button
    And User enters "<defaultBranchName>" default branch name
    And User selects "<codeLanguage>" application code language
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
      | applicationName     | codebaseStrategy | gitServer | relativePath     | codeLanguage | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType | username | password | startVersion |
      | terraform-terraform | Import           | github    | terraform-github | Terraform    | Terraform | master     | master            | github                | edp            | username | password | 1.2.3        |
