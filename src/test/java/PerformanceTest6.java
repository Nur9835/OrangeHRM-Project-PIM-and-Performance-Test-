import Base.BaseTest;
import Pages.KPIPage;
import Pages.PerformanceTrackersPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class PerformanceTest6 extends BaseTest {

    static PerformanceTrackersPage performanceTrackersPage;
    @Test(description = "Test Case 6: Cancel Delete Peroformance Tracker")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Cancel Delete Perofrmance Tracker")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
            5. Configure'den Trackers  tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır
            6. Listedeki ilk Tracker'ın silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki No cancel butona tıklanır ve Tracker'ın silmediği doğrulanır
         
     """)

    public  void revertDeleteTracker() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        PerformanceTest1.openPerformancePage();
        PerformanceTest4.openPerformanceTrackersPage();
        cancelDeleteFirstTracker();
    }



    @Step("Listedeki ilk Tracker'ın silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki No cancel butona tıklanır ve Tracker'ın silmediği doğrulanır")
    public void cancelDeleteFirstTracker() throws InterruptedException {
        performanceTrackersPage= new PerformanceTrackersPage(driver);
        performanceTrackersPage.rejectDeleteFirstTracker();
        sleep(2000);
        String firstTrackerName= performanceTrackersPage.getFirstTracker();
        performanceTrackersPage.getPerformanceTrackerNames();
        List<String> filteredTracker = performanceTrackersPage.filteredEPerformanceTrackerNameList(firstTrackerName);
        Assert.assertTrue(filteredTracker.size() >0, "Tracker silinmemeli.");
    }




}
