package stepsDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ScreenShotCapture;
import Constants.Constants;
public class Hooks {

			WebDriver driver;
			Properties p;
			ScreenShotCapture screenshotcapture = new ScreenShotCapture(); 
			
			@Before
		    public void setup() throws IOException
		    {
		    	driver=BaseClass.initilizeBrowser();
		    	    	
		    	p=BaseClass.getProperties();
		    	driver.get(p.getProperty("appURL"));
		    	driver.manage().window().maximize();
		    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
			}
				
		    @After
		    public void tearDown(Scenario scenario) {	
		       driver.quit(); 
		    }
		   
		    @AfterStep
		    public void addScreenshot(Scenario scenario)
		    {
		        if(scenario.isFailed()) 
		        {
		        screenshotcapture.takeScreenShot(driver, scenario.getName());
		        }
		    }
	}

