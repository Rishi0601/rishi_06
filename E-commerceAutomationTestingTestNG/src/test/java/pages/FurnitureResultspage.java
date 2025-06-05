package pages;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.FurnitureResultsPageLocators;
import uistore.HomepageLocators;
import utils.Base;
import utils.ExcelUtils;
import utils.WebDriverAssistance;

public class FurnitureResultspage extends Base{
    
    WebDriverAssistance driverAsst=new WebDriverAssistance();
    FurnitureResultsPageLocators furniture=new FurnitureResultsPageLocators();
    HomepageLocators home=new HomepageLocators();
    String filePath=System.getProperty("user.dir")+"/testdata/testdata.xlsx";


    /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform furniture validation
     */
    public void validateFurnitures(ExtentTest test){
        driverAsst.waitForElementToBeVisible(furniture.furniture,10);
        try{
            String val=ExcelUtils.readdata(filePath, "Sheet1", 3, 3);
            String text=driverAsst.getText(furniture.furniture,test);
            Assert.assertEquals(text,val);
            test.log(Status.PASS, "furniture validation completed");
        } catch(Error e){
            test.log(Status.FAIL, "furniture validation not completed");
        }
    }
        
    /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform verify furniture
     */
    public void verifyLivingRoomFurniture(ExtentTest test){    
        try{
            driverAsst.clickOnElement(furniture.More,"More",test);
            String furnitureverify=driverAsst.getText(furniture.checkfurniture, test);
            String Room=ExcelUtils.readdata(filePath,"Sheet1", 3, 1);
            Assert.assertEquals(furnitureverify,Room);
            test.log(Status.PASS, "'Living Room Furinture' verified");
        } catch(Error e){
            test.log(Status.FAIL, "'Living Room Furinture' not verified");
        }
        String testDesc="Website logo";
        driver.navigate().back();
        driverAsst.clickOnElement(furniture.logo,testDesc,test);
    }

    /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform searchbar reseted
     */
    public void WrapperForFurniture(ExtentTest test){
        Homepage home=new Homepage();
        home.searchFurniture(test);
        verifyLivingRoomFurniture(test);
        home.resetsearchbar(test);
    }
}
