package org.selenium_learn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class basics
{
    @Test
     public void basic()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        String Tile_of_Tab= driver.getTitle();
        // Open a new tab or window
       // driver.execute_script("window.open('https://www.anotherexample.com');");

        // Close the current window (which will be the new tab/window if just opened)
        //     driver.close()

        //To switch back to the first window (if needed)
      //  driver.switch_to.window(driver.window_handles[0]);

      //   Eventually, quit the WebDriver session, all windows closed
        driver.quit();

    }
}
