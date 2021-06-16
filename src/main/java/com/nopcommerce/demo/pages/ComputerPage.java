package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerPage extends Utility {

    HomePage homepage = new HomePage();

    By clickOnDesktop = By.xpath( "//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]" );

    public void clickOnComputersTab() throws InterruptedException {
         homepage.selectMenu( "Computers" );

    }

    public void clickOnDesktopOption() throws InterruptedException {
        Thread.sleep( 2000 );
        Reporter.log("Clicking on Desktop options:" + clickOnDesktop.toString() + "<br>");
        clickOnElement( clickOnDesktop );

    }

    public void verifyproductsSortByGivenOrder() {
        Reporter.log("Sorting Products by Z to A <br>");
        List<WebElement> deskTopList = driver.findElements( By.xpath( "//div[@class='item-grid']/div/div/div[2]/child::h2" ) );  //verifying sort by products are in 'z to a'
        List<String> productName = new ArrayList<>();
        for (WebElement deskTop : deskTopList) {
            productName.add( deskTop.getText() );
        }

        List<String> tempList = new ArrayList<>();
        tempList.addAll( productName );

        Collections.sort( tempList, Collections.reverseOrder() );//reverseOrder()
        Collections.sort( productName, Collections.reverseOrder() );
        System.out.println( productName );
        System.out.println( tempList );
        Assert.assertEquals( productName, tempList );

    }


}
