package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceTrackersPage  extends BaseTest {
    List<String> allPerformanceTrackers;
    private final WebDriver driver;
    public PerformanceTrackersPage (WebDriver driver){
        this.driver=driver;
    }
    private final By title= By.xpath("//h5");
    private final By addButton= By.xpath("//button[normalize-space()='Add']");
    private final By performanceTrackerNames= By.xpath("//div[@class='oxd-table-card']//div//div[3]//div");
    private final By nextPageButton= By.xpath("//ul[@class='oxd-pagination__ul']/li[last()]/button[@class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']");

    private final By deleteAcceptButton= By.xpath("//button[normalize-space()='Yes, Delete']");
    private final By deleteRejectButton= By.xpath("//button[normalize-space()='No, Cancel']");
    private final By toastPanel=By.xpath("//div[@id=\"oxd-toaster_1\"]");

    private final By firstTrackerDeleteButton=By.xpath("(//button[i[contains(@class, 'oxd-icon bi-trash')]][1])[1]");
    private final By firstTrackerName= By.xpath("(//div[@class='oxd-table-card']//div//div[3]//div)[1]");


    private final By firstPerformanceTrackerEditButton= By.xpath("(//button[i[contains(@class, 'oxd-icon bi-pencil-fill')]][1])[1]");


    public String getTtile(){
        return driver.findElement(title).getText();
    }


    public AddPerformanceTrackersPage openAddPerformanceTrackersPage() throws InterruptedException {
        driver.findElement(addButton).click();
        sleep(3000);
        return new AddPerformanceTrackersPage(driver);
    }



    public List<String> getPerformanceTrackerNames() throws InterruptedException {
        allPerformanceTrackers = new ArrayList<>();
        while (true) {
            List<WebElement> performanceTrackerElements = driver.findElements(performanceTrackerNames);
            allPerformanceTrackers.addAll(performanceTrackerElements.stream().map(WebElement::getText).collect(Collectors.toList()));
            List<WebElement> nextButtons = driver.findElements(nextPageButton);
            if (nextButtons.size() > 0) { // Eğer next buton varsa
                WebElement nextButton = nextButtons.get(0);
                if (nextButton.isDisplayed() && nextButton.isEnabled()) {
                    nextButton.click();
                    sleep(6000);
                } else {
                    break; // Buton varsa ama tıklanamazsa döngüyü bitir
                }
            } else {
                break; // Buton hiç yoksa döngüyü bitir
            }
        }
        return allPerformanceTrackers;
    }


    public List<String> filteredEPerformanceTrackerNameList (String searchName) throws InterruptedException {
        List<String> filteredPerformanceTrackerNames = new ArrayList<>();

        for (int i = 0; i < allPerformanceTrackers.size(); i++) {
            if (allPerformanceTrackers.get(i).toLowerCase().contains(searchName.toLowerCase())) {
                filteredPerformanceTrackerNames.add(allPerformanceTrackers.get(i));
            }
        }
        sleep(3000);
        System.out.println("Filtered Employee Names: " + filteredPerformanceTrackerNames);
        return filteredPerformanceTrackerNames;
    }



    public String getFirstTracker(){
        return driver.findElement(firstTrackerName).getText();
    }


    public void clickFirstTrackerDeleteButton() throws InterruptedException {
        driver.findElement(firstTrackerDeleteButton).click();
        sleep(3000);
    }


    public EditPerformanceTrackerPage openEditPerformanceTrackerPage() throws InterruptedException {
        driver.findElement(firstPerformanceTrackerEditButton).click();
        sleep(2000);
        return  new EditPerformanceTrackerPage(driver);

    }




    public String acceptDeleteFirstTracker() throws InterruptedException {
        clickFirstTrackerDeleteButton();
        sleep(3000);
        driver.findElement(deleteAcceptButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastPanel));
        System.out.println("Toast mesajı: " + toastMessage.getText());
        return toastMessage.getText();

    }


    public void rejectDeleteFirstTracker() throws InterruptedException {
        clickFirstTrackerDeleteButton();
        sleep(2000);
        driver.findElement(deleteRejectButton).click();

    }


}
