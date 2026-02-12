package ST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Pay {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
         
            driver.get("file:///C:/Users/Abu_M/OneDrive/Documents/Software%20Engineering/Projects/HTML%20Project/HCI/shopping.HTML");
            driver.manage().window().maximize();

            WebElement nameField = driver.findElement(By.id("name"));
            WebElement cardField = driver.findElement(By.id("card"));
            WebElement expField = driver.findElement(By.id("data"));
            WebElement cvcField = driver.findElement(By.id("cvc"));

            if (nameField.isEnabled()) {
                nameField.sendKeys("Abeer Mohamed");
                System.out.println(" Name field accepts input.");
            } else {
                System.out.println(" Name field is not editable.");
            }

            if (cardField.isEnabled()) {
                cardField.sendKeys("1111-2222-3333-4444");
                System.out.println(" Card number field accepts input.");
            } else {
                System.out.println(" Card number field is not editable.");
            }

            if (expField.isEnabled()) {
                expField.sendKeys("09-25");
                System.out.println(" Expiring Date field accepts input.");
            } else {
                System.out.println(" Expiring Date field is not editable.");
            }

            if (cvcField.isEnabled()) {
                cvcField.sendKeys("123");
                System.out.println(" CVC field accepts input.");
            } else {
                System.out.println(" CVC field is not editable.");
            }

        } catch (Exception e) {
            System.out.println(" An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

