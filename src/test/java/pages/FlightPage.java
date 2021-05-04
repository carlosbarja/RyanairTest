package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPage {
	
    private WebDriver driver;
	private WebDriverWait wait;

	private By flight = By.xpath("//flight-info");
	private By fare = By.xpath("//fare-card");
	private By pasengerForm = By.className("passenger");
	private By adult1Title = By.xpath("//button[@type='button']");
	private By adult1Mr = By.xpath("//ry-dropdown-item/button/div/div");
	private By adult1Name = By.id("formState.passengers.ADT-0.name");
	private By adult1Surname = By.id("formState.passengers.ADT-0.surname");
	private By adult2Title = By.xpath("//ry-dropdown[@id='title-0-error-message']/div[2]/button/icon");
	private By adult1Mrs = By.xpath("//ry-dropdown[@id='title-0-error-message']/div[2]/div/div/ry-dropdown-item[2]/button/div/div");
	private By adult2Name = By.id("formState.passengers.ADT-1.name");
	private By adult2Surname = By.id("formState.passengers.ADT-1.surname");
	private By childName = By.id("formState.passengers.CHD-0.name");
	private By childSurname = By.id("formState.passengers.CHD-0.surname");
	private By btnContinue = By.xpath("//continue-flow/div/div/span");


    public FlightPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
		this.wait = wait;
    }


    public void selectFlight() {
        wait.until(ExpectedConditions.elementToBeClickable(flight));
        driver.findElement(flight).click();
    }

    public void selectFare() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fare));
        driver.findElement(fare).click();
    }
        
    public void enterAdult1Info() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pasengerForm));
        driver.findElement(adult1Title).click();
        driver.findElement(adult1Mr).click();
        driver.findElement(adult1Name).click();
        driver.findElement(adult1Name).clear();
        driver.findElement(adult1Name).sendKeys("Carlos");
        driver.findElement(adult1Surname).clear();
        driver.findElement(adult1Surname).sendKeys("Romero Pozo");
    }

    public void enterAdult2Info() {
        driver.findElement(adult2Title).click();
        driver.findElement(adult1Mrs).click();
        driver.findElement(adult2Name).click();
        driver.findElement(adult2Name).clear();
        driver.findElement(adult2Name).sendKeys("Victoria");
        driver.findElement(adult2Surname).clear();
        driver.findElement(adult2Surname).sendKeys("Marugan Barrios");
    }

    public void enterChildInfo() {
        driver.findElement(childName).click();
        driver.findElement(childName).clear();
        driver.findElement(childName).sendKeys("Eduardo");
        driver.findElement(childSurname).clear();
        driver.findElement(childSurname).sendKeys("Romero Marugan");
    }

    public void clickContinue() {
        driver.findElement(btnContinue).click();
    }
	
}