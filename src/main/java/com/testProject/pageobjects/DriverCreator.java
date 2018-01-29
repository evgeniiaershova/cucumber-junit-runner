package com.testProject.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverCreator {

    @Bean
    public WebDriver startDriver() {
        WebDriverManager.chromedriver().setup();
        EventFiringWebDriver driver =
                new EventFiringWebDriver(new ChromeDriver());
        driver.register(new WebDriverLogger());
        return driver;
    }

}
