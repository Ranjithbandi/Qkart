import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v120.media.model.Timestamp;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    WebDriver driver;
    String url = "https://qcart-frontend.vercel.app/register";

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public void navigatetoRegister() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }

    public boolean Registeruser(String username, String Password, boolean MakeUsernameDynamic) {
        WebElement username_txt_box = driver.findElement(By.xpath("//input[@id='username']"));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String test_data_username;
        if (MakeUsernameDynamic) {
            test_data_username = username + "_" + timestamp;
        } else {
            test_data_username = username;
        }
        WebElement User_Password_txt_box = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement confirm_password_txt_box = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        WebElement register_btn = driver.findElement(By.xpath("//button[@id='registerBtn']"));
        username_txt_box.sendKeys(test_data_username);
        User_Password_txt_box.sendKeys(Password);
        confirm_password_txt_box.sendKeys(Password);
        register_btn.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.urlToBe("https://crio-qkart-qa.vercel.app/login"));
        } catch (Exception e) {

            String last_username = test_data_username;

        }
        return driver.getCurrentUrl().contains("/login");
    }
}
