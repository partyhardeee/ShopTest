import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Iterator;
import java.util.Random;
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

    @FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
    private WebElement clickonphone;

    @Step("Регистрация")
    public void SignUp() throws InterruptedException{
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        randomString = sb.toString();

        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }

        signupbutton.click();
        Thread.sleep(1000);
        driver.switchTo().window(subWindowHandler);
        signusername.sendKeys(randomString);
        signpassword.sendKeys("password");
        signupClick.click();
        Thread.sleep(1000);
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        Thread.sleep(1000);
        driver.switchTo().window(parentWindowHandler);
        Thread.sleep(1000);
    }

    @Step("Вход в аккаунт")
    public void LogIn() throws InterruptedException {

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
        user.sendKeys(randomString);
        pass.sendKeys("password");
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
