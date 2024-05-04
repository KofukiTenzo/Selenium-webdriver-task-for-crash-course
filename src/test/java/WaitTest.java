import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaitTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\SeleniumWebdriver\\geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void testOpenCart() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://speak-ukrainian.eastus2.cloudapp.azure.com/dev/");

        driver.findElement(By.xpath("/html/body/div[1]/div/header/div[2]/ul/li[1]/span[2]/a")).click();

        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/main/div/div[1]/div[2]/div/div[1]/div/span[1]/input"));
        search.click();
        search.sendKeys("Dream Team");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/main/div/div[2]/main")).getText().contains("Dream Team");

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
