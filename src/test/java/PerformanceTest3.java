import Base.BaseTest;
import Pages.KPIPage;
import Pages.PIMPage;
import Pages.ReportPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class PerformanceTest3  extends BaseTest {
    static KPIPage kpiPage;
    @Test(description = "Test Case 3:Cancel Delete KPI")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Cancel Delete KPI")
    @Description(""" 
          1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
            5. Configure'den KPIs  tıklanır ve Key Performance Indicators for Job Title sayfasına yönlendirildiği doğrulanır
            6. Listedeki ilk KPI'nin silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki  No cancel butona tıklanır ve KPI'nin silmediği doğrulanır
         
     """)

    public  void revertDeleteKPI() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        PerformanceTest1.openPerformancePage();
        PerformanceTest1.openKPIPage();
        cancelDeleteKPI();
    }


    @Step("Listedeki ilk KPI'nin silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki  No cancel butona tıklanır ve KPI'nin silmediği doğrulanır")
     public void cancelDeleteKPI() throws InterruptedException {
        kpiPage= new KPIPage(driver);
        kpiPage.rejectDeleteFirstKPI();
        sleep(2000);
        String firstKPIName= kpiPage.getFirstKPI();
        kpiPage.getKPINames();
        List<String> filteredKPI = kpiPage.filteredKPINameList(firstKPIName);
        Assert.assertTrue(filteredKPI.size() >0, "KPI silinmemeli.");
    }


}
