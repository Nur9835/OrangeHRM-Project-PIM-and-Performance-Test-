package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditPerformanceTrackerPage extends BaseTest {

    private final WebDriver driver;

    public EditPerformanceTrackerPage (WebDriver driver){
        this.driver=driver;
    }

    private final By pageTitle= By.xpath("(//h6)[2]");
    private final By trackerNameInput= By.xpath("//label[text()='Tracker Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    private final By saveButton= By.xpath("//button[normalize-space()='Save']");
    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }


    public void updatePerformanceTrackerName(String name) throws InterruptedException {
       // driver.findElement(trackerNameInput).clear();
        clearInputWithJs(driver.findElement(trackerNameInput));
        sleep(3000);
        driver.findElement(trackerNameInput).sendKeys(name);
        sleep(3000);
        driver.findElement(saveButton).click();
        sleep(2000);
    }



}
