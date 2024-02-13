package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class CommonUtil {

    protected WebDriver driver;
    private final Properties properties;
    private final WebDriverWait wait;
    private final String loadingSpinnerXpath = "//oxd-loader[@ng-if='job.loading']";

    public CommonUtil(WebDriver driver) {
        this.driver = driver;
        properties = new Properties();
        properties.setProperty("implicit.wait.time", "10");
        wait = new WebDriverWait(driver, Duration.ofSeconds(getImplicitWaitTime()));
    }

    public void scrollToElement(WebElement element) {
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }

    public void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVueFToLoad() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loadingSpinnerXpath)));
    }

    public int getImplicitWaitTime() {
        String implicitWaitTime = properties.getProperty("implicit.wait.time");
        return Integer.parseInt(implicitWaitTime);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}