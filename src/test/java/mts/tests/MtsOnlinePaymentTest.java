package mts.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mts.pages.OnlinePaymentPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

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

        assertFalse(
                logos.isEmpty(),
                "Логотипы платежных систем отсутствуют."
        );

        for (WebElement logo : logos) {

            assertTrue(
                    logo.isDisplayed(),
                    "Логотип не отображается."
            );

            String src = logo.getAttribute("src");

            assertNotNull(src);
            assertFalse(
                    src.isBlank(),
                    "У логотипа отсутствует атрибут src."
            );
        }
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
}