package Main.tests;

import org.testng.annotations.Test;
import Main.pages.MainPage;

public class MainTest extends Base{

    @Test
    public void chooseChlight() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFlights();
        mainPage.chooseWaysFlights("cośtam");
        mainPage.Scroll("500");
    }
}
