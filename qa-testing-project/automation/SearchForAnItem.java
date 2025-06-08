import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchForAnItem {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        WebElement search =driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16727122542821__header\"]/store-header/div/div/div/div/a[1]"));
        search.click();
        driver.findElement(By.className("predictive-search__input")).sendKeys("muse");
        Thread.sleep(1000);
        WebElement searched =driver.findElement(By.xpath("//*[@id=\"predictive-search-products\"]/ul/li/a/span/img"));
        searched.click();
        //Choose size
        WebElement size7 = driver.findElement(By.xpath("//label[text()='Size 7']"));
        size7.click();
        //Then add to cart
       driver.findElement(By.id("AddToCart")).click();
       Thread.sleep(2000);
       driver.quit();
    }
}