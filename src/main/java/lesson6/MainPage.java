package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.time.Duration;

public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'IconAndTextWithCount__text_mainHeader') and contains(., 'Войти')]")
    private WebElement signInButton;

    public LoginPage clickSignInButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
        return new LoginPage(driver);
    }



    ////button[@data-label='Каталог товаров']
    private static final String moveToCatalogCategoriesLocator=
            "//span[contains(., 'Каталог товаров')]";
    @FindBy(xpath = moveToCatalogCategoriesLocator)
    private WebElement catalogButton;

    public CatalogBlock moveToCatalogButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(moveToCatalogCategoriesLocator)));
        catalogButton.click();
        return new CatalogBlock(driver);
    }
}