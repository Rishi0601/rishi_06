package uistore;

import org.openqa.selenium.By;

public class ElectronicsPageLocators {

    //electronics label
    public By electronicsLabel=By.xpath("//em[.='electronics']");
    
    //get title to check electronics is present in title or not
    public By supplierList=By.xpath("//ul[@class='tab']/li[2]/a");
    
    //get the consumer electronics
    public By consumerElectronicsLabel=By.xpath("//span[@class='refine-selected']");
    
    //Identify Category text in 
    public By categoriesBar=By.xpath("//h3[text()='Category']");
    public By consumerElectronics=By.xpath("//a[text()='Consumer Electronics ']");
    
    //check for ManagementCertification text
    public By managementCertiFication=By.xpath("//h3[text()='Management Certification']");
    public By iso9000=By.xpath("//dl[@class='refine-node'][2]/dd/a[3]");
    
    //iso label
    public By isoLabel=By.xpath("//dl[@class='refine-node'][2]/dd/span");
    
    //scroll to member and type
    public By memberType=By.xpath("//h3[text()='Member & Type']");
    public By diamondMember=By.xpath("(//a[@title='Suppliers with verified business licenses.'])[1]'");
    
    //check checkbox diamondmember is clicked or not
    public By firstElement=By.xpath("(//h2[@class='company-name'])[1]");
}