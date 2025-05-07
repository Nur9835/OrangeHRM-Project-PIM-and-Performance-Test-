package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideBarPage extends BaseTest {

    private final WebDriver driver;

    public SideBarPage (WebDriver driver){
        this.driver=driver;
    }

    private final By pımPageLink= By.xpath("//ul[@class='oxd-main-menu']//li[a/span[text()='PIM']]");
    private final By performancePageLink= By.xpath("//ul[@class='oxd-main-menu']//li[a/span[text()='Performance']]");
    private final By adminPageLink= By.xpath("//ul[@class='oxd-main-menu']//li[a/span[text()='Admin']]");

    public PIMPage openPIMMenu() throws InterruptedException {
        driver.findElement(pımPageLink).click();
        sleep(3000);
        return new PIMPage(driver);
    }

    public AdminPage openAdminMenu() throws InterruptedException {
        driver.findElement(adminPageLink).click();
        sleep(3000);
        return new AdminPage(driver);
    }

    public HeaderPage openPerformanceMenu() throws InterruptedException {
        driver.findElement(performancePageLink).click();
        sleep(3000);
        return new HeaderPage(driver);
    }

}
