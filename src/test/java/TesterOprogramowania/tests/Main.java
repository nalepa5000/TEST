package TesterOprogramowania.tests;

import Main.tests.Base;
import org.testng.annotations.Test;

public class Main extends Basic {

    @Test
    public void changingHandles() throws InterruptedException {
        TesterOprogramowania.pages.Main main = new TesterOprogramowania.pages.Main(driver);
        main.checkIfPicIsCorrect();
        /*main.handlingNewWindow();*/
    }
}
