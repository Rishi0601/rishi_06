package pages;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.SignInpageException;
import uistore.ElectronicsPageLocators;
import uistore.FillformPageLocators;
import uistore.HomepageLocators;
import uistore.LEDLightsPageLocators;
import uistore.SignInPageLocators;
import utils.Base;
import utils.ExcelUtils;
import utils.ExtentReporter;
import utils.TakeScreenshot;
import utils.WebDriverAssistance;

public class SignInpage extends Base{

    WebDriverAssistance driverAsst=new WebDriverAssistance();
    HomepageLocators home=new HomepageLocators();
    ElectronicsPageLocators electronics=new ElectronicsPageLocators();
    FillformPageLocators form=new FillformPageLocators();
    SignInPageLocators signin=new SignInPageLocators();
    LEDLightsPageLocators led=new LEDLightsPageLocators();
    String filePath=System.getProperty("user.dir")+"/testdata/testdata.xlsx";

    public void  preSteps(ExtentTest test){
        driverAsst.hoverOverElement(home.hoverOverSignInJoinIn,test); 
        String testDesc="Join free";
        driverAsst.clickOnElement(home.clickJoinFree,testDesc,test);
        driverAsst.waitForElementToBeVisible(signin.verifyAccount,10);
        String testDesc1="Sign in now";
        driverAsst.clickOnElement(signin.clickSignInNow,testDesc1,test);
        
    }

    public void hoverOnLanguageDropdown(ExtentTest test) {
        preSteps(test);
        driverAsst.hoverOverElement(signin.hoverOnDropdown,test);

    }

    public void  selectEspanolAndVerify(ExtentTest test){
        try{
            hoverOnLanguageDropdown(test);
            String input=ExcelUtils.readdata(filePath, "Sheet1", 4, 2);
            String testDesc="Spanish";
            driverAsst.clickOnElement(signin.Espanol,testDesc,test);
            String actual=driverAsst.getText(signin.submit,test);

            try {
                Assert.assertEquals(actual, input);
                test.log(Status.PASS,"selected Espanol and verified spanish");
            } catch (Error e) {
                test.log(Status.FAIL,"unable to select Espanol and verify");
                ExtentReporter.attachScreenshotToReport(test, driver, "spanish");
            }
        TakeScreenshot.takeScreenshot("spanish");
        } catch(Exception e){}
    }

    public void  selectFrenchAndVerify(ExtentTest test) {
        try{
            hoverOnLanguageDropdown(test);
            String testDesc="French";
            String input=ExcelUtils.readdata(filePath, "Sheet1", 4, 3);
            driverAsst.clickOnElement(signin.Français,testDesc,test);
            String actual=driverAsst.getText(signin.submit,test);
            try {
                Assert.assertEquals(actual, input);
                test.log(Status.PASS,"selected Francias and verified French");
            } catch (Error e) {
                test.log(Status.FAIL,"unable to select Francias and verify");
                ExtentReporter.attachScreenshotToReport(test, driver, "french");
            }
            TakeScreenshot.takeScreenshot("french");
        } catch(Exception e){}
    }


    public void  selectDeutschAndVerify(ExtentTest test) {
        try{
            hoverOnLanguageDropdown(test);
            String input=ExcelUtils.readdata(filePath, "Sheet1", 4, 4);
            String testDesc="Deutsch";
            driverAsst.clickOnElement(signin.Deutsch,testDesc,test);
            String actual=driverAsst.getText(signin.submit,test);
            try {
                Assert.assertEquals(actual, input);
                test.log(Status.PASS,"selected Deutsch and verified Danish");
            } catch (Error e) {
                test.log(Status.FAIL,"unable to select Deutsch and verify");
                ExtentReporter.attachScreenshotToReport(test, driver, "deutsch");
            } 
            TakeScreenshot.takeScreenshot("german");
        } catch(Exception e){}
    }

    public void  selectRussianAndVerify(ExtentTest test) {
        try{
            hoverOnLanguageDropdown(test);
            String input=ExcelUtils.readdata(filePath, "Sheet1", 4, 5);
            String testDesc="Russian";
            driverAsst.clickOnElement(signin.Russian,testDesc,test);
            String actual=driverAsst.getText(signin.submit,test);
            try {
                Assert.assertEquals(actual, input);
                test.log(Status.PASS,"selected Russian and verified Russian");
            } catch (Error e) {
                test.log(Status.FAIL,"unable to select Russian and verify");                
                ExtentReporter.attachScreenshotToReport(test, driver, "russian");
            } 
            TakeScreenshot.takeScreenshot("russian");
        } catch(Exception e){}
    }

    public void  selectJapaneseAndVerify(ExtentTest test) {
        try{
            hoverOnLanguageDropdown(test);
            String input=ExcelUtils.readdata(filePath, "Sheet1", 4, 6);
            String testDesc="Japanese";
            driverAsst.clickOnElement(signin.Japanese,testDesc,test);
            String actual=driverAsst.getText(signin.submit,test);
            try {
                Assert.assertEquals(actual, input);
                test.log(Status.PASS,"selected Japanese and verified Japanese");
            } catch (Error e) {
                test.log(Status.FAIL,"unable to select Japanense and verify");
                ExtentReporter.attachScreenshotToReport(test, driver, "japanese");
            }
            TakeScreenshot.takeScreenshot("japanese");
        } catch(Exception e){}
    }

    public void  selectEnglishAndVerify(ExtentTest test){
        try{
            hoverOnLanguageDropdown(test);
            String input=ExcelUtils.readdata(filePath, "Sheet1", 4, 7);
            String testDesc="English";
            driverAsst.clickOnElement(signin.English,testDesc,test);
            String actual=driverAsst.getText(signin.submit,test);
            try {
                Assert.assertEquals(actual, input);
                test.log(Status.PASS,"selected English and verified English");
            } catch (Error e) {
                test.log(Status.FAIL,"unable to select english and verify");
                ExtentReporter.attachScreenshotToReport(test, driver, "english");
            }
            TakeScreenshot.takeScreenshot("english");
        } catch(Exception e){}
    } 

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to verify Create Account text in join free
     */
    public void verifyCreateAccount(ExtentTest test){
        try{
            driverAsst.hoverOverElement(home.hoverOverSignInJoinIn,test); 
            String testDesc="Join free";
            driverAsst.clickOnElement(home.clickJoinFree,testDesc,test);
            String input=ExcelUtils.readdata(filePath, "Sheet1", 4, 0);
            String verifyAccount= driverAsst.getText(signin.verifyAccount,test);
            try{
                Assert.assertEquals(verifyAccount, input);
                test.log(Status.PASS,"'Create Account' is verified");
            } catch(Error e){
                test.log(Status.FAIL,"'Create Account' is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "create acc");
            }
            driver.navigate().back();
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to verify Sign In Now text in join free
     */
    public void verifySignInButtonTextInPage(ExtentTest test) {
        try{
            driverAsst.waitForElementToBeVisible(home.hoverOverSignInJoinIn,10);
            //driverAsst.hoverOverElement(home.hoverOverSignInJoinIn,test); 
            String testDesc="Sign In Now";
            driverAsst.clickOnElement(home.hoverOverSignInJoinIn,testDesc,test);    
            String input=ExcelUtils.readdata(filePath, "Sheet1", 1, 10);
            String actual=driverAsst.getText(signin.loginButton,test);
            try{
                Assert.assertEquals(actual,input);
                test.log(Status.PASS,"Sign In' verified");
            } catch(Error e){
                test.log(Status.FAIL,"Sign In' not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "sign in now");
            }
            driver.navigate().back();
        } catch(Exception e){}
   }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to verify email box in join free
     */
    public void verifyEmailBoxVisibility(ExtentTest test){
        try{
            driverAsst.hoverOverElement(home.hoverOverSignInJoinIn,test);
            String testDesc="Join Free";
            driverAsst.clickOnElement(home.clickJoinFree,testDesc,test);
            driverAsst.waitForElementToBeVisible(signin.identifyEmail, 10);
            Boolean display=driver.findElement(signin.enterEmail).isDisplayed();
            try{
                Assert.assertEquals(display,true);
                test.log(Status.PASS,"Email box is present");
            } catch(Error e){
                test.log(Status.FAIL,"Email box is not present");
                ExtentReporter.attachScreenshotToReport(test, driver, "email");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to verify verification code box in join free
     */
    public void verifyVerificationCode(ExtentTest test){
        try{
            String val=ExcelUtils.readdata(filePath, "Sheet1", 1, 0);
            String val1=ExcelUtils.readdata(filePath, "Sheet1", 1, 9);
            String testDesc="Email";
            driverAsst.sendKeys(signin.enterEmail, val,testDesc,test);
            String testDesc1="Click on I agree checkbox working";
            driverAsst.javascriptClick(signin.agreeCheckBox,testDesc1,test);
            String testDesc2="Click on next button working";
            driverAsst.clickOnElement(signin.nextButton,testDesc2,test);
            driverAsst.waitForElementToBeVisible(signin.checkVerifactionText, 10);
            String txt=driverAsst.getText(signin.checkVerifactionText,test);
            try{
                Assert.assertEquals(txt,val1);
                test.log(Status.PASS,"'Please enter the verification code.' is verified");
            } catch(Error e){
                test.log(Status.FAIL,"'Please enter the verification code.' is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "verification");
            }
            throw new SignInpageException();
        } catch(SignInpageException e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to verify Sign In with wrong credentials
     */
    public void clickOnSignInNowWrongIdPass(ExtentTest test){
        try{
            String testDesc="Click on Sign in working";
            driverAsst.clickOnElement(signin.clickSignInNow,testDesc,test);
            String val=ExcelUtils.readdata(filePath, "Sheet1", 1, 0);
            String testDesc1="Username";
            driverAsst.sendKeys(signin.enterUserName, val, testDesc1,test);
            String val2=ExcelUtils.readdata(filePath,"Sheet1",1,2);
            String testDesc2="Password";
            driverAsst.sendKeys(signin.enterPass,val2,testDesc2,test);
            driverAsst.javascriptClick(signin.loginButton,testDesc,test);
            driverAsst.waitForElementToBeVisible(signin.errorMessage, 10);
            String errorMessage=driverAsst.getText(signin.errorMessage,test);
            String val3=ExcelUtils.readdata(filePath, "Sheet1", 1, 4);
            try{
                Assert.assertEquals(errorMessage,val3);
                test.log(Status.PASS,"Error message 'Incorrect Password.' verified for wrong password");
            } catch(Error e){
                test.log(Status.FAIL,"Error message not verified for wrong password");
                ExtentReporter.attachScreenshotToReport(test, driver, "password");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to verify Sign In with correct credentials
     */
    public void clickOnSignInNowCorrectIdPass(ExtentTest test){
        try{
            String testDesc="Sign in";
            driverAsst.clickOnElement(signin.clickSignInNow,testDesc,test);
            driverAsst.waitForElementToBeVisible(signin.enterUserName,10);
            String val=ExcelUtils.readdata(filePath, "Sheet1", 1, 5);
            String testDesc1="Username";
            driverAsst.sendKeys(signin.enterUserName, val, testDesc1,test);
            String val2=ExcelUtils.readdata(filePath,"Sheet1",1,6);
            String testDesc2="Password";
            driverAsst.sendKeys(signin.enterPass,val2,testDesc2,test);
            String testDesc3="login button";
            driverAsst.wait(5);
            driverAsst.javascriptClick(signin.loginButton,testDesc3,test);
            driver.navigate().refresh();
            driverAsst.waitForElementToBeVisible(signin.hoverAccount,15);
            String accountHolderName=driverAsst.getText(signin.userName,test);
            String val3=ExcelUtils.readdata(filePath, "Sheet1", 1, 7);
            try{
                Assert.assertEquals(accountHolderName,val3);
                test.log(Status.PASS,"User verified");
            } catch(Error  e){
                test.log(Status.FAIL,"User not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "user");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to
     */
    public void forgetPass(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath,"Sheet1",1,3);
            String testDescLoginBtn="login button";
            String testDescForgetPassBtn="forget password button";
            String testDescContinue="continue button";
            driverAsst.clickOnElement(signin.loginButton,testDescLoginBtn,test);
            driverAsst.clickOnElement(signin.forgetPass,testDescForgetPassBtn,test);
            driverAsst.clickOnElement(signin.continueButton,testDescContinue,test);
            String failedLogin=driverAsst.getText(signin.verifyText,test);
            try{
                Assert.assertEquals(failedLogin,expected);
                test.log(Status.PASS,"Error message verified for wrong email");
            } catch(Exception  e){
                test.log(Status.FAIL,"Error message not verified for wrong email");
                ExtentReporter.attachScreenshotToReport(test, driver, "wrong email");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=wrapper method to automate incorrect sign in
     */
    public void WrapperForSignInpageInCorrectLogin(ExtentTest test){
        Homepage home=new Homepage();
        home.verifySignIn(test);
        verifyCreateAccount(test);
        verifySignInButtonTextInPage(test);
        verifyEmailBoxVisibility(test);
        verifyVerificationCode(test);
        clickOnSignInNowWrongIdPass(test);
        forgetPass(test);
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=wrapper method to automate incorrect sign in
     */
    public void WrapperForSignInpageCorrectLogin(ExtentTest test){
        Homepage home=new Homepage();
        home.verifySignIn(test);
        verifyCreateAccount(test);
        verifySignInButtonTextInPage(test);
        verifyEmailBoxVisibility(test);
        verifyVerificationCode(test);
        clickOnSignInNowCorrectIdPass(test);
    }
}