package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static Base.BaseLibrary.sleep;

public class EditReportPage  extends BaseTest {

    private final WebDriver driver;

    public EditReportPage (WebDriver driver){
        this.driver=driver;
    }

    private final By pageTitle= By.xpath("(//h6)[2]");
    private final By reportNameInput=By.xpath("//label[text()='Report Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By saveReportButton= By.xpath("//button[@type=\"submit\"]");

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }

    public String getReportName(){
        return driver.findElement(reportNameInput).getText();
    }

    public void updateReportName(String name) throws InterruptedException {
        driver.findElement(reportNameInput).clear();
        sleep(3000);
        driver.findElement(reportNameInput).sendKeys(name);
        sleep(3000);
        driver.findElement(saveReportButton).click();
        sleep(2000);
    }

}
