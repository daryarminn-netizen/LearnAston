package aston.darya.homework.lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private MtsMainPage mtsPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        acceptCookiesIfPresent();
        mtsPage = new MtsMainPage(driver);
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
            cookieBanner.findElement(By.id("cookie-agree")).click();
            new WebDriverWait(driver, 3).until(ExpectedConditions.invisibilityOf(cookieBanner));
        } catch (TimeoutException ignored) { }
    }

    @Test
    public void testPaymentBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", mtsPage.getPaymentBlockTitle());
    }

    @Test
    public void testPaymentLogosPresent() {
        String[] logos = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String alt : logos) {
            assertTrue(mtsPage.isPaymentLogoVisible(alt), "Логотип «" + alt + "» не отображается");
        }
    }

    @Test
    public void testMoreInfoLink() {
        mtsPage.clickMoreInfoLink();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("https://mts.by")));
        assertFalse(driver.getCurrentUrl().isEmpty(), "Переадресация не произошла");
    }

    @Test
    public void testFillAndContinue_UslugiSvyazi() {
        mtsPage.fillConnectionForm("297777777", "1");
        mtsPage.clickContinue();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("payment"),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[src*='bepaid']"))
        ));
    }

    @Test
    public void testPlaceholdersForAllPaymentOptions() {
        mtsPage.selectPaymentOption("Услуги связи");
        assertEquals("Номер телефона", mtsPage.getPlaceholder("connection-phone"));
        assertEquals("Сумма", mtsPage.getPlaceholder("connection-sum"));
        assertEquals("E-mail для отправки чека", mtsPage.getPlaceholder("connection-email"));

        mtsPage.selectPaymentOption("Домашний интернет");
        assertEquals("Номер абонента", mtsPage.getPlaceholder("internet-phone"));
        assertEquals("Сумма", mtsPage.getPlaceholder("internet-sum"));
        assertEquals("E-mail для отправки чека", mtsPage.getPlaceholder("internet-email"));

        mtsPage.selectPaymentOption("Рассрочка");
        assertEquals("Номер счета на 44", mtsPage.getPlaceholder("score-instalment"));
        assertEquals("Сумма", mtsPage.getPlaceholder("instalment-sum"));
        assertEquals("E-mail для отправки чека", mtsPage.getPlaceholder("instalment-email"));

        mtsPage.selectPaymentOption("Задолженность");
        assertEquals("Номер счета на 2073", mtsPage.getPlaceholder("score-arrears"));
        assertEquals("Сумма", mtsPage.getPlaceholder("arrears-sum"));
        assertEquals("E-mail для отправки чека", mtsPage.getPlaceholder("arrears-email"));
    }

    @Test
    public void testServicesPaymentModal() {
        mtsPage.selectPaymentOption("Услуги связи");
        mtsPage.fillConnectionForm("297777777", "1");
        mtsPage.clickContinue();

        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("iframe[src*='bepaid']")));
        driver.switchTo().frame(frame);

        String phoneText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".pay-description__text span"))).getText();
        assertTrue(phoneText.contains("375297777777"), "Телефон отображается некорректно");

        String amountText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".pay-description__cost span"))).getText();
        assertTrue(amountText.contains("1.00"), "Сумма отображается некорректно");

        String buttonText = driver.findElement(By.cssSelector("button.colored")).getText();
        assertTrue(buttonText.contains("1.00"), "Кнопка оплаты не содержит сумму");

        WebElement ccNumberLabel = driver.findElement(By.cssSelector("#cc-number + label"));
        assertEquals("Номер карты", ccNumberLabel.getText());

        WebElement expiryLabel = driver.findElement(By.cssSelector("input[formcontrolname='expirationDate'] + label"));
        assertEquals("Срок действия", expiryLabel.getText());

        WebElement cvcLabel = driver.findElement(By.cssSelector("input[name='verification_value'] + label"));
        assertEquals("CVC", cvcLabel.getText());

        List<WebElement> icons = driver.findElements(By.cssSelector(
                "img[src*='visa-system'], img[src*='mastercard-system'], img[src*='belkart-system']"));
        assertFalse(icons.isEmpty(), "Нет иконок платёжных систем");

        driver.switchTo().defaultContent();
    }



}
