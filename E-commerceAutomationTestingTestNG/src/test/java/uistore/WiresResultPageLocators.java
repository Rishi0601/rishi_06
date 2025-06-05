package uistore;

import org.openqa.selenium.By;

public class WiresResultPageLocators {
    
    //wires
    public By firstProductLink=By.xpath("(//h2[@class='product-name']/a)[1]");
    public By wires=By.xpath("//em[text()='Wires']");
    public By firstpage=By.xpath("//span[@class='current']");
    public By pagination2 = By.xpath("//a[text()='2']");
    public By pagination1 = By.xpath("//a[text()='1']");
    public By header = By.xpath("(//a[@class='nail-link'])[1]");
    public By supplierName=By.xpath("(//div[@class='sr-side-contSupplier-txt'])[1]/div[1]");
    public By supplierDesignation=By.xpath("(//div[@class='sr-side-contSupplier-txt'])[1]/div[2]");
}
