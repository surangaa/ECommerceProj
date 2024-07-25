package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CartPage {

    private WebDriver driver;
    By selectProcessorDrpDown = By.xpath("//select[@id='product_attribute_1']");
    By selectRamDrpDown = By.xpath("//select[@id='product_attribute_2']");

    By hddRadioBtn = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[6]/dl[1]/dd[3]/ul[1]/li[2]/input[1]");

    By osRadioBtn = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[6]/dl[1]/dd[4]/ul[1]/li[2]/input[1]");

    By softwareChkBox = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[6]/dl[1]/dd[5]/ul[1]/li[2]/input[1]");

    By softwareChkBox2 = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[6]/dl[1]/dd[5]/ul[1]/li[1]/input[1]");

    By lblPrice = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div/div[1]/div[2]/div[7]/div/span");

    By lblQty = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div/div[1]/div[2]/div[8]/div/input");

    By addToCartBtn = By.xpath("//button[@id='add-to-cart-button-1']");

    By addMacToCartBtn = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[8]/div[2]/button[1]");

    By alertContent = By.xpath("/html/body/div[5]/div");

    By lnkShoppingCart = By.xpath("/html/body/div[5]/div/p/a");

    By updateBtn = By.xpath("//button[@class='button-1 add-to-cart-button' and text()='Update']");

    By lblMacPrice = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[7]/div[1]/span[1]");

    By lblMin = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[8]/div[1]");

   By lblMacQty = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[8]/div[2]/input[1]");

   By closeAlertBtn = By.xpath("/html[1]/body[1]/div[5]/div[1]/span[1]");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement selectDropdownProcessor(){
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(selectProcessorDrpDown);

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        WebElement selectedOption = dropdown.getFirstSelectedOption();

        return selectedOption;

    }

    public WebElement selectDropdownRam(String ramsize){
        // Locate the dropdown element
        WebElement dropdownElement2 = driver.findElement(selectRamDrpDown);

        // Create a Select object
        Select dropdown = new Select(dropdownElement2);

        // Select an option by visible text
        dropdown.selectByVisibleText(ramsize);

        WebElement selectedOption = dropdown.getFirstSelectedOption();

        return selectedOption;

    }

    public void clickHddRadioBtn(){
        driver.findElement(hddRadioBtn).click();
    }

    public void clickOsRadioBtn(){
        driver.findElement(osRadioBtn).click();
    }

    public void clickSoftwareChkBox(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(softwareChkBox2).click();
        System.out.println( driver.findElement(softwareChkBox2).getText());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(softwareChkBox).click();
    }

    public String verifyPrice(){
        WebElement priceElement = driver.findElement(lblPrice);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBe(lblPrice,"$1,370.00"));

        // Get the text of the price element
        String priceText = priceElement.getText();
        return priceText;

    }

    public String verifyQuantity(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement qtyElement = driver.findElement(lblQty);

        // Get the text of the price element
        String quantity = qtyElement.getAttribute("value");
        return quantity;

    }

    public void clickAddToCartBtn(){
        driver.findElement(addToCartBtn).click();
    }


    public String getAlertContent(){
        WebElement qtyElement = driver.findElement(alertContent);

        // Get the text of the price element
        String alertContent = qtyElement.getText();
        return alertContent;
    }

    public void clickShoppingCartLink(){
        driver.findElement(lnkShoppingCart).click();
    }

    public void clickUpdateBtn(){
        driver.findElement(updateBtn).click();
    }

    public String verifyMacPrice(){
        WebElement priceElement = driver.findElement(lblMacPrice);

        // Get the text of the price element
        String macPriceText = priceElement.getText();
        return macPriceText;

    }

    public String verifyMacQty(){
        WebElement qtyElement = driver.findElement(lblMacQty);

        // Get the text of the price element
        String macQtyText = qtyElement.getText();
        return macQtyText;

    }

    public String verifyLabel(){
        WebElement lblElement = driver.findElement(lblMin);

        // Get the text of the price element
        String macText = lblElement.getText();
        return macText;

    }

    public void clickMacAddToCartBtn(){
        driver.findElement(addMacToCartBtn).click();
    }

    public void clickAlertCloseBtn(){
        driver.findElement(closeAlertBtn).click();
    }

}
