package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage extends BaseTest {

    private final WebDriver driver;

    public AdminPage (WebDriver driver){
        this.driver=driver;
    }


    private final By pageTitle= By.xpath("(//h6)[1]");

    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }

}
