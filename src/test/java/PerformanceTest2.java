import Base.BaseTest;
import Pages.KPIPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class PerformanceTest2  extends BaseTest {
    static KPIPage kpiPage;
    @Test(description = "Test Case 2: Delete KPI")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete KPI")
    @Description(""" 
          1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
            5. Configure'den KPIs  tıklanır ve Key Performance Indicators for Job Title sayfasına yönlendirildiği doğrulanır
            6. Listedeki ilk KPI'nin silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve KPI'nin silindiği doğrulanır
         
     """)
    public  void deleteKeyPerformanceIndicator() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        PerformanceTest1.openPerformancePage();
        PerformanceTest1.openKPIPage();
        deleteFirstKPI();
    }


    @Step("Listedeki ilk KPI'nin  silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve raporun silindiği doğrulanır")
    public void deleteFirstKPI() throws InterruptedException {
        kpiPage= new KPIPage(driver);
        String firstKPIName= kpiPage.getFirstKPI();
        String message=kpiPage.acceptDeleteFirstKPI();
        Assert.assertTrue(message.contains("Success"), "KPI Silindi uyarısı vermeli!");;
        sleep(4000);
        kpiPage.getKPINames();
        List<String> filteredKPI = kpiPage.filteredKPINameList(firstKPIName);
        Assert.assertTrue(filteredKPI.size() ==0, "KPI silinmeli.");
    }



}
