package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class PaymentPage {

    private WebDriver driver;
	private WebDriverWait wait;
	
	private By contactDetails = By.tagName("contact-details");
	private By countryCode = By.xpath("//button/div");
	private By spainCode = By.xpath("//ry-dropdown-item[179]/button/div/div");
	private By phoneNumber = By.name("undefined");
	private By noInsured = By.xpath("//div[3]/div/ry-checkbox/label/div/div");
	private By cardNumber = By.xpath("(//input[@name='undefined'])[2]");
	private By expiryMonth = By.xpath("//expiry-date/div/span[2]/div[1]/ry-dropdown/div");
	private By august = By.xpath("//expiry-date/div/span[2]/div[1]/ry-dropdown/div/div/div/ry-dropdown-item[8]");
	private By expiryYear = By.xpath("//expiry-date/div/span[2]/div[2]/ry-dropdown/div");
	private By _2024 = By.xpath("//expiry-date/div/span[2]/div[2]/ry-dropdown/div/div/div/ry-dropdown-item[4]");
	private By securityCode = By.xpath("(//input[@name='undefined'])[3]");
	private By holderName = By.xpath("(//input[@name='undefined'])[4]");
	private By address = By.xpath("(//input[@name='undefined'])[5]");
	private By city = By.xpath("(//input[@name='undefined'])[7]");
	private By country = By.xpath("//address-form/form/ry-autocomplete/div/div/div[1]");
	private By spain = By.xpath("//address-form/form/ry-autocomplete/div[2]/div[179]/div");
	private By zipCode = By.xpath("(//input[@name='undefined'])[8]");
	private By currency = By.xpath("//form/div/div/div/div[2]/ry-dropdown/div[2]/button");
	private By euro = By.xpath("//form/div/div/div/div[2]/ry-dropdown/div[2]/div/div/ry-dropdown-item/button/div/div");
	private By termConditions = By.xpath("//terms-and-conditions/div/div/ry-checkbox/label/div/div");
	private By btnPay = By.xpath("//div/pay-button/div/button");
	private By errorMessage = By.xpath("//payment-methods/div/div/ry-tabs/div[2]/ry-alert/div/div/div");
	
	
    public PaymentPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
		this.wait = wait;
    }

    public void enterPhoneNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactDetails));
        driver.findElement(countryCode).click();
        driver.findElement(spainCode).click();
        driver.findElement(phoneNumber).click();
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys("696548722");
    }

    public void tickNoInsurance() {
        driver.findElement(noInsured).click();
    }

    public void enterCardNumber() {
        driver.findElement(cardNumber).click();
        driver.findElement(cardNumber).clear();
        driver.findElement(cardNumber).sendKeys("5555555555555557");
    } 

    public void enterCardExpiryDate() {
    	driver.findElement(expiryMonth).click();
    	driver.findElement(august).click();
    	driver.findElement(expiryYear).click();
    	driver.findElement(_2024).click();   
    }

    public void enterCardSecurityCode() {
        driver.findElement(securityCode).click();
        driver.findElement(securityCode).clear();
        driver.findElement(securityCode).sendKeys("123");
    }

    public void enterCardholderName() {
        driver.findElement(holderName).click();
        driver.findElement(holderName).clear();
        driver.findElement(holderName).sendKeys("Carlos Romero");
    }

    public void enterAddress() {
        driver.findElement(address).click();
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys("C. Barraquer, 20 1D");
        driver.findElement(city).click();
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys("Getafe");
        driver.findElement(country).click();
        driver.findElement(spain).click();
        driver.findElement(zipCode).click();
        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys("28054");
    }

    public void selectCurrency() {
        driver.findElement(currency).click();
        driver.findElement(euro).click();
    }

    public void confirmTermsAndConditions() {
        driver.findElement(termConditions).click();
    }

    public void clickPay() throws InterruptedException {
    	wait.until(ExpectedConditions.presenceOfElementLocated(btnPay));
    	Thread.sleep(500); 
        driver.findElement(btnPay).click();
    }

    public void verifyErrorText() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String message = driver.findElement(errorMessage).getText();
        assertTrue(message.contains("Transaction could not be processed. Your payment was not authorised therefore we could not complete your booking. Please ensure that the information was correct and try again or use a new payment card."));
    }
    
}