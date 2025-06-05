package pages;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.HomepageException;
import uistore.ElectronicsPageLocators;
import uistore.FillformPageLocators;
import uistore.HomepageLocators;
import uistore.LEDLightsPageLocators;
import uistore.ProductDirectoryPageLocators;
import uistore.SignInPageLocators;
import utils.Base;
import utils.ExcelUtils;
import utils.ExtentReporter;
import utils.TakeScreenshot;
import utils.WebDriverAssistance;

public class Homepage extends Base{
    WebDriverAssistance driverAsst=new WebDriverAssistance();

    HomepageLocators home=new HomepageLocators();
    ElectronicsPageLocators electronics=new ElectronicsPageLocators();
    FillformPageLocators form=new FillformPageLocators();
    SignInPageLocators sign=new SignInPageLocators();
    LEDLightsPageLocators led=new LEDLightsPageLocators();
    ProductDirectoryPageLocators prod=new ProductDirectoryPageLocators();
    
    String filePath=System.getProperty("user.dir")+"/testdata/testdata.xlsx";

    /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform verification of logo
     */
    public void searchingWires(ExtentTest test){
        driverAsst.waitForElementToBeVisible(home.searchBar, 10);
        driverAsst.clickOnElement(home.searchBar,"Search Bar",test);
        try{
            String wires= ExcelUtils.readdata(filePath,"Sheet1", 3, 2);
            driverAsst.sendKeys(home.searchBar,wires,"searchbar", test);
            test.log(Status.PASS,"searching wires");
        } catch(Exception e){
            test.log(Status.FAIL,"verification of keyword wires not done");
        }
        driverAsst.clickOnElement(home.searchButton,"Search", test);
    }

     /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform furniture validation
     */
    public void searchFurniture(ExtentTest test){
        String val=ExcelUtils.readdata(filePath, "Sheet1", 3, 3);
        driverAsst.clickOnElement(home.searchBar,"Search Bar",test);
        driverAsst.sendKeys(home.searchBar,val,"search bar", test);
        driverAsst.clickOnElement(home.searchButton,"Search Icon",test);
    }

     /* created by=Sai Chandu A
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform searchbar reseted
     */
    public void resetsearchbar(ExtentTest test){
        try{
            driver.findElement(home.searchBar).clear();
            TakeScreenshot.takeScreenshot("Reset SearchBar");
            test.log(Status.PASS, "Reset SearchBar");
        } catch(Error e){
            test.log(Status.FAIL, "searchbar not reset");
        }
    }

    /* created by= B V S Manognaa
     * date= 16-05-24
     * last modified by= 18-05-25
     * purpose= To verify buyer module performs hover and click on New User Guide
     */
    public void newUserandVerify(ExtentTest test){
        try{
            driverAsst.hoverOverElement(home.buyer,test);
            String testDesc = "Click on New User Guide";
            driverAsst.clickOnElement(home.newusrguide, testDesc, test);
        
            String expected = ExcelUtils.readdata(filePath,"Sheet1", 6, 0);
            String actual = driverAsst.getText(home.newusrguide, test);
            try {
                Assert.assertEquals(actual, expected);
                test.log(Status.PASS,"New User Guide is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"New User Guide is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "new user");
            }
            driverAsst.switchToNewWindow();
            driverAsst.waitForElementToBeVisible(home.newusrguide,5);
        } catch(Exception e){
        }   
    }    
    
    /* created by= B V S Manognaa
     * date= 16-05-24
     * last modified by= 18-05-25
     * purpose= To verify buyer module performs hover and click on New User Guide
     */
    public void newUserPage(ExtentTest test){
        try{
            String testDesc = "New User Guide";
            String currUrl = driver.getCurrentUrl();
            String url = ExcelUtils.readdata(filePath,"Sheet1", 6, 3);
            if(currUrl.contains(url)){
                test.log(Status.PASS,"'how-to-source-products-on-made-in-china-com' text matched");
            }
            else{
                test.log(Status.FAIL,"'how-to-source-products-on-made-in-china-com' text not matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "new user page");
            }
            driverAsst.clickOnElement(prod.backbutton,testDesc,test);
        } catch(Exception e){
        }
    }
    
    public void searchFunctionality(ExtentTest test){
        try{
            String readVal = ExcelUtils.readdata(filePath,"Sheet1",0,0);
            String testDescSearchbar="searchbar";
            driverAsst.clickOnElement(home.searchBar,testDescSearchbar,test);
            driverAsst.sendKeys(home.searchBar, readVal,testDescSearchbar,test);
            String testDescSearchBtn="search button";
            driverAsst.clickOnElement(home.searchButton,testDescSearchBtn,test);
        } catch(Exception e){}
    }

    public void verifyWebsiteLogo(ExtentTest test){
        try{
            driverAsst.waitForElementToBeVisible(home.madeInChinaLogo,20);
            Boolean display=driver.findElement(home.madeInChinaLogo).isDisplayed();
            try{
                Assert.assertEquals(display, true);
                test.log(Status.PASS,"MADE IN CHINA logo is present");
            } catch(Error e){
                test.log(Status.FAIL,"MADE IN CHINA logo is not present");
            }
        } catch(Exception e){}
    }

    public void verifySignIn(ExtentTest test){
        try{
            String text=driverAsst.getText(home.hoverOverSignInJoinIn,test);
            String readSignIn=ExcelUtils.readdata(filePath, "Sheet1", 1, 8);
            try{
                Assert.assertEquals(text, readSignIn);
                test.log(Status.PASS, "'Sign in/Join' is present");
                test.log(Status.PASS,"'Sign in/Join' button is working ");
            } catch(Error e){
                test.log(Status.FAIL, "'Sign in/Join' is not present");
                test.log(Status.FAIL,"'Sign in/Join' button is not working ");
            } 
        } catch(Exception e){}
    }

    public void navigateBackToHome(){
        try{
            String parent=driver.getWindowHandle();
            Set<String>s=driver.getWindowHandles();
            Iterator<String> it= s.iterator();
            while(it.hasNext()){
                String child_window=it.next();
                if(!parent.equals(child_window)){
                    driver.switchTo().window(parent);
                    driver.close();
                }
            }            
        } catch(Exception e){}    
    }

    public void clickOnFurnitureAndVerifyPage(ExtentTest test){
        try{
            String testDescFurniture="furniture";
            driverAsst.clickOnElement(home.furniture,testDescFurniture,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 0);
            String actual=  driverAsst.getText(home.verifyFurniturePage,test);
            try{
                Assert.assertEquals(actual, expected);
                test.log(Status.PASS,"'Furniture' keyword is verified");
            }catch(Error e){
                test.log(Status.FAIL,"'Furniture' keyword is not verified");
            }
            navigateBackToHome();
        } catch(Exception e){}
    }

    public void clickOnApparalAndVerify(ExtentTest test){
        try{
            String testDescApparal="Apparal and Clothing";
            driverAsst.javascriptScroll(home.apparelAndClothing,test);
            driverAsst.clickOnElement(home.apparelAndClothing,testDescApparal,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 1);
            String actual=  driverAsst.getText(home.verifyApparelPage,test);
            try {
                Assert.assertEquals(actual, expected);
                test.log(Status.PASS,"Apparal & Clothing is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"Apparal & Clothin is not verified");
            }
            TakeScreenshot.takeScreenshot("sports");
            navigateBackToHome();
        } catch(Exception e){}
    }

    public void clickOnAutoParts(ExtentTest test){
        try{
            String testDescAuto="Auto Parts";
            driverAsst.javascriptScroll(home.autoPartsAndAccessories,test);
            driverAsst.clickOnElement(home.autoPartsAndAccessories,testDescAuto,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 2);
            String actual= driverAsst.getText(home.verifyAutoPartsPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"Auto Parts & Accessories is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"Auto Parts & Accessories is not verified");
            }
            TakeScreenshot.takeScreenshot("autoparts");
            navigateBackToHome();
        } catch(Exception e){}
    }

    public void clickOnBags(ExtentTest test) {
        try{
            String testDescBags="Bags";
            driverAsst.javascriptScroll(home.bagsCases,test);
            driverAsst.clickOnElement(home.bagsCases,testDescBags,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 3);
            String actual= driverAsst.getText(home.verifyBagsPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"Bags Cases is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"Bags Cases is not verified");
            }
            TakeScreenshot.takeScreenshot("bags");
        } catch(Exception e){}
        navigateBackToHome();
    }


    public void clickOnComputerProducts(ExtentTest test){
        try{
            String testDescComputerProducts="computer products";
            driverAsst.javascriptScroll(home.computerProducts,test);
            driverAsst.clickOnElement(home.computerProducts,testDescComputerProducts,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 4);
            String actual= driverAsst.getText(home.verifyComputerPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"Computer Products is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"Computer electronics is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "computer_electronics");
            }
            TakeScreenshot.takeScreenshot("computer_product");
            navigateBackToHome();
        } catch(Exception e){}
    }


    public void clickOnConsumerElectronics(ExtentTest test){
        try{
            String testDescConsumerElectronics="consumer electronics";
            driverAsst.javascriptScroll(home.consumerElectronics,test);
            driverAsst.wait(2);
            driverAsst.wait(2);
            driverAsst.wait(2);
            driverAsst.clickOnElement(home.consumerElectronics,testDescConsumerElectronics,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 5);
            String actual= driverAsst.getText(home.verifyConsumerPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"Consumer electronics is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"Consumer electronics is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "consumer_electronics");
            }
            TakeScreenshot.takeScreenshot("consumer");
            navigateBackToHome();
        } catch(Exception e){}
    }


    public void clickOnElectricalEquipment(ExtentTest test){
        try{
            String testDescElectricalEquip="Electrical Equipment";
            driverAsst.javascriptScroll(home.electricalEquipment,test);
            driverAsst.clickOnElement(home.electricalEquipment,testDescElectricalEquip,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 6);
            String actual=  driverAsst.getText(home.verifyElectricalPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"Electrical Equipment is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"Electrical Equipment is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "electrical_equipment");
            }
        navigateBackToHome();
        } catch(Exception e){}
    }

    public void clickOnElectronicComponent(ExtentTest test){
        try{
            String testDescElectronicComponent="Electronic Component";
            driverAsst.javascriptScroll(home.electronicComponent,test);
            driverAsst.clickOnElement(home.electronicComponent,testDescElectronicComponent,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 7);
            String actual=  driverAsst.getText(home.verifyElectronicPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"clicked on Electronic Component");
            } catch (Error e) {
                test.log(Status.FAIL,"Unable to click on Electronic Component ");
                ExtentReporter.attachScreenshotToReport(test, driver, "electronic_component");
            }
            TakeScreenshot.takeScreenshot("electronics_component");
            navigateBackToHome();
        } catch(Exception e){}
    }

    public void clickOnGiftsCrafts(ExtentTest test) {
        try{
            String testDescGifts="Girft Crafts";
            driverAsst.javascriptScroll(home.giftsCrafts,test);
            driverAsst.clickOnElement(home.giftsCrafts,testDescGifts,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 8);
            String actual=  driverAsst.getText(home.verifyGiftsPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"clicked on Gifts Crafts & Collectibles");
            } catch (Error e) {
                test.log(Status.FAIL,"Unable to click on Gifts Crafts & Collectibles");
                ExtentReporter.attachScreenshotToReport(test, driver, "gifts");
            }
            TakeScreenshot.takeScreenshot("gifts");
            navigateBackToHome();
        } catch(Exception e){}
    }



    public void clickOnMotorCyclesAndScooters(ExtentTest test){
        try{
            String testDescMotorcycle="Motorcycles and Scooters";
            driverAsst.javascriptScroll(home.motorcycles,test);
            driverAsst.clickOnElement(home.motorcycles,testDescMotorcycle,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 9);
            String actual=  driverAsst.getText(home.verifyMotorcyclesPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"MotorCycles And Scooters is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"MotorCycles And Scooters is not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "motorcycles");
            }
            TakeScreenshot.takeScreenshot("scooters");
            navigateBackToHome();
        } catch(Exception e){}

    }

    
    public void clickOnSealingPackaging(ExtentTest test){
        try{
            String testDescSealingPkg="Sealing Packages";
            driverAsst.javascriptScroll(home.sealing,test);
            driverAsst.clickOnElement(home.sealing,testDescSealingPkg,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 10);
            String actual= driverAsst.getText(home.verifySealingPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"Sealing Packaging is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"Sealing Packaging is not");
                ExtentReporter.attachScreenshotToReport(test, driver, "sealing");
            }
            TakeScreenshot.takeScreenshot("sealing");
            navigateBackToHome();
        } catch(Exception e){}
    }

    public void clickOnBuildingMaterials(ExtentTest test){
        try{
            String testDescBuildingMaterial="Building Materials";
            driverAsst.javascriptScroll(home.buildingMaterials,test);
            driverAsst.wait(2);
            driverAsst.wait(2);
            driverAsst.wait(2);
            driverAsst.clickOnElement(home.buildingMaterials,testDescBuildingMaterial,test);
            driverAsst.switchToNewWindow();
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 7, 11);
            String actual= driverAsst.getText(home.verifyBuildingPage,test);
            try {
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS,"Building Materials is verified");
            } catch (Error e) {
                test.log(Status.FAIL,"Building Materials not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "building");
            }
            TakeScreenshot.takeScreenshot("building");
            navigateBackToHome();
        } catch(Exception e){}
    }

    public void clickonManufacturing(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 9, 0);
            String testDescManufacturing="Manufacturing";
            driverAsst.clickOnElement(prod.manufacturingAndProcessing,testDescManufacturing,test);
            String actual= driverAsst.getText(prod.text,test);
            try{
                Assert.assertEquals(actual, expected);
                test.log(Status.PASS, "'Manufacturing & Processing Machinery' is Matched");
            } catch(Error e){
                test.log(Status.FAIL,"'Manufacturing & Processing Machinery' is Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "manufacturing");
            }
            TakeScreenshot.takeScreenshot("manufacturing");
            driver.navigate().back();
        } catch(Exception e){}
    }

    public void clickConsumerElectronics(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 8, 1);
            String testDesc="consumer electronics";
            driverAsst.clickOnElement(prod.consumerEle,testDesc,test);
            String actual= driverAsst.getText(prod.text,test);
            try{
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS, "'Consumer Electronics' is Matched");
            } catch(Error e){
                test.log(Status.FAIL,"'Consume Electronics' is Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "consumer electronics");
            }
            TakeScreenshot.takeScreenshot("consumer_electronics");
            driver.navigate().back();
        } catch(Exception e){}
    }

    public void clickIndustrial(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 8, 2);
            driverAsst.javascriptScroll(prod.industrialEquip,test);
            String testDescIndustrialEquip="Industrial Equipment";;
            driverAsst.clickOnElement(prod.industrialEquip,testDescIndustrialEquip,test);
            String actual= driverAsst.getText(prod.text,test);
            try{
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS, "'Industrial Equipment & Components' is Matched");
            }
            catch(Error e){
                test.log(Status.FAIL,"'Industrial Equipment & Components' Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "industrial");
            }
            TakeScreenshot.takeScreenshot("industrial");
            driver.navigate().back();
        } catch(Exception e){}
    }

    public void clickElectrical(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 8, 3);
            String testDesc="Electrical and Electronics";
            driverAsst.javascriptScroll(prod.electricalAndElectronics,test);
            driverAsst.clickOnElement(prod.electricalAndElectronics, testDesc, test);
            String actual= driverAsst.getText(prod.text,test);
            try{
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS, "'Electrical & Electronics' is Matched");
            }
            catch(Error e){
                test.log(Status.FAIL,"'Electrical & Electronics' not Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "electronics");
            }
            TakeScreenshot.takeScreenshot("electrical");
            driver.navigate().back();
        } catch(Exception e){}
    }

    public void clickConstruction(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath, "Sheet1", 8, 4);
            String testDescConstAndDest="Construction and Destruction";
            driverAsst.javascriptScroll(prod.constructionDecoration,test);
            driverAsst.clickOnElement(prod.constructionDecoration,testDescConstAndDest,test);
            String actual= driverAsst.getText(prod.text,test);
            try{
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS, "'Construction & Decoration' is Matched");
            }
            catch(Error e){
                test.log(Status.FAIL,"'Construction & Decoration' is Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "construction");
            }
            TakeScreenshot.takeScreenshot("construction");
            driver.navigate().back();
        } catch(Exception e){}
    }

    public void clickLightIndustry(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath,  "Sheet1", 8, 5);
            String testDescLight="Light Industry";
            driverAsst.javascriptScroll(prod.lightIndustry,test);
            driverAsst.clickOnElement(prod.lightIndustry,testDescLight,test);
            String actual= driverAsst.getText(prod.text,test);
            try{
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS, "'Light Industry & Daily Use' is Matched");
            }
            catch(Error e){
                test.log(Status.FAIL,"'Light Industry & Daily Use' is Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "light industry");
            }
            TakeScreenshot.takeScreenshot("light_industry");
            driver.navigate().back();
        } catch(Exception e){}
    }

    public void clickAutoMotorCycle(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath,  "Sheet1", 8, 6);
            String testDescAutoMotorcycle="Auto Motorcycle";
            driverAsst.javascriptScroll(prod.autoMotorcycle,test);
            driverAsst.clickOnElement(prod.autoMotorcycle,testDescAutoMotorcycle,test);
            String actual= driverAsst.getText(prod.text,test);
            try{
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS, "'Auto, Motorcycle Parts & Accessories' is Matched");
            }
            catch(Exception e){
                test.log(Status.FAIL,"'Auto, Motorcycle Parts & Accessories' is Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "auto motorcycle");
            }
            TakeScreenshot.takeScreenshot("motorcycle");
            driver.navigate().back();
        } catch(Exception e){}
    }

    public void clickApparelAccessorices(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath,  "Sheet1", 8, 7);
            String testDescApparal="Apparel Accesories";
            driverAsst.javascriptScroll(prod.apparelAccessories,test);
            driverAsst.clickOnElement(prod.apparelAccessories,testDescApparal,test);
            String actual= driverAsst.getText(prod.text,test);
            try{
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS, "'Apparel & Accessories' is Matched");
            }
            catch(Exception e){
                test.log(Status.FAIL,"'Apparel & Accessories' is Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "apparel");
            }
            TakeScreenshot.takeScreenshot("apparel");
            driver.navigate().back();
            throw new HomepageException();
        } catch(HomepageException e){
            e.printStackTrace();
        }
    }

    public void clickLightandLightinig(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath,  "Sheet1", 8, 8);
            String testDesc="Light and Lighting";
            driverAsst.javascriptScroll(prod.lightsAndLighting,test);
            driverAsst.clickOnElement(prod.lightsAndLighting,testDesc,test);
            String actual=driverAsst.getText(prod.text,test);
            try{
                Assert.assertEquals(actual, expected);
                test.log(Status.PASS, "'Lights & Lighting' is Matched");
            }
            catch(Exception e){
                test.log(Status.FAIL,"'Lights & Lighting' is Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "light&lighting");
            }
            TakeScreenshot.takeScreenshot("lights");
            driver.navigate().back();
        } catch(Exception e){}
    }
    
    public void clickSportingGood(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath,  "Sheet1", 8, 9);
            String testDescSportsGood="Sporting Goods";
            driverAsst.javascriptScroll(prod.sportingGoods,test);
            driverAsst.clickOnElement(prod.sportingGoods,testDescSportsGood,test);
            String actual=driverAsst.getText(prod.text,test);
            try{
            Assert.assertEquals(actual, expected);
            test.log(Status.PASS, "'Sporting Goods & Recreation' is Matched");
            }
            catch(Exception e){
                test.log(Status.FAIL,"'Sporting Goods & Recreation' is Not Matched");
                ExtentReporter.attachScreenshotToReport(test, driver, "sports");
            }
            TakeScreenshot.takeScreenshot("sports");
            driver.navigate().back();
        } catch(Exception e){}
    }

    /* created by=Rishiraj Basu
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform search on empty searchbox
     */
    public void navigationToLedTube(ExtentTest test){
        try{
            String expected=ExcelUtils.readdata(filePath,"Sheet1",5,8);
            driverAsst.hoverOverElement(led.lights,test);
            driverAsst.hoverOverElement(led.ledTube,test);
            String testDescLedTube="LED Tube";
            driverAsst.clickOnElement(led.ledTube,testDescLedTube,test);
            String actual=driverAsst.getText(led.verifyledkeyword,test);
            try{
                Assert.assertEquals(actual,expected);
                test.log(Status.PASS, "'LED Tube' verified");
            } catch(Error e){
                test.log(Status.FAIL, "'LED Tube' not verified");
                ExtentReporter.attachScreenshotToReport(test, driver, "led tube");
            }
            String testDescLedLightTube="LED light tube";
            driverAsst.clickOnElement(led.ledlightTube,testDescLedLightTube,test);
            driverAsst.waitForElementToBeVisible(led.ledlightTubeLabel, 10);
            driverAsst.javascriptScroll(led.warmWhite,test);
            //driverAsst.clickOnElement(test6.warmWhite);
            // driverAsst.waitForElementToBeVisible(test6.ledlightTubeLabel, 10);
            // driverAsst.javascriptScroll(test6.colorTemp);
            // String txt1=driverAsst.getText(test6.verifywarmWhite);
            // try{
            //     Assert.assertEquals(txt1,val1);
            //     test.log(Status.PASS, "'Warm White' is verified");
            // } catch(Exception e){
            //     test.log(Status.FAIL, "'Warm White' not verified");
            // }
        } catch(Exception e){}
    }

    /* created by=Abhishek Kumar Singh
     * date=16/04/2024
     * last modified date=18/04/2024
     * purpose=to perform search spices in searchbox
     */
    public void searchSpices(ExtentTest test){
        String readVal=ExcelUtils.readdata(filePath, "Sheet1", 2, 0);
        String testDescSearchbox="searchBox";
        driverAsst.clickOnElement(home.searchBar,testDescSearchbox,test );
        driverAsst.sendKeys(home.searchBar, readVal, testDescSearchbox,test);
        String testDesc2="click on search Icon";
        driverAsst.clickOnElement(home.searchButton,testDesc2,test);
    }

    /* created by=Rishiraj Basu
     * date=18/04/2024
     * last modified date=18/04/2024
     * purpose=to perform search on empty searchbox
     */
    public void checkAlertonEmptySearch(ExtentTest test){
        try{
            driverAsst.clickOnElement(home.searchBar, "Click on searchbar working", test);
            driverAsst.clickOnElement(home.searchButton, "Click on search button working", test);
            driverAsst.switchToAlert(test);
            throw new HomepageException();
        } catch(HomepageException e){}
    }
}