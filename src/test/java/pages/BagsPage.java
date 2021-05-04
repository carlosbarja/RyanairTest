package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BagsPage {

    private WebDriver driver;
	private WebDriverWait wait;

	private By cabinBag = By.xpath("//bags-priority-boarding-pax-control/div/bags-product-selector/div/div/div[1]");
	private By btnContinue = By.xpath("//button[@class='ry-button--gradient-yellow']");

	
    public BagsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
		this.wait = wait;
    }

    
    public void addBags() throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cabinBag));
        driver.findElement(cabinBag).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(btnContinue));
    	Thread.sleep(500);
        driver.findElement(btnContinue).click();
    }

}