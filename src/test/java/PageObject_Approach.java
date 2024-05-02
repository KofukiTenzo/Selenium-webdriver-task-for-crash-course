import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PageObject_Approach {

    private WebDriver driver;

    public PageObject_Approach(WebDriver driver) {
        this.driver = driver;
    }

    public void getInShoppingCart() {
        driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/ul/li[4]/a")).click();
    }

    public boolean isShoppingCartEmpty() {
        return driver.findElement(By.id("content")).getText().contains("Your shopping cart is empty!");
    }

    public void clickContinue() {
        driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div/a")).click();
    }

    public void waiting() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public boolean isPageHome() {
        return driver.getCurrentUrl().equals("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
    }

}
