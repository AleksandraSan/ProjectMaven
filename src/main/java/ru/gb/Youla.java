package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Youla {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //ПОИСК ТОВАРА НА ЮЛЕ
        driver.get("https://youla.ru/");
        WebElement inputSearch = driver.findElement(By.xpath("//input[@role='combobox']"));
        inputSearch.sendKeys("телефон");
        inputSearch.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        driver.quit();
    }
}
