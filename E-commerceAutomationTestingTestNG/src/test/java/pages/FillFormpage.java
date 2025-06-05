package pages;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.FillFormpageException;
import uistore.FillformPageLocators;
import uistore.HomepageLocators;
import uistore.LEDLightsPageLocators;
import uistore.SignInPageLocators;
import utils.Base;
import utils.ExcelUtils;
import utils.ExtentReporter;
import utils.TakeScreenshot;
import utils.WebDriverAssistance;

public class FillFormpage extends Base{
    
    WebDriverAssistance driverAsst=new WebDriverAssistance();
    HomepageLocators home=new HomepageLocators();
    LEDLightsPageLocators light=new LEDLightsPageLocators();
    FillformPageLocators form=new FillformPageLocators();
    SignInPageLocators sign=new SignInPageLocators();
    LEDLightsPageLocators led=new LEDLightsPageLocators();
    String filePath=System.getProperty("user.dir")+"/testdata/testdata.xlsx";
    
    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=method to fill form for contacting 
     */
    public void fillForm(ExtentTest test){
        try{
            List<String> list=new ArrayList<>();
            for(int i=2;i<11;i++){
                list.add(ExcelUtils.readdata(filePath,"Sheet1",5,i));
            }  
            String testDescContent="content";
            String testDescEmail="email";
            String testDescInquiry="Send Inquiry";
            String testDescFullname="full name";
            String testDescCompname="company name";
            String testDescContactNo="contact info";
            String testDescWebsite="website";
            driverAsst.sendKeys(form.content, list.get(0),testDescContent,test);
            driverAsst.sendKeys(form.email, list.get(1),testDescEmail,test);
            driverAsst.clickOnElement(form.sendInquiry,testDescInquiry,test);
            driverAsst.waitForElementToBeVisible(form.fullName,20);
            driverAsst.sendKeys(form.fullName, list.get(2),testDescFullname,test);
            driverAsst.sendKeys(form.companyName, list.get(3),testDescCompname,test);
            driverAsst.sendKeys(form.contactNo, list.get(4),testDescContactNo,test);
            driverAsst.sendKeys(form.website, list.get(5),testDescWebsite,test);
            driverAsst.clickOnElement(form.sendInquiry,testDescInquiry,test);
            driverAsst.waitForElementToBeVisible(form.successMsg,10);
            String txt=driverAsst.getText(form.successMsg,test);
            try{    
                Assert.assertEquals(txt, list.get(7));
                test.log(Status.PASS,"Registration is succesful");
            } catch(Error e){
                test.log(Status.FAIL, "Registration is not succesful");
                ExtentReporter.attachScreenshotToReport(test, driver, "registration");
            }
            TakeScreenshot.takeScreenshot("registration success");
            throw new FillFormpageException();
        } catch(FillFormpageException e){
        }
    }
}
