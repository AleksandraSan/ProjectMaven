package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StakexChangeTest extends ParentClassTest{


    @Disabled("Авторизация и проверка пояления элемента с сообщением об успешной авторизации")
    @Test
    void authorizationTest() throws InterruptedException {

        driver.get("https://sqa.stackexchange.com/users/signup?ssrc=head");
        ((JavascriptExecutor)driver).executeScript("let element = document.evaluate(\"//div[contains(@class, 'r16 js-consent-banner')]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        driver.findElement(By.id("display-name")).sendKeys("TesterTestitTest");
        driver.findElement(By.id("email")).sendKeys("sbr38275@cdfaq.com");
        driver.findElement(By.id("password")).sendKeys("password124");
        //прокликивание капчи
        Thread.sleep(5000);
        driver.findElement(By.id("opt-in")).click();
        driver.findElement(By.id("submit-button")).click();
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'s-notice__success ')]")));
        WebElement weElement = driver.findElement(By.xpath("//div[contains(@class,'s-notice__success ')]"));
        Assertions.assertTrue(weElement.isDisplayed());
    }
}
