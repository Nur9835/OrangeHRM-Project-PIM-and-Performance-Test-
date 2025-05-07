package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class AddPerformanceTrackersPage  extends BaseTest {
    private final WebDriver driver;
    public AddPerformanceTrackersPage (WebDriver driver){
        this.driver=driver;
    }

    private final By title= By.xpath("(//h6)[2]");
    private final By saveButton= By.xpath("//button[normalize-space()='Save']");
    private final By trackerNameInput= By.xpath("//label[text()='Tracker Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    private final By reviewersInput= By.xpath("//label[text()='Reviewers']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    private final By employeeNameInput= By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input");

    private final By option =By.xpath("//div[@role='listbox']//div[@role='option'][1]\n");
    public String getTtile(){return driver.findElement(title).getText();}

    private void fillNewPerformanceTracker(String trackerName,String reviewers,String employeeName) throws InterruptedException {
        sleep(5000);
        driver.findElement(trackerNameInput).sendKeys(trackerName);
        sleep(2000);
        driver.findElement(reviewersInput).sendKeys(reviewers);
        sleep(4000);
        driver.findElement(option).click();
        sleep(3000);
        driver.findElement(employeeNameInput).sendKeys(employeeName);
        sleep(4000);
        driver.findElement(option).click();
        sleep(3000);
        driver.findElement(saveButton).click();
        sleep(5000);

    }

    public void fillCorrectNewPerformanceTracker(String trackerName,String reviewers,String employeeName) throws InterruptedException {
        fillNewPerformanceTracker(trackerName,reviewers,employeeName);
    }


}
