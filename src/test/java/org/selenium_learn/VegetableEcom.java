package org.selenium_learn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VegetableEcom {

    @Test
    public void end2end() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();


        //Adding vegetables cucumber and beetroot each  2 quantity

        //       <h4 class="product-name" xpath="1">Cucumber - 1 Kg</h4>
        //now this has sibling for quantity input(<div class="stepper-input"><a href="#" class="decrement">–</a><input type="number" class="quantity" value="2"><a href="#" class="increment">+</a></div>
        // and add to card button (<div class="product-action"><button class="" type="button">ADD TO CART</button></div>)

        //Increasing quantity by +  button 2 times and  - button 1 time. total quantity 2 as initial quantity is 1
        String pathtoCucumber="//h4[contains(text(),'Cucumber')]/";
        int i=0;
        while(i<2) {
            driver.findElement(By.xpath(pathtoCucumber + "following-sibling::div/a[@class='increment']")).click();
            i++;
        }
        driver.findElement(By.xpath(pathtoCucumber + "following-sibling::div/a[@class='decrement']")).click();

        //Adding to cart
        driver.findElement(By.xpath(pathtoCucumber + "following-sibling::div[@class='product-action']/button")).click();

        //Adding another vegetable and quantity using input
        String pathtoBeet="//h4[contains(text(),'Beetroot')]/";
        driver.findElement(By.xpath(pathtoBeet + "following-sibling::div/input")).clear();
        driver.findElement(By.xpath(pathtoBeet + "following-sibling::div/input")).sendKeys("2");

        driver.findElement(By.xpath(pathtoBeet + "following-sibling::div[@class='product-action']/button")).click();

        //Or add vege using list of web elements
        //list(elements)

        // List<WebElement> products=driver.findElements(by.xpath("h4[@class='product-name'") gives list

        //for(int i=0;i<products.size();i++)
        //{
//              get(i)//array list method
//               name=products.get(i).getText();
//                if(name.constins("cucumber"))
//                {
//                    //gives list of add to card button  driver.findElements(by.xpath("div[@class='product-action']/button")
//                    //                                                                                     .get(i).click()
//                }
        //}

       //open checkout bag
        driver.findElement(By.xpath( "//a[@class='cart-icon']/img")).click();
        Thread.sleep(1000);

        //button[text()='PROCEED TO CHECKOUT']
        driver.findElement(By.xpath( "//button[text()='PROCEED TO CHECKOUT']")).click();
        Thread.sleep(1000);

        //input[@class='promoCode']
        driver.findElement(By.xpath( "//input[@class='promoCode']\n")).sendKeys("ras");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();//apply button

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));//promo info not available till apply button is clicked
        String promoinfo=driver.findElement(By.className("promoInfo")).getText();
        System.out.println(promoinfo);
        Assert.assertEquals(promoinfo,"Invalid code ..!");

        driver.findElement(By.xpath("//button[text()='Place Order']")).click();//place order button

        //agree terms checkbox //input[@type='checkbox']
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();//agree terms check
        //button[text()='Proceed']
        driver.findElement(By.xpath("//button[text()='Proceed']\n ")).click();//agree terms check













    }
}
