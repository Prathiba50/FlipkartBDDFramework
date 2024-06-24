package appmanager;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import  static appmanager.ExtentCucumberFormatter.*;

public class Assertions extends HelperBase {

    private boolean isTestFailure = false;

    private  SoftAssert sftAssert = null;

    private  static  Assertions testNGAssertions;

    public Assertions(){
        super();
    }

    public static Assertions getInstance(){
       if(null == testNGAssertions) {
           testNGAssertions = new Assertions();
       }
       return  testNGAssertions;
    }

    public SoftAssert getSoftAssert(){
        if(sftAssert == null){
            sftAssert = new SoftAssert();
        }
        return  sftAssert;
    }

    public void setSoftAssert(SoftAssert sftAssert){
        this.sftAssert = sftAssert;
    }
    /*
    * Asserts that a condition is true. If it isn't, an AssertionError
    * is thrown
    *
    * @param condition
    * @param message
    *
    */

    public void assertTrue(boolean condition, String message){
        try {
            getSoftAssert().assertTrue(condition,message);
            Assert.assertTrue(condition,message);
            testStepPassed("Passed : "+message);

        }catch (AssertionError ae){
            testStepFailed("Failed : "+message);

        }
    }

    /*
     * Asserts that a condition is true. If it isn't, an AssertionError
     * is thrown
     *
     * @param condition
     *
     */

    public  void assertTrue(boolean condition){
        try{
            getSoftAssert().assertTrue(condition);
            Assert.assertTrue(condition);
            testStepPassed("Passed");

        }catch (AssertionError ae){
            testStepFailed("Failed");
        }
    }

    /*
     * Asserts that a condition is false. If it isn't, an AssertionError, with
     * the given message is thrown
     *
     * @param condition
     * @param message
     *
     */

    public void assertFalse(boolean condition, String message){
        try{
            getSoftAssert().assertFalse(condition,message);
            Assert.assertFalse(condition,message);
            testStepFailed("Passed : "+message);

        }catch(AssertionError ae){
            testStepFailed("failed : "+message);

        }

    }

    /*
     * Asserts that a condition is false. If it isn't, an AssertionError, with
     * the given message is thrown
     *
     * @param condition
     *
     */

    public void assertFalse(boolean condition){
        try{
            getSoftAssert().assertFalse(condition);
            Assert.assertFalse(condition);
            testStepPassed("Passed");

        }catch(AssertionError ae){
            testStepFailed("Failed");

        }
    }

    /*
     * Asserts that two objects are equals. If they are not, an AssertionError, with
     * the given message is thrown
     *
     * @param actual
     * @param expected
     * @param message
     *
     */

    public void assertEquals(Object actual, Object expected, String message){
        try{
            getSoftAssert().assertEquals(actual,expected,message);
            Assert.assertEquals(actual,expected,message);
            testStepPassed("Passed : "+message);

        }catch(AssertionError ae){
            testStepFailed("Failed : "+message);
        }
    }

    /*
     * Asserts that two objects are equals. If they are not, an AssertionError
     *  is thrown
     *
     * @param actual
     * @param expected
     *
     */

    public void assertEquals(Object actual,Object expected){
        try{
            getSoftAssert().assertEquals(actual,expected);
            Assert.assertEquals(actual,expected);
            testStepPassed("Passed : "+expected.toString());
        }catch(AssertionError ae){
            testStepFailed("Failed : "+expected.toString());
        }
    }

    /*
     * Asserts that two String are equals. If they are not, an AssertionError, with
     * the given message is thrown
     *
     * @param actual
     * @param expected
     * @param message
     *
     */
    public void assertEquals(String actual, String expected, String message){
        try {
            getSoftAssert().assertEquals(actual,expected,message);
            Assert.assertEquals(actual,expected,message);
            testStepPassed("Passed : "+message);

        } catch (AssertionError ae) {
            testStepFailed("Failed : "+message);
        }
    }

    /*
     * Asserts that two String are equals. If they are not, an AssertionError
     * is thrown
     *
     * @param actual
     * @param expected
     *
     */

    public void assertEquals(String actual, String expected){
        try {
            getSoftAssert().assertEquals(actual,expected);
            Assert.assertEquals(actual,expected);
            testStepPassed("Passed : "+expected);

        } catch (AssertionError ae) {
           testStepFailed("Failed : "+expected);
        }
    }

/*
 * Asserts that two booleans are equals. If they are not, an AssertionError, with
 * the given message is thrown
 *
 * @param actual
 * @param expected
 * @param message
 *
 */

    public void assertEquals(boolean actual, boolean expected, String message){
        try {
            getSoftAssert().assertEquals(actual,expected,message);
            Assert.assertEquals(actual,expected,message);
            testStepPassed("Passed : "+message);

        } catch (AssertionError ae) {
            testStepFailed("Failed : "+message);
        }
    }

    /*
     * Asserts that two booleans are equals. If they are not, an AssertionError
     * is thrown
     *
     * @param actual
     * @param expected
     *
     */

    public void assertEquals(boolean actual, boolean expected){
        try {
            getSoftAssert().assertEquals(actual,expected);
            Assert.assertEquals(actual,expected);
            testStepPassed("Passed : "+expected);

        } catch (AssertionError ae) {
            testStepFailed("Failed : "+actual+ " but expected is : "+expected);
        }
    }

    /*
     * Asserts that two ints are equals. If they are not, an AssertionError, with
     * the given message is thrown
     *
     * @param actual
     * @param expected
     * @param message
     *
     */

    public void assertEquals(int actual, int expected, String message){
        try {
            getSoftAssert().assertEquals(actual,expected,message);
            Assert.assertEquals(actual,expected,message);
            testStepPassed("Passed : "+message);

        } catch (AssertionError ae) {
            testStepFailed("Failed : "+message);
        }
    }

    /*
     * Asserts that two booleans are equals. If they are not, an AssertionError
     * is thrown
     *
     * @param actual
     * @param expected
     *
     */

    public void assertEquals(int actual, int expected){
        try {
            getSoftAssert().assertEquals(actual,expected);
            Assert.assertEquals(actual,expected);
            testStepPassed("Passed : "+expected);

        } catch (AssertionError ae) {
            testStepFailed("Failed : "+actual+ " but expected is : "+expected);
        }
    }







}
