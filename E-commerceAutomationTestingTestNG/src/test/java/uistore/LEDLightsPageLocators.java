package uistore;

import org.openqa.selenium.By;

public class LEDLightsPageLocators {


    public By ledlightsLabel=By.xpath("//em[.='LED lights']");
    public By more=By.xpath("//span[.='More']");
    public By striplight=By.xpath("//a[contains(.,'Led Strip Light')]");
    //public By ledStriplight = By.xpath("(//ul[@class='s-list J-s-list'])[1]/li[5]/a");

    //verify 1st item
    public By item = By.xpath("(//div[@class='list-node loadedswiper'])[1]");
    public By contactNow = By.xpath("(//a[@class='btn btn-main'])[1]");
    public By inquiryBasket = By.xpath("(//i[@class='ob-icon icon-cart-add'])[1]");
    
    //categories
    public By lights = By.xpath("(//span[text()='Lights & Lighting'])[3]");
    public By ledTube = By.xpath("//a[text()='LED Tube']");
    public By verifyledkeyword = By.xpath("//h1[text()=' LED Tube ']");
    public By ledlightTube=By.xpath("//a[.='Led Light Tube']");
    public By ledFilter = By.xpath("//span[@class='multi-sub']");
    public By colorTemp=By.xpath("//div[.='Color Temperature']");
    public By ledlightTubeLabel=By.xpath("//h1[.='Led Light Tube']");
    public By warmWhite = By.xpath("(//ul[@class='s-list J-s-list'])[5]/li[2]");
    public By verifywarmWhite=By.xpath("//div[@class='sub-search-box cf']/span");
}
