import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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
        Thread.sleep(2000);
        String productprice = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")).getText();
        String totalprice = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
        Assert.assertEquals(productprice, totalprice);
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//a[normalize-space()='Delete']")).isDisplayed()){
        delelement.click();
        Thread.sleep(1000);}

    }
    @Step("Сравнение цены товара и цены корзины")
    public void manyPrice() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        String productprice1 = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")).getText();
        String productprice2 = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]")).getText();
        String totalprice = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
        Integer intprice = Integer.parseInt(totalprice);
        Integer twoprices = Integer.parseInt(productprice1) + Integer.parseInt(productprice2);

        Assert.assertEquals(twoprices, intprice);
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//a[normalize-space()='Delete']")).isDisplayed()){
            delelement.click();
            Thread.sleep(2000);}
}}
