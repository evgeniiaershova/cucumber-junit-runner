package com.testProject.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverCreator {

    @Bean
    public WebDriver startDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
