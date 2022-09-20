package lesson6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='SignIn__login']//ancestor-or-self::input")
    private WebElement loginField;

    @FindBy(xpath = "//div[@class='SignIn__password']//ancestor-or-self::input")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='SignIn__actions']//ancestor-or-self::button[@data-label='Войти']")
    private WebElement buttonSignIn;

    public MainPage login (String login, String password) throws InterruptedException {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        Thread.sleep(5000);
        buttonSignIn.click();
        return new MainPage(driver);
    }
}
