import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

    public WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@id='cartur']")
    private WebElement cart;

    @FindBy(xpath = "//a[normalize-space()='Delete']")
    private WebElement delelement;

    @Step("Сравнение цены товара и цены корзины")
    public void comparePrice() throws InterruptedException {
        cart.click();
        Thread.sleep(1000);
        String productprice = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")).getText();
        String totalprice = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
        Assert.assertEquals(productprice, totalprice);
        Thread.sleep(1000);
        delelement.click();
        Thread.sleep(1000);
    }
}
