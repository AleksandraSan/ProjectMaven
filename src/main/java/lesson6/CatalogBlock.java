package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogBlock extends BaseView{

    public CatalogBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='CatalogMenu__category-list js--CatalogMenu__category-list']//span ")
    private List<WebElement> categoryProductCatalog;

    public SmartfonsMarkPage chooseCategoryProductInCatalog(String categoryProductsName) throws InterruptedException {
        webDriverWait.until(d -> categoryProductCatalog.size() > 1);
        categoryProductCatalog.stream().filter(d -> d.getText().contains(categoryProductsName)).findFirst().get().click();
        Thread.sleep(5000);
        return new SmartfonsMarkPage(driver);
    }


}
