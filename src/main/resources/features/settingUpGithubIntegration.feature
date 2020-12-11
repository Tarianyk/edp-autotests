#Feature: Github_integration
#
#  @Github_integration
#  Scenario Outline: Create API token in jenkins for Github integration
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User clicks 'Jenkins' link
#    And User clicks 'Manage Jenkins' button
#    And User clicks 'Manage Credentials' button
#    And User clicks 'global' button
#    And User clicks 'Add Credentials' button
#    And User selects "<credentialsKind>" credentials kind
#    And User enters "<secret>" secret token
#    And User enters "<secretId>" secret id
#    Then User clicks 'ok' button
#
#    Examples:
#      | username | password | credentialsKind | secret            | secretId            |
#      | username | password | Secret text     | githubSecretToken | github-access-token |
#
#  @Smoke
#  Scenario Outline: Create SSH Credential for Github integrations
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User clicks 'Jenkins' link
#    And User clicks 'Manage Jenkins' button
#    And User clicks 'Manage Credentials' button
#    And User clicks 'global' button
#    And User clicks 'Add Credentials' button
#    And User selects "<credentialsKind>" credentials kind
#    And User enters "<sshKeyId>" ssh key id
#    And User clicks 'Enter directly' button
#    And User clicks 'Add ssh' button
#    And User enters "<privatSshKey>" privat ssh key
#    Then User clicks 'ok' button
#
#    Examples:
#      | username | password | credentialsKind               | sshKeyId      | privatSshKey |
#      | username | password | SSH Username with private key | github-sshkey | privatSshKey |
#
#  @Github_integration
#  Scenario Outline: Configure Github connection
#    Given User opens EDP Admin Console
#    When User enters "<username>" in username field
#    And User enters "<password>" in password field
#    And User clicks 'login' button
#    And User clicks 'Jenkins' link
#    And User clicks 'Manage Jenkins' button
#    And User clicks 'Configure System' button
#    And User clicks 'Add Github server' button
#    And User clicks 'github Server' button
#    And User enters "<githubConnectionName>" github connection name
##    And User enters "<githubHostUrl>" github host url
#    And User selects "<githubAccessApiToken>" github access api token
#    And User clicks 'Save' button
#    Examples:
#      | username | password | githubConnectionName | githubHostUrl          | githubAccessApiToken |
#      | username | password | github               | https://api.github.com | github-access-token  |
#
#  @Github_integration
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
#      | username | password | gitlab1         | master     | String Parameter | NAME          | TYPE           | BUILD_TOOL     | BRANCH         | GIT_SERVER_CR_NAME | GIT_SERVER_CR_VERSION | GIT_SERVER     | GIT_SSH_PORT   | GIT_USERNAME   | GIT_CREDENTIALS_ID | REPOSITORY_PATH | JIRA_INTEGRATION_ENABLED | Process Job DSLs |
