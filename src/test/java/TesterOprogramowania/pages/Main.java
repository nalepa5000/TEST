package TesterOprogramowania.pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Main {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    private static final Logger logger = LogManager.getLogger();

    @FindBy(id = "newPage")
    WebElement nePageButton;

    @FindBy(id = "smileImage")
    WebElement picture;

    public Main(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void handlingNewWindow() throws InterruptedException {
        String mainHandle = driver.getWindowHandle();
        nePageButton.click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if(handle!=mainHandle){
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(10000);
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(mainHandle);
        System.out.println(driver.getCurrentUrl());

    }

    public void checkIfPicIsCorrect(){
        logger.info("Obrazek Sprawdzany");
        String height = picture.getAttribute("natturalHeight");
        Assert.assertNotEquals(height,"0");
        logger.info("Obrazek Sprawdzony");
    }

    public void takeScreenshot() throws IOException {
        int random = (int) (Math.random()*1000);
       TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr, new File("src/test/resources/screen.png"));
    }

}
