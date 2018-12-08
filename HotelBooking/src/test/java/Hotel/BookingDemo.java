package Hotel;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingDemo {
	
    WebDriver driver=null;
	BookingFactory  fact=null;
	String error;
    
	
	@Given("^User is on the Registration page$")
	public void user_is_on_the_Registration_page() throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		driver=new FirefoxDriver();
		fact=new BookingFactory(driver);
		driver.get("file:///C:/Users/sagadi/Desktop/Hotel%20Booking.html");
				//Thread.sleep(1000);
		
	}
	
	
	@Then("^check title of the page$")
	public void check_title_of_the_page()  {
	    
		
		String exp="Hotel Booking";
		String act=driver.getTitle();
		if(exp.equals(act))
		{
			System.out.println("Matched");
		}
		else
		{
			System.out.println("not matched");
		}
		
	   
	}

	@When("^User enters invalid first name$")
	public void user_enters_invalid_first_name(DataTable names) throws InterruptedException  {
		
		List<String> list=names.asList(String.class);
	    String data=null;
	    for (String fname : list) {
    	
	    	//System.out.println("----------"+fname);
	    	data=fname;
	    	//SSystem.out.println("data...."+data);
	    	fact.setFname("sandhya");
	    	fact.getFname().clear();
	    	fact.setFname(fname);
	    	Thread.sleep(1000);
	    	fact.setButton();
			
		
	    
	    if (Pattern.matches("^[A-Za-z]{4,35}$",fname)) {
			System.out.println("Matching ");
		} else {
			String alertMessage = driver.switchTo().alert().getText();
			Thread.sleep(1000);
		    driver.switchTo().alert().accept();
			System.out.println("not matched "+alertMessage);
			error=alertMessage;
		
		}	   
	    	}
		System.out.println(list);
	  
	}
	
	

	@Then("^user should get an error message$")
	public void user_should_get_an_error_message()  {
	      System.out.println(error);	
	
	}
	

	@When("^User enters invalid last name$")
	public void user_enters_invalid_last_name(DataTable lastname) throws InterruptedException {
	    
		List<String> list=lastname.asList(String.class);
	    String data=null;
	    for (String lname : list) {
    	
	    	//System.out.println("----------"+fname);
	    	data=lname;
	    	//SSystem.out.println("data...."+data);
	    	fact.getFname().clear();
	    	fact.setFname("sandhya");
	    	fact.getLname().clear();
	    	fact.setLname(lname);
	    	Thread.sleep(1000);
	    	fact.setButton();
			
		
	    
	    if (Pattern.matches("^[A-Za-z]{4,35}$",lname)) {
			System.out.println("Matching ");
		} else {
			String alertMessage = driver.switchTo().alert().getText();
			Thread.sleep(1000);
		    driver.switchTo().alert().accept();
			System.out.println("not matched "+alertMessage);
			error=alertMessage;
		
		}	   
	    	}
		System.out.println(list);
	   
	}
     
	@When("^User enters invalid (\\d+)$")
	public void user_enters_invalid(Integer phone) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fact.getFname().clear();
    	fact.setFname("jjkjmk");
    	fact.setLname("gadi");
    	fact.setEmail("abc@gmail.com");
    	String phn=phone.toString();
    	fact.setMobile(phn);
    	Thread.sleep(1000);
    	fact.setButton();
    	
    	if (Pattern.matches("^[6-9][0-9]{9}",phn)) {
			System.out.println("Matching ");
		} else {
			String alertMessage = driver.switchTo().alert().getText();
			Thread.sleep(1000);
		    driver.switchTo().alert().accept();
			System.out.println("not matched "+alertMessage);
			error=alertMessage;
		
		}	   
    	
	}
	
	
	
	@When("^User clicks drop down list$")
	public void user_clicks_drop_down_list() throws InterruptedException {
		
		fact.getFname().clear();
    	fact.setFname("jjkjmk");
    	fact.setLname("gadi");
    	fact.setEmail("abc@gmail.com");
    	fact.setMobile("9912345678");
    	Select city=new Select(fact.city);
    	fact.setCity("chennai");
    	Thread.sleep(1000);
    	fact.setButton();
    	
    	String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
	    driver.switchTo().alert().accept();
    	
    	
    	
		
	 
		
	}

	@Then("^user should get the city name$")
	public void user_should_get_the_city_name(){
	   
	  System.out.println("-----------"+fact.getCity());
	}
	
	
	
	
	
	
	
	
	
	@After
	public void destroy() {
		driver.quit();
	}

	
	

}
