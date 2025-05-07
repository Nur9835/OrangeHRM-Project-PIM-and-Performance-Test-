package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformancePage extends BaseTest {


    private final WebDriver driver;

    public PerformancePage (WebDriver driver){
        this.driver=driver;
    }

    private final By configureButton = By.xpath("//li[.//span[normalize-space(text())=\"Configure\"]]");
    private final By configureKIPSButton = By.xpath("//li[.//span[normalize-space(text())=\"Configure\"]]//li[1]");
    private final By configureTrackersButton = By.xpath("//li[.//span[normalize-space(text())=\"Configure\"]]//li[2]");
    private final By employeeTrackersButton=By.xpath("//li[.//a[normalize-space(text())='Employee Trackers']]");



    public KPIPage clickKIPSButton() throws InterruptedException {
//        Actions builder = new Actions(driver);
//        builder.moveToElement(driver.findElement(configureButton)).build().perform();
        driver.findElement(configureButton).click();
        sleep(1000);
        driver.findElement(configureKIPSButton).click();
        sleep(1000);
        return new KPIPage(driver);

    }
    public PerformanceTrackersPage clickTrackersButton() throws InterruptedException {
        driver.findElement(configureButton).click();
        sleep(1000);
        driver.findElement(configureTrackersButton).click();
        sleep(1000);
        return new PerformanceTrackersPage(driver);

    }

    public EmployeeTrackerPage clickEmployeeTrackerButton() throws InterruptedException {
        driver.findElement(employeeTrackersButton).click();
        sleep(2000);
        return new EmployeeTrackerPage(driver);

    }





}
