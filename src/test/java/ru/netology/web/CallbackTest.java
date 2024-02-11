package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CallbackTest {

    private WebDriver driver;

    @BeforeAll

    static  void  setUpAll() {
        System.setProperty("webDriver.chrome.driver", "driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp() { driver = new ChromeDriver(); }

    @AfterEach
    void tearDown() {

        driver.quit();
        driver = null;
    }

    @Test

    void shouldTestSomething() {
        //загрузить страницу
        //поиск элементов
        //взаимодействие с элементами
    }
}
