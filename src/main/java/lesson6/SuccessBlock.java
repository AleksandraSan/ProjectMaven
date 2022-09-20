package lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessBlock extends BaseView {
    public SuccessBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='UpsaleBasket']")
    private WebElement accessBlock;

    public void productSuccessAddToCard(){
        Assertions.assertTrue(accessBlock.isDisplayed());
    }
}
