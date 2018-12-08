package Hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingFactory {

	 WebDriver wd;

	public BookingFactory(WebDriver driver) {
		
	this.wd=driver;
	PageFactory.initElements(wd, this);
	}
	 
	public BookingFactory() {
		super();
	}

	@FindBy(name="txtFN")
	@CacheLookup
	WebElement fname;
	
	@FindBy(name="txtLN")
	@CacheLookup
	WebElement lname;
	
	
	@FindBy(id="btnPayment")
	@CacheLookup
	WebElement button;
	
	@FindBy(name="Email")
	@CacheLookup
	WebElement email;
	
	
	@FindBy(name="Phone")
	@CacheLookup
	WebElement mobile;
	
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	
    
	
	
	public WebElement getCity() {
		return city;
	}

	public void setCity(String city1) {
		city.sendKeys(city1);
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(String emailid) {
           email.sendKeys(emailid);
	}

	public WebElement getMobile() {
		return mobile;
	}

	public void setMobile(String mobileno) {
		mobile.sendKeys(mobileno);
	}

	public WebElement getLname() {
		return lname;
	}

	public void setLname(String lname1) {
		lname.sendKeys(lname1);
	}

	public WebElement getFname() {
		return fname;
	}

	public void setFname(String fname1) {
		fname.sendKeys(fname1);
	}

	public WebElement getButton() {
		return button;
	}

	public void setButton() {
		button.click();
	}
	
	
	
	
	
	
	
	
}
