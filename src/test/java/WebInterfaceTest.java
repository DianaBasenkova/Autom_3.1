
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ChromeSeleniumTest{
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }
        @BeforeEach
        void setUp() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.get("http://localhost:9999/");
        }
    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldFillByValidData() {
        driver.findElement(By.xpath("//span[@data-test-id='name']//input")).sendKeys("Иванов Иван");
        driver.findElement(By.xpath("//span[@data-test-id='phone']//input")).sendKeys("+79123456789");
        driver.findElement(By.xpath(".//span[contains(@class, 'checkbox__box')]")).click();
        driver.findElement(By.xpath(".//span[contains(text(), 'Продолжить')]")).click();
        String actual = driver.findElement(By.xpath("//div[contains(@class, 'Success_successBlock')]//p")).getText();
        String expected = " Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actual);
    }
    }
