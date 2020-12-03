package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuList extends PageObject {

    public MenuList(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#treemenu > li > ul > li:nth-child(1)")
    private WebElement inputForms;

    @FindBy(css = "#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(1)")
    private WebElement simpleFormDemo;

    public MenuList clickOnInputFormsButton(){
        inputForms.click();
        return this;
    }
    public MenuList clickOnSimpleFormDemo(){
        simpleFormDemo.click();
        return this;
    }

}
