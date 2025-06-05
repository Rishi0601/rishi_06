package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {

	public static WebDriver driver;
	public static FileInputStream file;
	public static Properties prop;

	public void loadProperties() throws IOException {
		String propertiesPath = System.getProperty("user.dir") + "/config/browser.properties";
		try {
			file = new FileInputStream(propertiesPath);
			prop = new Properties();
			prop.load(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void openBrowser() {
		try {
			loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");

		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			LoggerHandler.error("Unsupported browser");
			break;
		}

		if (driver != null) {
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
}
