package pages;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.LEDLightsResultspageException;
import uistore.FillformPageLocators;
import uistore.HomepageLocators;
import uistore.LEDLightsPageLocators;
import uistore.SignInPageLocators;
import utils.Base;
import utils.ExcelUtils;
import utils.ExtentReporter;
import utils.WebDriverAssistance;

public class LEDLightsResultspage extends Base{

    WebDriverAssistance driverAsst=new WebDriverAssistance();
    HomepageLocators home=new HomepageLocators();
    LEDLightsPageLocators light=new LEDLightsPageLocators();
    FillformPageLocators form=new FillformPageLocators();
    SignInPageLocators sign=new SignInPageLocators();
    LEDLightsPageLocators led=new LEDLightsPageLocators();
    FillFormpage fill=new FillFormpage();
    String filePath=System.getProperty("user.dir")+"/testdata/testdata.xlsx";
    
    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check the search results contains keyword
     */
    public void verifyLEDLightsKeyword(ExtentTest test){
        try{
            String val = ExcelUtils.readdata(filePath,"Sheet1",5,0);
            String testDescSearchbar="search bar";
            driverAsst.clickOnElement(home.searchBar,testDescSearchbar,test);
            driverAsst.sendKeys(home.searchBar,val,testDescSearchbar,test);
            String testDescSearchBtn="search button";
            driverAsst.javascriptClick(home.searchButton,testDescSearchBtn,test);
            driverAsst.waitForElementToBeVisible(led.ledlightsLabel,10);
            String txt=driverAsst.getText(led.ledlightsLabel,test);
            try{    
                Assert.assertEquals(txt, val);
                test.log(Status.PASS,"'LED Lights' keyword is present");
            } catch(Error e){
                test.log(Status.FAIL, "'LED Lights' keyword is not present");
                ExtentReporter.attachScreenshotToReport(test, driver, "led lights");
            }
            throw new LEDLightsResultspageException();
        } catch(LEDLightsResultspageException e){
        }
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check the filter is choosen correctly after product details search
     */
    public void verifyStripLightDetails(ExtentTest test){
        try{
            driverAsst.waitForElementToBeVisible(light.more,10);
            String testDescMore="more";
            String testDescStripLight="striplight";
            String testDescContactNow="Contact Now";
            driverAsst.clickOnElement(light.more, testDescMore,test);
            driverAsst.clickOnElement(light.striplight,testDescStripLight,test);
            driverAsst.clickOnElement(light.contactNow,testDescContactNow,test);
            driverAsst.switchToNewWindow();
            driverAsst.waitForElementToBeVisible(form.content,10);        
            Boolean display=driver.findElement(form.content).isDisplayed();
            try{    
                Assert.assertEquals(display, true);
                test.log(Status.PASS,"Contact Page is present present");
            } catch(Error e){
                test.log(Status.FAIL, "Contact Page is not present");
                ExtentReporter.attachScreenshotToReport(test, driver, "contact page");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to navigate to led tube in categories
     */
    public void navigationToLedTube(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath,"Sheet1",5,8);
            driverAsst.hoverOverElement(led.lights,test);
            driverAsst.hoverOverElement(led.ledTube,test);
            String testDescLedTube="LED tube";
            driverAsst.clickOnElement(led.ledTube,testDescLedTube,test);
            String actual=driverAsst.getText(led.verifyledkeyword,test);
            try{
                Assert.assertEquals(actual,expected);
                test.log(Status.PASS, "'LED Tube' verified");
            } catch(Error e){
                test.log(Status.FAIL, "'LED Tube' not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "led tube");
            }
            String testDesc1="LED Light Tube";
            driverAsst.clickOnElement(led.ledlightTube,testDesc1,test);
            driverAsst.waitForElementToBeVisible(led.ledlightTubeLabel, 10);
            driverAsst.javascriptScroll(led.warmWhite,test);
        } catch(Exception e){}
    }    

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=wrapper method for led lights page
     */
    public void WrapperForLEDLightspage(ExtentTest test){
        verifyLEDLightsKeyword(test);
        verifyStripLightDetails(test);
        fill.fillForm(test);
    }
}
