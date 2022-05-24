import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

    @FindBy(xpath = "//a[@id='cartur']")
    private WebElement cart;

    @FindBy(xpath = "//a[normalize-space()='Delete']")
    private WebElement delelement;

    @FindBy(xpath ="//a[@id='nava']")
    private WebElement mainpage;


    @Step("Добавление продукта в корзину")
    public void AddCard() throws InterruptedException {
        addproduct.click();
        Thread.sleep(1000);
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        Thread.sleep(2000);
    }
    @Step("Сравнение цены товара и цены корзины")
    public void comparePrice() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
    String productprice = driver.findElement(By.xpath("//td[normalize-space()='360']")).getText();
    String totalprice = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
        Assert.assertEquals(productprice, totalprice);
        Thread.sleep(1000);
        delelement.click();
        Thread.sleep(2000);
    }
    @Step("Переход на главную страницу")
    public void toMain() throws InterruptedException {
    mainpage.click();
    Thread.sleep(1000);

    }

    }

