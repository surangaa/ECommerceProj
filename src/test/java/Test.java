import org.example.CartPage;
import org.example.HomePage;
import org.example.ShoppingCartPage;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test extends Setup{

    @org.testng.annotations.Test(groups = "regression", priority = 1)
    public void testCaseOne() {

        HomePage homeObj = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        // Check if the button is enabled
        Assert.assertTrue(homeObj.displayAddToCartButtonBtn(), "The button is not enabled.");
        Assert.assertTrue(homeObj.enableAddToCartButtonBtn(), "The button is not visible.");

        //click the button
        homeObj.clickAddToCartBtn();

        CartPage cartObj = new CartPage(driver);

        //Select the "2.2 GHz Intel Pentium Dual-Core E2200"
        cartObj.selectDropdownProcessor();

        // Verify the selected option
        Assert.assertEquals(cartObj.selectDropdownProcessor().getText(), "2.2 GHz Intel Pentium Dual-Core E2200", "The selected option is not in the dropdown");

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        //Select "2 GM" as RAM
        cartObj.selectDropdownRam("2 GB");

        // Verify the selected option
        Assert.assertEquals(cartObj.selectDropdownRam("2 GB").getText(), "2 GB", "The selected option is not in the dropdown");

        driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);

        //click hdd radio button
        cartObj.clickHddRadioBtn();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click os radio button
        cartObj.clickOsRadioBtn();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click software checkbox
        cartObj.clickSoftwareChkBox();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Get the text of the span element
        //get the price
        String priceText = cartObj.verifyPrice();

        // Verify the price is $1,370.00
        Assert.assertEquals(priceText, "$1,370.00", "The price is incorrect.");

        //get the quantity
        String qtyText = cartObj.verifyQuantity();
        // Verify the quantity is 1
        Assert.assertEquals(qtyText, "1", "The quantity is incorrect.");

        //add to cart
        cartObj.clickAddToCartBtn();

        //get the alert content
        String alertText = cartObj.getAlertContent();
        // Verify the alert content
        Assert.assertEquals(alertText, "The product has been added to your shopping cart", "The product is not added to the cart");

        //click on the link to go to shopping cart
        cartObj.clickShoppingCartLink();

        ShoppingCartPage shpObj = new ShoppingCartPage(driver);

        //Verify the price is $1,370.00
        String tblPrice = shpObj.verifyTblPrice();
        Assert.assertEquals(tblPrice, "$1,370.00", "The price is incorrect.");

        //get the quantity
        String tblQty = shpObj.verifyTblQuantity();
        // Verify the quantity is 1
        Assert.assertEquals(tblQty, "1", "The quantity is incorrect.");

        //Verify the total price is $1,370.00
        String tblTotalPrice = shpObj.verifyTblTotal();
        Assert.assertEquals(tblTotalPrice, "$1,370.00", "The price is incorrect.");

        //click edit link
        shpObj.clickEdit();

        //Select "4 GB" as RAM
        cartObj.selectDropdownRam("4GB [+$20.00]");

        // Verify the selected option
        Assert.assertEquals(cartObj.selectDropdownRam("4GB [+$20.00]").getText(), "4GB [+$20.00]", "The selected option is not in the dropdown");

        //Click update button
        cartObj.clickUpdateBtn();

        //Click shopping cart link
        cartObj.clickShoppingCartLink();

        //Verify the total price is $1,370.00
        String tblUpdatedTotalPrice = shpObj.verifyTblTotal();
        Assert.assertEquals(tblUpdatedTotalPrice, "$1,390.00", "The price is incorrect.");

        //click continue shopping btn
        shpObj.clickContinueShoppingBtn();

        //add macbook to cart
        homeObj.clickAddMacToCartBtn();

        //verify mac book price
        cartObj.verifyMacPrice();

        //verify mac book qty
        cartObj.verifyMacQty();

        //verify the min qty label
        cartObj.verifyLabel();

        //Add mac book to cart
        cartObj.clickMacAddToCartBtn();

        //get the alert content
        String alertText2 = cartObj.getAlertContent();
        // Verify the alert content
        Assert.assertEquals(alertText2, "The product has been added to your shopping cart", "The product is not added to the cart");

        //close the alert
        cartObj.clickAlertCloseBtn();

        //click shopping link
        cartObj.clickShoppingCartLink();

        //Verify the price is $1,800.00
        String tblPrice2 = shpObj.verifyTblPrice2();
        Assert.assertEquals(tblPrice2, "$1,800.00", "The price is incorrect.");

        //get the quantity
        String tblQty2 = shpObj.verifyTblQuantity2();
        // Verify the quantity is 2
        Assert.assertEquals(tblQty2, "2", "The quantity is incorrect.");

        //Verify the total price is $3,600.00
        String tblTotalPrice2 = shpObj.verifyTblTotal2();
        Assert.assertEquals(tblTotalPrice2, "$3,600.00", "The price is incorrect.");

        //select gift wrapping
        shpObj.selectDropdownGiftWrapping();
        Assert.assertEquals(shpObj.selectDropdownGiftWrapping().getText(), "Yes [+$10.00]", "The selected option is not in the dropdown");

        //Verify the total price is $5,000.00
        String subtotal = shpObj.verifySubTotal();
        Assert.assertEquals(subtotal, "$5,000.00", "The price is incorrect.");

        //Verify the tax is $0.00
        String tax = shpObj.verifyTax();
        Assert.assertEquals(tax, "$0.00", "The price is incorrect.");

        //Verify the shipping is $0.00
        String shippingCost = shpObj.verifyShipping();
        Assert.assertEquals(shippingCost, "$0.00", "The price is incorrect.");

        //Verify the total cost is $5000.00
        String TotalCost = shpObj.verifyTotal();
        Assert.assertEquals(TotalCost, "$5,000.00", "The price is incorrect.");

        //click agree terms and conditions checkbox
        shpObj.clickAgree();

        //click checkout button
        shpObj.clickCheckOutBtn();

        //Verify the success message
        String message = shpObj.verifySuccessMsg();
        Assert.assertEquals(message, "Welcome, Please Sign In!", "The success message is incorrect.");
    }
}
