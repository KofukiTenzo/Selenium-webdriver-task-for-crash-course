import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpencartTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\SeleniumWebdriver\\geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void testOpenCart() {
        driver.get("https://demo.opencart.com/");

        WebElement currency = driver.findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[1]/form/div/a/span"));
        currency.click();

        WebElement euroOption = driver.findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[1]/form/div/ul/li[1]/a"));
        euroOption.click();

        WebElement desktopsMenu = driver.findElement(By.xpath("/html/body/main/div[1]/nav/div[2]/ul/li[1]/a"));
        desktopsMenu.click();

        WebElement mac = driver.findElement(By.xpath("/html/body/main/div[1]/nav/div[2]/ul/li[1]/div/div/ul/li[2]/a"));
        mac.click();

        WebElement product = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[2]/div/form/div/div[2]/div[1]"));
        assertTrue(product.getText().contains("111.04"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
