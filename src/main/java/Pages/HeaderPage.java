package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage extends BaseTest {
    private final WebDriver driver;

    public HeaderPage (WebDriver driver){
        this.driver=driver;
    }

    private final By headerTitle= By.xpath("//h6");
    private final By userPanel= By.xpath("//div[@class='oxd-topbar-header-userarea']");
    private final By logOutButton= By.xpath("//a[normalize-space()='Logout']");
    private final By adminName= By.xpath("//p[@class='oxd-userdropdown-name']");


    public WebElement getHeaderTitle(){
        return driver.findElement(headerTitle);
    }


    public String  getAdminInfo(){
        return driver.findElement(adminName).getText();

    }


    public LoginPage logOutClick() throws InterruptedException {
        driver.findElement(userPanel).click();
        sleep(3000);
        driver.findElement(logOutButton).click();
        sleep(5000);
        return new LoginPage(driver);
    }




    public void clickUserPanel (){
        driver.findElement(userPanel).click();
    }


}
