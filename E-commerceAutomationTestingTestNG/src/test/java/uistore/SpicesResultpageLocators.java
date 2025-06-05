package uistore;

import org.openqa.selenium.By;

public class SpicesResultpageLocators {

    //first product
    public  By  firstitem=By.xpath("(//h2[@class='product-name']/a)[1]");

    //first product details
    public By firstProductTitle=By.xpath("//div[@class='sr-proMainInfo-baseInfo-name']/h1");
    public By firsttext=By.xpath("//h1[@class='sr-proMainInfo-baseInfoH1 J-baseInfo-name']");

    //first product contact now
    public By contactnow=By.xpath("(//div[@class='button-block']/a)[1]");
    public By contact1=By.xpath("(//a[@class='btn btn-main'])[1]");
}
