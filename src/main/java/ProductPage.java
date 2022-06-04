import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;
import io.qameta.allure.Step;

public class ProductPage {

    public WebDriver driver;
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private WebElement addproduct;

    @FindBy(xpath ="//a[@id='nava']")
    private WebElement mainpage;

    @FindBy(xpath = "//a[normalize-space()='Apple monitor 24']")
    private WebElement manclick;


    @Step("Добавление продукта в корзину")
    public void addCard() throws InterruptedException {
        addproduct.click();
        Thread.sleep(1000);
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        Thread.sleep(2000);
    }

    @Step("Переход на страницу монитора")
    public void toMonitor() throws InterruptedException {

        driver.findElement(By.xpath("//a[4]")).click();
        Thread.sleep(1000);

    }

    @Step("Переход на главную страницу")
    public void toMain() throws InterruptedException {
    mainpage.click();
    Thread.sleep(1000);}

    }

