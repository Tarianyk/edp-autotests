#Feature: Smoke
#
#################
#  # LOGIN
#  ##################################
##  @smoke
##  Scenario Outline: Get access into Admin Console
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User enters "<firstName>" first name
##    And User enters "<lastName>" last name
##    And User clicks 'Submit' button
##    Examples:
##      | username | password | firstName | lastName |
##      | username | password | firstName | lastName |
#
##################################################################
#  ##GITLAB/GITHUB INTEGRATION SETUP
#  ############################################################
#
##  @smoke
##  Scenario Outline: Create API token in jenkins for Github integration
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User clicks 'Jenkins' link
##    And User clicks 'Manage Jenkins' button
##    And User clicks 'Manage Credentials' button
##    And User clicks 'global' button
##    And User clicks 'Add Credentials' button
##    And User selects "<credentialsKind>" credentials kind
##    And User enters "<secret>" secret token
##    And User enters "<secretId>" secret id
##    Then User clicks 'ok' button
##
##    Examples:
##      | username | password | credentialsKind | secret            | secretId            |
##      | username | password | Secret text     | githubSecretToken | github-access-token |
#
##  @Smoke
##  Scenario Outline: Create SSH Credential for Gitlab/Github integrations
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User clicks 'Jenkins' link
##    And User clicks 'Manage Jenkins' button
##    And User clicks 'Manage Credentials' button
##    And User clicks 'global' button
##    And User clicks 'Add Credentials' button
##    And User selects "<credentialsKind>" credentials kind
##    And User enters "<sshKeyId>" ssh key id
##    And User clicks 'Enter directly' button
##    And User clicks 'Add ssh' button
##    And User enters "<privatSshKey>" privat ssh key
##    Then User clicks 'ok' button
##
##    Examples:
##      | username | password | credentialsKind               | sshKeyId      | privatSshKey |
##      | username | password | SSH Username with private key | gitlab-sshkey | privatSshKey |
###      | username | password | SSH Username with private key | github-sshkey | privatSshKey |
#
##  @smoke
##  Scenario Outline: Create API token in jenkins for Gitlab integration
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User clicks 'Jenkins' link
##    And User clicks 'Manage Jenkins' button
##    And User clicks 'Manage Credentials' button
##    And User clicks 'global' button
##    And User clicks 'Add Credentials' button
##    And User selects "<credentialsKind>" credentials kind
##    And User enters "<apiToken>" api token
##    And User enters "<tokenId>" token id
##    Then User clicks 'ok' button
##
##
##    Examples:
##      | username | password | credentialsKind  | apiToken       | tokenId             |
##      | username | password | GitLab API token | gitlabApiToken | gitlab-access-token |
#
##  @Smoke
##  Scenario Outline: Configure Gitlab connection
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User clicks 'Jenkins' link
##    And User clicks 'Manage Jenkins' button
##    And User clicks 'Configure System' button
##    And User enters "<gitlabConnectionName>" gitlab connection name
##    And User enters "<gitlabHostUrl>" gitlab host url
##    And User selects "<gitlabAccessApiToken>" gitlab access api token
##    And User clicks 'Save' button
##    Examples:
##      | username | password | gitlabConnectionName | gitlabHostUrl        | gitlabAccessApiToken |
##      | username | password | git.epam.com         | https://git.epam.com | gitlab-access-token  |
#
##  @Smoke
##  Scenario Outline: Configure Github connection
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User clicks 'Jenkins' link
##    And User clicks 'Manage Jenkins' button
##    And User clicks 'Configure System' button
##    And User clicks 'Add Github server' button
##    And User clicks 'github Server' button
##    And User enters "<githubConnectionName>" github connection name
###    And User enters "<githubHostUrl>" github host url
##    And User selects "<githubAccessApiToken>" github access api token
##    And User clicks 'Save' button
##    Examples:
##      | username | password | githubConnectionName | githubHostUrl          | githubAccessApiToken |
##      | username | password | github               | https://api.github.com | github-access-token  |
#
#  @Smoke
#  Scenario Outline: Create CI provisioner for Gitlab integration
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User clicks 'Jenkins' link
#    And User opens 'job provisions' folder
#    And User opens 'ci' folder
#    And User clicks 'New item' button
#    And User enters "<provisionerName>" provisioner name
#    And User clicks 'freestyle project' option
#    And User clicks 'create provisioner' button
#    And User enters "<branchName>" branch name in 'Label Expression' field
#    And User checks 'Execute concurrent builds if necessary' checkbox
#    And User checks 'This project is parameterized' checkbox
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName1>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName2>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName3>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName4>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName5>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName6>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName7>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName8>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName9>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName10>" parameter name
#    And User clicks 'Add parameter' button
#    And User selects "<parametersType>" parameters type
#    And User enters "<parameterName11>" parameter name
#    And User clicks 'Build triggers' button
#    And User clicks 'Add Build step' button
#    And User selects "<buildStep>" build step
#    And User clicks 'Use the provided DSL script' checkbox
##    And User activate 'DSL script' window
#    And User enters "<provisionerCode>" provisioner code
#    Then User clicks 'Save provisioner' button
#    Examples:
#      | username | password | provisionerName | branchName | parametersType   | parameterName | parameterName1 | parameterName2 | parameterName3 | parameterName4     | parameterName5        | parameterName6 | parameterName7 | parameterName8 | parameterName9     | parameterName10 | parameterName11          | buildStep        |
#      | username | password | gitlab7         | master     | String Parameter | NAME          | TYPE           | BUILD_TOOL     | BRANCH         | GIT_SERVER_CR_NAME | GIT_SERVER_CR_VERSION | GIT_SERVER     | GIT_SSH_PORT   | GIT_USERNAME   | GIT_CREDENTIALS_ID | REPOSITORY_PATH | JIRA_INTEGRATION_ENABLED | Process Job DSLs |
#
##  @Smoke
##  Scenario Outline: Create secret with ssh key for Gitlab integration
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User clicks 'OpenShift' link
##    And User clicks 'SSO' button
###    And User clicks 'Resources' button
###    And User clicks 'Secrets' button
##    And User clicks 'Add to Project' button
##    And User selects 'Import YAML  JSON' option
##    And User enters "<sshKey>" Gitlab ssh key
##    And User clicks 'Create secret' button
##    And User clicks 'Create secret' button
##    Examples:
##      | username | password | sshKey           |
##      | username | password | gitlabSshKeyYaml |
#
##  @Smoke
##  Scenario Outline: Create Git Server for Gitlab integration
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User clicks 'OpenShift' link
##    And User clicks 'SSO' button
###    And User clicks 'Resources' button
###    And User clicks 'Secrets' button
##    And User clicks 'Add to Project' button
##    And User selects 'Import YAML  JSON' option
##    And User enters "<gitServer>" Gitlab git server
##    And User clicks 'Create secret' button
##    And User clicks 'Create Anyway' button
##    And User clicks 'Create secret' button
##    Examples:
##      | username | password | gitServer       |
##      | username | password | gitlabGitServer |
#
###############################################################
############################################################### APPLICATION
###############################################################
##
#
##  @smoke
##  Scenario Outline: Create application using Create strategy
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
# ##   And User enters "<firstName>" first name
###    And User enters "<lastName>" last name
###    And User clicks 'Submit' button
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    And User clicks 'Overview' tab
##    And User clicks 'Jenkins' link
##    And User clicks "<codebaseJenkinsFolder>" codebase jenkins folder
##    And User sees success status for "<createReleaseJob>" create release job
##    And User sees success status for "<buildJob>" build job
##    And User click 'Gerrit' link
#
#
##    And User clicks 'Manage Jenkins' button
##    And User click 'Gerrit' link
##    And User clicks 'Browse' button
##    And User clicks 'VCS' link
##    And User clicks 'delete codebase' button
##    And User enters "<applicationName>" in confirmation name field
##    And User clicks 'Delete confirmation' button
#
##    And User deletes "<applicationName>" codebase by request
#
##    Examples:
##      | applicationName     | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | username | password | firstName | lastName | codebaseJenkinsFolder | buildJob                         | createReleaseJob                   | buildVersion            |
##      | java8-maven-create7 | Create           | Java         | java8           | Maven     | master     | master            | default        | username | password | firstName | lastName | java8-maven-create7   | MASTER-Build-java8-maven-create7 | Create-release-java8-maven-create7 | 1-master-0.0.1-snapshot |
##      | java11-maven-create2 | Create           | Java         | java11          | Maven     | master     | master            | default        | username | password | firstName | lastName | java11-maven-create2  | MASTER-Build-java11-maven-create2 | Create-release-java11-maven-create2 |                         |
##      | java8-gradle-create1    | Create           | Java         | java8           | Gradle    | master     | master            | default        | username | password |
##      | java11-gradle-create1   | Create           | Java         | java11          | Gradle    | master     | master            | default        | username | password |
##      | dotnet-2-1-create1      | Create           | DotNet       | dotnet-2.1      | dotnet    | master     | master            | default        | username | password |
##      | dotnet-3-1-create1      | Create           | DotNet       | dotnet-3.1      | dotnet    | master     | master            | default        | username | password |
##      | python-3-8-create1      | Create           | Python       | python-3.8      | Python    | master     | master            | default        | username | password |
##      | javascript-create1      | Create           | JavaScript   | react           | NPM       | master     | master            | default        | username | password |
##      | go-beego-create1        | Create           | Go           | beego           | Go        | master     | master            | default        | username | password |
##      | go-operator-sdk-create1 | Create           | Go           | operator-sdk    | Go        | master     | master            | default        | username | password |
###
##  @smoke
##  Scenario Outline: Create multi-module application using Create strategy
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User checks 'Multi-module Project' checkbox
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    And User deletes "<applicationName>" codebase by request
##
##    Examples:
##      | applicationName          | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName |versioningType|
##      | java8-maven-mult-create  | Create           | Java         | java8           | Maven     | master     | master            |default       |
##      | java11-maven-mult-create | Create           | Java         | java11          | Maven     | master     | master            |default       |
##
##
##  @smoke
##  Scenario Outline: Create application using Clone strategy (Gitlab)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User enters "<repository>" in git repository url field
##    And User checks 'Codebase Authentication' check-box
##    And User enters "<repositoryLogin>" for Gitlab in repository login field
##    And User enters "<repositoryPassword>" for Gitlab in repository password field
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName              | codebaseStrategy | repository            | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName |versioningType|
##      | java8-maven-clone-gitlab     | Clone            | java8-gitlab          | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            |default       |
##      | java11-gradle-clone-gitlab   | Clone            | java11-gitlab         | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Gradle    | master     | master            |default       |
##      | dotnet-3-1-clone-gitlab      | Clone            | dotnet31-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-3.1      | dotnet    | master     | master            |default       |
##      | python-3-8-clone-gitlab      | Clone            | python38-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Python       | python-3.8      | Python    | master     | master            |default       |
##      | javascript-clone-gitlab      | Clone            | javascript-gitlab     | gitlabRepositoryLogin | gitlabRepositoryPassword | JavaScript   | react           | NPM       | master     | master            |default       |
##      | go-beego-clone-gitlab        | Clone            | go-beego-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | beego           | Go        | master     | master            |default       |
##      | go-operator-sdk-clone-gitlab | Clone            | go-operatorsdk-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | operator-sdk    | Go        | master     | master            |default       |
##      | dotnet-2-1-clone-gitlab      | Clone            | go-operatorsdk-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-2.1      | dotnet    | master     | master            |default       |
##
##  @smoke
##  Scenario Outline: Create multi-module application using Clone strategy (Gitlab)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User enters "<repository>" in git repository url field
##    And User checks 'Codebase Authentication' check-box
##    And User enters "<repositoryLogin>" for Gitlab in repository login field
##    And User enters "<repositoryPassword>" for Gitlab in repository password field
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User checks 'Multi-module Project' checkbox
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName                | codebaseStrategy | repository    | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName |versioningType|
##      | java8-maven-mult-clone-gitlab  | Clone            | java8-gitlab  | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            |default       |
##      | java11-maven-mult-clone-gitlab | Clone            | java11-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Maven     | master     | master            |default       |
##
##  @smoke
##  Scenario Outline: Create application using Clone strategy (Github)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User enters "<repository>" in git repository url field
##    And User checks 'Codebase Authentication' check-box
##    And User enters "<repositoryLogin>" for Github in repository login field
##    And User enters "<repositoryPassword>" for Github in repository password field
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName          | codebaseStrategy | repository         | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName |versioningType|
##      | java8-maven-clone-github | Clone            | java8-mavem-github | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            |default       |
##      | python-3-8-clone-github  | Clone            | python38-github    | githubRepositoryLogin | githubRepositoryPassword | Python       | python-3.8      | Python    | master     | master            |default       |
##      | javascript-clone-github  | Clone            | javascript-github  | githubRepositoryLogin | githubRepositoryPassword | JavaScript   | react           | NPM       | master     | master            |default       |
##
##  @smoke
##  Scenario Outline: Create multi-module application using Clone strategy (Github)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User enters "<repository>" in git repository url field
##    And User checks 'Codebase Authentication' check-box
##    And User enters "<repositoryLogin>" for Github in repository login field
##    And User enters "<repositoryPassword>" for Github in repository password field
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User checks 'Multi-module Project' checkbox
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName               | codebaseStrategy | repository         | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName |versioningType|
##      | java8-maven-mult-clone-github | Clone            | java8-mavem-github | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            |default       |
##
##  @smoke
##  Scenario Outline: Create application using Import strategy (gitlab)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User selects "<gitServer>" git server
##    And User enters "<relativePath>" repository relative path
##    And User clicks 'Proceed' button
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName            | codebaseStrategy | gitServer | relativePath          | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner |versioningType|
##      | java11-gradle              | Import           | git-epam  | java11-gitlab         | Java         | java11          | Gradle    | master     | master            | gitlab                |default       |
##      | test-springboot-helloworld | Import           | git-epam  | java8-gitlab          | Java         | java8           | Maven     | master     | master            | gitlab                |default       |
##      | dotnet-dotnet-dotnet-3-1   | Import           | git-epam  | dotnet31-gitlab       | DotNet       | dotnet-3.1      | dotnet    | master     | master            | gitlab                |default       |
##      | python-python-python-3-8   | Import           | git-epam  | python38-gitlab       | Python       | Python-3.8      | Python    | master     | master            | gitlab                |default       |
##      | edp-react-helloworld       | Import           | git-epam  | javascript-gitlab     | JavaScript   | react           | NPM       | master     | master            | gitlab                |default       |
##      | go-go-beego                | Import           | git-epam  | go-beego-gitlab       | Go           | beego           | Go        | master     | master            | gitlab                |default       |
##      | go-go-operator-sdk         | Import           | git-epam  | go-operatorsdk-gitlab | Go           | operator-sdk    | Go        | master     | master            | gitlab                |default       |
##
##  @smoke
##  Scenario Outline: Create multi-module application using Import strategy (gitlab)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User selects "<gitServer>" git server
##    And User enters "<relativePath>" repository relative path
##    And User clicks 'Proceed' button
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User checks 'Multi-module Project' checkbox
##    And User clicks 'Proceed' button
##    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName            | codebaseStrategy | gitServer | relativePath          | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner |versioningType|
##      | test-springboot-helloworld | Import           | git-epam  | java8-gitlab          | Java         | java8           | Maven     | master     | master            | gitlab                |default       |
##
##  @smoke
##  Scenario Outline: Create application using Import strategy (github)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User selects "<gitServer>" git server
##    And User enters "<relativePath>" relative path for github repository
##    And User clicks 'Proceed' button
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName           | codebaseStrategy | gitServer | relativePath          | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner |versioningType|
##      | edp-springboot-helloworld | Import           | github    | java8-mavem-github    | Java         | java8           | Maven     | master     | master            | github                |default       |
##      | python-3-8                | Import           | github    | python38-github       | Python       | Python-3.8      | Python    | master     | master            | github                |default       |
##      | edp-javascript-project    | Import           | github    | javascript-github     | JavaScript   | react           | NPM       | master     | master            | github                |default       |
##
##  @smoke
##  Scenario Outline: Create multi-module application using Import strategy (github)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User selects "<gitServer>" git server
##    And User enters "<relativePath>" relative path for github repository
##    And User clicks 'Proceed' button
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User checks 'Multi-module Project' checkbox
##    And User clicks 'Proceed' button
##    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName           | codebaseStrategy | gitServer | relativePath       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner |versioningType|
##      | edp-springboot-helloworld | Import           | github    | java8-mavem-github | Java         | java8           | Maven     | master     | master            | github                |default       |
#
#  ############################ APPLICATIONS EDP VERSIONING TYPE
##  @smoke
##  Scenario Outline: Create Gitlab API token in Jenkins
##    Given User opens EDP Admin Console
##    When User enters "<username>" in username field
##    And User enters "<password>" in password field
##    And User clicks 'login' button
##    And User clicks 'Overview' tab
##  And User clicks 'Jenkins' link
##    And User clicks 'Manage Jenkins' button
##    Examples:
##      | username | password |
##      | username | password |
##  @smoke
##  Scenario Outline: Create application using Create strategy (EDP versioning Type)
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User enters "<startVersion>" start version
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Proceed' button
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
###    And User deletes "<applicationName>" codebase by request
##
##    Examples:
##      | applicationName                 | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType | startVersion |
##      | java8-maven-create-edp-vers     | Create           | Java         | java8           | Maven     | master     | master            | edp            | 1.2.3        |
##      | java11-maven-create-edp-vers    | Create           | Java         | java11          | Maven     | master     | master            | edp            | 1.2.3        |
##      | java8-gradle-create-edp-vers    | Create           | Java         | java8           | Gradle    | master     | master            | edp            | 1.2.3        |
##      | java11-gradle-create-edp-vers   | Create           | Java         | java11          | Gradle    | master     | master            | edp            | 1.2.3        |
##      | dotnet-2-1-create-edp-vers      | Create           | DotNet       | dotnet-2.1      | dotnet    | master     | master            | edp            | 1.2.3        |
##      | dotnet-3-1-create-edp-vers      | Create           | DotNet       | dotnet-3.1      | dotnet    | master     | master            | edp            | 1.2.3        |
##      | python-3-8-create-edp-vers      | Create           | Python       | python-3.8      | Python    | master     | master            | edp            | 1.2.3        |
##      | javascript-create-edp-vers      | Create           | JavaScript   | react           | NPM       | master     | master            | edp            | 1.2.3        |
##      | go-beego-create-edp-vers        | Create           | Go           | beego           | Go        | master     | master            | edp            | 1.2.3        |
##      | go-operator-sdk-create-edp-vers | Create           | Go           | operator-sdk    | Go        | master     | master            | edp            | 1.2.3        |
#
###################################################################
################################################################### LIBRARY
###################################################################
##  @smoke
##  Scenario Outline: Create library using Create strategy
##    Given User opens EDP Admin Console
##    When User clicks on Libraries tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##
##    Examples:
##      | applicationName          | codebaseStrategy | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName |versioningType|
##      | java8-maven-lib-create   | Create           | Java         | java8           | Maven     | master     | master            |default       |
##      | java8-gradle-lib-create  | Create           | Java         | java8           | Gradle    | master     | master            |default       |
##      | java11-maven-lib-create  | Create           | Java         | java11          | Maven     | master     | master            |default       |
##      | java11-gradle-lib-create | Create           | Java         | java11          | Gradle    | master     | master            |default       |
##      | javascript-lib-create    | Create           | JavaScript   | react           | NPM       | master     | master            |default       |
##      | dotnet-2-1-lib-create    | Create           | DotNet       | dotnet-2.1      | dotnet    | master     | master            |default       |
##      | dotnet-3-1-lib-create    | Create           | DotNet       | dotnet-3.1      | dotnet    | master     | master            |default       |
##      | python-lib-create        | Create           | Python       | python-3.8      | Python    | master     | master            |default       |
##
##  @smoke
##  Scenario Outline: Create library using Clone strategy (Gitlab)
##    Given User opens EDP Admin Console
##    When User clicks on Libraries tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User enters "<repository>" in git repository url field
##    And User checks 'Codebase Authentication' check-box
##    And User enters "<repositoryLogin>" for Gitlab in repository login field
##    And User enters "<repositoryPassword>" for Gitlab in repository password field
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##
##    Examples:
##      | applicationName                | codebaseStrategy | repository            | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName |versioningType|
##      | java8-maven-lib-gitlab-clone   | Clone            | java8-gitlab          | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java8           | Maven     | master     | master            |default       |
##      | java11-gradle-lib-gitlab-clone | Clone            | java11-gitlab         | gitlabRepositoryLogin | gitlabRepositoryPassword | Java         | java11          | Gradle    | master     | master            |default       |
##      | dotnet-3-1-lib-gitlab-clone    | Clone            | dotnet31-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | DotNet       | dotnet-3.1      | dotnet    | master     | master            |default       |
##      | python-3-8-lib-gitlab-clone    | Clone            | python38-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Python       | python-3.8      | Python    | master     | master            |default       |
##      | javascript-lib-gitlab-clone    | Clone            | javascript-gitlab     | gitlabRepositoryLogin | gitlabRepositoryPassword | JavaScript   | react           | NPM       | master     | master            |default       |
##      | go-beego--lib-gitlab-clone     | Clone            | go-beego-gitlab       | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | beego           | Go        | master     | master            |default       |
##      | go-operator-sdk-gitlab-clone   | Clone            | go-operatorsdk-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | operator-sdk    | Go        | master     | master            |default       |
##      | dotnet-2-1-clone-gitlab        | Clone            | go-operatorsdk-gitlab | gitlabRepositoryLogin | gitlabRepositoryPassword | Go           | operator-sdk    | Go        | master     | master            |default       |
#
##  @smoke
##  Scenario Outline: Create library using Clone strategy (Github)
##    Given User opens EDP Admin Console
##    When User clicks on Libraries tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User enters "<repository>" in git repository url field
##    And User checks 'Codebase Authentication' check-box
##    And User enters "<repositoryLogin>" for Github in repository login field
##    And User enters "<repositoryPassword>" for Github in repository password field
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName          | codebaseStrategy | repository         | repositoryLogin       | repositoryPassword       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | versioningType |
##      | java8-maven-clone-github | Clone            | java8-mavem-github | githubRepositoryLogin | githubRepositoryPassword | Java         | java8           | Maven     | master     | master            | default        |
##      | python-3-8-clone-github  | Clone            | python38-github    | githubRepositoryLogin | githubRepositoryPassword | Python       | python-3.8      | Python    | master     | master            | default        |
##      | javascript-clone-github  | Clone            | javascript-github  | githubRepositoryLogin | githubRepositoryPassword | JavaScript   | react           | NPM       | master     | master            | default        |
#
##  @smoke
##  Scenario Outline: Create library using Import strategy (gitlab)
##    Given User opens EDP Admin Console
##    When User clicks on Libraries tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User selects "<gitServer>" git server
##    And User enters "<relativePath>" repository relative path
##    And User clicks 'Proceed' button
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    And User deletes "<applicationName>" codebase by request
##    Examples:
##      | applicationName            | codebaseStrategy | gitServer | relativePath          | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType |
##      | java11-gradle              | Import           | git-epam  | java11-gitlab         | Java         | java11          | Gradle    | master     | master            | gitlab                | default        |
##      | test-springboot-helloworld | Import           | git-epam  | java8-gitlab          | Java         | java8           | Maven     | master     | master            | gitlab                | default        |
##      | dotnet-dotnet-dotnet-3-1   | Import           | git-epam  | dotnet31-gitlab       | DotNet       | dotnet-3.1      | dotnet    | master     | master            | gitlab                | default        |
##      | python-python-python-3-8   | Import           | git-epam  | python38-gitlab       | Python       | Python-3.8      | Python    | master     | master            | gitlab                | default        |
##      | edp-react-helloworld       | Import           | git-epam  | javascript-gitlab     | JavaScript   | react           | NPM       | master     | master            | gitlab                | default        |
##      | go-go-beego                | Import           | git-epam  | go-beego-gitlab       | Go           | beego           | Go        | master     | master            | gitlab                | default        |
##      | go-go-operator-sdk         | Import           | git-epam  | go-operatorsdk-gitlab | Go           | operator-sdk    | Go        | master     | master            | gitlab                | default        |
#
##  @smoke
##  Scenario Outline: Create library using Import strategy (github)
##    Given User opens EDP Admin Console
##    When User clicks on Libraries tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User selects "<gitServer>" git server
##    And User enters "<relativePath>" relative path for github repository
##    And User clicks 'Proceed' button
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<ciPipelineProvisioner>" ci pipeline provisioner
##    And User selects "<versioningType>" codebase versioning type
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName           | codebaseStrategy | gitServer | relativePath       | codeLanguage | languageVersion | buildTool | branchName | defaultBranchName | ciPipelineProvisioner | versioningType |
##      | edp-springboot-helloworld | Import           | github    | java8-mavem-github | Java         | java8           | Maven     | master     | master            | github                | default        |
##      | python-3-8                | Import           | github    | python38-github    | Python       | Python-3.8      | Python    | master     | master            | github                | default        |
##      | edp-javascript-project    | Import           | github    | javascript-github  | JavaScript   | react           | NPM       | master     | master            | github                | default        |
#
#
##########################
#
##  @smoke
##  Scenario Outline: Create library using Clone strategy (Gitlab)!(Will be used later)!
##    Given User opens EDP Admin Console
##    When User clicks on Libraries tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User enters "<repository>" in git repository url field
##    And User checks 'Codebase Authentication' check-box
##    And User enters "<repositoryLogin>" in repository login field
##    And User enters "<repositoryPassword>" in repository password field
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User checks 'Integrate with Jira' checkbox
##    And User selects "<jiraServer>" Jira Server
##    And User specify "<commitMessagePattern>" the pattern to validate commit message
##    And User specify "<jiraTicketPattern>" the  pattern to find a Jira ticket number in a commit message
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    Examples:
##      | applicationName         | codebaseStrategy | repository            | repositoryLogin | repositoryPassword | codeLanguage | languageVersion | buildTool | versioningType | jiraServer | commitMessagePattern   | jiraTicketPattern | branchName |
##      | java8-maven-lib-clone1  | Clone            | java8-gitlab          | repositoryLogin | repositoryPassword | Java         | java8           | Maven     | default        | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | master     |
##      | java11-gradle-lib-clone | Clone            | java11-gitlab         | repositoryLogin | repositoryPassword | Java         | java11          | Gradle    | default        | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | master     |
##      | dotnet-3-1-lib-clone    | Clone            | dotnet31-gitlab       | repositoryLogin | repositoryPassword | DotNet       | dotnet-3.1      | dotnet    | default        | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | master     |
##      | python-3-8-lib-clone    | Clone            | python38-gitlab       | repositoryLogin | repositoryPassword | Python       | python-3.8      | Python    | default        | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | master     |
##      | javascript-lib-clone    | Clone            | javascript-gitlab     | repositoryLogin | repositoryPassword | JavaScript   | react           | NPM       | default        | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | master     |
##      | go-beego--lib-clone     | Clone            | go-beego-gitlab       | repositoryLogin | repositoryPassword | Go           | beego           | Go        | default        | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | master     |
##      | go-operator-sdk-clone   | Clone            | go-operatorsdk-gitlab | repositoryLogin | repositoryPassword | Go           | operator-sdk    | Go        | default        | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | master     |
#
#
##  @smoke
##  Scenario Outline: Create application using Create strategy Full
##    Given User opens EDP Admin Console
##    When User clicks on Application tab
##    And User clicks 'Create' button
##    And User selects "<codebaseStrategy>" codebase integration strategy
##    And User clicks 'Proceed' button
##    And User enters "<applicationName>" in application name field
##    And User enters "<defaultBranchName>" default branch name
##    And User selects "<codeLanguage>" application code language
##    And User selects "<languageVersion>" language version
##    And User selects "<buildTool>" build tool
##    And User clicks 'Proceed' button
##    And User selects "<versioningType>" codebase versioning type
##    And User selects "<deploymentScript>" deployment script
##    And User checks 'Integrate with Jira' checkbox
##    And User selects "<jiraServer>" Jira Server
##    And User specify "<commitMessagePattern>" the pattern to validate commit message
##    And User specify "<jiraTicketPattern>" the  pattern to find a Jira ticket number in a commit message
##    And User clicks 'Proceed' button
##    And User checks 'Need Route' checkbox
##    And User enters "<routeName>" in route name field
##    And User enters "<routePath>" in route path field
##    And User clicks 'Proceed' button
##    And User checks 'Need Database' checkbox
##    And User selects "<databaseType>" database type
##    And User selects "<databaseVersion>" database version
##    And User enters "<databaseCapacity>" database capacity
##    And User selects "<capacityUnit>" capacity unit
##    And User selects "<persistentStorage>" persistent storage
##    And User clicks 'Create' button
##    And User clicks 'Continue' button in confirmation popup
##    Then User sees success status for "<applicationName>" application name
##    And User clicks "<applicationName>" application name
##    And User sees success status in Branches section for "<branchName>" branch
##    And User clicks 'Create' button
##    And User enters "<newBranchName>" branch name
##    And User clicks 'Proceed' button
##    And User sees success status in Branches section for "<branchName>" branch
##    And User sees success status in Branches section for "<newBranchName>" branch
##    And User clicks on Continuous Delivery tab
###    And User clicks 'Create' button
##    And User clicks 'Create' button in CD pipeline tab
##    And User enters "<cdPipelineName>" cd pipeline name
##    And User clicks 'Proceed' button
##    And User select "<applicationName>" application by checkbox
##    And User selects "<dockerStream>" docker stream
##    And User clicks 'Proceed' button
##    And User clicks 'Add CD pipeline stage' button
##    And User enters "<stageName>" cd pipeline stage name
##    And User enters "<stageDescription>" description
##    And User selects "<qualityGateType>" quality gate type
##    And User enters "<stepName>" step name
###    And User selects "<autotest>" autotest
###    And User selects "<autotestsBranch>" autotests branch
##    And User clicks 'Add' button
##    And User clicks 'Proceed' button
##    And User clicks 'Services' section
##    And User clicks 'Create' button
##   And User deletes "<applicationName>" codebase by request
#
#
#
##    Examples:
##      | applicationName      | codebaseStrategy | codeLanguage | languageVersion | buildTool | versioningType | deploymentScript   | jiraServer | commitMessagePattern   | jiraTicketPattern | routeName | routePath | databaseType | databaseVersion | databaseCapacity | capacityUnit | persistentStorage | newBranchName | branchName | cdPipelineName          | stageName | stageDescription | qualityGateType | stepName | autotest    | autotestsBranch | defaultBranchName | dockerStream         |
##      | dk-java8-auto        | Create           | Java         | java8           | Maven     | default        | helm-chart         | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | java11-maven-create  | Create           | Java         | java11          | Maven     | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | java8-gradle-create  | Create           | Java         | java8           | Gradle    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | java11-gradle-create | Create           | Java         | java11          | Gradle    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | dotnet-2-1-create    | Create           | DotNet       | dotnet-2.1      | dotnet    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | dotnet-3-1-create    | Create           | DotNet       | dotnet-3.1      | dotnet    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | python-3-8-create    | Create           | Python       | python-3.8      | Python    | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | javascript-create    | Create           | JavaScript   | react           | NPM       | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | go-beego             | Create           | Go           | beego           | Go        | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
##      | go-operator-sdk      | Create           | Go           | operator-sdk    | Go        | default        | openshift-template | epam-jira  | ^\[EPMDEDP-\d{4}\]:.*$ | EPMDEDP-\d{4}     | test2     | /         | PostgreSQL   | postgres:9.6    | 2                | Gi           | gp2               | new           | master     | java8-maven-create-pipe | sit       | sit              | manual          | sit      | allure-test | master          | master            | dk-java8-auto-master |
#
