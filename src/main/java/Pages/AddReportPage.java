package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddReportPage  extends BaseTest {

    private final WebDriver driver;

    public AddReportPage (WebDriver driver){
        this.driver=driver;
    }

    private final By title= By.xpath("(//h6)[2]");
    private final By selectionCriteriaMenuDownIcon= By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]");
    private final By includeMenuDownIcon=By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]");
    private final By displayFieldsDownIcon=By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[3]");
    private final By selectDisplayFileds= By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[4]");
    private final By saveButton=By.xpath("//button[normalize-space()='Save']");
    private final By reportNameInput= By.xpath("//label[normalize-space(text())='Report Name']/ancestor::div[contains(@class,'oxd-input-group') and contains(@class,'oxd-input-field-bottom-space')]//input");

    private final By firstElement=By.xpath("//div[@role='listbox']//div[@role='option'][2]\n");


    private final By addDisplayFieldsButton=By.xpath("(//button[@class='oxd-icon-button orangehrm-report-icon'])[2]");


    public String getTitle(){
        return driver.findElement(title).getText();
    }


    private void newReport(String name) throws InterruptedException {
        driver.findElement(reportNameInput).sendKeys(name);
        sleep(1000);
        driver.findElement(selectionCriteriaMenuDownIcon).click();
        sleep(3000);
        driver.findElement(firstElement).click();
        sleep(3000);
        driver.findElement(includeMenuDownIcon).click();
        driver.findElement(firstElement).click();
        sleep(3000);
        driver.findElement(displayFieldsDownIcon).click();
        driver.findElement(firstElement).click();
        sleep(3000);
        driver.findElement(selectDisplayFileds).click();
       // driver.findElement(firstElement).click();
        sleep(3000);
        driver.findElement(addDisplayFieldsButton).click();
        sleep(3000);
        driver.findElement(saveButton).click();
        sleep(9000);

    }
    private void newReportwithSingleDisplayField(String name) throws InterruptedException {
        driver.findElement(reportNameInput).sendKeys(name);
        sleep(1000);
        driver.findElement(selectionCriteriaMenuDownIcon).click();
        sleep(3000);
        driver.findElement(firstElement).click();
        sleep(3000);
        driver.findElement(includeMenuDownIcon).click();
        driver.findElement(firstElement).click();
        sleep(3000);
        driver.findElement(displayFieldsDownIcon).click();
        driver.findElement(firstElement).click();
        sleep(3000);
        driver.findElement(selectDisplayFileds).click();
        sleep(2000);
        driver.findElement(firstElement).click();
        sleep(2000);
        driver.findElement(addDisplayFieldsButton).click();
        sleep(3000);
        driver.findElement(saveButton).click();
        sleep(9000);

    }


    public void fillCorrectNewReport(String reportName) throws InterruptedException {
        newReport(reportName);

    }

    public void fillCorrectNewReportwithSingleDisplayField(String reportName) throws InterruptedException {
        newReportwithSingleDisplayField(reportName);

    }

}
