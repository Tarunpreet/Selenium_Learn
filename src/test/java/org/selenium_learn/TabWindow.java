package org.selenium_learn;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class TabWindow {


    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pharmeasy.in/#");
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='c-PJLV c-bXbWpx c-bXbWpx-bZJlhX-direction-column c-bXbWpx-ibBhYHy-css']/a"));

        String Current_Window = driver.getWindowHandle();
        for (WebElement link : links) {
            Actions actions = new Actions(driver);
            actions.moveToElement(link).keyDown(Keys.COMMAND).click().build().perform();//open link in new tab

            //one more method if we have url of the link
            //driver.switchTo().newWindow(WindowType.TAB);
            //driver.get(("url of new link"));

        }

        driver.quit();

    }
    @Test
    public void test2() {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://pharmeasy.in/#");

        // Store the base URL of the current page
        String baseUrl = driver.getCurrentUrl();

        // Locate all link elements
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='c-PJLV c-bXbWpx c-bXbWpx-bZJlhX-direction-column c-bXbWpx-ibBhYHy-css']/a"));

        // Store the current window handle
        String originalWindow = driver.getWindowHandle();

        for (WebElement link : links) {
            // Extract the URL from each link
            String href = link.getAttribute("href");
            String fullUrl;

            // Check if the href is a relative URL
            if (href.startsWith("http://") || href.startsWith("https://")) {
                fullUrl = href; // It's already a full URL
            } else {
                // Construct the full URL using the base URL
                fullUrl = baseUrl + href;
            }

            // Open a new tab
            driver.switchTo().newWindow(WindowType.TAB);

            // Navigate to the full URL in the new tab
            driver.get(fullUrl);

            // Optional: Add some interaction or validation here
            System.out.println("Opened link with URL: " + fullUrl);
            System.out.println("New tab title: " + driver.getTitle());

            // Close the new tab after the interaction
            driver.close();

            // Switch back to the original window
            driver.switchTo().window(originalWindow);
        }

        // Close the original browser window
        driver.quit();
    }
}



