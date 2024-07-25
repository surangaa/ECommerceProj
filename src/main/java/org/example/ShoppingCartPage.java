package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage {

    private WebDriver driver;


    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }
    By tblPrice = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]");

    By tblQty = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/div/input");

    By totalPrice = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]");


    By lnkEdit = By.xpath("//a[contains(text(),'Edit')]");

    By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue shopping')]");

    By tblPrice2 = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/span[1]");

    By tblQty2 = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr[2]/td[5]/div/input");

    By totalPrice2 = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/span[1]");

    By selectGiftDrpDown = By.xpath("//select[@id='checkout_attribute_1']");

    By lblSubTotal = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[1]/table/tbody/tr[1]/td[2]/span");

    By lblShipping = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]");

    By lblTax = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/span[1]");

    By lblTotal = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]");

    By agreeCheckBox = By.xpath("//input[@id='termsofservice']");

    By checkOutBtn = By.xpath("//button[@id='checkout']");

    By successMsg = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");


    public String verifyTblPrice(){
        WebElement priceElement = driver.findElement(tblPrice);

        // Get the text of the price element
        String priceText = priceElement.getText();
        return priceText;


    }

    public String verifyTblQuantity(){
        WebElement qtyElement = driver.findElement(tblQty);

        // Get the text of the price element
        String quantity = qtyElement.getAttribute("value");;
        System.out.println("qty"+quantity);
        return quantity;

    }

    public String verifyTblTotal(){
        WebElement totalPriceElement = driver.findElement(totalPrice);

        // Get the text of the price element
        String totalText = totalPriceElement.getText();
        return totalText;

    }

    public void clickEdit(){
        driver.findElement(lnkEdit).click();
    }

    public void clickContinueShoppingBtn(){
        driver.findElement(continueShoppingBtn).click();
    }

    public String verifyTblPrice2(){
        WebElement priceElement = driver.findElement(tblPrice2);

        // Get the text of the price element
        String priceText = priceElement.getText();
        return priceText;


    }

    public String verifyTblQuantity2(){
        WebElement qtyElement = driver.findElement(tblQty2);

        // Get the text of the price element
        String quantity = qtyElement.getAttribute("value");;
        return quantity;

    }

    public String verifyTblTotal2(){
        WebElement totalPriceElement = driver.findElement(totalPrice2);

        // Get the text of the price element
        String totalText = totalPriceElement.getText();
        return totalText;

    }

    public WebElement selectDropdownGiftWrapping(){
        // Locate the dropdown element
        WebElement dropdownElement3 = driver.findElement(selectGiftDrpDown);

        // Create a Select object
        Select dropdown = new Select(dropdownElement3);

        // Select an option by visible text
        dropdown.selectByVisibleText("Yes [+$10.00]");

        WebElement selectedOption = dropdown.getFirstSelectedOption();

        return selectedOption;

    }
    public String verifySubTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lblSubTotal, "$5,000.00"));

        int attempts = 0;
        String subTotalText = null;

        while (attempts < 10) {
            try {
                // Locate the subtotal element
                WebElement subTotalPriceElement = driver.findElement(lblSubTotal);

                // Get the text of the price element
                subTotalText = subTotalPriceElement.getText();

                // If text is retrieved successfully, break the loop
                if (subTotalText != null) {
                    break;
                }
            } catch (StaleElementReferenceException ex) {
                System.out.println("StaleElementReferenceException caught. Retrying...");
                wait.until(ExpectedConditions.visibilityOfElementLocated(lblSubTotal));
            }

            attempts++;
        }

        return subTotalText;
    }
    public String verifyTax(){
        WebElement taxElement = driver.findElement(lblTax);

        // Get the text of the price element
        String taxText = taxElement.getText();
        return taxText;

    }

    public String verifyShipping(){
        WebElement shippingElement = driver.findElement(lblShipping);

        // Get the text of the price element
        String shippingText = shippingElement.getText();
        return shippingText;

    }

    public String verifyTotal(){
        WebElement totalElement = driver.findElement(lblTotal);

        // Get the text of the price element
        String totalText = totalElement.getText();
        return totalText;

    }

    public void clickAgree(){
        driver.findElement(agreeCheckBox).click();
    }

    public void clickCheckOutBtn(){
        driver.findElement(checkOutBtn).click();
    }

    public String verifySuccessMsg(){
        WebElement msgElement = driver.findElement(successMsg);

        // Get the text of the price element
        String msgText = msgElement.getText();
        return msgText;

    }

}
