package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.SignInPageLocators;
import uistore.SpicesResultpageLocators;
import utils.Base;
import utils.WebDriverAssistance;

public class SpicesResultpage extends Base{

    WebDriverAssistance driverAsst=new WebDriverAssistance();
    SpicesResultpageLocators spice=new SpicesResultpageLocators();
    SignInPageLocators sign=new SignInPageLocators();
    Homepage home=new Homepage();

    /* created by=Abhishek Kumar Singh
     * date=16/04/2024
     * last modified date=18/04/2024
     * purpose=to verify the first product name after search spices
     */
    public void verifyProductName(ExtentTest test){
        driverAsst.waitForElementToBeVisible(spice.firstitem, 5);
        String testDescFirstItem="first item";
        driverAsst.clickOnElement(spice.firstitem,testDescFirstItem,test);
        driverAsst.switchToNewWindow();
        driverAsst.waitForElementToBeVisible(spice.firstProductTitle,20);
        String expected=driverAsst.getText(spice.firstProductTitle,test);
        String actual=driver.getTitle();
        if(actual.contains(expected)){
            test.log(Status.PASS,"Product title verified");
        } else{
            test.log(Status.FAIL,"Product title is not verified");
        }
        driverAsst.waitForElementToBeVisible(spice.contactnow,15);
        String testDesc1="contact now";
        driverAsst.clickOnElement(spice.contactnow,testDesc1,test);
        driverAsst.switchToNewWindow();
    }

    /* created by=Abhishek Kumar Singh
     * date=16/04/2024
     * last modified date=18/04/2024
     * purpose=wrapper method to search spices and fill the content form and registration form
     */
    public void WrapperForSpicesPage(ExtentTest test){
        FillFormpage form=new FillFormpage();
        home.searchSpices(test);
        verifyProductName(test);
        form.fillForm(test);
    }
}
