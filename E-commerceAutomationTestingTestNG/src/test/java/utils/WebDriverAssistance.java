package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.time.Duration;
import java.util.Set;

public class WebDriverAssistance extends Base {
  

    public void waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            // Handle or rethrow the exception here
            //e.printStackTrace();
        }
    }

    public void clickOnElement(By locator,String testDesc,ExtentTest test) {
        try {
            WebElement webElement = driver.findElement(locator);
            webElement.click();
            test.log(Status.PASS,"Click on "+testDesc+" is working");
            LoggerHandler.info("Click on "+testDesc+" performed");
        } catch (Exception e) {
            // Handle or rethrow the exception here
            test.log(Status.FAIL,"Click on "+testDesc+" is not working");
            LoggerHandler.error("Click on "+testDesc+" is not working");
            //e.printStackTrace();
        }
    }

    public void sendKeys(By locator, String data, String testDesc, ExtentTest test) {
        try {
            WebElement webElement = driver.findElement(locator);
            webElement.sendKeys(data);
            test.log(Status.PASS,"Value on "+testDesc+" entered");
            LoggerHandler.info("Value entered in "+testDesc);
        } catch (Exception e) {
            // Handle or rethrow the exception here
            //e.printStackTrace();
            test.log(Status.FAIL,"Value on "+testDesc+" is not entered");
            LoggerHandler.error("Value not entered in "+testDesc);
        }
    }

    public String getText(By locator, ExtentTest test) {
        try {
            WebElement webElement = driver.findElement(locator);
            test.log(Status.PASS,"Text is retrieved");
            LoggerHandler.info("Text is retrieved");
            return webElement.getText();
        } catch (Exception e) {
            // Handle or rethrow the exception here
            //e.printStackTrace();
            test.log(Status.FAIL,"Text is not retrieved");
            LoggerHandler.error("Text is not retrieved");
            return null;
        }
    }

    public void javascriptClick(By locator, String testDesc, ExtentTest test) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            test.log(Status.PASS,"Javascript click on "+testDesc+" performed");
            LoggerHandler.info("Javascript click on "+testDesc+" performed");
        } catch (Exception e) {
            // Handle or rethrow the exception here
            //e.printStackTrace();
            test.log(Status.FAIL,"Javascript click "+testDesc+" is not working");
            LoggerHandler.error("Javascript click on "+testDesc+" is not working");
        }
    }

    public void javascriptScroll(By locator, ExtentTest test) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            test.log(Status.PASS,"JavaScript scroll is working");
            LoggerHandler.info("Javascript scroll is working");
        } catch (Exception e) {
            // Handle or rethrow the exception here
            //e.printStackTrace();
            test.log(Status.FAIL,"Out of scope scroll");
            LoggerHandler.error("Javascript scroll is not working");
        }
    }

    public void switchToNewWindow() {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.isEmpty()) {
                    driver.switchTo().window(windowHandle);
                } else {
                    throw new Exception("New window could not be opened");
                }
                //test.log(Status.PASS,"New tab opened successful");
                LoggerHandler.info("Switch tab happening");
            }
        } catch (Exception e) {
            // Handle or rethrow the exception here
            //e.printStackTrace();
            //test.log(Status.FAIL,"New tab opening failed");
            LoggerHandler.error("Switch tab not happening");
        }
    }

    public void enterAction(By locator, ExtentTest test) {
        try {
            WebElement webElement = driver.findElement(locator);
            webElement.sendKeys(Keys.ENTER);
            test.log(Status.PASS,"Enter Action performed");
            LoggerHandler.info("Enter action performed");
        } catch (Exception e) {
            // Handle or rethrow the exception here
            //e.printStackTrace();
            test.log(Status.FAIL,"Enter action is not performed");
            LoggerHandler.error("Enter action is not performed");
        }
    }

    public  void hoverOverElement(By hoverOverSignInJoinIn, ExtentTest test) {
        try {
            WebElement webElement = driver.findElement(hoverOverSignInJoinIn);
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).perform();
            test.log(Status.PASS,"Hover actions is performed");
            LoggerHandler.info("Hover actions are performed");
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
            test.log(Status.FAIL,"Hover actions is not performed");
            LoggerHandler.error("Hover actions are not performed");
        }
    }

    public void switchToAlert(ExtentTest test){
        try{
            driver.switchTo().alert();
            test.log(Status.PASS,"Alert box is seen");
            LoggerHandler.info("Alert box is seen");
        } catch(Exception e){
            //e.printStackTrace();
            test.log(Status.FAIL,"Alert box not seen");
            LoggerHandler.error("Alert box is not seen");
        }
    }
}
