package homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyProductTest {
    WebDriver driver;
    lesson6.MainPage mainPage;


    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("https://www.citilink.ru/");
    }

    @Test
    void buyProductTest() throws InterruptedException {
        mainPage.clickSignInButton()
                .login("sandakovaalexx@mail.ru", "Sasha2002_")
                .moveToCatalogButton()
                .chooseCategoryProductInCatalog("Смартфоны и гаджеты")
                .chooseGadgetTypeInCatalog("Смартфоны Apple iPhone")
                 .chooseIphoneByNameModel("Смартфон Apple iPhone 11 64Gb")
                .productSuccessAddToCard();
    }


    @AfterEach
    void tearDown(){
        driver.quit();
    }


}
