package org.test.adactin.booking1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinHotelsBooking1 
{
WebDriver driver;
	
	@Given("user enters into the Adcatin Hotels LoginPage")
	public void user_enters_into_the_adcatin_hotels_login_page() 
	{
	   WebDriverManager.edgedriver().setup();
	   driver = new EdgeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.navigate().to("http://adactinhotelapp.com/");
	}
	
	@When("user enters the {string} , {string} and click the login button")
	public void user_enters_the_and_click_the_login_button(String username, String password) 
	{
	   driver.findElement(By.id("username")).sendKeys(username);
	   driver.findElement(By.id("password")).sendKeys(password);
	   driver.findElement(By.id("login")).click();
	}
	
	@Then("user enters the search hotel {string} , {string} , {string} and {string}")
	public void user_enters_the_search_hotel_and(String losangeles, String Hotelsunshine, String Standard, String four) 
	{
	   driver.findElement(By.xpath("//select[@name='location']//following::option[@value='London']")).click();
	   driver.findElement(By.xpath("//select[@name='hotels']//following::option[@value='Hotel Creek']")).click();
	   driver.findElement(By.xpath("//select[@name='room_type']//following::option[@value='Double']")).click();
	   driver.findElement(By.xpath("//select[@name='room_nos']//following::option[@value='2']")).click();
	   
	}

	@And("user enters and check the date {string} and {string}")
	public void user_enters_the_check_date_and(String checkinDate, String checkoutDate) 
	{
	   driver.findElement(By.xpath("//input[@value='08/09/2023']")).sendKeys(checkinDate);
	   driver.findElement(By.xpath("//input[@value='09/09/2023']")).sendKeys(checkoutDate);
		
	}

	@And("user enters the {string} and {string}")
	public void user_enters_the_and(String string, String string2) 
	{
	   driver.findElement(By.xpath("(//select[@id='adult_room']//following::option[@value='2'])[1]")).click();
	   driver.findElement(By.xpath("(//select[@id='child_room']//following::option[@value='2'])[1]")).click();
	}
	
	@And("user click the search button")
	public void user_click_the_search_button() 
	{
		driver.findElement(By.cssSelector("input#Submit")).click();
	}

}
