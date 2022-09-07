package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tinkoff {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Настройте свою карту
        driver.get("https://www.tinkoff.ru/cards/credit-cards/");
        WebElement element = driver.findElement(By.xpath("//div[contains(@data-qa-type,'thumb_position_right')]"));
        WebElement element2 = driver.findElement(By.xpath("//div[@data-value=\"100000\"]"));

        Actions actions = new Actions(driver);
        //actions.dragAndDropBy(element, 100, 0).build().perform();
        actions.dragAndDrop(element, element2).build().perform();

        Thread.sleep(5000);
        driver.quit();

    }
}
