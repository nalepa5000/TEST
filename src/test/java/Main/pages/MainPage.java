package Main.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(id = "flights-tab")
    WebElement flightButton;

    @FindBy(id = "one-way")
    WebElement oneWayFlightRadio;

    @FindBy(id = "round-trip")
    WebElement roundTripFlightRadio;

    @FindBy(css = ".form-group #autocomplete")
    WebElement form;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        js = (JavascriptExecutor) driver;
    }

    public void clickFlights(){
        wait.until(ExpectedConditions.elementToBeClickable(flightButton));
        js.executeScript("arguments[0].click();",flightButton );

    }

    public void chooseWaysFlights(String ways){
        if(ways=="one way"){
            wait.until(ExpectedConditions.elementToBeClickable(oneWayFlightRadio)).click();
        }
        else
            wait.until(ExpectedConditions.elementToBeClickable(roundTripFlightRadio)).click();
    }

    public void typeInToInput(){
        wait.until(ExpectedConditions.visibilityOf(form)).sendKeys(Keys.ENTER);
    }

    public void Scroll(String scroll) {
        js.executeScript("window.scrollBy(0,"+scroll+")",""); //przy scrollowaniu w górę dajemy -300

    }


}
