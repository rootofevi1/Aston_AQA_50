package mts.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mts.pages.OnlinePaymentPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@Epic("MTS Онлайн пополнение")
@Feature("Проверка плейсхолдеров")
public class MtsOnlinePaymentTest {

    private static final String BASE_URL = "https://mts.by";
    private static final String PHONE_NUMBER = "297777777";
    private static final String AMOUNT = "10";
    private static final String PAYMENT_INFO_URL =
            "poryadok-oplaty-i-bezopasnost-internet-platezhey";

    static {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("selenium.silent", "true");
        System.setProperty("wdm.quiet", "true");

        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        Logger.getLogger("io.github.bonigarcia").setLevel(Level.OFF);
    }

    private WebDriver driver;
    private OnlinePaymentPage paymentPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--log-level=3");
        options.setExperimentalOption(
                "excludeSwitches",
                new String[]{"enable-logging"}
        );

        driver = new ChromeDriver(options);
        driver.get(BASE_URL);

        paymentPage = new OnlinePaymentPage(driver);
        paymentPage.closeCookieBanner();
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка заголовка блока 'Онлайн пополнение без комиссии'")
    void testBlockTitle() {
        paymentPage.verifyBlockTitle("Онлайн пополнение без комиссии");
    }

    @Test
    @DisplayName("Проверка логотипов платежных систем")
    void testPaymentLogos() {
        List<WebElement> logos = paymentPage.getPaymentLogos();

        // Проверяем, что логотипы есть
        assertFalse(logos.isEmpty(), "Логотипы платежных систем отсутствуют.");

        // Ожидаемые значения alt (в том порядке, как на странице)
        List<String> expectedAltValues = Arrays.asList(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );

        // Проверяем каждый логотип
        for (int i = 0; i < logos.size(); i++) {
            WebElement logo = logos.get(i);

            // Проверяем, что логотип отображается
            assertTrue(logo.isDisplayed(), "Логотип не отображается!");

            // Проверяем src
            String src = logo.getDomAttribute("src");
            assertNotNull(src, "У логотипа отсутствует атрибут src!");
            assertFalse(src.isBlank(), "Атрибут src пустой!");

            // Проверяем alt (уникальное значение)
            String alt = logo.getDomAttribute("alt");
            assertNotNull(alt, "У логотипа отсутствует атрибут alt!");
            assertFalse(alt.isBlank(), "Атрибут alt пустой!");

            // Проверяем, что alt совпадает с ожидаемым
            if (i < expectedAltValues.size()) {
                assertEquals(expectedAltValues.get(i), alt,
                        "Логотип " + i + " имеет неверный alt! Ожидалось: " +
                                expectedAltValues.get(i) + ", а получили: " + alt);
            }
        }

        // Проверяем, что количество логотипов совпадает с ожидаемым
        assertEquals(expectedAltValues.size(), logos.size(),
                "Количество логотипов не совпадает! Ожидалось: " +
                        expectedAltValues.size() + ", а получили: " + logos.size());
    }

    @Test
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    void testMoreInfoLink() {
        paymentPage.clickMoreInfoLink();

        assertTrue(
                paymentPage.isMoreInfoPageOpened(PAYMENT_INFO_URL),
                "Открылась неверная страница."
        );
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Продолжить' для услуги связи")
    void testContinueButtonForCommunicationServices() {
        paymentPage.selectCommunicationServices();
        paymentPage.enterPhone("PHONE_NUMBER");
        paymentPage.enterAmount("AMOUNT");
        paymentPage.clickContinue();

        assertTrue(
                paymentPage.isPaymentPageOpened(),
                "Форма оплаты не открылась."
        );
    }

    @Test
    @DisplayName("Проверка плейсхолдеров для услуги 'Услуги связи'")
    @Description("Проверка плейсхолдеров в полях: Номер телефона, Сумма, E-mail")
    @Severity(SeverityLevel.NORMAL)
    @Story("Услуги связи")
    void testConnectionServicePlaceholders() {
        paymentPage.selectCommunicationServices();
        paymentPage.verifyConnectionServicePlaceholders();
    }

    @Test
    @DisplayName("Проверка плейсхолдеров для услуги 'Домашний интернет'")
    @Description("Проверка плейсхолдеров в полях: Номер абонента, Сумма, E-mail")
    @Severity(SeverityLevel.NORMAL)
    @Story("Домашний интернет")
    void testInternetServicePlaceholders() {
        paymentPage.selectInternetService();
        paymentPage.verifyInternetServicePlaceholders();
    }

    @Test
    @DisplayName("Проверка плейсхолдеров для услуги 'Рассрочка'")
    @Description("Проверка плейсхолдеров в полях: Номер счета на 44, Сумма, E-mail")
    @Severity(SeverityLevel.NORMAL)
    @Story("Рассрочка")
    void testInstalmentServicePlaceholders() {
        paymentPage.selectInstalmentService();
        paymentPage.verifyInstalmentServicePlaceholders();
    }

    @Test
    @DisplayName("Проверка плейсхолдеров для услуги 'Задолженность'")
    @Description("Проверка плейсхолдеров в полях: Номер счета на 2073, Сумма, E-mail")
    @Severity(SeverityLevel.NORMAL)
    @Story("Задолженность")
    void testArrearsServicePlaceholders() {
        paymentPage.selectArrearsService();
        paymentPage.verifyArrearsServicePlaceholders();
    }

    @Test
    @DisplayName("Проверка страницы оплаты после заполнения формы 'Услуги связи'")
    @Description("Проверка: суммы на кнопке, номера телефона, надписей в полях карты, иконок")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Оплата услуги связи")
    void testPaymentPageAfterSubmit() {
        paymentPage.selectCommunicationServices();
        paymentPage.enterPhone(PHONE_NUMBER);
        paymentPage.enterAmount(AMOUNT);
        paymentPage.clickContinue();
        paymentPage.verifyPaymentPageOpened("375" + PHONE_NUMBER, AMOUNT + ".00");
    }
}