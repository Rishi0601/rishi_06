package uistore;

import org.openqa.selenium.By;

public class ProductDirectoryPageLocators {

    //validating new user guide page
    public By page = By.xpath("//div[@class='banner-nav J-banner-nav']");
    
    //back button
    public By backbutton = By.xpath("//a[@class='m-logo']");
    
    //public By auditsupply = By.xpath("(//a[@class='nail-link'])[15]");
    public By auditsupply = By.xpath("//*[@id='header']/div/div[2]/div/div[2]/span[2]/div/div/div/div[2]/div/div/div[1]/div/div[2]/div[2]/a");
    
    //url = https://www.made-in-china.com/audited-suppliers/for-buyers/?pv_id=1htp2nv0m087&faw_id=1htp4unjaf97
    public By verifyTitle = By.xpath("//a[@title='Audited Chinese Suppliers']");
    public By verifycontent = By.xpath("//div[@class='big-pic as-cn']");
    public By meetsupplier = By.xpath("//a[text()='Meet Suppliers']");
    
    //url = https://sourcing.made-in-china.com/tradeservice/private-sourcing-meetings.html?pv_id=1htp2nv0m087&faw_id=1htp6jel4283
    public By verifycontent1 = By.xpath("//div[@class='offline-banner']");

    //navigate back to product directory
    public By enggAndConstr=By.xpath("(//a[@class='item-anchor'])[2]");
    public By woodWorkinMachinery=By.xpath("(//a[@class='item-anchor'])[3]");
    public By plasticMachinery=By.xpath("(//a[@class='item-anchor'])[4]");
    public By metallicProcessingMachinery=By.xpath("(//a[@class='item-anchor'])[5]");
    public By mould=By.xpath("(//a[@class='item-anchor'])[6]");
    public By laser=By.xpath("(//a[@class='item-anchor'])[7]");
    public By castingAndForeign=By.xpath("(//a[@class='item-anchor'])[8]");
    public By agriculturalMachinery=By.xpath("(//a[@class='item-anchor'])[9]");

    //product page navigations
    public By machineTools=By.xpath("(//a[@class='item-anchor'])[1]");
    public By manufacturingAndProcessing=By.xpath("(//span[contains(text(),'Processing Machinery')])[3]");
    public By text=By.xpath("//h1[@class='cate-title']");
    public By consumerEle=By.xpath("(//span[text()='Consumer Electronics'])[3]");
    public By industrialEquip=By.xpath("(//span[text()='Industrial Equipment & Components'])[3]");
    public By electricalAndElectronics=By.xpath("(//span[text()='Electrical & Electronics'])[3]");
    public By constructionDecoration=By.xpath("(//span[text()='Construction & Decoration'])[3]");
    public By lightIndustry=By.xpath("(//span[text()='Light Industry & Daily Use'])[3]");
    public By autoMotorcycle=By.xpath("(//span[text()='Auto, Motorcycle Parts & Accessories'])[3]");
    public By apparelAccessories=By.xpath("(//span[text()='Apparel & Accessories'])[3]");
    public By lightsAndLighting=By.xpath("(//span[text()='Lights & Lighting'])[3]");
    public By sportingGoods=By.xpath("(//span[text()='Sporting Goods & Recreation'])[3]");
}
