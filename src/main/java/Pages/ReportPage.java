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

public class ReportPage extends BaseTest {
    private final WebDriver driver;
    List<String> allReportNames;
    public ReportPage (WebDriver driver){
        this.driver=driver;
    }
    private final By pageTitle= By.xpath("//h5");
    private final By firstReportDeleteButton= By.xpath("//button[i[contains(@class, 'oxd-icon bi-trash')]][1]");
    private final By firstReportDetailButton=By.xpath("(//button[i[contains(@class, 'oxd-icon bi-file-text-fill')]])[1]");
    private final By firstReportEditButton= By.xpath("//button[i[contains(@class, 'oxd-icon bi-pencil-fill')]][1]");
    private final By deleteReportRejectButton= By.xpath("//button[normalize-space()='No, Cancel']");
    private final By deleteReportAcceptButton= By.xpath("//button[normalize-space()='Yes, Delete']");
    private final By toastPanel=By.xpath("//div[@id=\"oxd-toaster_1\"]");
    private final By reportNames= By.xpath("//div[@class='oxd-table-card']//div//div[2]//div");
    private final By nextPageButton= By.xpath("//ul[@class='oxd-pagination__ul']/li[last()]/button[@class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']");

    private final By addReportPageButton= By.xpath("//button[normalize-space()='Add']");

    private final By reportNameInput= By.xpath("//label[text()='Report Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    private final By searchButton=By.xpath("//button[normalize-space()='Search']");

    private final By firstReportName=By.xpath("(//div[@class='oxd-table-card']//div//div[2]//div)[1]");

    public void clickFirstReportDeleteButton() throws InterruptedException {
        driver.findElement(firstReportDeleteButton).click();
        sleep(3000);
    }

    public ReportDetailPage clickFirstReportDetailButton() throws InterruptedException {
        driver.findElement(firstReportDetailButton).click();
        sleep(3000);
        return new ReportDetailPage(driver );
    }

    public String getFirstReport(){
        return driver.findElement(firstReportName).getText();
    }


    public List<String> getAllReports() throws InterruptedException {
        allReportNames=new ArrayList<>();
        while (true) {
            List<WebElement> employeeElements = driver.findElements(reportNames);
            allReportNames.addAll(employeeElements.stream().map(WebElement::getText).collect(Collectors.toList()));
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
        return allReportNames;


    }

    public ReportPage searchReportName(String name) throws InterruptedException {
        driver.findElement(reportNameInput).sendKeys(name);
        sleep(2000);
        driver.findElement(searchButton).click();
        sleep(2000);
        return this;
    }






    public List<String> filteredReportNameList (String searchName) throws InterruptedException {
        List<String> filteredEmployeeReportNames = new ArrayList<>();

        for (int i = 0; i < allReportNames.size(); i++) {
            if (allReportNames.get(i).toLowerCase().contains(searchName.toLowerCase())) {
                filteredEmployeeReportNames.add(allReportNames.get(i));
            }
        }
        sleep(3000);
        System.out.println("Filtered Employee Names: " + filteredEmployeeReportNames);
        return filteredEmployeeReportNames;
    }


    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }


    public void rejectDeleteFirstReport() throws InterruptedException {
        clickFirstReportDeleteButton();
        sleep(2000);
        driver.findElement(deleteReportRejectButton).click();

    }


    public String acceptDeleteFirstReport() throws InterruptedException {
        clickFirstReportDeleteButton();
        sleep(3000);
        driver.findElement(deleteReportAcceptButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastPanel));
        System.out.println("Toast mesajı: " + toastMessage.getText());
        return toastMessage.getText();

    }


    public String getFirstReportName(){
        return driver.findElement(firstReportName).getText();

    }

    public EditReportPage openEditReportPage() throws InterruptedException {
        driver.findElement(firstReportEditButton).click();
        sleep(3000);
        return new EditReportPage(driver);
    }



    public AddReportPage openAddReportPage() throws InterruptedException {
        driver.findElement(addReportPageButton).click();
        sleep(3000);
        return new AddReportPage(driver);
    }

}
