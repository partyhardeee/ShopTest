import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Iterator;
import java.util.Set;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

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

    @FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
    private WebElement clickonphone;


    @Step("Вход в аккаунт")
    public void LogIn(String log, String password) throws InterruptedException {

        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }

        driver.switchTo().window(subWindowHandler);
        login.click();
        Thread.sleep(2000);
        user.sendKeys(log);
        pass.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();
        driver.switchTo().window(parentWindowHandler);
        Thread.sleep(2000);
    }
    @Step("Выход из аккаунта")
    public void LogOut() throws InterruptedException {
        logout.click();
        Thread.sleep(2000);
    }

    @Step("Переход на страницу товара")
    public void ToPhone() throws InterruptedException {
        clickonphone.click();
        Thread.sleep(2000);
    }

}
