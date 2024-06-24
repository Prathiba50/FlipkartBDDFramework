package appmanager;

import gherkin.lexer.Ro;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static appmanager.HelperBase.sleep;

public class ApplicationManager {
    public static WebDriver driver;
    private static String browser;

    static String target = System.getProperty("target","local");
    public static PropertyFileReader reader = new PropertyFileReader(String.format("local.properties",target));

    public ApplicationManager(String browser){
        this.browser=browser;
    }

    public ApplicationManager(){
    }

    public static WebDriver getWebDriver(){
        try{
            if (driver == null) {
            if("".equals(reader.get("selenium.server"))) {
                if (browser.equals((BrowserType.IE))) {
                    driver = new InternetExplorerDriver();
                    driver.manage().deleteAllCookies();
                } else if (browser.equals(BrowserType.EDGE)) {
                    File file = new File(ExtentCucumberFormatter.outputDirectory + File.separator + "TestDocuments");
                    file.mkdir();
                    String file1 = file.getAbsolutePath();
//                    System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
                  driver =  WebDriverManager.edgedriver().create();

                    Map<String, Object> edgeprefs = new HashMap<String,Object>();

                    edgeprefs.put("profile.default_content_setting.popups", 0);
                    edgeprefs.put("profile.default_content_setting_values.notifications", 2);
                    edgeprefs.put("download.default_directory", file1);
                    edgeprefs.put("profile.default_content_setting.values.automatic_downloads", 1);
                    edgeprefs.put("download.prompt_for_download", false);
//                    driver = new EdgeDriver();
                    driver.manage().deleteAllCookies();
                } else if (browser.equals(BrowserType.CHROME)) {
//                    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//                    WebDriverManager.chromedriver().setup();
                    File file = new File(ExtentCucumberFormatter.outputDirectory + File.separator + "TestDocuments");
                    file.mkdir();
                    HashMap<String, Object> chromeprefs = new HashMap<String,Object>();

                    chromeprefs.put("profile.default_content_setting.popups", 0);
                    chromeprefs.put("profile.content_setting.exceptions.automatic_download.*.setting", 1);
                    chromeprefs.put("download.prompt_for_download", false);
                    chromeprefs.put("download.default_directory", file.getAbsolutePath());

                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", chromeprefs);
//                    options.addArguments("--test-type");
                    options.addArguments("--disable-extensions");
                    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

                   driver = WebDriverManager.chromedriver().capabilities(options).create();
//                    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//                    driver = new ChromeDriver(options);
                    driver.manage().deleteAllCookies();
                }
            }else{
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName(browser);
                    try{
                        driver = new RemoteWebDriver(new URL(reader.get("selenium.server")),capabilities);

                    }catch(MalformedURLException e){
                        e.printStackTrace();
                    }
                }

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                return driver;
            }else{
               return driver;
            }
        }catch(Exception e){
           e.printStackTrace();
        }

        return null;
    }

//Use instead above
//    public static WebDriver getWebDriver() {
//        if (driver == null) {
//            if (browser.equals(BrowserType.IE)) {
//                //System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
//                WebDriverManager.iedriver().setup();
//                driver = new InternetExplorerDriver();
//                driver.manage().deleteAllCookies();
//            } else if (browser.equals(BrowserType.CHROME)) {
//                //System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//                WebDriverManager.chromedriver().setup();
////                WebDriverManager.edgedriver().create();
////                driver = new ChromeDriver();
//                driver.manage().deleteAllCookies();
//            }
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//            return driver;
//        }else{
//            return driver;
//        }
//
//    }
    public void initUrl1(String userName){
        try{
            getWebDriver().get(reader.get("web.Url"));
//            String pwd = new String(reader.get(""+userName+""));

        }catch(Exception ex){

        }

    }

//    public  void initUrl2()  {
//        try {
//            getWebDriver().get(reader.get("web.Url"));
//            getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public  void initUrl()  {
        try {
            getWebDriver().get(reader.get("web.Url"));
            Robot robot = new Robot();
            sleep(1000);


            robot.keyPress(KeyEvent.VK_ENTER);
            sleep(2000);
            getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }



    public void initUrlHRM(String userName) {
        try {
//            String userid="fhlbny\\" + userName;
            //      String userid = userName;
            getWebDriver().get(reader.get("web.Url"));
            Robot robot = new Robot();
            sleep(1000);

            robot.keyPress(KeyEvent.VK_ENTER);
            sleep(2000);
            String pwd = new String(reader.get("" + userName + ""));
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='txtUsername']")));
            driver.findElement(By.xpath("//input[@name='txtUsername']")).clear();
            driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(userName);
            driver.findElement(By.xpath("//input[@name='txtPassword']")).clear();
            driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(pwd);
            driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
            sleep(3000);

            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Welcome')]")));
//            LoggedInUser = userName; //Need to create method for LoggedInUser for reuse
//            Robot robot = new Robot();
//            robotType(robot, userid);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robotType(robot, pwd);
//            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertFalse(true, "Application is down or username is not displayed");
        }
    }

    public void initUrlMFS(String userName) {
        try {
//            String userid="fhlbny\\" + userName;
            //      String userid = userName;
            getWebDriver().get(reader.get("web.Url"));
            Robot robot = new Robot();
            sleep(1000);

            robot.keyPress(KeyEvent.VK_ENTER);
            sleep(2000);
            String pwd = new String(reader.get("" + userName + ""));
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
            driver.findElement(By.xpath("//input[@name='username']")).clear();
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
            driver.findElement(By.xpath("//input[@name='password']")).clear();
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
            driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
            sleep(3000);

            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Security Validate']")));
//            LoggedInUser = userName; //Need to create method for LoggedInUser for reuse
//            Robot robot = new Robot();
//            robotType(robot, userid);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robotType(robot, pwd);
//            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertFalse(true, "Application is down or username is not displayed");
        }
    }


    public static void robotType(Robot robot, String characters) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(characters);
        clipboard.setContents(stringSelection, null);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(1000);
    }


}



