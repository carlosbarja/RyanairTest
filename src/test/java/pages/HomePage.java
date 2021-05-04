package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private final String URL = "https://www.ryanair.com/ie/en";
	
	private By btnYesCookies = By.className("cookie-popup-with-overlay__button");
	private By lnkLogIn = By.xpath("//hp-header-menu-item[4]/button/span");
	private By popUpLogIn = By.className("auth-popup");
	private By fieldEmail = By.xpath("//input[@name='email']");
	private By fieldPassword = By.xpath("//input[@name='password']");
	private By fieldFrom = By.id("input-button__departure");
	private By fieldTo = By.id("input-button__destination");
	private By airport = By.xpath("//fsw-airport-item/span/span");
	private By checkOneWay = By.xpath("//fsw-trip-type-button[2]");
	private By selectDate = By.xpath("//div[@data-id='2021-06-20']");
	private By plusAdults = By.xpath("//ry-counter/div[2]/div[3]");
	private By plusChild = By.xpath("//ry-counter[3]/div[2]/div[3]");
	private By btnSearch = By.tagName("ry-spinner");
	private By popUpBasket = By.linkText("View basket");
	private By btnCheckOut = By.xpath("//ry-basket-continue-flow/button");

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		driver.get(URL);
	}
	
	
	public void closeCookiesPopUp(){
		driver.findElement(btnYesCookies).click();
	}
	
    public void clickLogin() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(lnkLogIn));
        driver.findElement(lnkLogIn).click();
    }
    
    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpLogIn));
        WebElement emailInput = driver.findElement(fieldEmail);
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
	
    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(fieldPassword);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    
    public void submitLogin(){
        WebElement loginPopup = driver.findElement(popUpLogIn);
        WebElement form = loginPopup.findElement(By.tagName("form"));
        form.submit();
    }
    
    public void chooseDeparture(String city) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUpLogIn));
        WebElement departureField = driver.findElement(fieldFrom);
        departureField.click();
        departureField.clear();
        departureField.sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(airport));
        driver.findElement(airport).click();
    }
    
    public void chooseDestination(String city) {
        WebElement destinationField = driver.findElement(fieldTo);
        destinationField.click();
        destinationField.clear();
        destinationField.sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(airport));
        driver.findElement(airport).click();
    }
    
    public void chooseOneway() {
        driver.findElement(checkOneWay).click();
    }
    
    public void chooseDepartDate() {
        wait.until(ExpectedConditions.presenceOfElementLocated(selectDate));
        driver.findElement(selectDate).click();
    }
    
    public void addAdults() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(plusAdults));
        driver.findElement(plusAdults).click();
    }
    
    public void addChildren() {
    	driver.findElement(plusChild).click();
    }

    public void clickSearch() {
        driver.findElement(btnSearch).click();;
    }
    
    public void viewBasket() throws InterruptedException {
    	wait.until(ExpectedConditions.presenceOfElementLocated(popUpBasket));
        driver.findElement(popUpBasket).click();
    }

    public void checkOut() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(btnCheckOut));
        driver.findElement(btnCheckOut).click();
    }

}