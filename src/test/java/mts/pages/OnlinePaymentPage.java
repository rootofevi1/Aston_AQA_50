package mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentPage extends BasePage {

    // Блок "Онлайн пополнение"
    @FindBy(xpath = "//h2[contains(normalize-space(.), 'Онлайн пополнение')]")
    private WebElement blockTitle;

    // Логотипы
    @FindBy(css = ".pay__partners img")
    private List<WebElement> paymentLogos;

    // Подробнее о сервисе
    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement moreInfoLink;

    // Форма оплаты
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

    // Услуги связи
    @FindBy(id = "connection-phone")
    private WebElement connectionPhoneInput;

    @FindBy(id = "connection-sum")
    private WebElement connectionSumInput;

    @FindBy(id = "connection-email")
    private WebElement connectionEmailInput;

    @FindBy(css = "#pay-connection.opened")
    private WebElement connectionFormActive;

    // Домашний интернет
    @FindBy(xpath = "//li[contains(@class,'select__item')]//*[contains(text(),'Домашний интернет')]")
    private WebElement internetOption;

    @FindBy(id = "internet-phone")
    private WebElement internetPhoneInput;

    @FindBy(id = "internet-sum")
    private WebElement internetSumInput;

    @FindBy(id = "internet-email")
    private WebElement internetEmailInput;

    @FindBy(css = "#pay-internet.opened")
    private WebElement internetFormActive;

    // Рассрочка
    @FindBy(xpath = "//li[contains(@class,'select__item')]//*[contains(text(),'Рассрочка')]")
    private WebElement instalmentOption;

    @FindBy(id = "score-instalment")
    private WebElement instalmentScoreInput;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSumInput;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmailInput;

    @FindBy(css = "#pay-instalment.opened")
    private WebElement instalmentFormActive;

    // Задолженность
    @FindBy(xpath = "//li[contains(@class,'select__item')]//*[contains(text(),'Задолженность')]")
    private WebElement arrearsOption;

    @FindBy(id = "score-arrears")
    private WebElement arrearsScoreInput;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSumInput;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmailInput;

    @FindBy(css = "#pay-arrears.opened")
    private WebElement arrearsFormActive;

    // Страница оплаты (после нажатия "Продолжить")

    // Номер телефона на странице оплаты
    @FindBy(xpath = "//span[contains(text(),'Номер')]")
    private WebElement paymentPhoneNumber;

    // Кнопка "Оплатить"
    @FindBy(xpath = "//button[contains(@class,'colored')]//span[contains(text(),'Оплатить')]")
    private WebElement payButton;

    // Иконки платёжных систем (все)
    @FindBy(css = ".cards-brands img")
    private List<WebElement> paymentSystemIcons;

    // Поля карты (лейблы)
    @FindBy(xpath = "//input[@id='cc-number']/following-sibling::label")
    private WebElement cardNumberLabel;

    @FindBy(xpath = "//input[@placeholder='MM / ГГ']/following-sibling::label")
    private WebElement expiryDateLabel;

    @FindBy(xpath = "//input[@formcontrolname='cvc']/following-sibling::label")
    private WebElement cvcLabel;

    @FindBy(xpath = "//input[@formcontrolname='holder']/following-sibling::label")
    private WebElement holderLabel;

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

    // Услуги связи
    public void verifyConnectionServicePlaceholders() {
        assertTrue(
                connectionFormActive.isDisplayed(),
                "Форма 'Услуги связи' не активна!"
        );

        assertEquals(
                "Номер телефона",
                connectionPhoneInput.getDomAttribute("placeholder"),
                "Плейсхолдер для номера телефона не совпадает!"
        );

        assertEquals(
                "Сумма",
                connectionSumInput.getDomAttribute("placeholder"),
                "Плейсхолдер для суммы не совпадает!"
        );

        assertEquals(
                "E-mail для отправки чека",
                connectionEmailInput.getDomAttribute("placeholder"),
                "Плейсхолдер для email не совпадает!"
        );
    }

    // Домашний интернет
    public void selectInternetService() {
        selectService("Домашний интернет");
    }

    public void verifyInternetServicePlaceholders() {
        assertTrue(
                internetFormActive.isDisplayed(),
                "Форма 'Домашний интернет' не активна!"
        );

        assertEquals(
                "Номер абонента",
                internetPhoneInput.getDomAttribute("placeholder"),
                "Плейсхолдер для номера абонента не совпадает!"
        );

        assertEquals(
                "Сумма",
                internetSumInput.getDomAttribute("placeholder"),
                "Плейсхолдер для суммы не совпадает!"
        );

        assertEquals(
                "E-mail для отправки чека",
                internetEmailInput.getDomAttribute("placeholder"),
                "Плейсхолдер для email не совпадает!"
        );
    }

    // Рассрочка
    public void selectInstalmentService() {
        selectService("Рассрочка");
    }

    public void verifyInstalmentServicePlaceholders() {
        assertTrue(
                instalmentFormActive.isDisplayed(),
                "Форма 'Рассрочка' не активна!"
        );

        assertEquals(
                "Номер счета на 44",
                instalmentScoreInput.getDomAttribute("placeholder"),
                "Плейсхолдер для номера счета не совпадает!"
        );

        assertEquals(
                "Сумма",
                instalmentSumInput.getDomAttribute("placeholder"),
                "Плейсхолдер для суммы не совпадает!"
        );

        assertEquals(
                "E-mail для отправки чека",
                instalmentEmailInput.getDomAttribute("placeholder"),
                "Плейсхолдер для email не совпадает!"
        );
    }

    // Задолженность
    public void selectArrearsService() {
        selectService("Задолженность");
    }

    public void verifyArrearsServicePlaceholders() {
        assertTrue(
                arrearsFormActive.isDisplayed(),
                "Форма 'Задолженность' не активна!"
        );

        assertEquals(
                "Номер счета на 2073",
                arrearsScoreInput.getDomAttribute("placeholder"),
                "Плейсхолдер для номера счета не совпадает!"
        );

        assertEquals(
                "Сумма",
                arrearsSumInput.getDomAttribute("placeholder"),
                "Плейсхолдер для суммы не совпадает!"
        );

        assertEquals(
                "E-mail для отправки чека",
                arrearsEmailInput.getDomAttribute("placeholder"),
                "Плейсхолдер для email не совпадает!"
        );
    }

    // Метод для проверки страницы оплаты
    public void verifyPaymentPageOpened(String expectedPhone, String expectedAmount) {
        try {
            // Переключаемся в iframe BePaid
            driver.switchTo().defaultContent();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement bepaidIframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//iframe[contains(@src, 'checkout.bepaid.by')]")
            ));
            driver.switchTo().frame(bepaidIframe);

            // Ждём загрузки формы
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            // ПРОВЕРКА: Сумма на кнопке "Оплатить X.XX BYN"
            WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(@class, 'colored')]//span[contains(text(), 'Оплатить')]")
            ));
            String actualPayButtonText = payButton.getText().trim();
            assertTrue(actualPayButtonText.contains(expectedAmount),
                    "Сумма на кнопке не совпадает! Ожидалось: " + expectedAmount +
                            ", а получили: " + actualPayButtonText);

            // ПРОВЕРКА: Номер телефона
            WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(text(), '375')]")
            ));
            String actualPhone = phoneElement.getText().trim();
            assertTrue(actualPhone.contains(expectedPhone),
                    "Номер телефона не совпадает! Ожидалось: " + expectedPhone +
                            ", а получили: " + actualPhone);

            // ПРОВЕРКА: Поля карты
            // Номер карты
            WebElement cardNumberLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[contains(text(), 'Номер карты')]")
            ));
            assertEquals("Номер карты", cardNumberLabel.getText().trim(),
                    "Надпись 'Номер карты' не совпадает!");

            // Срок действия
            WebElement expiryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[contains(text(), 'Срок действия')]")
            ));
            assertEquals("Срок действия", expiryLabel.getText().trim(),
                    "Надпись 'Срок действия' не совпадает!");

            // CVC
            WebElement cvcLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[contains(text(), 'CVC')]")
            ));
            assertEquals("CVC", cvcLabel.getText().trim(),
                    "Надпись 'CVC' не совпадает!");

            // Имя и фамилия на карте
            WebElement holderLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[contains(text(), 'Имя и фамилия на карте')]")
            ));
            assertEquals("Имя и фамилия на карте", holderLabel.getText().trim(),
                    "Надпись 'Имя и фамилия на карте' не совпадает!");

            // ПРОВЕРКА: Иконки платёжных систем
            List<WebElement> icons = wait.until(ExpectedConditions.visibilityOfAllElements(
                    driver.findElements(By.cssSelector(".cards-brands img"))
            ));
            assertFalse(icons.isEmpty(), "Иконки платёжных систем не найдены!");
            assertTrue(icons.size() >= 3,
                    "Найдено меньше 3 иконок платёжных систем! Найдено: " + icons.size());
        } catch (Exception e) {
            throw new AssertionError("Страница оплаты не загрузилась: " + e.getMessage());
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

    // Вспомогательный метод для выбора сервиса
    public void selectService(String serviceName) {
        click(selectHeader);

        WebElement option = driver.findElement(
                By.xpath("//li[contains(@class,'select__item')]//*[contains(text(),'" + serviceName + "')]")
        );
        click(option);
    }
}