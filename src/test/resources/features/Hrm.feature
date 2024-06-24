Feature: FlipKart_HomePage

  @Smoke
  Scenario Outline: Validate Holidays List in tHRM Application
    Given User launches the HRM application with: "<username>"
    When user fetch and validate List of holidays
    Then user validate phone number of each department in an Important Contacts
    Then User validate Important Contacts: "<ItSupportPhone>" and "<FacilityPhone>" and "<AccountPhone>" and "<HrmPhone>"


    Examples:
      | username   | ItSupportPhone | FacilityPhone | AccountPhone | HrmPhone   |
      | prathibhak | 9900294928     | 9986372258    | 9880338093   | 9739487860 |

  @Smoke
  Scenario Outline: Validate Holidays List in tHRM Application
    Given User launches the HRM application with: "<username>"
    When User fill required details in request WFH

    Examples:
      | username   |
      | prathibhak |
