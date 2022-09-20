package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SmartfonsApplePage extends BaseView {

    public SmartfonsApplePage(WebDriver driver) {
        super(driver);
    }


    //@FindBy(xpath = "//div[@class='ProductCardHorizontal__header-block']/a")
    @FindBy(xpath = "//div[contains(@class,'product_data__gtm-js')]")
    private List<WebElement> smartfonsAppleList;

    private static final String buttonAddToCardXpath=
            "//span[@class='Button__icon ']/ancestor::button[@class='ProductCardHorizontal__button_cart js--ProductCardInListing__button-buy js--ProductCardInListing__addToCart js--AddToCart Button  jsButton Button_theme_primary Button_size_s Button_with-icon']";
    @FindBy(xpath = buttonAddToCardXpath)
    private WebElement buttonAddToCard;


    public SuccessBlock chooseIphoneByNameModel(String IphoneModel) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("let element = document.evaluate(\"//div[@class='PersonalDataConfirm js--PersonalDataConfirm']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        webDriverWait.until(d -> smartfonsAppleList.size() > 1);
        smartfonsAppleList.stream().filter(d -> d.getText().contains(IphoneModel)).findFirst().get()
                .findElement(By.xpath(buttonAddToCardXpath)).click();
        Thread.sleep(5000);
        return new SuccessBlock(driver);
    }

}