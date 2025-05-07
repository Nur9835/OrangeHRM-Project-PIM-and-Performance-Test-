package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddKPIPage extends BaseTest {
    private final WebDriver driver;

    private final By title= By.xpath("(//p)[2]");

    private final By kipNameInput=By.xpath("//label[normalize-space(text())=\"Key Performance Indicator\"]/ancestor::div[contains(@class, \"oxd-input-group\")]//input");

    private final By deneme =By.xpath("//div[@class=\"oxd-select-text-input\"]");

    private final By saveButton = By.xpath("//button[normalize-space()='Save']");
    private final By minRatingInput=By.xpath("//label[normalize-space(text())=\"Minimum Rating\"]/ancestor::div[contains(@class,\"oxd-input-group\")]//input");

   private final By firstJobElement=By.xpath("//div[@role='listbox']//div[@role='option'][2]\n");

   private final By downIcon=By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]");

    public AddKPIPage (WebDriver driver){
        this.driver=driver;
    }

    public String getTtile(){
        return driver.findElement(title).getText();
    }

    private void newKPI(String kpiName) throws InterruptedException {
        driver.findElement(kipNameInput).sendKeys(kpiName);
        sleep(1000);
        driver.findElement(downIcon).click();
        sleep(5000);
        driver.findElement(firstJobElement).click();
        sleep(5000);
        driver.findElement(saveButton).click();
        sleep(9000);

    }


    public void fillCorrectNewKPI(String  name) throws InterruptedException {
        newKPI(name);

    }

}
