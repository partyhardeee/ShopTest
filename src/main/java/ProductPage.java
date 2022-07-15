import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath = "//a[4]")
    private WebElement manclick;


    @Step("Добавление продукта в корзину")
    public void addCard() throws InterruptedException {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(addproduct)));
        addproduct.click();
        Thread.sleep(1000);
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    @Step("Переход на страницу монитора")
    public void toMonitor(){
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(manclick)));
        manclick.click();
    }

    @Step("Переход на главную страницу")
    public void toMain() {
        mainpage.click();
        }
    }

