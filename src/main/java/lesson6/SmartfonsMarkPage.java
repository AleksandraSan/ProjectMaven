package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SmartfonsMarkPage extends BaseView {

    public SmartfonsMarkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "  //div[@class='CatalogCategoryMenu__subcategories-box']//a")
    private List<WebElement> typeGadgetCatalogList;

    public SmartfonsApplePage chooseGadgetTypeInCatalog(String typeGadget){
        webDriverWait.until(d -> typeGadgetCatalogList.size() > 1);
        typeGadgetCatalogList.stream().filter(t -> t.getText().contains(typeGadget)).findFirst().get().click();
        return new SmartfonsApplePage(driver);
    }
}
