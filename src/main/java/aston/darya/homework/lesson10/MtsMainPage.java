package aston.darya.homework.lesson10;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class MtsMainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By paymentTitle = By.cssSelector("section.pay h2");
    private By moreInfoLink = By.linkText("Подробнее о сервисе");
    private By connectionPhoneInput = By.id("connection-phone");
    private By connectionSumInput = By.id("connection-sum");
    private By continueBtn = By.cssSelector("section.pay button.button__default");
    private By paymentSelect = By.id("pay");

    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public String getPaymentBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentTitle));
        return title.getText().replace("\n", " ").trim();
    }

    public boolean isPaymentLogoVisible(String altText) {
        WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("section.pay img[alt*='" + altText + "']")));
        return img.isDisplayed();
    }

    public void clickMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        link.click();
    }

    public void fillConnectionForm(String phone, String sum) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionPhoneInput));
        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionSumInput));

        phoneInput.clear();
        phoneInput.sendKeys(phone);

        sumInput.clear();
        sumInput.sendKeys(sum);
    }

    public void clickContinue() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        btn.click();
    }

    public void selectPaymentOption(String optionText) {
        WebElement header = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select__header")));
        header.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".select__list .select__option")));

        boolean clicked = false;
        for (WebElement opt : options) {
            if (opt.getText().trim().equals(optionText)) {
                wait.until(ExpectedConditions.elementToBeClickable(opt)).click();
                clicked = true;
                break;
            }
        }

        if (!clicked) {
            throw new NoSuchElementException("Не найден пункт выпадающего списка: " + optionText);
        }

        WebElement nativeSelect = driver.findElement(By.id("pay"));
        String targetFormId = null;
        for (WebElement opt : nativeSelect.findElements(By.tagName("option"))) {
            if (opt.getText().trim().equals(optionText)) {
                targetFormId = opt.getAttribute("data-open");
                break;
            }
        }
        if (targetFormId != null) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(targetFormId)));
        }
    }


    public String getPlaceholder(String inputId) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputId)));
        return el.getAttribute("placeholder");
    }

}
