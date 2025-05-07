import Base.BaseTest;
import Pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class PerformanceTest1 extends BaseTest {
    static SideBarPage sideBarPage;
    static PerformancePage performancePage;
    static KPIPage kpiPage;
    static AddKPIPage addKPIPage;

    @Test(description = "Test Case 1: Add Key Performance Indicator  with correct parameters")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Key Performance Indicator")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
            5. Configure'den KPIs  tıklanır ve Key Performance Indicators for Job Title sayfasına yönlendirildiği doğrulanır
            6. Key Performance Indicators for Job Title sayfasındaki Add butonuna tıklanarak Add Key Performance Indicator sayfasına yönlendirildiği doğrulanır
            7. Add Key Performance Indicator sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
            8. Key Performance Indicators for Job Title sayfasındaki kayıtlardan yeni eklenen kayıt aranarak listede var olduğu kanıtlanır
           
   """)

    public  void addKeyPerformanceIndicator() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        openPerformancePage();
        openKPIPage();
        openAddKPIPage();
        fillNewKPI();
        verifyKpiIsAddedToList();

    }

    @Step(" Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır")
    public static void openPerformancePage() throws InterruptedException {
        sideBarPage=new SideBarPage(driver);
        String pageTitle= sideBarPage.openPerformanceMenu().getHeaderTitle().getText();
        Assert.assertTrue(pageTitle.toLowerCase().contains("performance"));
    }

    @Step("Configure'den KIPS tıklanır ve Key Performance Indicators for Job Title sayfasına yönlendirildiği doğrulanır")
    public static void openKPIPage() throws InterruptedException {
        performancePage=new PerformancePage(driver);
        String pageTitle=performancePage.clickKIPSButton().getTtile();
        Assert.assertEquals(pageTitle,  "Key Performance Indicators for Job Title");
    }

    @Step("Key Performance Indicators for Job Title sayfasındaki Add butonuna tıklanarak Add Key Performance Indicator sayfasına yönlendirildiği doğrulanır")
    public void openAddKPIPage() throws InterruptedException {
        kpiPage=new KPIPage(driver);
        String pageTitle=kpiPage.openAddKPIPage().getTtile();
        Assert.assertEquals(pageTitle,  "Add Key Performance Indicator");

    }

    @Step("Add Key Performance Indicator sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır")
    public void fillNewKPI() throws InterruptedException {
        addKPIPage= new AddKPIPage(driver);
        addKPIPage.fillCorrectNewKPI(newKpiName);

    }


    @Step("Key Performance Indicators for Job Title sayfasındaki kayıtlardan yeni eklenen kayıt aranarak listede var olduğu kanıtlanır")

    public List<String>  verifyKpiIsAddedToList() throws InterruptedException {

        kpiPage = new KPIPage(driver);
        sleep(8000);
        kpiPage.getKPINames();
        List<String> filteredKpi = kpiPage.filteredKPINameList(newKpiName);
        Assert.assertTrue(filteredKpi.size() > 0, "Eleman bulunamadı.");
        return filteredKpi;

    }





    }