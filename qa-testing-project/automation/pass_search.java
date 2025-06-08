import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class pass_search {
    public static void main(String[] args) {
        String productsText;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/");
        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16727122542821__header\"]/store-header/div/div/div/div/a[1]"));
        search.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'predictive-search__input')]")));
        searchBar.sendKeys("Necklace");
        searchBar.submit();

        WebElement productsTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button.tabs-nav__item[data-type='product']")));


        productsText = productsTab.getText();
        System.out.println("DEBUG: Found tab text => " + productsText);

        if (productsText.matches("(?i)^products \\(\\d+\\)$")) {
            System.out.println("Pass: Search results are displayed. " + productsText);
        } else {
            System.out.println("Fail: Search results are not displayed correctly. Found: " + productsText);
        }


        List<WebElement> productNames = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//*[@id=\"facet-main\"]/product-list/div")));

        boolean found = false;
        for (WebElement item : productNames) {
            String name = item.getText().toLowerCase();
            if (name.contains("necklace")) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Pass: Search results contain 'Necklace'.");
        } else{
            System.out.println("Fail: Search results do not contain 'Necklace'.");
        }

        driver.quit();
        System.out.println("Test completed.");
    }
}