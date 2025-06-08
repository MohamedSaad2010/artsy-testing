import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        WebElement contactLink = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16727122542821__header\"]/store-header/div/div/div/div/a[2]"));
       contactLink.click();
        Thread.sleep(4000);
        driver.findElement(By.id("customer[email]")).sendKeys("farahmoenis526@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("customer[password]")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.className("loader-button__text")).click();
    }
}
