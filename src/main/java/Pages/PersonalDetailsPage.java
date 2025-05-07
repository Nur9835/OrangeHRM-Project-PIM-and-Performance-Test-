package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Base.BaseLibrary.*;

public class PersonalDetailsPage extends BaseTest {

    private final WebDriver driver;

    private final By pageTitle=By.xpath("//h6[normalize-space()='Personal Details']");
    private final By empoloyeeID=By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
    private final By save1= By.xpath("(//button[@type=\"submit\"])[1]");

    public PersonalDetailsPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getTitle() throws InterruptedException {
        sleep(8000);
        return driver.findElement(pageTitle);
    }

    public void updateEmployeeID() throws InterruptedException {
        setInputWithJs(driver.findElement(empoloyeeID),"55");
        driver.findElement(save1).click();
        sleep(3000);

    }



}
