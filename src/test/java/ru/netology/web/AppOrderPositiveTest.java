package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppOrderPositiveTest {
    private WebDriver driver;
    @BeforeAll
    public static  void  setUpAll() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
        driver = null;
    }

    @Test

    public void ShouldBeSuccessfulForm() {
      driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Иваныч-Ивановичев Иван");
      driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+78005553535");
      driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
      driver.findElement(By.cssSelector("button.button")).click();
      var actualTextElement = driver.findElement(By.cssSelector("[data-test-id=order-success]"));
      var actualText = actualTextElement.getText().trim();
      assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actualText);
      assertTrue(actualTextElement.isDisplayed());
    }
}

