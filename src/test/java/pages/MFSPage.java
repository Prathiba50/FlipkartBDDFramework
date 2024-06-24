package pages;

import appmanager.ApplicationManager;
import appmanager.Assertions;
import appmanager.HelperBase;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

import static appmanager.ExtentCucumberFormatter.*;

public class MFSPage extends HelperBase {

    public MFSPage(){

    }
    HelperBase helperBase = new HelperBase();

    @Value("${country}")
    public String country;

    @Value("${motherName}")
    public String motherName;

    @Value("${fatherName}")
    public String fatherName;

    @Value("${answerInput}")
    public  String answerInput;

    @Value("${btnValidate}")
    public String btnValidate;

    @Value("${ProfileNameOnHomePage}")
    public String ProfileNameOnHomePage;

    @Value("${nameInMerchant}")
    public String nameInMerchant;

    @Value("${BusinessName}")
    public String BusinessName;

    @Value("${primaryEmail}")
    public String primaryEmail;

    @Value("${contactNumber}")
    public String contactNumber;

    @Value("${bankAccount}")
    public String bankAccount;

    @Value("${Locality}")
    public String Locality;

    @Value("${language}")
    public String language;

    @Value("${protocolVersion}")
    public String protocolVersion;

    @Value("${bankName}")
    public String bankName;

    @Value("${tabMerachant}")
    public String tabMerachant;

    @Value("${btnSave}")
    public String btnSave;

    @Value("${btnProcess}")
    public String btnProcess;

    @Value("${tebRule}")
    public String tebRule;

    @Value("${txtCreateNewRule}")
    public String txtCreateNewRule;

    @Value("${ruleName}")
    public String ruleName;

    @Value("${ruleDescription}")
    public String ruleDescription;

    @Value("${serviceSelect}")
    public String serviceSelect;

    @Value("${balanceOperator}")
    public String balanceOperator;

    @Value("${balanceInputValue}")
    public String balanceInputValue;

    @Value("${transactionFlagSelect}")
    public String transactionFlagSelect;

    @Value("${fromDate}")
    public String fromDate;

    @Value("${toDate}")
    public String toDate;

    @Value("${choosecategory}")
    public String choosecategory;

    @Value("${btnCreate}")
    public String btnCreate;

    @Value("${msgSuccess}")
    public String msgSuccess;


    public void validateAllQuestions(String Country, String MotherName, String FatherName){
        try {
            if (isElementPresent(country)) {
                enterText(answerInput, Country, "Enter country");
            } else if (isElementPresent(motherName)) {
//                WebDriver wd = ApplicationManager.driver;
//                wd.quit();
//                helperBase.checkLogInUserMFS(username);
                enterText(answerInput, MotherName, "Enter MotherName");
            } else if (isElementPresent(fatherName)) {
//                WebDriver wd = ApplicationManager.driver;
//                wd.quit();
//                helperBase.checkLogInUserMFS(username);
                enterText(answerInput, FatherName, "Enter Father Name");
            }
            clickOn(btnValidate,"Validate");
            sleep(1000);
            String text = getWebElement(ProfileNameOnHomePage).getText();
            Assertions.getInstance().assertEquals(text,"prathibhasuresh50","Security validation is done successfully");
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public void registerNewMerchant(String Name, String Business, String PrimaryEmail, String ContactNumber, String BankAccountNum, String locality, String lang, String protocolVer, String bnk ){
        try{
            clickOn(tabMerachant,"Merchant");
            enterText(nameInMerchant,Name,"Name in Merchant");
            enterText(BusinessName,Business,"Business Name");
            selectFromDropdown(Locality,locality,"locality");
            enterText(primaryEmail, PrimaryEmail,"Primary Email");
            enterText(contactNumber, ContactNumber,"Contact Namber");
            selectFromDropdown(language,lang,"Language");
            selectFromDropdown(protocolVersion,protocolVer,"Protocol Version");
            selectFromDropdown(bankName,bnk,"Bank Name");
            enterText(bankAccount,BankAccountNum,"Bank Account Number");


        }catch (Exception ex){
            testStepException(new Exception().getStackTrace()[0].getMethodName(),ex);
        }

    }

    public void selectStatusAndClickSave(String status){
        try{
        clickOn("//label[text()='Status']/following::div//label[contains(text(),'"+status+"')]","Status");
        clickOn(btnSave,"Save");
        clickOn(btnProcess,"Process");

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createRule(String Name, String description, String ruleFor, String serviceSelectOptionTxt, String partyAttribute,String conditonBalance,
                           String balanceOperatorTxt, String balanceinput,String ExpOutput,String  TransactionFlag,String category){
        try{
            clickOn(tebRule,"Rules");
            clickOn(txtCreateNewRule,"Create New Rule");
            enterText(ruleName,Name,"Rule Name");
            enterText(ruleDescription,description,"Rule Description");
            clickOn("//div[@formarrayname='ruleTargets']//label[contains(text(),'"+ruleFor+"')]//span","Apply this rule for");
            selectFromDropdown(serviceSelect,serviceSelectOptionTxt,"PEER TO PEER");
            clickOn("//div[@formarrayname='dfsRuleAttribute']//label[contains(text(),'"+partyAttribute+"')]//span","Choose party attribute as RECEIVER");
            clickOn("//div[@formarrayname='dfsRuleConditions']//label[contains(text(),'"+conditonBalance+"')]//span","Balance");
            selectFromDropdown(balanceOperator,balanceOperatorTxt,"Less Than");
            enterText(balanceInputValue,balanceinput,"input Balance");
//            clickOn("//div[@formarrayname='dfsRuleOutputType']//label[contains(text(),'"+ExpOutput+"')]","Expected Output");
            selectFromDropdown(transactionFlagSelect,TransactionFlag,"Select Transaction Flag");
            enterText(fromDate,getSystemCurrentDate(),"From Date");
            enterText(toDate,addDateForCurrentDate(currentDate,1,0,0),"To Date");
            selectFromDropdown(choosecategory,category,"Choose category");
            clickOn(btnCreate,"Create");

        }catch(Exception ex){
            testStepException(new Exception().getStackTrace()[0].getMethodName(),ex);
        }
    }

    public void verifySuccessMessage(String message){
        try{
            String actualTxt = getWebElement(msgSuccess).getText();
            Assertions.getInstance().assertEquals(actualTxt,message,"Successfully validated Success message");

        }catch(Exception ex){
            testStepException(new Exception().getStackTrace()[0].getMethodName(),ex);

        }
    }


    public static String currentDate;
    public String getSystemCurrentDate(){
        LocalDate date = LocalDate.now();
        String[] splitdate = date.toString().split("-");
        currentDate = splitdate[2] +"-"+ splitdate[1] +"-"+ splitdate[0];
        return currentDate;
    }

    public static String addDateForCurrentDate(String currentDate, int day, int month,int year) {
        String[]  strtdate1 = currentDate.split("/");
        int month1 = Integer.parseInt(strtdate1[0]);
        int day1 = Integer.parseInt(strtdate1[1]);
        int year1 = Integer.parseInt(strtdate1[2]);

        LocalDate startdate = LocalDate.of(year1, month1, day1);

        LocalDate finaldate = startdate.plusYears(year).plusMonths(month).plusDays(day);

        String[]  finaldate1 = finaldate.toString().split("-");
        String addDate = finaldate1[1] +"-"+ finaldate1[2] +"-"+ finaldate1[0];

        return addDate;
    }

}
