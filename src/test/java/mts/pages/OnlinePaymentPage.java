package mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinePaymentPage extends BasePage {

    @FindBy(xpath = "//h2[contains(normalize-space(.), 'Онлайн пополнение')]")
    private WebElement blockTitle;

    @FindBy(css = ".pay__partners img")
    private List<WebElement> paymentLogos;

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement moreInfoLink;

    @FindBy(css = ".select__header")
    private WebElement selectHeader;

    @FindBy(id = "connection-phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[contains(.,'Продолжить')]")
    private WebElement continueButton;

    @FindBy(xpath = "//p[contains(normalize-space(.),'Услуги связи')]")
    private WebElement servicesButton;

    @FindBy(id = "connection-sum")
    private WebElement sumInput;

    public OnlinePaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Блок "Онлайн пополнение"
    public void verifyBlockTitle(String expectedTitle) {
        String actualTitle = wait.until(ExpectedConditions.visibilityOf(blockTitle))
                .getText()
                .toLowerCase()
                .replaceAll("\\s+", " ")
                .trim();

        String cleanExpected = expectedTitle.toLowerCase()
                .replaceAll("\\s+", " ")
                .trim();

        assertEquals(cleanExpected, actualTitle, "Заголовок блока не совпадает!");
    }

    // Логотипы
    public List<WebElement> getPaymentLogos() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentLogos));
        return paymentLogos;
    }

    // Подробнее о сервисе
    public void clickMoreInfoLink() {
        click(moreInfoLink);
    }

    public boolean isMoreInfoPageOpened(String expectedUrlPart) {
        return waitForUrlContains(expectedUrlPart);
    }

    // Форма оплаты
    public void selectCommunicationServices() {
        click(selectHeader);
        click(servicesButton);
    }

    public void enterPhone(String phone) {
        type(phoneInput, phone);
    }

    public void enterAmount(String amount) {
        type(sumInput, amount);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public boolean isPaymentPageOpened() {

        try {
            wait.until(ExpectedConditions.or(

                    ExpectedConditions.urlContains("pay"),

                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("iframe")
                    ),

                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("form")
                    )

            ));

            return true;

        } catch (TimeoutException e) {
            return false;
        }
    }

    // Cookie banner
    public void closeCookieBanner() {

        try {

            WebElement cookieButton = driver.findElement(
                    By.xpath("//button[contains(@class,'cookie') and contains(.,'Принять')]")
            );

            click(cookieButton);

            waitUntilInvisible(cookieButton);

        } catch (NoSuchElementException | TimeoutException ignored) {
        }
    }
}