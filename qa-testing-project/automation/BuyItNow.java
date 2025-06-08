import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyItNow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"block-template--16727121887461__2dc87c0a-2e9a-4c60-853c-f99b8effb971-695d9b5f-446a-49c8-aa63-e105be8fcb48\"]/div[1]/div/product-item[1]/div[2]/div/a")).click();
        Thread.sleep(1000);
        WebElement BuyIt =  driver.findElement(By.xpath("//*[@id=\"MainPaymentContainer\"]/div/shopify-accelerated-checkout/shopify-buy-it-now-button/button"));
        BuyIt.click();
        Thread.sleep(1000);
        WebElement log = driver.findElement(By.xpath("//a[text()='Log in']"));
        log.click();
        Thread.sleep(1000);
        driver.quit();
    }
}
