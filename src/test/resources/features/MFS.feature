Feature: Isha Traings(MFS)

  @Smoke
  Scenario Outline: Verify Login functionality of MFS
    Given User login to application: "<UserName>"
    When User Validate application by Entering country Father or Mother: "<country>" and "<Father>" and "<mother>"

    Examples:
      | TestCaseID | UserName | country | Father | mother         |
      | MFS_TC_01  | Asha     | India   | Radha  | NarasimhaReddy |

  @Smoke
  Scenario Outline: User Register new Merchant and Validate in Home tab
    Given User login to application: "<UserName>"
    When User Validate application by Entering country Father or Mother: "<country>" and "<Father>" and "<mother>"
    When User enters all required details and save: "<Name>" and "<Business>" and "<PrimaryEmail>" and "<ContactNumber>" and "<BankAccountNum>" and "<Locality>" and "<language>" and "<protocolVersion>" and "<Bank>"
    Then  user selects status and click save: "<status>"



    Examples:
      | TestCaseID | UserName | country | Father | mother         | Name      | Business     | PrimaryEmail        | ContactNumber | BankAccountNum | Locality       | language | protocolVersion | Bank      | status     |
      | MFS_TC_02  | Asha     | India   | Radha  | NarasimhaReddy | MerchantA | IT Solutions | Merchant1@gmail.com | 9846537987    | ICIC394379     | Bengaluru-East | ENGLISH  | VERSION 1.0     | Test Bank | REGISTERED |


  @Smoke
  Scenario Outline: User creates new rule and Validate in Rule list
    Given User login to application: "<UserName>"
    When User Validate application by Entering country Father or Mother: "<country>" and "<Father>" and "<mother>"
    Then Userenters all required details to  create new rule: "<Name>" and "<description>" and "<ruleFor>" and "<serviceSelectOptionTxt>" and "<partyAttribute>" and "<conditonBalance>" and "<balanceOperatorTxt>" and "<balanceinput>" and "<ExpOutput>" and "<TransactionFlag>" and "<category>"
    Then User Verify success message:"<message>"

    Examples:
      | TestCaseID | UserName | country | Father | mother         | Name            | description             | ruleFor | serviceSelectOptionTxt | partyAttribute | conditonBalance | balanceOperatorTxt | balanceinput | ExpOutput          | TransactionFlag | category         | message |
      | MFS_TC_02  | Asha1    | India   | Radha  | NarasimhaReddy | Rule Automation | knowledge on Automation | SERVICE | BANK CASH IN           | INITIATOR      | BALANCE         | Less Than          | 3000         | TRANSACTION_FLAG * | TRUE            | Regular interval | Success |
