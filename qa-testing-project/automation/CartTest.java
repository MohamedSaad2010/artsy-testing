import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class CartTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/cart");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Verify increasing the quantity (Test Case 1)
        // Fill the Locator for the "+" button
        // Example: By.xpath("//button[contains(@class, 'quantity-increase')]")
        WebElement increaseButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("FILL_INCREASE_BUTTON_LOCATOR_HERE")));
        increaseButton.click();

        // Verify quantity updated to 2 and total price to EGP 1630.00
        // Fill the Locator for Quantity field
        // Example: By.xpath("//input[@class='quantity-input']")
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("FILL_QUANTITY_FIELD_LOCATOR_HERE")));
        // Fill the Locator for Total Price
        // Example: By.xpath("//span[contains(@class, 'cart-total')]")
        WebElement totalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("FILL_TOTAL_PRICE_LOCATOR_HERE")));
        // Fill the Locator for Savings
        // Example: By.xpath("//span[contains(@class, 'savings-amount')]")
        WebElement savings = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("FILL_SAVINGS_LOCATOR_HERE")));

        if (quantityField.getAttribute("value").equals("2") && totalPrice.getText().contains("EGP 1630.00") && savings.getText().contains("-EGP 288.00")) {
            System.out.println("Pass: Quantity increased to 2, total price updated to EGP 1630.00, and savings to -EGP 288.00.");
        } else {
            System.out.println("Fail: Quantity or price update failed.");
        }

        // Step 2: Verify decreasing the quantity (Test Case 2)
        // Fill the Locator for the "-" button
        // Example: By.xpath("//button[contains(@class, 'quantity-decrease')]")
        WebElement decreaseButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("FILL_DECREASE_BUTTON_LOCATOR_HERE")));
        decreaseButton.click();

        // Verify quantity updated to 1 and total price to EGP 815.00
        if (quantityField.getAttribute("value").equals("1") && totalPrice.getText().contains("EGP 815.00") && savings.getText().contains("-EGP 144.00")) {
            System.out.println("Pass: Quantity decreased to 1, total price updated to EGP 815.00, and savings to -EGP 144.00.");
        } else {
            System.out.println("Fail: Quantity or price decrease failed.");
        }

        // Step 3: Verify adding a text order note (Test Case 7)
        // Fill the Locator for Add Order Note field
        // Example: By.id("order-note-input")
        WebElement orderNoteField = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("FILL_ORDER_NOTE_FIELD_LOCATOR_HERE")));
        orderNoteField.sendKeys("Please wrap as a gift");

        // Fill the Locator for Save Note button
        // Example: By.xpath("//button[contains(text(), 'Save Note')]")
        WebElement saveNoteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("FILL_SAVE_NOTE_BUTTON_LOCATOR_HERE")));
        saveNoteButton.click();

        // Verify note is added
        // Fill the Locator for Order Note display
        // Example: By.xpath("//div[contains(@class, 'order-note-display')]")
        WebElement orderNoteDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("FILL_ORDER_NOTE_DISPLAY_LOCATOR_HERE")));
        if (orderNoteDisplay.getText().contains("Please wrap as a gift")) {
            System.out.println("Pass: Order note 'Please wrap as a gift' added successfully.");
        } else {
            System.out.println("Fail: Order note not added correctly.");
        }

        // Step 4: Verify clarity of edit buttons (+/-) (Test Case 15)
        if (increaseButton.isDisplayed() && decreaseButton.isDisplayed()) {
            System.out.println("Pass: + and - buttons are clear and visible.");
        } else {
            System.out.println("Fail: + or - buttons are not visible.");
        }

        driver.quit();
        System.out.println("Test completed.");
    }
}