package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

import static Base.BaseLibrary.clearInputWithJs;
import static Base.BaseLibrary.sleep;

public class AddEmployeePage extends BaseTest {

    private final WebDriver driver;

    public AddEmployeePage (WebDriver driver){
        this.driver=driver;
    }

    private final By pageTitle= By.xpath("//h6");
    private final By firstNameInput= By.xpath("//input[@placeholder='First Name']");
    private final By middleNameInput= By.xpath("//input[@placeholder='Middle Name']");
    private final By lastNameInput= By.xpath("//input[@placeholder='Last Name']");
    private final By employeeIdInput= By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private final By saveButton= By.xpath("//button[normalize-space()='Save']");
    private final By imgInput= By.xpath("//input[@type=\"file\"]");
    private final By requiredTitle=By.xpath("//span[text()=\"Required\"]");


    public WebElement getTitle(){
        return driver.findElement(pageTitle);
    }


    private void fillNewEmployee(String firstname, String middlename, String lastname, String employeeId) throws InterruptedException {
        sleep(5000);
        driver.findElement(firstNameInput).sendKeys(firstname);
        sleep(2000);
        driver.findElement(middleNameInput).sendKeys(middlename);
        sleep(2000);
        driver.findElement(lastNameInput).sendKeys(lastname);
        sleep(2000);
        driver.findElement(employeeIdInput).clear();
        sleep(8000);
        clearInputWithJs(driver.findElement(employeeIdInput));
        sleep(3000);
        driver.findElement(employeeIdInput).sendKeys(employeeId);
        sleep(4000);
        String imagePath = new File("src/test/resources/img/bjk.jpg").getAbsolutePath();
        sleep(2000);
        driver.findElement(imgInput).sendKeys(imagePath);
        sleep(2000);
        driver.findElement(saveButton).click();

    }


    public PersonalDetailsPage fillCorrectNewEmployee(String firstname, String middlename, String lastname, String employeeId) throws InterruptedException {
        fillNewEmployee(firstname, middlename,lastname,employeeId);
        sleep(8000);
        return new PersonalDetailsPage(driver);
    }


        public void fillInCorrectNewEmployee(String firstname, String middlename, String lastname, String employeeId) throws InterruptedException {
        fillNewEmployee(firstname, middlename,lastname,employeeId);
        sleep(8000);
    }

    public WebElement  getRequiredTitle(){
        return driver.findElement(requiredTitle);
    }


}
