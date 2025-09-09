package aston.darya.homework.lesson9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        acceptCookiesIfPresent();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void acceptCookiesIfPresent() {
        try {
            WebElement cookieBanner = new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cookie.show")));
            WebElement acceptBtn = cookieBanner.findElement(By.id("cookie-agree"));
            acceptBtn.click();
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.invisibilityOf(cookieBanner));
        } catch (TimeoutException e) {

        }
    }

    @Test
    public void testPaymentBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("section.pay h2")
        ));
        String actualText = title.getText().replace("\n", " ").trim();
        assertEquals("Онлайн пополнение без комиссии", actualText);
    }

    @Test
    public void testPaymentLogosPresent() {
        String[] logos = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String alt : logos) {
            WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("section.pay img[alt*='" + alt + "']")
            ));
            assertTrue(img.isDisplayed(), "Логотип «" + alt + "» не отображается");
        }
    }

    @Test
    public void testMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Подробнее о сервисе")
        ));
        String href = link.getAttribute("href");
        assertNotNull(href, "Ссылка не имеет href");
        link.click();

        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("https://mts.by")));
        assertFalse(driver.getCurrentUrl().isEmpty(), "Переадресация не произошла");
    }

    @Test
    public void testFillAndContinue_UslugiSvyazi() {
        WebElement inputNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        WebElement inputSum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum")));

        inputNumber.clear();
        inputNumber.sendKeys("297777777");
        inputSum.clear();
        inputSum.sendKeys("1");

        WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("section.pay button.button__default")
        ));

        assertTrue(continueBtn.isEnabled(), "Кнопка «Продолжить» не активна после ввода данных");
        continueBtn.click();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("payment"),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[src*='bepaid']"))
        ));
    }
}