package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.Electronicspage;
import pages.FillFormpage;
import pages.FurnitureResultspage;
import pages.Homepage;
import pages.LEDLightsResultspage;
import pages.ProductDirectorypage;
import pages.SignInpage;
import pages.SpicesResultpage;
import pages.WiresResultpage;
import utils.*;

public class TestRunner extends Base{

    ExtentTest test;
    ExtentReports report;

    Homepage home=new Homepage();
    LEDLightsResultspage led=new LEDLightsResultspage();
    FillFormpage fill=new FillFormpage();
    SignInpage signin=new SignInpage();
    SpicesResultpage spice=new SpicesResultpage();
    Electronicspage electronics=new Electronicspage();
    ProductDirectorypage prod=new ProductDirectorypage();
    FurnitureResultspage furniture=new FurnitureResultspage();
    WiresResultpage wires=new WiresResultpage();

    @BeforeMethod
    public void launch(){
        report=ExtentReporter.generateExtentReport("reports");
        openBrowser();
    }

    @Test(priority=1, groups = {"search"})
    public void testHomepageElements(){
        test=report.createTest("Testcase to verify Website logo, Electronics label, Consumer Electronics label, ISO 9000");
        electronics.WrapperForElectronicsPage(test);
    }

    @Test(priority=2, groups = {"search"})
    public void testLEDLightsLink(){
        test=report.createTest("Testcase for verifying various functionality after searching 'led lights' keyword");
        led.WrapperForLEDLightspage(test);
    }

    @Test(priority=31, groups={"search"})
    public void testSpices(){
        test=report.createTest("Testcase for verifying first product name after searching spices in textbox");
        spice.WrapperForSpicesPage(test);
    }

    @Test(priority=3, groups = "{homepage_categories},{search}")
    public void testNavigateToLEDTubeLink(){
        test=report.createTest("Testcase for verifying 'LED Tube' keyword after navigating to it");
        home.navigationToLedTube(test);
    }
    
    @Test(priority=4, groups = "{homepage_categories}")
    public void testMachineToolsLink(){
        test=report.createTest("Testcase verify Machine Tools link");
        prod.clickmachineTools(test);
    }

    @Test(priority=5, groups = "{homepage_categories}")
    public void testEngineeringAndConstructionLink(){   
        test=report.createTest("Testcase verify Engineering and Construction link");
        prod.clickEnggandConst(test);
    }

    @Test(priority=6, groups = "{homepage_categories}")
    public void testWoodWorkingMachineryLink(){
        test=report.createTest("Testcase verify Woodworking Machinery link link");
        prod.clickWoodWorkingandMachinery(test);
    }

    @Test(priority=7, groups = "{homepage_categories}")
    public void testPlasticMachinery(){
        test=report.createTest("Testcase verify Plastic Machinery link");
        prod.clickPlasticMachinery(test);
    }

    @Test(priority=7, groups = "{homepage_categories}")
    public void testMouldLink(){
        test=report.createTest("Testcase verify Mould link");
        prod.clickMould(test);
    }

    @Test(priority=8, groups = "{homepage_categories}")
    public void testLaserLink(){
        test=report.createTest("Testcase verify Laser link");
        prod.clickLaser(test);
    }

    @Test(priority=9, groups = "{homepage_categories}")
    public void testCastingAndForgingLink(){
        test=report.createTest("Testcase verify Casting and Forging link");
        prod.clickCastingndForeign(test);
    }

    @Test(priority=10, groups = "{homepage_categories}")
    public void testAgricultureLink(){
        test=report.createTest("Testcase verify Agriculture link");
        prod.clickAgricultural(test); 
    }

    @Test(priority=11, groups = "{Footer_links}")
    public void testVerifyFurniture() {
        test=report.createTest("Testcase for verifying click on Furniture");
        home.clickOnFurnitureAndVerifyPage(test);
  
    }

    @Test(priority=12, groups = "{Footer_links}")
    public void testVerifyApparel() {
        test=report.createTest("Testcase for verifying click on Apparel & Clothing ");
        home.clickOnApparalAndVerify(test);
    }

    @Test(priority=13, groups = "{Footer_links}")
    public void testVerifyAutoParts() {
        test=report.createTest("Testcase for verifying click on Auto Parts & Accessories");
        home.clickOnAutoParts(test);
    }

    @Test(priority=14, groups = "{Footer_links}")
    public void testVerifyBags(){
        test=report.createTest("Testcase for verifying click on Bags, Cases & Luggages");
        home.clickOnBags(test);
    }

    @Test(priority=15, groups = "{Footer_links}")
    public void testVerifyComputerProducts() {
        test=report.createTest("Testcase for verifying click on Computer Products");
        home.clickOnComputerProducts(test);
    }

    @Test(priority=16, groups = "{Footer_links}")
    public void testConsumerElectronics() {
        test=report.createTest("Testcase for verifying click on Consumer Electronics");
        home.clickOnConsumerElectronics(test);
    }

    @Test(priority=17, groups = "{Footer_links}")
    public void testVerifyElectricalEquipments() {
        test=report.createTest("Testcase for verifying click on Electrical Equipment");
        home.clickOnElectricalEquipment(test);
    }

    @Test(priority=18, groups = "{Footer_links}")
    public void testVerifyElectricalComponents() {
        test=report.createTest("Testcase for verifying click on Electronic Components");
        home.clickOnElectronicComponent(test);
    }

    @Test(priority=19, groups = "{Footer_links}")
    public void testVerifyGifts() {
        test=report.createTest("Testcase for verifying click on Gifts, Crafts & Collectibles");
        home.clickOnGiftsCrafts(test);
    }

    @Test(priority=20, groups = "{Footer_links}")
    public void testVerifyMotorcycles(){
        test=report.createTest("Testcase for verifying click on Motorcycles & Scooters");
        home.clickOnMotorCyclesAndScooters(test);
    }

    @Test(priority=21, groups = "{Footer_links}")
    public void testVerifySealing(){
        test=report.createTest("Testcase for verifying click on Sealing, Packaging, Storage & Shelving");
        home.clickOnSealingPackaging(test);
    }

    @Test(priority=22, groups = "{Footer_links}")
    public void testVerifyBuildingMaterials() {
        test=report.createTest("Testcase for verifying click on Building Materials & Supplies");
        home.clickOnBuildingMaterials(test);
    }

    @Test(priority=23, groups = "{sign_in}")
    public void testForCorrectCredentials(){
        test=report.createTest("Testcase for verifying the Sign in/Join on homepage, Email box, Verification code message, Sign in now, Forget Password (Incorrect Credentials)");
        signin.WrapperForSignInpageCorrectLogin(test);
    }

   @Test(priority=24, groups = "{sign_in}")
    public void testForInCorrectCredentials(){
        test=report.createTest("Testcase for verifying login Correct Credentials");
        signin.WrapperForSignInpageInCorrectLogin(test);
    }

    @Test(priority=25, groups = "{language}")
    public void test6(){
      test=report.createTest("Select Espanol and verify spanish");
      signin.selectEspanolAndVerify(test);
    }

    @Test(priority=26, groups = "{language}")
    public void test7(){
      test=report.createTest("select Francias and verify French");
      signin.selectFrenchAndVerify(test);
    }

    @Test(priority=27, groups = "{language}")
    public void test8(){
      test=report.createTest("select Deutsch and verify German");
      signin.selectDeutschAndVerify(test);
    }

    @Test(priority=28, groups = "{language}")
    public void test9(){
      test=report.createTest("select russian and verify russian");
      signin.selectRussianAndVerify(test);
    }

    @Test(priority=29, groups = "{language}")
    public void test10(){
      test=report.createTest("select japanese and verify japanese");
      signin.selectJapaneseAndVerify(test);
    }

    @Test(priority=30, groups = "{language}")
    public void test11(){
      test=report.createTest("select English and verify English");
      signin.selectEnglishAndVerify(test);
    }

    @Test(priority=32, groups = "{functionality}")
    public void testEmptySearch(){
        test=report.createTest("Testcase to verify the behaviour when user enters nothing and searches");
        home.checkAlertonEmptySearch(test);
    }

    @Test(priority=33, groups = "{homepage}")
    public void testLinksUnderProductDirectory(){
        test=report.createTest("Testcase For Verifying Buyer Module and various links under it");
        prod.WrapperforBuyerpage(test);
    }

    @Test(priority=34, groups = "{search}")
    public void testFurniture(){
        test=report.createTest("Testcase For Verifying Furniture after searching it in search box");
        furniture.WrapperForFurniture(test);
    }

    @Test(priority=35, groups = "{search}")
    public void testWires(){
        test=report.createTest("Testcase For Verifying Wires after searching it in search box");
        wires.WrapperForWires(test);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
        report.flush();
    }
}