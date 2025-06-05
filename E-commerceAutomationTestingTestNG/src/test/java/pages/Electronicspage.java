package pages;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.ElectronicspageException;
import uistore.ElectronicsPageLocators;
import uistore.HomepageLocators;
import uistore.LEDLightsPageLocators;
import utils.Base;
import utils.ExcelUtils;
import utils.ExtentReporter;
import utils.WebDriverAssistance;

public class Electronicspage extends Base{
    
    WebDriverAssistance driverAsst= new WebDriverAssistance();
    HomepageLocators home=new HomepageLocators();
    LEDLightsPageLocators led=new LEDLightsPageLocators();
    ElectronicsPageLocators electronics=new ElectronicsPageLocators();
    String filePath=System.getProperty("user.dir")+"/testdata/testdata.xlsx";

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=verify electronics label after searching the electonics in the search bar
     */
    public void verifyElectronicsLabel(ExtentTest test){ 
        try{
            String readVal = ExcelUtils.readdata(filePath,"Sheet1",0,0);
            String testDescSearchbar="searchbar";
            driverAsst.clickOnElement(home.searchBar,testDescSearchbar,test);
            String testDesforSearch="search";
            driverAsst.sendKeys(home.searchBar, readVal, testDesforSearch, test);
            String testDescSearchbutton="Search button";
            driverAsst.clickOnElement(home.searchButton,testDescSearchbutton,test);
            String readLabel= ExcelUtils.readdata(filePath,"Sheet1",0,0);

            driverAsst.waitForElementToBeVisible(electronics.electronicsLabel, 15);
            String txt=driverAsst.getText(electronics.electronicsLabel,test);
            try{
                Assert.assertEquals(txt, readLabel);
                test.log(Status.PASS,"electronics is searched");
                test.log(Status.PASS,"'electronics' keyword is present");
            } catch(Error e){
                test.log(Status.FAIL,"electronics is not searched");
                test.log(Status.FAIL,"'electronics' keyword is not present");
                ExtentReporter.attachScreenshotToReport(test, driver, "electronics");
            }
        }
        catch(Exception e){}
    } 

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=verify consumer electronics label after selecting the filter
     */
    public void verifyConsumerElectronics(ExtentTest test){
        try{
            String readConsumer = ExcelUtils.readdata(filePath,"Sheet1",0,1);
            String testDescSupplierList="Supplier List";
            driverAsst.clickOnElement(electronics.supplierList,testDescSupplierList,test);
            driverAsst.waitForElementToBeVisible(electronics.consumerElectronics, 15);
            String testDesforSearch="Consumer electronics";
            driverAsst.clickOnElement(electronics.consumerElectronics,testDesforSearch,test);
            driverAsst.waitForElementToBeVisible(electronics.consumerElectronicsLabel,15);
            String txt=driverAsst.getText(electronics.consumerElectronicsLabel,test);
            try{
                Assert.assertEquals(txt,readConsumer);
                test.log(Status.PASS,"'Consumer Electronics' is verified");
            } catch(Error e){
                test.log(Status.FAIL,"'Consumer Electronics' is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "consumeelec");
            }
        }
        catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=verify iso9000 label after selecting the filter
     */
    public void verifyISO(ExtentTest test){
        try{
            String readIso=ExcelUtils.readdata(filePath,"Sheet1",0,2);
            String testDescIso="ISO 9000";
            driverAsst.waitForElementToBeVisible(electronics.iso9000,15);
            driverAsst.clickOnElement(electronics.iso9000,testDescIso,test);
            String txt=driverAsst.getText(electronics.isoLabel,test);
            try{
                Assert.assertEquals(txt,readIso);
                test.log(Status.PASS,"'ISO 9000' is verified");
            } catch(Error e){
                test.log(Status.FAIL,"'ISO 9000' is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "iso 9000");
            }  
            throw new ElectronicspageException();      
        } catch(ElectronicspageException e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=wraps all the automation test methods into a single method
     */
    public void WrapperForElectronicsPage(ExtentTest test){
        Homepage home=new Homepage();
        home.verifyWebsiteLogo(test);
        verifyElectronicsLabel(test);
        verifyConsumerElectronics(test);
        verifyISO(test);
    }
}