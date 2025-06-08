import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Fail_Search_saad{
    public static void main(String[] args) throws InterruptedException {
        String productsText  ;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/");
        driver.manage().window().maximize();
        WebElement searchDrawerToggle = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16727122542821__header\"]/store-header/div/div/div/div/a[1]"));
        searchDrawerToggle.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'predictive-search__input')]")));
        searchBar.sendKeys("saad");
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"search-drawer\"]/div/div/div[2]/p")));
        if (errorMessage.isDisplayed() && errorMessage.getText().contains("No results could be found")) {
            System.out.println("Predictive Search: No results found as expected.");

            searchBar.submit();
            Thread.sleep(2000);
            WebElement productsTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("button.tabs-nav__item[data-type='product']")));
            productsText = productsTab.getText();
            System.out.println("DEBUG: Found tab text => " + productsText);
            if (productsText.matches("(?i)^products \\(\\d+\\)$")) {
                System.out.println("Fail: Products displayed for invalid input saad after pressing Enter. " + productsText);
            } else {
                System.out.println("Pass: No products displayed as expected after pressing Enter.");
            }
        } else {
            System.out.println("Fail: Predictive Search did not show 'No results could be found'.");
        }

        driver.quit();
        System.out.println("Test completed.");
    }
}