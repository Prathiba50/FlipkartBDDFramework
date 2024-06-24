package pages;

import appmanager.Assertions;
import appmanager.HelperBase;
import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import static appmanager.ExtentCucumberFormatter.*;


public class HrmPage extends HelperBase {

    @Value("${HolidayList}")
    public String HolidayList;

    @Value("${ITSupport}")
    public String ITSupport;

    @Value("${FacilityTeam}")
    public String FacilityTeam;

    @Value("${AccountTeam}")
    public String AccountTeam;

    @Value("${HRTeam}")
    public String HRTeam;

    @Value("${ITSupportDeptName}")
    public String ITSupportDeptName;

    @Value("${ITSupportPhone}")
    public String ITSupportPhone;

    @Value("${Closewindow}")
    public String Closewindow;


    @Value("${FacilityTeamDeptName}")
    public String FacilityTeamDeptName;

    @Value("${FacilityPhone}")
    public String FacilityPhone;


    @Value("${AccountTeamDeptName}")
    public String AccountTeamDeptName;

    @Value("${AccountPhone}")
    public String AccountPhone;

    @Value("${AccountsContactInfo}")
    public String AccountsContactInfo;

    @Value("${HRTeamDeptName}")
    public String HRTeamDeptName;

    @Value("${HRPhone}")
    public String HRPhone;

    @Value("${flexiWork}")
    public String flexiWork;

    @Value("${requestWFH}")
    public String requestWFH;

    @Value("${fullDay}")
    public String fullDay;

    @Value("${toDateCalender1}")
    public String toDateCalender1;

    @Value("${FutureToDate}")
    public String FutureToDate;

   public HrmPage(){

    }

    public void validateHolidayList(){
        List<WebElement> allElements = getWebElements(HolidayList);
        if(allElements.size() > 0){
            for(WebElement ele : allElements){
                if(isElementPresent(ele)){
                    testStepPassed("Successfully validated holiday list-->"+ele.getText());
                    System.out.println(ele.getText());
                }
            }
        }else{
            testStepFailed("No records found");
        }
    }

    public void enterValidDataInRequestWFH(){
       try{
           clickOn(flexiWork,"FlexiWork");
           sleep(2000);
           switchToTabs(1);
           jsClick(requestWFH,"request WFH");
           clickOn(fullDay,"fullDay");
           clickOn(toDateCalender1,"To Date");
           clickOn(FutureToDate,"Future To Date");
           sleep(3000);

       }catch (Exception e){
           testStepException(new Exception().getStackTrace()[0].getMethodName(), e);
       }


    }

    public void validatePhoneNumberInImportantContacts(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
//        map.put("IT Support", "9900294928");
//        map.put("Facility Team", "9986372258");
        map.put("Accounts Team", "9880338093");
        map.put("HR Team", "9739487860");

        map.forEach((k,v) -> {
            try{
                clickOn(("//fieldset[@id='panel_resizable_1_0']//table//td//a[text()='"+ k +"']"), "Department Name");
                switch (k){
//                    case "IT Support":
//                        String ITSupportActual = getWebElement(ITSupportDeptName).getText().replace(": ","");;
//                        if(ITSupportActual.contains(k)){
//                            String phone = getWebElement(ITSupportPhone).getText().replace(": ","");
//                            Assertions.getInstance().assertEquals(phone,v);
//                            jsClick(Closewindow, "close");
//                        }
//                        break;
//                    case  "Facility Team":
//                        String FaciltyActual = getWebElement(FacilityTeamDeptName).getText().replace(": ","");
//                        if(FaciltyActual.equals(k)){
//                            String phone = getWebElement(FacilityPhone).getText().replace(": ","");
//                            Assertions.getInstance().assertEquals(phone,v);
//                            clickOn(Closewindow, "close");
//                        }
//                        break;
                    case "Accounts Team":
                        String AccountsActual = getWebElement(AccountTeamDeptName).getText().replace(": ","");
                        if(AccountsActual.equals(k)){
//                            JavascriptExecutor js = (JavascriptExecutor)driver;
//                            String title = (String)js.executeScript("return document.evaluate('//*[@id='contactdetails']/text()[4]', document, null, XPathResult.STRING_TYPE, null ).stringValue;");
                            String phone = getWebElement(AccountPhone).getAttribute("textContent");
                            Assertions.getInstance().assertEquals(phone,v);
                            clickOn(Closewindow,"Close");

//                           List<WebElement> contactInfo = getWebElements(AccountsContactInfo);
//                           contactInfo.forEach(s->{
//                               if(contactInfo.size()==4){
//                                   if(isElementPresent(s)){
//                                       String phone = s.getText();
//                                       Assertions.getInstance().assertEquals(phone,v);
//                                       clickOn(Closewindow,"close");
//
//                                   }
//                               }
//                           });

                        }
                        break;
                    case "HR Team":
                        String HRActual = getWebElement(HRTeamDeptName).getText().replace(": ","");
                        if(HRActual.equals(k)){
                            String phone = getWebElement(HRPhone).getText().replace(": ","");
                            Assertions.getInstance().assertEquals(phone,v);
                            clickOn(Closewindow,"Close");
                        }
                         break;



                }

            }catch(Exception e){
                e.printStackTrace();
            }

        });


//        map.forEach(k,v) -> {
//            jsClick(By.xpath("//fieldset[@id='panel_resizable_1_0']//table//td//a[text()='"+ k +"']"));
//        }



    }

}

