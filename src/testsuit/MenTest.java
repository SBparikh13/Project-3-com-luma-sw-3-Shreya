package testsuit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart () throws InterruptedException{
        Thread.sleep(2000);
        // Mouse Hover on Men Menu
       mouseHoverElement(By.xpath("(//a[@id='ui-id-5'])[1]"));
        //Mouse Hover on Bottoms
        mouseHoverElement(By.xpath("//a[@id='ui-id-18']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        //Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //* Mouse Hover on product name‘Cronus Yoga Pant’
        mouseHoverElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        //click on size 32.
        mouseClickOnElement(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        mouseClickOnElement(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]"));

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseClickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyText(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Cronus Yoga Pant to your shopping cart.");

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the text ‘Shopping Cart.’
        verifyText(By.xpath("//span[@class='base']"), "Shopping Cart");

        //Verify the product name ‘Cronus Yoga Pant’
        verifyText(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");


        // Verify the product size ‘32’
        verifyText(By.xpath("//dd[contains(text(),'32')]"), "32");

        //Verify the product colour ‘Black’
        verifyText(By.xpath("//dd[contains(text(),'Black')]"), "Black");

    }

    @After
    public void tearDown() {
         closeBrowser();
    }
}










