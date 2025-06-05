package pages;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomepageLocators;
import uistore.ProductDirectoryPageLocators;
import utils.Base;
import utils.ExcelUtils;
import utils.ExtentReporter;
import utils.LoggerHandler;
import utils.WebDriverAssistance;

public class ProductDirectorypage extends Base{

    WebDriverAssistance driverAsst=new WebDriverAssistance();
    HomepageLocators home=new HomepageLocators();
    ProductDirectoryPageLocators prod=new ProductDirectoryPageLocators();
    String filePath=System.getProperty("user.dir")+"/testdata/testdata.xlsx";
    
    /* created by= B V S Manognaa
     * date= 16-05-24
     * last modified by= 18-05-25
     * purpose= To verify buyer module performs hover and click on New User Guide
     */
     public void auditSupply(ExtentTest test){
        try{
            driverAsst.hoverOverElement(home.buyer,test);
            String testDesc = "Click on Audited Suppliers Report";
            driverAsst.clickOnElement(prod.auditsupply, testDesc, test);
            
            String currText = "Audited Suppliers Reports";
            String text = ExcelUtils.readdata(filePath,"Sheet1", 6, 1);
            if (currText.contains(text)) {
                test.log(Status.PASS,"clicked on Audited Suppliers Report");
            } else {
                test.log(Status.FAIL,"Unable to click on Audited Suppliers Report");
                ExtentReporter.attachScreenshotToReport(test, driver, "audit supply");
            }
            driverAsst.switchToNewWindow();
            driverAsst.waitForElementToBeVisible(prod.auditsupply,5);
            LoggerHandler.info("Hovering on buyer and clicking on Audited Suppliers Report");
        } catch(Exception e){
            LoggerHandler.error("Buyer module is unable to access by user");
        }    
    }   

    /* created by= B V S Manognaa
     * date= 16-05-24
     * last modified by= 18-05-25
     * purpose= To verify buyer module performs hover and click on Meet Supplier
     */
    public void auditSupplyPage(ExtentTest test){
        try{
            String testDesc = "Click on Audited Suppliers Report";
            String currUrl = driver.getCurrentUrl();
            String url = ExcelUtils.readdata(filePath,"Sheet1", 6, 4);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'audited-suppliers' text matched");
            }
            else{
                test.log(Status.FAIL,"'audited-suppliers' text not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "audit supply page");
            }
            driverAsst.clickOnElement(prod.backbutton, testDesc, test);
            LoggerHandler.info("Verify the url of current page");
        } catch(Exception e){
            LoggerHandler.error("Url is not verified");
        }
    }

    /* created by= B V S Manognaa
     * date= 16-05-24
     * last modified by= 18-05-25
     * purpose= To verify buyer module performs hover and click on Audited Suppliers Report
     */
    public void meetSupplier(ExtentTest test){
        try{
            driverAsst.hoverOverElement(home.buyer,test);
            String testDesc = "Click on Meet Suppliers";
            driverAsst.clickOnElement(prod.meetsupplier, testDesc, test);
            String expected = ExcelUtils.readdata(filePath,"Sheet1", 6, 2);
            String actual = driverAsst.getText(prod.meetsupplier, test);
            try {
                Assert.assertEquals(actual, expected);
                test.log(Status.PASS,"clicked on Meet Suppliers");
            } catch (Exception e) {
            test.log(Status.FAIL,"Unable to click on Meet Suppliers");
            ExtentReporter.attachScreenshotToReport(test, driver, "meet supplier");
            }
            driverAsst.switchToNewWindow();
            driverAsst.waitForElementToBeVisible(prod.meetsupplier,5);
            LoggerHandler.info("Hovering on buyer and clicking on Meet Suppliers");
        } catch(Exception e){
            LoggerHandler.error("Buyer module is unable to access by user");
        }    
    }    

    /* created by= B V S Manognaa
     * date= 16-05-24
     * last modified by= 18-05-25
     * purpose= To verify buyer module performs hover and click on Meet Supplier
     */
    public void meetSupplyPage(ExtentTest test){
        try{
            String testDesc = "Click on Meet Suppliers";
            String currUrl = driver.getCurrentUrl();
            String url = ExcelUtils.readdata(filePath,"Sheet1", 6, 5);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'private-sourcing-meetings' text matched");
            }
            else{
                test.log(Status.FAIL,"'private-sourcing-meetings' text not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "meetsupplierpage");
            }
            driverAsst.clickOnElement(prod.backbutton, testDesc, test);
            LoggerHandler.info("Verify the url of current page");
        } catch(Exception e){
            LoggerHandler.error("Url is not verified");
        } 

    }

    /* created by= B V S Manognaa
     * date= 16-05-24
     * last modified by= 18-05-25
     * purpose= To verify buyer module performs hover and click on Meet Supplier
     */
    public void WrapperforBuyerpage(ExtentTest test){
        Homepage home1=new Homepage();
        home1.newUserandVerify(test);
        home1.newUserPage(test);
        auditSupply(test);
        auditSupplyPage(test);
        meetSupplier(test);
        meetSupplyPage(test);
    }

       /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to hover over buyers module and click on product directory
     */
    public void hoveroverBuyerAndClickProductDir(ExtentTest test){
        try{
            driverAsst.hoverOverElement(home.buyer,test);
            Boolean b = driver.findElement(home.buyer).isDisplayed();
            Assert.assertEquals(b,true);
            test.log(Status.PASS, "Passed, Hover over Buyer module");
        }
        catch (Exception e)
        {
            test.log(Status.FAIL, "Failed, Hover over Buyer module");
            ExtentReporter.attachScreenshotToReport(test, driver, "buyer");
        }
        String testDesc="Click on product directory working";
        driverAsst.clickOnElement(home.productDirectory,testDesc,test);
        driverAsst.switchToNewWindow();
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check machine tools url in buyer module under product directory
     */
    public void clickmachineTools(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            driverAsst.waitForElementToBeVisible(prod.machineTools,20);
            String testDesc="buyer module on homepage";
            driverAsst.clickOnElement(prod.machineTools,testDesc,test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9, 0); ;
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'/Manufacturing-Processing-Machinery-Catalog/Machine-Tools.html' is matched");   
            }
            else{
                test.log(Status.FAIL,"'/Manufacturing-Processing-Machinery-Catalog/Machine-Tools.html' is not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "machinery");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check engineering and construction url in buyer module under product directory
     */
    public void clickEnggandConst(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            String testDesc="engineering and construction on homepage";
            driverAsst.clickOnElement(prod.enggAndConstr,testDesc,test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9, 1);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'/Manufacturing-Processing-Machinery-Catalog/Engineering-Construction-Machinery.html' is matched");   
            }
            else{
                test.log(Status.FAIL,"'/Manufacturing-Processing-Machinery-Catalog/Engineering-Construction-Machinery.html' is not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "construction");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check wood working machinery url in buyer module under product directory
     */
    public void clickWoodWorkingandMachinery(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            String testDesc="woodworking machinery on on homepage";
            driverAsst.clickOnElement(prod.woodWorkinMachinery,testDesc,test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9, 2);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'/Manufacturing-Processing-Machinery-Catalog/Woodworking-Machinery.html' is matched");   
            }
            else{
                test.log(Status.FAIL,"'/Manufacturing-Processing-Machinery-Catalog/Woodworking-Machinery.html' is not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "woodworking");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check plastic machinery url in buyer module under product directory
     */
    public void clickPlasticMachinery(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            String testDesc="plastic machinery on homepage";
            driverAsst.clickOnElement(prod.plasticMachinery,testDesc,test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9, 3);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'/Manufacturing-Processing-Machinery-Catalog/Plastic-Machinery.html' is matched");   
            }
            else{
                test.log(Status.FAIL,"'/Manufacturing-Processing-Machinery-Catalog/Plastic-Machinery.html' is matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "palstic");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check metallic process machinery url in buyer module under product directory
     */
    public void clickMettalicProcessMachinery(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            String testDesc="metallic processing machinery on homepage";
            driverAsst.clickOnElement(prod.metallicProcessingMachinery,testDesc,test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9, 4);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'Metallic-Processing-Machinery' is matched");   
            }
            else{
                test.log(Status.FAIL,"'/Manufacturing-Processing-Machinery-Catalog/Metallic-Processing-Machinery.html'");
                ExtentReporter.attachScreenshotToReport(test,driver,"metallic");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check mould url in buyer module under product directory
     */
    public void clickMould(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            String testDesc="mould on homepage";
            driverAsst.clickOnElement(prod.mould, testDesc, test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9,5);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'/Manufacturing-Processing-Machinery-Catalog/Mould.html' is matched");   
            }
            else{
                test.log(Status.FAIL,"'/Manufacturing-Processing-Machinery-Catalog/Mould.html' is not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "mould");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check laser url in buyer module under product directory
     */
    public void clickLaser(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            String testDesc="laser on homepage";
            driverAsst.clickOnElement(prod.laser,testDesc,test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9, 6);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'/Manufacturing-Processing-Machinery-Catalog/Laser-Equipment.html' is matched");   
            }
            else{
                test.log(Status.FAIL,"'/Manufacturing-Processing-Machinery-Catalog/Laser-Equipment.html' is not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "laser");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check casting and foreign url in buyer module under product directory
     */
    public void clickCastingndForeign(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            String testDesc="casting and foreign on homepage";
            driverAsst.clickOnElement(prod.castingAndForeign,testDesc,test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9, 7);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'/Manufacturing-Processing-Machinery-Catalog/Casting-Forging.html' is matched");   
            }
            else{
                test.log(Status.FAIL,"/'Manufacturing-Processing-Machinery-Catalog/Casting-Forging.html' is not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "forging");
            }
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=16/04/2024
     * last modified date=17/04/2024
     * purpose=to check agriculture url in buyer module under product directory
     */
    public void clickAgricultural(ExtentTest test){
        try{
            hoveroverBuyerAndClickProductDir(test);
            String testDesc="agricultural machinery on homepage";
            driverAsst.clickOnElement(prod.agriculturalMachinery,testDesc,test);
            driverAsst.switchToNewWindow();
            String currUrl=driver.getCurrentUrl();
            String url=ExcelUtils.readdata(filePath, "Sheet1", 9, 8);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'/Manufacturing-Processing-Machinery-Catalog/Agricultural-Machinery.html' is matched");   
            }
            else{
                test.log(Status.FAIL,"'/Manufacturing-Processing-Machinery-Catalog/Agricultural-Machinery.html' is not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "agriculture");
            }
        } catch(Exception e){}
    } 

}
