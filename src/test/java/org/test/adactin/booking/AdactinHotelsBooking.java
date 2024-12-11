package org.test.adactin.booking;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinHotelsBooking 
{
	WebDriver driver;
	@Given("user enters into the Adcatin Hotels LoginPage with invalid credentails")
	@Given("user enters into the Adcatin Hotels LoginPage")
	public void user_enters_into_the_adcatin_hotels_login_page() 
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("http://adactinhotelapp.com/");

	}


	@And("user enters the {string} , {string} and click the login button")
	public void user_enters_the_and_click_the_login_button(String username, String password) 
	{
		//	   driver.findElement(By.id("username")).sendKeys(username);

		//Verfiying if webelement is displayed and Enabled

		WebElement DD = driver.findElement(By.id("username"));
		if(DD.isDisplayed() && DD.isEnabled())
		{
			driver.findElement(By.id("username")).sendKeys(username);
		}
		else 
		{
			System.out.println("Is not avaiable :"+DD.getText());
			driver.quit();
		}

		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();

		try {
			String expected= "Invalid Login details or Your Password might have expired. Click here to reset your password";
		if(driver.findElement(By.xpath("//div[@class='auth_error']")).isDisplayed())
		{
			String actual = driver.findElement(By.xpath("//div[@class='auth_error']")).toString();
			Assert.assertEquals(expected, actual);
		}

		}catch(Exception e) {}
	}

	@Then("user enters the search hotel {string} , {string} , {string} and {string}")
	public void user_enters_the_search_hotel_and(String losangeles, String Hotelsunshine, String Standard, String four) 
	{
		driver.findElement(By.xpath("//select[@name='location']//following::option[@value='"+losangeles+"']")).click();
		driver.findElement(By.xpath("//select[@name='hotels']//following::option[@value='"+Hotelsunshine+"']")).click();
		driver.findElement(By.xpath("//select[@name='room_type']//following::option[@value='"+Standard+"']")).click();
		Select tempse= new Select(driver.findElement(By.id("room_nos")));
		 
		tempse.selectByValue(four);
	}
	@And("close browser")
	public void closebrowser() 
	{
		driver.close();
		driver.quit();
	}
	@And("user enters and check the date {string} and {string}")
	public void user_enters_the_check_date_and(String checkinDate, String checkoutDate) throws AWTException, InterruptedException 
	{
		//		WebElement checkin = driver.findElement(By.xpath("//input[@name='datepick_in']"));
		//		checkin.click();
		//		Thread.sleep(2000);
		//		String W = checkin.toString();
		//		Robot D = new Robot();
		//		for(int i=0; i<W.length()-1; i++)
		//		{
		//			D.keyPress(KeyEvent.VK_RIGHT);
		//			D.keyRelease(KeyEvent.VK_RIGHT);
		//			D.keyPress(KeyEvent.VK_BACK_SPACE);
		//			D.keyRelease(KeyEvent.VK_BACK_SPACE);
		//
		//		}

		String temp;
		Robot D = new Robot();
		WebElement checkin=null;
		do
		{
			checkin = driver.findElement(By.xpath("//input[@name='datepick_in']"));
			checkin.click();
			D.keyPress(KeyEvent.VK_RIGHT);
			D.keyRelease(KeyEvent.VK_RIGHT);
			D.keyPress(KeyEvent.VK_BACK_SPACE);
			D.keyRelease(KeyEvent.VK_BACK_SPACE);

			temp=checkin.getAttribute("value");
		}while(temp.length() > 0);

		checkin.sendKeys(checkinDate);

		//date pick out
		WebElement checkout = driver.findElement(By.xpath("//input[@name='datepick_out']"));
		checkout.click();
		D.keyPress(KeyEvent.VK_CONTROL);
		D.keyPress(KeyEvent.VK_A);
		D.keyRelease(KeyEvent.VK_CONTROL);
		D.keyRelease(KeyEvent.VK_A);
		D.keyPress(KeyEvent.VK_DELETE);
		checkout.sendKeys(checkoutDate);
	}

	@And("user enters the {string} and {string}")
	public void user_enters_the_and(String string, String string2) throws InterruptedException 
	{
		Select tempse1= new Select(driver.findElement(By.id("child_room")));
		tempse1.selectByValue(string2);
		Select tempse2= new Select(driver.findElement(By.id("adult_room")));
		tempse2.selectByValue(string);
		Thread.sleep(4000);
		//	   driver.findElement(By.xpath("(//select[@id='adult_room']//following::option[@value='"+string+"'])[1]")).click();
		//	   driver.findElement(By.xpath("(//select[@id='child_room']//following::option[@value='1'"+string2+"])[1]")).click();
	}

	@Then("user click the search button")
	public void user_click_the_search_button() 
	{
		driver.findElement(By.cssSelector("input#Submit")).click();
	}



	@Then("user verify the search results")
	public void user_verify_the_search_results() 
	{
		WebElement verify = driver.findElement(By.xpath("//td[text()='Select Hotel ']"));
		String string = verify.toString();
		if(string.contains("Select Hotel"))
		{
			System.out.println("Verified :"+string);
			driver.quit();
		}
		else
		{
			System.out.println("If not Verified :"+string);

		}

	}


	@Then("user click the Reset button")
	public void user_click_the_reset_button()
	{

	}



}
