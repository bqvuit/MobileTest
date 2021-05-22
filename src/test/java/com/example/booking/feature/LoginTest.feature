Feature: Test login

  Scenario Outline: Login successfully
    Given open the app
    When open Menu bar
    And navigate to Login page
    And the user logs in with <userName> and <password>
    Then the user logs in successfully

    Examples:
    |userName|password|
    |"0968440699"|"Vu123456="|

  Scenario Outline: Login failed
    Given open the app
    When open Menu bar
    And navigate to Login page
    And the user logs in with <userName> and <password>
    Then the user logs in failed

    Examples:
      |userName|password|
      |""    |"213232"|

