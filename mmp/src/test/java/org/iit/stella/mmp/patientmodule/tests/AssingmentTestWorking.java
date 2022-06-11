package org.iit.stella.mmp.patientmodule.tests;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssingmentTestWorking {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		js = (JavascriptExecutor) driver;
		 
	}

	@Test
	public void assingment() throws InterruptedException {
		driver.get("https://demoqa.com/");
		js.executeScript("window.scrollTo(0,400)");
		driver.findElement(By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']")).click();
		WebElement e = driver.findElement(By.xpath("//span[normalize-space()='Alerts']"));
		e.click();
		driver.findElement(By.xpath("//span[normalize-space()='On button click, alert will appear after 5 seconds']/parent::div/following-sibling::div/button")).click();
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		Alert alrt = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alrt.getText());
		alrt.accept();
	}
}
