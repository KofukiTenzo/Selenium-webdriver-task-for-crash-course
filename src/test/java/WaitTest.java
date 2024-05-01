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
        driver.get("https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/");
        driver.manage().window().maximize();

        WebElement acceptCookies = driver.findElement(By.xpath("/html/body/div/div[1]/div/footer[2]/div/div/div[2]/button"));
        acceptCookies.click();
//
        acceptCookies = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div/div[1]/div/div/h3[1]/a"));
        acceptCookies.click();

        List<WebElement> filter = driver.findElements(By.xpath("//html/body/div[2]/div/div/div/div/div/div/div/table/thead/tr[2]/th[3]/div/div"));

        for (WebElement webElement : filter) {
            webElement.sendKeys("L");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        List<WebElement> valueElement = driver.findElements(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[3]"));
//
//        wait.until(ExpectedConditions.textToBePresentInElement(valueElement.get(0), "Las Vegas"));
//        wait.until(ExpectedConditions.textToBePresentInElement(valueElement.get(1), "Las Vegas"));
//        wait.until(ExpectedConditions.textToBePresentInElement(valueElement.get(2), "London"));

        List<WebElement> filteredElements = driver.findElements(By.cssSelector(".MuiTableBody-root > tr:nth-child(1) > td:nth-child(3)"));

//        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(filteredElements));

        // Find text in filtered elements
        for (WebElement element : filteredElements) {
            String text = element.getText();
            System.out.println("Text found: " + text);
        }


//        List<WebElement> valueElement = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]")), "Las Vegas"));

//        /html/body/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]

//        /html/body/div[2]/div/div/div/div/div/div/div/table/colgroup/col[3]

//        WebDriverWait waitAfterSearch = new WebDriverWait(driver, Duration.ofSeconds(5));
//        waitAfterSearch.until(ExpectedConditions.textToBePresentInElement(valueElement.get(0), "Las Vegas"));
//        waitAfterSearch.until(ExpectedConditions.textToBePresentInElement(valueElement.get(1), "Las Vegas"));
//        waitAfterSearch.until(ExpectedConditions.textToBePresentInElement(valueElement.get(2), "London"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
