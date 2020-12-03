import Page.MenuList;
import Page.SimpleFormDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    private static WebDriver driver;
    private static MenuList menuList;
    private static SimpleFormDemoPage simpleFormDemoPage;
    WebDriverWait wait = new WebDriverWait(driver, 5);


    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        menuList = new MenuList(driver);
        simpleFormDemoPage = new SimpleFormDemoPage(driver);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("https://www.seleniumeasy.com/test/");
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void isTheTitleCorrectTest() {
        WebElement adsBanner = driver.findElement(By.id("at-cv-lightbox-close"));
        wait.until(ExpectedConditions.visibilityOf(adsBanner)).click();
        Assertions.assertTrue(driver.getTitle().equals("Selenium Easy - Best Demo website to practice Selenium Webdriver Online"));
    }

    @Test
    public void sendMessageTest() {
        menuList.clickOnInputFormsButton()
                .clickOnSimpleFormDemo();

        wait.until(ExpectedConditions.visibilityOf(simpleFormDemoPage.headerLogo));

        simpleFormDemoPage.fillMessage()
                .acceptMessage();

        Assertions.assertEquals("Selenium is easy", simpleFormDemoPage.messageOutput.getText());
    }

    @Test
    public void addNumbersTest() {
        menuList.clickOnInputFormsButton()
                .clickOnSimpleFormDemo();

        simpleFormDemoPage.fillFirstValue()
                .fillSecondValue()
                .sumValues();

        Assertions.assertEquals(simpleFormDemoPage.sumOutput.getText(), "5");
    }
}
