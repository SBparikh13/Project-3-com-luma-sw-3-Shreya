package testsuit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Women Menu
        mouseHoverElement(By.xpath("//span[normalize-space()='Women']"));
        // * Mouse Hover on Tops
        mouseHoverElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        List<WebElement> listOrder = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li/div/div/strong"));
        ArrayList<String> originalList = new ArrayList<>();
        for (WebElement e : listOrder) {
            originalList.add(e.getText());
        }
        System.out.println(originalList);
        Collections.sort(originalList);
        System.out.println(originalList);
        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='sorter']"), "Product Name ");


        // Verify the products name display in alphabetical order
        List<WebElement> listSorted = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li/div/div/strong"));
        ArrayList<String> listAfterSorting = new ArrayList<>();
        for (WebElement e : listSorted) {
            listAfterSorting.add(e.getText());
        }
        System.out.println(listAfterSorting);

        Assert.assertEquals("List is not sorted Alphabetical order", originalList, listAfterSorting);
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Women Menu
        mouseHoverElement(By.xpath("//span[normalize-space()='Women']"));
        // * Mouse Hover on Tops
        mouseHoverElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        List<WebElement> listOrder = driver.findElements(By.xpath("//div[2]//div[3]//select[1]/option[3]"));
        ArrayList<String> originalList = new ArrayList<>();
        for (WebElement e : listOrder) {
            originalList.add(e.getText());
        }
        System.out.println(originalList);
        Collections.sort(originalList);
        System.out.println(originalList);
        //Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='sorter']"), "Price");

        // Verify the products  displayed in descending  order
        List<WebElement> listSorted = driver.findElements(By.xpath("//div[2]//div[3]//select[1]/option[3]"));
        ArrayList<String> listAfterSorting = new ArrayList<>();
        for (WebElement e : listSorted) {
            listAfterSorting.add(e.getText());
        }
        System.out.println(listAfterSorting);

        Assert.assertEquals("List is not sorted in descending order", originalList, listAfterSorting);

    }
    public void tearDown(){
        closeBrowser();
    }
}


