package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    By addToCartBtn = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");

    By addMacToCart = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/button[1]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddToCartBtn(){
        driver.findElement(addToCartBtn).click();
    }

    public boolean displayAddToCartButtonBtn() {
        return driver.findElement(addToCartBtn).isDisplayed();
    }

    public boolean enableAddToCartButtonBtn() {
        return driver.findElement(addToCartBtn).isDisplayed();
    }

    public void clickAddMacToCartBtn(){
        driver.findElement(addMacToCart).click();
    }

}
