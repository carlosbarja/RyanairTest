package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtrasPage {

    private WebDriver driver;
	private WebDriverWait wait;

	private By btnContinue = By.xpath("//div[2]/button");

    public ExtrasPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
		this.wait = wait;
    }

    public void clickContinueAnythingElse() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(btnContinue));
        driver.findElement(btnContinue).click();
    }

}