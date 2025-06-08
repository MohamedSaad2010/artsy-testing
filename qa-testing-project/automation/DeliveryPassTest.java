import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class DeliveryPassTest {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/checkouts/cn/Z2NwLXVzLWNlbnRyYWwxOjAxSlZSR1FLV044UjhYUlM1QkhYWjhKSFdS");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        WebElement contactLink = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16727122542821__header\"]/store-header/div/div/div/div/a[2]"));
//        contactLink.click();
//        Thread.sleep(4000);
//        driver.findElement(By.id("customer[email]")).sendKeys("farahmoenis526@gmail.com");
//        Thread.sleep(1000);
//        driver.findElement(By.id("customer[password]")).sendKeys("12345");
//        Thread.sleep(1000);
//        driver.findElement(By.className("loader-button__text")).click();
//        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//        System.out.println("عدد الـ iframes في الصفحة: " + iframes.size());
//        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
//
//        for (int i = 0; i < frames.size(); i++) {
//            driver.switchTo().frame(i); // الدخول إلى الفريم رقم i
//
//            List<WebElement> inputs = driver.findElements(By.name("firstname"));
//
//            if (inputs.size() > 0) {
//                System.out.println("العنصر موجود في الفريم رقم: " + i);
//                inputs.get(0).sendKeys("Ahmed"); // التعامل مع العنصر
//                break; // وقف بعد ما تلاقيه
//            }
//
//            driver.switchTo().defaultContent(); // ارجع تاني للصفحة الرئيسية
//        }

// //////////////////////////////////////
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"shopify-section-sections--16727122542821__header\"]/store-header/div/div/div/div/a[1]")));
        search.click();

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("predictive-search__input")));
        searchInput.sendKeys("Ring");

        WebElement viewSearch = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"predictive-search-products\"]/ul/li[1]/a")));
        viewSearch.click();

        WebElement buyItNow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"MainPaymentContainer\"]/div/shopify-accelerated-checkout/shopify-buy-it-now-button/button")));
        buyItNow.click();
// ////////////////////////



        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));
        email.sendKeys("mohamedsaad2010@gmail.com");
        System.out.println("Email entered.");
        Thread.sleep(2000);

        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#TextField358")));
        firstNameField.sendKeys("Ahmed");

        WebElement lastNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TextField1\"]")));
        lastNameField.sendKeys("Ali");

        WebElement addressField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TextField2\"]")));
        addressField.sendKeys("123 Cairo St");

        WebElement apartmentField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TextField3\"]")));
        apartmentField.sendKeys("Apt 4");

        WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TextField4\"]")));
        cityField.sendKeys("El Mahala");

        WebElement governorateDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Select1\"]/option[12]")));
        Select selectGovernorate = new Select(governorateDropdown);
        selectGovernorate.selectByVisibleText("Gharbia");

        WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TextField6\"]")));
        phoneField.sendKeys("+20123456789");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"save_shipping_information\"]")));
        saveButton.click();
        System.out.println("Shipping info saved.");

        Thread.sleep(3000);

        WebElement cashOnDelivery = wait.until(ExpectedConditions.elementToBeClickable(By.id("basic-paymentOnDelivery")));
        cashOnDelivery.click();

        WebElement sameAsShipping = wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_address_selector-shipping_address")));
        sameAsShipping.click();

        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-pay-button")));
        if (confirmation.isDisplayed()) {
            System.out.println("Pass: Delivery address saved successfully and moved to payment.");
        } else {
            System.out.println("Fail: Delivery address not saved correctly.");
        }

        driver.quit();
        System.out.println("Test completed.");
    }
}
