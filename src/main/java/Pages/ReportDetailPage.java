package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportDetailPage  extends BaseTest {
    private final WebDriver driver;
    List<String> allReportNames;
    public ReportDetailPage (WebDriver driver){
        this.driver=driver;
    }

    private final By pageTitle= By.xpath("(//h6)[2]");
    private final By countRecordFound=By.xpath("//span[@class='oxd-text oxd-text--span oxd-text--count']");

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }

//rapor detay sayfasında Records Found alanında belirtilen sayı
    public Integer getRecordFoundCountTitle(){
        Integer  recordFoundCount= Integer.parseInt(driver.findElement(countRecordFound).getText().replaceAll("[^0-9]", ""));
        System.out.printf("recordFoundCount");
        return recordFoundCount;
    }

}
