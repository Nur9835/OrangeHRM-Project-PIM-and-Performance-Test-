package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeTrackerPage extends BaseTest {

    private final WebDriver driver;

    public EmployeeTrackerPage (WebDriver driver){
        this.driver=driver;
    }
    private final By title= By.xpath("//h5");

    public String getTtile(){
        return driver.findElement(title).getText();
    }


    private void clickViewButtonByName(String name) throws InterruptedException {
        String xpath = "//div[text()='" + name + "']/ancestor::div[@role='row']//button[@name='view']";
        WebElement viewButton = driver.findElement(By.xpath(xpath));
        viewButton.click();
        sleep(2000);
    }

    public TrackerDetailPage openTrackerDetailPage(String value) throws InterruptedException {
        clickViewButtonByName(value);
        return new TrackerDetailPage(driver);
    }



}
