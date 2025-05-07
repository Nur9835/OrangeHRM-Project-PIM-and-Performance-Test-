package Pages;
import Base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BaseTest {
    private final WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver=driver;
    }

    private final By userNameInput= By.xpath("//input[@placeholder='Username']");
    private final By passwordInput= By.xpath("//input[@placeholder='Password']");
    private final By loginButton= By.xpath("//button[normalize-space()='Login']");
    private final By errorText= By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    private final By loginPageTitle= By.xpath("//h5[normalize-space()='Login']");


    public WebElement getErrorText() throws InterruptedException {
        sleep(2000);
        return driver.findElement(errorText);
    }

    private void fillLogin(String name, String password) throws InterruptedException {
        sleep(5000);
        driver.findElement(userNameInput).sendKeys(name);
        sleep(2000);
        driver.findElement(passwordInput).sendKeys(password);
        sleep(2000);
        driver.findElement(loginButton).click();
        sleep(5000);
    }


    public HeaderPage fillCorrectLogin(String name, String password) throws InterruptedException {
        fillLogin(name, password);
        sleep(4000);
        return new HeaderPage(driver);
    }

    public LoginPage fillIncorrectLogin(String name, String password) throws InterruptedException {
        fillLogin(name, password);
        return this;
    }


    public WebElement getLoginPageTitle() {
        return driver.findElement(loginPageTitle);

    }

}
