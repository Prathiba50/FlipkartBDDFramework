package pages;

import appmanager.Assertions;
import appmanager.HelperBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static appmanager.ApplicationManager.getWebDriver;
import static appmanager.ExtentCucumberFormatter.*;

public class FlipHomePage extends HelperBase {

    public FlipHomePage(){

    }

    @Value("${searchItem}")
    public String searchItem;

    @Value("${searchDropDown}")
    public String searchDropDown;

    @Value("${listOfProductNames}")
    public String listOfProductNames;

    @Value("${listOfProductPrices}")
    public String listOfProductPrices;

    @Value("${totalResults}")
    public String totalResults;

    @Value("${paginationTotal}")
    public String paginationTotal;

    @Value("${paginationNextButton}")
    public String paginationNextButton;

    @Value("${allExistingProducts}")
    public String allExistingProducts;

    public void verifyLoadingTimeOfHomePage(){
        try {
            long startTime = System.currentTimeMillis();
            WebDriver wd = getWebDriver();
            JavascriptExecutor js =(JavascriptExecutor)wd;
            long endTime = ((Number) js.executeScript(
                    "return window.performance.timing.loadEventEnd")).longValue();
            long loadingTime = startTime - endTime;
            testStepInfo("Page loaded is-> "+loadingTime+" milliseconds");
            System.out.println("Page loaded is-> "+loadingTime+" milliseconds");
        }catch (Exception ex){
            testStepFailed("Exception caught Message is -> " +ex.getMessage());
        }

    }

    public void searchProductAndCountProducts(String product){
        try{
            clickOn(searchItem,"Search Item");
            enterText(searchItem,product,"Iphone");
            clickOn(searchDropDown,"Click first product fro the list");
            String results = getWebElement(totalResults).getText();
            testStepInfo("Total showing results are: "+results);
        }catch(Exception ex){
            testStepException(new Exception().getStackTrace()[0].getMethodName(),ex);
        }
    }

    public void fetchAllProductsAndPrices(){
        try{
//            clickOn(paginationTotal,"PaginationTotal");
            int lastrecord = getLastRecordCount();
            for(int i =0; i<=lastrecord;i++) {
                List<WebElement> productNames = getWebElements(listOfProductNames);
                for (WebElement ele : productNames) {
                    String text = ele.getText();
                    System.out.println(text);
                }

                List<WebElement> productPrices = getWebElements(listOfProductPrices);
                for (WebElement ele1 : productPrices) {
                    String text = ele1.getText().replaceAll("[^0-9]", "");
                    System.out.println(text);
                }
                clickOn(paginationNextButton,"Next");
            }


        }catch (Exception ex){
            testStepException(new Exception().getStackTrace()[0].getMethodName(),ex);

        }
    }

    public void validateAllProduct(){
        try {
            List<WebElement> list = getWebElements(allExistingProducts);
            testStepInfo("Below all Element is available in the list");
            for (WebElement we : list){
                if(isElementPresent(we)) {
                    testStepInfo(we.getText());
                }
                else {
                    testStepFailed(we.getText()+ " Element is not available in the list");
                }
            }

        }catch(Exception ex) {
            testStepException(new Exception().getStackTrace()[0].getMethodName(),ex);
        }
    }

}
