package com.MavenTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.HelperM;

public class AlertsChromeTest {
	@Test
	  public void Popup() throws InterruptedException {
	    	
		WebDriver driver = HelperM.startBrowser("GC");
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert1.accept();
		String Res1 =driver.findElement(By.id("result")).getText();
		Assert.assertEquals(Res1, "You successfully clicked an alert");
		System.out.println("Res1 is  :" +Res1);
				
		  driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		  Thread.sleep(2000); Alert alert2 = driver.switchTo().alert();
		  Thread.sleep(2000); alert2.accept(); 
		  
		  String Res2 = driver.findElement(By.id("result")).getText(); Assert.assertEquals(Res2,
		  "You clicked: Ok");
		  //System.out.println(Res2);
		  System.out.println("Res2 is  :" +Res2);
		  
		  driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		  Thread.sleep(2000); Alert alert3 = driver.switchTo().alert();
		  alert3.sendKeys("HI DVL"); Thread.sleep(2000); alert3.accept(); 
		  String Res3 =driver.findElement(By.id("result")).getText(); //Assert.assertEquals(Res3, "You entered:"); 
		  //Assert.assertEquals("You entered:" ,Res3);
		  Assert.assertEquals("You entered: HI DVL", Res3); 
		  System.out.println(Res3);
		  System.out.println("Res3 is  :" +Res3);
		 // driver .quit();
		 	
	}
	
}
