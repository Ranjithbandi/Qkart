package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.bytebuddy.asm.Advice.This;

public class Home {
    WebDriver driver;
    String url = "https://qcart-frontend.vercel.app/";

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void navigatetoHomepage() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            driver.get(url);
        }
    }

    public boolean ClickonRegister() throws InterruptedException {
        try {
            WebElement Register_button = driver.findElement(By.xpath("//button[text()='Register']"));
            Register_button.click();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking on Register button: " + e.getMessage());
            return false;

        }
    }

}
