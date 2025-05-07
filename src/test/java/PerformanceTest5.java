import Base.BaseTest;
import Pages.KPIPage;
import Pages.PerformanceTrackersPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class PerformanceTest5 extends BaseTest {

    static PerformanceTrackersPage performanceTrackersPage;
    @Test(description = "Test Case 5:Delete Peroformance Tracker")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete Perofrmance Tracker")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
            5. Configure'den Trackers  tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır
            6. Listedeki ilk Tracker'ın silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve Tracker'ın silindiği doğrulanır
         
     """)

    public  void deleteTracker() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        PerformanceTest1.openPerformancePage();
        PerformanceTest4.openPerformanceTrackersPage();
        deleteFirstTracker();
    }



    @Step("Listedeki ilk Tracker'ın silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve Tracker'ın silindiği doğrulanır")
    public void deleteFirstTracker() throws InterruptedException {
        performanceTrackersPage= new PerformanceTrackersPage(driver);
        String firstTracker= performanceTrackersPage.getFirstTracker();
        String message=performanceTrackersPage.acceptDeleteFirstTracker();
        Assert.assertTrue(message.contains("Success"), "Tracker Silindi uyarısı vermeli!");;
        sleep(4000);
        performanceTrackersPage.getPerformanceTrackerNames();
        List<String> filteredTracker = performanceTrackersPage.filteredEPerformanceTrackerNameList(firstTracker);
        Assert.assertTrue(filteredTracker.size() ==0, "Tracker silinmeli.");
    }




}
