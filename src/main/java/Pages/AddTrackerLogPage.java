package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTrackerLogPage extends BaseTest {

    private final WebDriver driver;

    public AddTrackerLogPage (WebDriver driver){
        this.driver=driver;
    }

    private final By title = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-title']");
    private final By logNameInput=By.xpath("//label[text()='Log']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    private final By commentInput=By.xpath("//label[text()='Comment']/ancestor::div[contains(@class, 'oxd-input-group')]//textarea");

    private final By saveButton= By.xpath("//button[normalize-space()='Save']");
    private final By negativeButton= By.xpath("//button[normalize-space()='Negative']");


    public String getTitleName(){
        return driver.findElement(title).getText();
    }

    private void fillPositiveNewLog(String log,String comment) throws InterruptedException {
        sleep(5000);
        driver.findElement(logNameInput).sendKeys(log);
        sleep(2000);
        driver.findElement(commentInput).sendKeys(comment);
        sleep(4000);
        driver.findElement(saveButton).click();
        sleep(5000);
    }


    private void fillNegativeNewLog(String log,String comment) throws InterruptedException {
        sleep(5000);
        driver.findElement(logNameInput).sendKeys(log);
        sleep(2000);
        driver.findElement(commentInput).sendKeys(comment);
        sleep(4000);
        driver.findElement(negativeButton).sendKeys(comment);
        sleep(4000);
        driver.findElement(saveButton).click();
        sleep(5000);
    }

    public void fillCorrectNewTrackerLog(String log, String comment) throws InterruptedException {
        fillPositiveNewLog(log,comment);
    }


}
