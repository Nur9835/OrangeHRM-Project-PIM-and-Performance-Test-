package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TrackerDetailPage extends BaseTest {

    private final WebDriver driver;

    public TrackerDetailPage (WebDriver driver){
        this.driver=driver;
    }


    private final By trackerName= By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-employee-tracker-header-title']");
    private final By addLogButton= By.xpath(" //button[normalize-space()='Add Log']");
    private final By allTrackerLogNames= By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-employee-tracker-log-title-text']");

    List<String> allLogs ;

    public List<String> getAllTrackerLogNames(){
        allLogs=new ArrayList<>();
        List<WebElement> logElements = driver.findElements(allTrackerLogNames);

        for (WebElement element : logElements) {
            allLogs.add(element.getText());
        }

        return allLogs;
    }

    public boolean searchLogByName(String name) {
        List<String> allLogs = getAllTrackerLogNames();
        for (String log : allLogs) {
            if (log.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }





    public String getTrackerName(){
        return driver.findElement(trackerName).getText();
    }


    public AddTrackerLogPage openAddButtonLog() throws InterruptedException {
        driver.findElement(addLogButton).click();
        sleep(2000);
        return new AddTrackerLogPage(driver);
    }


}
