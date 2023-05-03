import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebInterfaceTest {
    private WebDriver driver;
    @BeforeAll
    static void setUpAll(){
        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);*/
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldFillByValidData() {
        driver.get("http://localhost:9999");

    }
}
