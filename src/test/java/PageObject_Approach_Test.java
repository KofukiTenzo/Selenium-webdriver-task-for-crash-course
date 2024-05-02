import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageObject_Approach_Test {

    private WebDriver driver;

    private PageObject_Approach pageObject_approach;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\SeleniumWebdriver\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

        pageObject_approach = new PageObject_Approach(driver);
    }

    @Test
    public void testOpenCart() throws InterruptedException {

        pageObject_approach.getInShoppingCart();

        pageObject_approach.waiting();

        assertTrue(pageObject_approach.isShoppingCartEmpty());

        pageObject_approach.clickContinue();

        pageObject_approach.waiting();

        assertTrue(pageObject_approach.isPageHome());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
