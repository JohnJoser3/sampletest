
package newpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.Platform;


import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class MyClass {
	public static void main(String[] arg) {
		
		final String USERNAME = "johnjose_pjx5Yk";
		final String AUTOMATE_KEY = "7zNR8G31jxjoyBz7EVhZ";
		String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "11");
		browserstackOptions.put("projectName", "Sample sandbox project");
		browserstackOptions.put("buildName", "Build #1");
		browserstackOptions.put("sessionName", "My First Test");
		capabilities.setCapability("bstack:options", browserstackOptions);

		// WebDriver driver = new ChromeDriver();
	    
		// driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

        WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(URL), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		
		WebElement txtbx_username = driver.findElement(By.id("ap_email"));
		
		txtbx_username.sendKeys("testamazon520@gmail.com");
		
		WebElement button_continue = driver.findElement(By.id("continue"));
		button_continue.click();
		
		WebElement txtbx_password = driver.findElement(By.id("ap_password"));
		txtbx_password.sendKeys("br0wserSt@ck");
		
		WebElement button_signin = driver.findElement(By.id("signInSubmit"));
		button_signin.click();
		
	//	WebElement warning_message = driver.findElement(By.className("a-list-item"));
	//	String warning_incorrect_password = "Your password is incorrect";
		
		
	
		String expected_URL1 = "https://www.amazon.in/ap/signin";
		String expected_URL2 = "https://www.amazon.in/?ref_=nav_signin";
		String actual_URL = driver.getCurrentUrl();
		
		if (expected_URL1.equals(actual_URL) || expected_URL2.equals(actual_URL)  ) {
			System.out.println("Login Successful");
			System.out.println(actual_URL);
			System.out.println(URL);
			
		}
		else {
			System.out.println("Login Failed");
			System.out.println(actual_URL);
			System.out.println(URL);
			
		}
		
		driver.quit();
		
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\JohnJose\\browserdrivers");
	}
}
