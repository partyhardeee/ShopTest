import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class AutoShopTest {
    public static WebDriver driver;
    public static LoginPage LoginPage;
    public static ProductPage Productpage;
    public static CartPage CartPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        LoginPage = new LoginPage(driver);
        Productpage = new ProductPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='nava']"))));
    }
    @Test
    public void test1() throws InterruptedException {
        //Регистрация
        LoginPage.signUp();
    }
    @Test
    public void test2() throws InterruptedException {
        //Залогинивание под созданным аккаунтом
        LoginPage.logIn();
    }

    @Test
    public void test3() throws InterruptedException {
        LoginPage.toPhone();
        Productpage.addCard();
        CartPage.comparePrice();
        Productpage.toMain();
        LoginPage.logOut();
    }
    @AfterClass
    public static void down() {
        driver.quit();}}
