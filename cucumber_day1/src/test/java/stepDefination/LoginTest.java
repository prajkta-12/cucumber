package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	public static WebDriver driver;
	PageObjects po;

	@Given("^Navigate to Home page$")
	public void NavigatetoHomepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		po = new PageObjects(driver);

	}

	@When("^user enters username and password$")
	public void userentersusernameandpassword() {
		po.SignIn.click();
		po.userName.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.Login.click();
	}

	@Then("^user logged in successfully$")
	public void userloggedinsuccessfully() {
		System.out.println("User login successfully");

	}

	@When("^Larry searches below products in the search box:$")
	public void Larrysearchesbelowproductsinthesearchbox(DataTable dt) {

		List<String> product = dt.asList(String.class);

		for (String s : product) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value ='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
			driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		}
	}

	@Then("product should be added in the cart if available")
	public void productshouldbeaddedinthecartifavailable() {

	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Loginwithvalidcredentials(String userName, String password) {
		po.SignIn.click();
		po.userName.sendKeys(userName);
		po.password.sendKeys(password);
		po.Login.click();

	}

}
