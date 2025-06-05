package pages;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomepageLocators;
import uistore.WiresResultPageLocators;
import utils.Base;
import utils.ExcelUtils;
import utils.WebDriverAssistance;

public class WiresResultpage extends Base{

    WebDriverAssistance driverAsst=new WebDriverAssistance();
    WiresResultPageLocators wires=new WiresResultPageLocators();
    HomepageLocators home=new HomepageLocators();
    String filePath=System.getProperty("user.dir")+"/testdata/testdata.xlsx";

    /* created by=Sai Chandu A
    * date=18/04/2024
    * last modified date=18/04/2024
    * purpose=to perform verification of wires
    */
    public void verifywires(ExtentTest test){
        try{
            String actual=driverAsst.getText(wires.wires, test);
            String expected=ExcelUtils.readdata(filePath,"Sheet1", 3, 2);
            Assert.assertEquals(actual,expected);
            test.log(Status.PASS,"verification of keyword wires done");
        } catch(Error e){
            test.log(Status.FAIL,"verification of keyword wires not done");
        }
    }
       
    /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform clickingPagination
     */
    public void clickingPagination(ExtentTest test){
        driverAsst.clickOnElement(wires.pagination2,"Page 2", test);
        driverAsst.clickOnElement(wires.pagination1,"Page 1", test);
    }

    /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform verifypagiation
     */
    public void verifyPagination(ExtentTest test){
        String pagination=driverAsst.getText(wires.pagination2, test);
        try{
            String page=ExcelUtils.readdata(filePath,"Sheet1", 3, 0);
            Assert.assertEquals(pagination,page);
            test.log(Status.PASS,"verification of pagination done");
        } catch(Error e){
            test.log(Status.FAIL, "verification of pagination not done");
        }
    }
      
    /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform clicking on the First Product
     */
    public void clickingFirstProduct(ExtentTest test){
        String windowHandle = driver.getWindowHandle();
        driverAsst.waitForElementToBeVisible(wires.firstProductLink, 10);
        driverAsst.javascriptScroll(wires.header,test);
        driverAsst.clickOnElement(wires.firstProductLink,"First Product", test);
        driverAsst.switchToNewWindow();
        
        try{
            String supplierName=ExcelUtils.readdata(filePath,"Sheet1", 3, 5);
            String supplierDesignation=ExcelUtils.readdata(filePath,"Sheet1", 3, 6);
            String actualSupplierName=driverAsst.getText(wires.supplierName, test);
            String actualSupplierDesgn=driverAsst.getText(wires.supplierDesignation, test);
            if((actualSupplierName.trim()).contains(supplierName.trim())){
                Assert.assertEquals(actualSupplierName+actualSupplierDesgn,supplierName+supplierDesignation);
                test.log(Status.PASS,"supplier information verified");
            } else {
                test.log(Status.FAIL, "supplier information not verified");
            }
        }
        catch(Error e){}
        driver.switchTo().window(windowHandle);  
    }

    public void WrapperForWires(ExtentTest test){
        Homepage home=new Homepage();
        home.searchingWires(test);
        verifywires(test);
        clickingPagination(test);
        clickingFirstProduct(test);
    }
}
