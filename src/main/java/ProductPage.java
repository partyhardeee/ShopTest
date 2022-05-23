import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.Alert;

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
    }

    }

