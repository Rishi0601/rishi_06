package uistore;

import org.openqa.selenium.By;

public class HomepageLocators {

    //logo and search 
    public By madeInChinaLogo=By.xpath("//a[@class='logo-link']");
    public By searchBar=By.xpath("//input[@class='nail-search-input']");
    
    // Enter eletronics from (Excel/Feature File)
    public By searchButton=By.cssSelector("button#J-nail-search-submit");

    //sign in/join in
    public By signIn= By.xpath("//div[@class='sign-link']");
    public By hoverOverSignInJoinIn=By.xpath("//div[@class='login-link']");
    public By clickJoinFree=By.xpath("(//a[text()='Join Free'])[1]");
    public By signInBtn=By.cssSelector("button#sign-in-submit");

    //buyer
    public By buyer=By.xpath("//a[text()='Buyer']");
    public By productDirectory=By.xpath("//a[text()='Product Directory']");
    public By newusrguide = By.xpath("//a[contains(text(),'Guide')]");

    //footer links
    public By furniture=By.xpath("(//a[@title='Furniture'])[2]");
    public By verifyFurniturePage=By.xpath("//h1[@class='h2 fl']");
    public By apparelAndClothing=By.xpath("//a[@title='Apparel & Clothing']");
    public By verifyApparelPage=By.xpath("//h1[@class='h2 fl']");
    public By autoPartsAndAccessories=By.xpath("//a[@title='Auto Parts & Accessories']");
    public By verifyAutoPartsPage=By.xpath("//h1[@class='h2 fl']");
    public By bagsCases=By.xpath("//a[@title='Bags, Cases & Luggages']");
    public By verifyBagsPage=By.xpath("//h1[@class='h2 fl']");
    public By computerProducts=By.xpath("//a[@title='Computer Products']");
    public By verifyComputerPage=By.xpath("//h1[@class='h2 fl']");
    public By consumerElectronics=By.xpath("//a[@title='Consumer Electronics']");
    public By verifyConsumerPage=By.xpath("//h1[@class='h2 fl']");
    public By electricalEquipment=By.xpath("//a[@title='Electrical Equipment']");
    public By verifyElectricalPage=By.xpath("//h1[@class='h2 fl']");
    public By electronicComponent=By.xpath("//a[@title='Electronic Components']");
    public By verifyElectronicPage=By.xpath("//h1[@class='h2 fl']");
    public By giftsCrafts=By.xpath("//a[@title='Gifts, Crafts & Collectibles']");
    public By verifyGiftsPage=By.xpath("//h1[@class='h2 fl']");
    public By motorcycles=By.xpath("//a[@title='Motorcycles & Scooters']");
    public By verifyMotorcyclesPage=By.xpath("//h1[@class='h2 fl']");
    public By sealing=By.xpath("//a[@title='Sealing, Packaging, Storage & Shelving']");
    public By verifySealingPage=By.xpath("//h1[@class='h2 fl']");
    public By buildingMaterials=By.xpath("//a[@title='Building Materials & Supplies']");
    public By verifyBuildingPage=By.xpath("//h1[@class='h2 fl']");
}
