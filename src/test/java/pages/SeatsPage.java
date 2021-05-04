package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeatsPage {

    private WebDriver driver;
	private WebDriverWait wait;

	private By btnFamilySeating = By.xpath("//div[2]/div[2]/button");
	private By seatMap = By.xpath("//seat-map");
	private By seats = By.xpath(".//button[@class='ng-star-inserted seatmap__seat seatmap__seat--standard']");
	private By btnContinue = By.cssSelector("button.seats-action__button.ry-button.ry-button--gradient-yellow");
	private By crowds = By.xpath("//ry-enhanced-takeover-beta-desktop/div/div[3]/div[2]/div[1]/button");

	
    public SeatsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
		this.wait = wait;
    }

    public void closeSeatingPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(btnFamilySeating));
        driver.findElement(btnFamilySeating).click();
    }

    public void selectSeats() {
    	// Select the first three seats available
    	wait.until(ExpectedConditions.visibilityOfElementLocated(seatMap));
    	List<WebElement> freeStandardSeats = driver.findElements(seats);
        WebElement seat1 = freeStandardSeats.get(0);
        seat1.click();
        WebElement seat2 = freeStandardSeats.get(1);
        seat2.click();
        WebElement seat3 = freeStandardSeats.get(2);
        seat3.click();
        driver.findElement(btnContinue).click();
        
        // No avoid long queues
    	wait.until(ExpectedConditions.presenceOfElementLocated(crowds));
        driver.findElement(crowds).click();
    }
	
}