package ST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Bot {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            
            driver.get("file:///C:/Users/Abu_M/OneDrive/Documents/Software%20Engineering/Projects/HTML%20Project/HCI/Home.html");
            driver.manage().window().maximize();

            WebElement logo = driver.findElement(By.xpath("//img[@src='aabb.png']"));   
            int logoX = logo.getLocation().getX();
            int logoY = logo.getLocation().getY();
            System.out.println("Logo position: X=" + logoX + ", Y=" + logoY);

            if (logo.isDisplayed() && logoX < 200) { 
                System.out.println(" The logo is visible and in the expected position.");
            } else {
                System.out.println(" The logo is not visible or not in the expected position.");
            }

            WebElement paletsButton = driver.findElement(By.xpath("//form[@action='PALETS.html']/button"));
            paletsButton.click();
            System.out.println(" PALETS button clicked.");

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("PALET.html")) {
                System.out.println(" Successfully navigated to PALETS.html after clicking the button.");
            } else {
                System.out.println(" Did not navigate to PALETS.html.");
            }

            driver.navigate().back();

            WebElement footer = driver.findElement(By.className("footer-distributed"));
            if (footer.isDisplayed()) {
                System.out.println(" Footer is visible on the page.");

                WebElement email = footer.findElement(By.cssSelector("a[href^='mailto:']"));
                String emailText = email.getText();
                if (emailText.equalsIgnoreCase("abeermohammed@gmail.com")) {
                    System.out.println(" Email is present in the footer: " + emailText);
                } else {
                    System.out.println(" Email not found or incorrect. Found: " + emailText);
                }
            } else {
                System.out.println(" Footer is not visible on the page.");
            }

        } catch (Exception e) {
            System.out.println(" An error occurred: " + e.getMessage());
        } finally {
        
            driver.quit();
        }
    }
}

