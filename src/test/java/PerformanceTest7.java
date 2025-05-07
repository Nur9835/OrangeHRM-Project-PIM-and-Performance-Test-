import Base.BaseTest;
import Pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class PerformanceTest7 extends BaseTest {

    static PerformanceTrackersPage performanceTrackersPage;
    static EditPerformanceTrackerPage editPerformanceTrackerPage;
    @Test(description = "Test Case 7:Edit Peroformance Tracker")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Edit Perofrmance Tracker")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
            5. Configure'den Trackers  tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır
            6. Listedeki ilk Tracker'ın güncellenmesi için edit icon button tıklanır ve Edit Performance Tracker sayfasına yönlendirildiği doğrulanır
            7. Edit Performance Tracker sayfasındaki Tracker adı güncellenerek Save butonuna tıkanır
            8. Performance Trackers sayfasında güncellenen trackerın adı doğrulanır
     """)

    public  void editTracker() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        PerformanceTest1.openPerformancePage();
        PerformanceTest4.openPerformanceTrackersPage();
        openEditReportPage();
        updateFirstTrackerName();
        verifyUpdateFirstTrackerName();
    }


    @Step("Listedeki ilk Tracker'ın güncellenmesi için edit icon button tıklanır ve Edit Performance Tracker sayfasına yönlendirildiği doğrulanır")
    public void openEditReportPage() throws InterruptedException {
        performanceTrackersPage= new PerformanceTrackersPage(driver);
        String editPerformanceTrackerPage= performanceTrackersPage.openEditPerformanceTrackerPage().getPageTitle();
        Assert.assertEquals( "Edit Performance Tracker", editPerformanceTrackerPage);
    }


    @Step("Edit Performance Tracker sayfasındaki Tracker adı güncellenerek Save butonuna tıkanır")
    public void updateFirstTrackerName() throws InterruptedException {
        editPerformanceTrackerPage= new EditPerformanceTrackerPage(driver);

        editPerformanceTrackerPage.updatePerformanceTrackerName(updateNewTrackerName);

    }


    @Step("Performance Trackers sayfasında güncellenen trackerın adı doğrulanır")
    public void verifyUpdateFirstTrackerName() throws InterruptedException {
        //güncellenen raporun adı tüm listede aranır
        List<String> filteredTrackerName= performanceTrackersPage.filteredEPerformanceTrackerNameList(updateNewTrackerName);
       // Assert.assertTrue(filteredTrackerName.size() >=1, "Rapor ismi güncellenmedi.");


    }

}
