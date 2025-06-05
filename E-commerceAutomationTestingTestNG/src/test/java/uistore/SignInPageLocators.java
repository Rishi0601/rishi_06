package uistore;

import org.openqa.selenium.By;

public class SignInPageLocators {

    //email box
    public By identifyEmail=By.xpath("//div[text()='Email']");

    //Enter Email
    public By enterEmail=By.cssSelector("input#userEmail");
    
    //CLick on Check Box
    public By verifyAccount=By.className("box-title");
    public By agreeCheckBox=By.xpath("//div[@class='form-item']/div/label/input");
    public By nextButton=By.cssSelector("button#submitEmail");

    //verify Please enter the verification code.
    public By checkVerifactionText=By.xpath("//label[contains(text(),'verification code.')]");
    //h4/a[contains(text(),'SAP M')]

    //Page Refreshed
    public By clickSignInNow=By.xpath("//a[text()='Sign in now']");

    //Enter UserName
    public By enterUserName=By.xpath("//input[@id='logonInfo.logUserName']");

    //Enter Password
    public By enterPass=By.id("logonInfo.logPassword");
    //click Login
    public By loginButton=By.xpath("//button[text()='Sign In']");
    
    //Error Message info
    public By errorMessage=By.id("error_title");
    
    //Click on forgetPass
    public By forgetPass=By.xpath("//a[text()='Forgot your password? ']");
    
    //click Continue Button after reaching to forgetpass Page
    public By continueButton=By.cssSelector("button#continue-submit");
    
    //Verfiy Text
    public By verifyText=By.xpath("//div[contains(text(),'Please enter the email address')]");
    public By hoverOnSign=By.xpath("//div[@class='nl-refer']");
    
    //Verify username after login success
    public By hoverAccount=By.xpath("//a[.='Account']");
    public By userName=By.xpath("//div[@class='login-name']");

    //dropdown
    //public static By hoverOnSign=By.xpath("//span[text()='Sign in']");
    public By hoverOnDropdown=By.xpath("//div[@class='language-switch pc-show']");

    //Iniciar sesión'
    public By Espanol=By.xpath("(//a[text()='Español'])[1]");
    public By submit=By.cssSelector("button#sign-in-submit");

    //S'identifier--> text for france to verify
    public By Français=By.xpath("(//a[text()='Français'])[1]");
  
    //Einloggen
    public By Deutsch=By.xpath("(//a[text()='Deutsch'])[1]");
   
    //Войти
    public By Russian=By.xpath("(//a[text()='Русский язык'])[1]");

    //ログイン
    public By Japanese=By.xpath("(//a[text()='日本語'])[1]");
   
    //Sign In
    public By English=By.xpath("(//a[text()='English'])[1]");
}
