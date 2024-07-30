package org.selenium_learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllWebElements {

    @Test
    public void end2end() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //check if one way is selected and return date clandar is disbaled

        //Id for one way-> ctl00_mainContent_rbtnl_Trip_0
        boolean onewaySelected=driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected();
        System.out.println(onewaySelected);
        Assert.assertTrue(onewaySelected);

        //Id for return calendar Input ctl00_mainContent_view_date2 ,assertion fails here as isEnabled check for if it can ve selected or not(clicked)
        //but here it gets enabled when it is clicked

//        boolean ReturnCalendarEnabled=driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled();
//        Assert.assertFalse(ReturnCalendarEnabled);

//      So we have to check with other info if any setting is changed in disbaled and enabled

//    The div for this calendar input has setting that changes id->Div1,style attribute changes from 0.5 opacity to 1
        String calendarboxStyle=(driver.findElement(By.id("Div1"))).getAttribute("style");
        if(calendarboxStyle.contains("1"))
        {
            boolean ReturnCalendarEnabled=true;
            Assert.assertFalse(ReturnCalendarEnabled);
        }
        else {
            System.out.println("Not enabled round trip calendar");
            Assert.assertTrue(true);
        }
   //NOW SELECT ROUNDR TRIP Radi Button, id -> ctl00_mainContent_rbtnl_Trip_1

       driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();//selected round trip
        System.out.println(" round trip button clicked");
        //now check if return calendar activated or not
         calendarboxStyle=(driver.findElement(By.id("Div1"))).getAttribute("style");
        if(calendarboxStyle.contains("1"))
        {
            boolean ReturnCalendarEnabled=true;
            System.out.println("Now round trip calendar enabled");
            Assert.assertTrue(ReturnCalendarEnabled);
        }
        else {
            System.out.println("Not enabled failed");
            Assert.assertTrue(false);
        }

       // NOW SELECT FROM DESTINATION
        // XPATH FOR IT //div[@id='dropdownGroup1']/div/ul //a[@value='DEL']
        //AS have both from and to destinations inner parts are same of html so need to selct a distinguish parent
        // and then traverse to child we wnat to traget
        // first part can be some ancestor and not necc the parent of child
        //the first x path should have unique result(ancestor)

        //open 'from location' tab id->ctl00_mainContent_ddl_originStation1_CTXT
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //select city delhi
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='DEL']")).click();
        //open destination tab id->ctl00_mainContent_ddl_destinationStation1_CTXT
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='ATQ']")).click();

    }
}
