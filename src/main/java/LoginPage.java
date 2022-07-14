import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class LoginPage {

    public WebDriver driver;
    private String randomString;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@id='signin2']")
    private WebElement signupbutton;

    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement signusername;

    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement signpassword;

    @FindBy(xpath = "//button[@onclick=\'register()\']")
    private WebElement signupClick;

    @FindBy(xpath = "//a[@id='login2']")
    private WebElement login;

    @FindBy(xpath ="//input[@id='loginusername']")
    private WebElement user;

    @FindBy(xpath ="//input[@id='loginpassword']")
    private  WebElement pass;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@id='logout2']")
    private WebElement logout;

    @FindBy(xpath = "/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h4[1]/a[1]")
    private WebElement fisrtthing;


    @Step("Вход в аккаунт")
    public void logIn(String log, String password) throws InterruptedException {
        /*
           Переключение между окнами
        */
        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }

        driver.switchTo().window(subWindowHandler);
        login.click();
            WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(user)));
        user.sendKeys(log);
        pass.sendKeys(password);
            Thread.sleep(2000);
        loginButton.click();
        driver.switchTo().window(parentWindowHandler);
            Thread.sleep(2000);
        }

    @Step("Выход из аккаунта")
    public void logOut() throws InterruptedException {
        logout.click();
        Thread.sleep(2000);}

    @Step("Переход на страницу товара")
    public void toGood() throws InterruptedException {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(fisrtthing)));
        fisrtthing.click();
        Thread.sleep(2000);}

    }
