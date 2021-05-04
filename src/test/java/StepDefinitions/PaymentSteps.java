package StepDefinitions;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import PageObjects.PaymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PaymentPage;
import pages.SeatsPage;
import pages.BagsPage;
import pages.ExtrasPage;
import pages.FlightPage;

public class PaymentSteps {
		
    private WebDriver driver = null;
	private WebDriverWait wait = null;

    private HomePage homePage = null;
    private FlightPage flightPage = null;
    private SeatsPage seatsPage = null;
    private BagsPage bagsPage = null;
    private ExtrasPage extrasPage = null;
    private PaymentPage paymentPage = null;
	

	@Given("user is on Ryanair main page")
	public void user_is_on_ryanair_main_page() {

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);
	
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
//		System.setProperty("webdriver.firefox.driver", projectPath+"/src/test/resources/drivers/geckodriver.exe");

		driver = new ChromeDriver();
//		driver = new FirefoxDriver();	

		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().window().setPosition(new Point(0, 0));
		
		wait = new WebDriverWait(driver, 20);
	
		homePage = new HomePage(driver, wait);
		paymentPage = new PaymentPage(driver, wait);
		flightPage = new FlightPage(driver, wait);
		seatsPage = new SeatsPage(driver, wait);
		bagsPage = new BagsPage(driver, wait);
		extrasPage = new ExtrasPage(driver, wait);
		
	}
	
	@And("user do login")
	public void user_do_login() {
        homePage.closeCookiesPopUp();
        homePage.clickLogin();
        homePage.enterEmail("basuracarlos@hotmail.com");
        homePage.enterPassword("Mermut4q");
        homePage.submitLogin();
    }

	@And("user search for a flight")
	public void user_search_for_a_flight() throws InterruptedException {
        homePage.chooseDeparture("Athens");
    	homePage.chooseOneway();
        homePage.chooseDestination("Dublin");
        homePage.chooseDepartDate();
        homePage.addAdults();
        homePage.addChildren();
        homePage.clickSearch();
        flightPage.selectFlight();
        flightPage.selectFare();
	}
	
	@And("user introduces personal information")
	public void user_introduces_personal_information() {
        flightPage.enterAdult1Info();
        flightPage.enterAdult2Info();
        flightPage.enterChildInfo();
        flightPage.clickContinue();
	}
	
	@And("user selects details of flight") 
	public void user_selects_details_of_flight() throws InterruptedException {
        seatsPage.closeSeatingPopup();
        seatsPage.selectSeats();
        bagsPage.addBags();
        extrasPage.clickContinueAnythingElse();
	}
	
	@And("user confirms details and price")
	public void user_confirms_details_and_price()  throws InterruptedException {
        homePage.viewBasket();
        homePage.checkOut(); 
	}

    @When("user pays with invalid credit card")
    public void user_pays_with_invalid_credit_card() throws InterruptedException {
        paymentPage.enterPhoneNumber();
        paymentPage.tickNoInsurance();
        paymentPage.enterCardNumber();
        paymentPage.enterCardExpiryDate();
        paymentPage.enterCardSecurityCode();
        paymentPage.enterCardholderName();
        paymentPage.enterAddress();
        paymentPage.selectCurrency();
        paymentPage.confirmTermsAndConditions();
        paymentPage.clickPay();
    }

    @Then("system should display a declined payment message")
    public void system_should_display_a_declined_payment_message() {
        paymentPage.verifyErrorText();
   }
	
}