package uistore;

import org.openqa.selenium.By;

public class FillformPageLocators {
    
    //verify the contact now page
    public By verifypage = By.xpath("//div[@class='inquiry-com-hd']");

    //input in the content form
    public By content = By.xpath("//*[@id='content']");
    public By email = By.xpath("//*[@id='senderMail']");
    public By sendInquiry = By.xpath("(//input[@value='Send Inquiry Now'])[1]");

    //navigating to new page
    public By dropdownName = By.xpath("(//div[@class='select-arrow J-arrow'])[1]");
    public By fullName = By.cssSelector("input#senderName");
    public By companyName = By.cssSelector("input#comName");
    public By country = By.xpath("(//label[text()='India'])[1]");
    public By dropdownContact = By.xpath("//i[@class='ft-icon icon-down ft-select-arrow']");
    public By contactNo = By.cssSelector("input#senderMobile");
    public By website = By.cssSelector("input#senderHomePage");
    
    public By sendEnquiry = By.xpath("(//input[@value='Send Inquiry Now'])[1]"); 
    public By successMsg=By.xpath("//div[@class='ft-result__desc recommend J-msg-h2']");
    public By logo=By.xpath("//div[@class='nail-logo']/a");
}