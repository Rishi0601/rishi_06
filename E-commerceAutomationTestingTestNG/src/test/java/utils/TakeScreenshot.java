package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshot extends Base{
    
    public static void takeScreenshot(String filename){
        String timestamp = new SimpleDateFormat("ss-HH-dd-MM-yyyy").format(new Date());
		String name = filename + timestamp + ".png";
        TakesScreenshot screenShot=((TakesScreenshot)driver);
        File source=screenShot.getScreenshotAs(OutputType.FILE);
        String filePath=System.getProperty("user.dir")+"/screenshots";
        File screenshotDirectory=new File(filePath);
        if (!screenshotDirectory.exists()) {
			screenshotDirectory.mkdirs();
		}
        File destination=new File(screenshotDirectory, name);
        try {
            FileHandler.copy(source,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
