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

public class KPIPage extends BaseTest {
    private final WebDriver driver;
    List<String> allKPINames;

    private final By title= By.xpath("//h5");
    private final By addButton= By.xpath("//button[normalize-space()='Add']");
    private final By kpiNames= By.xpath("//div[@class='oxd-table-card']//div//div[2]//div");
    private final By nextPageButton= By.xpath("//ul[@class='oxd-pagination__ul']/li[last()]/button[@class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']");
    private final By firstKPIDeleteButton=By.xpath("(//button[i[contains(@class, 'oxd-icon bi-trash')]][1])[1]");
    private final By deleteKpiAcceptButton= By.xpath("//button[normalize-space()='Yes, Delete']");
    private final By deleteKpitRejectButton= By.xpath("//button[normalize-space()='No, Cancel']");
    private final By toastPanel=By.xpath("//div[@id=\"oxd-toaster_1\"]");

    private final By firstKPIName= By.xpath("(//div[@class='oxd-table-card']//div//div[2]//div)[1]");

    public KPIPage (WebDriver driver){
        this.driver=driver;
    }

    public List<String> getKPINames() throws InterruptedException {
        allKPINames = new ArrayList<>();
        while (true) {
            List<WebElement> employeeElements = driver.findElements(kpiNames);
            allKPINames.addAll(employeeElements.stream().map(WebElement::getText).collect(Collectors.toList()));
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
        return allKPINames;
    }

    public List<String> filteredKPINameList (String searchName) throws InterruptedException {
        List<String> filteredEmployeeNames = new ArrayList<>();

        for (int i = 0; i < allKPINames.size(); i++) {
            if (allKPINames.get(i).toLowerCase().contains(searchName.toLowerCase())) {
                filteredEmployeeNames.add(allKPINames.get(i));
            }
        }
        sleep(3000);
        System.out.println("Filtered Employee Names: " + filteredEmployeeNames);
        return filteredEmployeeNames;
    }

    public String getTtile(){
        return driver.findElement(title).getText();
    }
    public String getFirstKPI(){
        return driver.findElement(firstKPIName).getText();
    }

    public AddKPIPage openAddKPIPage() throws InterruptedException {
        driver.findElement(addButton).click();
        sleep(3000);
        return new AddKPIPage(driver);
    }

    public void clickFirstKpiDeleteButton() throws InterruptedException {
        driver.findElement(firstKPIDeleteButton).click();
        sleep(3000);
    }


    public String acceptDeleteFirstKPI() throws InterruptedException {
        clickFirstKpiDeleteButton();
        sleep(3000);
        driver.findElement(deleteKpiAcceptButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastPanel));
        System.out.println("Toast mesajı: " + toastMessage.getText());
        return toastMessage.getText();

    }


    public void rejectDeleteFirstKPI() throws InterruptedException {
        clickFirstKpiDeleteButton();
        sleep(2000);
        driver.findElement(deleteKpitRejectButton).click();

    }


}
