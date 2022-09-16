package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexUslygiTest extends ParentClassTest{

    @Test
    void createOrderTest() throws InterruptedException {
        driver.get("https://uslugi.yandex.ru/");

        //для прокликивания капчи
        Thread.sleep(20000);
        driver.findElement(By.xpath("//div[contains(@class, 'PortalHeader')]/a[.='Создать заказ']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@data-lego='react']")));
        driver.findElement(By.xpath("//input[@data-lego='react']")).sendKeys("Сборка мебели");
        driver.findElement(By.xpath("//a[contains(@class,'_iconPosition_right')]")).click();
        driver.findElement(By.xpath("//span[contains(@class, 'Order') and contains(text(), 'У меня')]")).click();
        driver.findElement(By.xpath("//a[contains(@class,'_iconPosition_right')]")).click();
        driver.findElement(By.xpath("//span[.='Выберите категорию']")).click();
        //на основе ввода описания , выводится список подходящих категорий
        webDriverWait.until(d -> d.findElement(By.xpath("//input[@data-lego='react']")).getAttribute("value").contains("Сборка мебели"));
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='Link SelectRubric-SectionItem']/b[.='Ремонт и строительство']")));
        driver.findElement(By.xpath("//a[@class='Link SelectRubric-SectionItem']/b[.='Ремонт и строительство']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='Link SelectRubric-SectionItem']/span[.='Изготовление шкафов-купе']")));
        driver.findElement(By.xpath("//a[@class='Link SelectRubric-SectionItem']/span[.='Изготовление шкафов-купе']")).click();
        //driver.findElement(By.xpath("//a[@class='Link OrderFormModal-Close']")).click();
        driver.findElement(By.xpath("//span[contains(@class, 'Order') and contains(text(), 'У меня')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class, 'Button2_theme_actionYdo ')]")));
        driver.findElement(By.xpath("//button[contains(@class, 'Button2_theme_actionYdo ')]")).click();
        Thread.sleep(10000);


        WebElement messageAuthrization  = driver.findElement(By.xpath("//div[contains(@class,'ContactsModalContent')]"));
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'ContactsModalContent')]")));
        Assertions.assertTrue(messageAuthrization.isDisplayed());
    }

}
