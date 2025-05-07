package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.List;

public class PIMPage extends BaseTest {
    private final WebDriver driver;
    List<String> allEmployeeNames;

    public PIMPage (WebDriver driver){
        this.driver=driver;
    }
    private final By newEmployeeButton= By.xpath("//button[normalize-space()='Add']");
    private final By employeeNameInput = By.xpath("(//div[contains(@class, 'oxd-grid-item oxd-grid-item--gutters')])[1]//input");
    private final By searchButton= By.xpath("//div[contains(@class, 'oxd-table-filter')]//button[@type='submit']");
    private final By employeeNames= By.xpath("//div[@class='oxd-table-card']//div//div[3]//div");
    private final By employeeIDs= By.xpath("//div[@class='oxd-table-card']//div//div[2]//div");
    private final By nextPageButton= By.xpath("//ul[@class='oxd-pagination__ul']/li[last()]/button[@class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']");
    private final By firstEmployeeDeleteButton= By.xpath("(//button[i[contains(@class, 'oxd-icon bi-trash')]])[1]");
    private final By firstEmployeeName= By.xpath("(//div[@class='oxd-table-card']//div//div[3]//div)[1]");
    private final By deleteEmployeeAcceptButton= By.xpath("//button[normalize-space()='Yes, Delete']");
    private final By deleteEmployeeRejectButton= By.xpath("//button[normalize-space()='No, Cancel']");
    private final By toastPanel=By.xpath("//div[@id=\"oxd-toaster_1\"]");
    private final By employeeSize=By.xpath("//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]//span");
    private final By reportPageButton= By.xpath("//header[@class='oxd-topbar']//li[4]//a");

    public AddEmployeePage newEmployeeLink() throws InterruptedException {
        sleep(3000);
        driver.findElement(newEmployeeButton).click();
        sleep(3000);
        return new AddEmployeePage(driver);

    }

    public ReportPage openReportsPage () throws InterruptedException {
        driver.findElement(reportPageButton).click();
        sleep(2000);
        return new ReportPage(driver);

    }

    public PIMPage searchEmployeeName(String name) throws InterruptedException {
        driver.findElement(employeeNameInput).sendKeys(name);
        sleep(2000);
        driver.findElement(searchButton).click();
        sleep(2000);
        return this;
    }


    public List<String> getEmployeeNames() throws InterruptedException {
        allEmployeeNames = new ArrayList<>();
        while (true) {
            List<WebElement> employeeElements = driver.findElements(employeeNames);
            allEmployeeNames.addAll(employeeElements.stream().map(WebElement::getText).collect(Collectors.toList()));
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
        return allEmployeeNames;
    }

    public List<String> getEmployeeID() throws InterruptedException {
        List<String> allEmployeeID = new ArrayList<>();
        while (true) {
            List<WebElement> employeeElements = driver.findElements(employeeIDs);
            allEmployeeID.addAll(employeeElements.stream().map(WebElement::getText).collect(Collectors.toList()));
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
        return allEmployeeID;
    }

    public List<String> filteredEmployeeNameList (String searchName) throws InterruptedException {
        List<String> filteredEmployeeNames = new ArrayList<>();

        for (int i = 0; i < allEmployeeNames.size(); i++) {
            if (allEmployeeNames.get(i).toLowerCase().contains(searchName.toLowerCase())) {
                filteredEmployeeNames.add(allEmployeeNames.get(i));
            }
        }
        sleep(3000);
        System.out.println("Filtered Employee Names: " + filteredEmployeeNames);
        return filteredEmployeeNames;
    }

    public String getFirstEmployeeName(){
        return driver.findElement(firstEmployeeName).getText();
    }

    public String firstDeleteEmployee() throws InterruptedException {
        driver.findElement(firstEmployeeDeleteButton).click();
        sleep(3000);
        driver.findElement(deleteEmployeeAcceptButton).click();
        sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastPanel));
        System.out.println("Toast mesajı: " + toastMessage.getText());
        return toastMessage.getText();


    }
    public void cancelDeleteFirstEmployee() throws InterruptedException {

        driver.findElement(firstEmployeeDeleteButton).click();
        sleep(3000);
        driver.findElement(deleteEmployeeRejectButton).click();
        sleep(3000);

    }

    public Integer employeeSize(){
        Integer  employeeCount= Integer.parseInt(driver.findElement(employeeSize).getText().replaceAll("[^0-9]", ""));
        System.out.printf("employeeCount");
        return employeeCount;


    }




}
