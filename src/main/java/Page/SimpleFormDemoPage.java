package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleFormDemoPage extends PageObject {

    public SimpleFormDemoPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".cbt")
    public WebElement headerLogo;

    @FindBy(css = "#display")
    public WebElement messageOutput;

    @FindBy(css = "#displayvalue")
    public WebElement sumOutput;

    @FindBy(css = "label[for='message' ] + #user-message")
    private WebElement messageField;

    @FindBy(css = "button[onclick='showInput();']")
    private WebElement sendMessageButton;

    @FindBy(css = "#sum1")
    private WebElement firstValueField;

    @FindBy(css = "#sum2")
    private WebElement secondValueField;

    @FindBy(css = "button[onclick='return total()']")
    private WebElement getTotal;

    public SimpleFormDemoPage fillMessage(){
        messageField.sendKeys("Selenium is easy");
        return this;
    }

    public SimpleFormDemoPage acceptMessage(){
        sendMessageButton.click();
        return this;
    }

    public SimpleFormDemoPage fillFirstValue(){
        firstValueField.sendKeys("2");
        return this;
    }

    public SimpleFormDemoPage fillSecondValue(){
        secondValueField.sendKeys("3");
        return this;
    }

    public SimpleFormDemoPage sumValues(){
        getTotal.click();
        return this;
    }

}
