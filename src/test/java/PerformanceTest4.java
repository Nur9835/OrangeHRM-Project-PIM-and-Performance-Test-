import Base.BaseTest;
import Pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PerformanceTest4  extends BaseTest {
    String adminName;
    static PerformancePage performancePage;
    static PerformanceTrackersPage performanceTrackersPage;
    static AddPerformanceTrackersPage addPerformanceTrackersPage;
    static EmployeeTrackerPage employeeTrackerPage;
    static TrackerDetailPage trackerDetailPage;
    static AddTrackerLogPage addTrackerLogPage;


    @Test(description = "Test Case 4:Add Peroformance Tracker with Reviewer on Admin and Add Log inTrackers")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Perofrmance Tracker")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
            5. Configure'den Trackers  tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır
            6. Performance Trackers sayfasındaki Add butonuna tıklanr ve Add Performance Tracker sayfasına yönlendirildiği doğrulanır
            7. Add Performance Tracker sayfasındaki ilgili alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
            8. Performance Trackers sayfasında eklenen raporun adı doğrulanır
            9. Employee Trackers tıklanr ve Employee Performance Trackers sayfasına yönlendirildiği doğrulanır
            10.Employee Performance Tracker sayfasındaki ilk kayıtın View butonuna tıklanır ve Tracker detay sayfasına yönlendirildiği doğrulanır
            11.Tracker detay sayfasındaki Add Log butonu tıklanır
            12.Add Tracker Log Dialog penceresindeki gerekli alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
            13.Yeni eklenen Log'un Tracker detay sayfasında göründüğü doğrulanır
         
     """)

    public void addPerformanceTracker() throws InterruptedException {

        LoginTest.LoginSuccesfull();
        sleep(5000);
        adminName=HeaderTest.getAdminInfo();
      //  System.out.printf("Admin : "+ adminName);
        sleep(1000);

        //yeni bir çalışan eklenir ve o Reviewers yapalım
        EmployeeTest.openPIM();
        EmployeeTest.openAddEmployeePage();
        EmployeeTest.fillNewEmployee();
        EmployeeTest.openPIM();

        PerformanceTest1.openPerformancePage();
        openPerformanceTrackersPage();
        openAddPerformanceTrackerPage();
        fillNewPerformanceTracker();
        verifyPerformanceTrackerIsAddedToList();

       openEmployeePerformanceTrackerPage();
        openFirstTrackerDetailPage();
        clickAddLog();
        fillNewTrackerLog();
        verifyLogIsAddedToList();

    }

    @Step("Configure'den Trackers  tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır")
    public static void openPerformanceTrackersPage() throws InterruptedException {
        performancePage=new PerformancePage(driver);
        String pageTitle=performancePage.clickTrackersButton().getTtile();
        Assert.assertEquals(pageTitle,  "Performance Trackers");
    }


    @Step(" Performance Trackers sayfasındaki Add butonuna tıklanr ve Add Performance Tracker sayfasına yönlendirildiği doğrulanır")
    public void openAddPerformanceTrackerPage() throws InterruptedException {
        performanceTrackersPage=new PerformanceTrackersPage(driver);
        String pageTitle=performanceTrackersPage.openAddPerformanceTrackersPage().getTtile();
        Assert.assertEquals(pageTitle,  "Add Performance Tracker");
    }


    @Step("Add Performance Tracker sayfasındaki ilgili alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır")
    public void fillNewPerformanceTracker() throws InterruptedException {
        addPerformanceTrackersPage= new AddPerformanceTrackersPage(driver);
        String newEmployee= firstname+" "+ middlename+" "+lastname;
    //  System.out.printf("yeni eklenen çalışan"+newEmployee);;
      //Admin'in Reviewer olduğu yeni eklenmiş employee için performance tracker oluşturulur
        addPerformanceTrackersPage.fillCorrectNewPerformanceTracker(newTrackerName,newEmployee,adminName);

    }


    @Step("Performance Trackers sayfasında eklenen raporun adı doğrulanır")
    public static List<String> verifyPerformanceTrackerIsAddedToList() throws InterruptedException {
        performanceTrackersPage = new PerformanceTrackersPage(driver);
        sleep(8000);
        performanceTrackersPage.getPerformanceTrackerNames();
        List<String> filteredPerformanceTracker = performanceTrackersPage.filteredEPerformanceTrackerNameList(newTrackerName);
        Assert.assertTrue(filteredPerformanceTracker.size() > 0, "Tracker bulunamadı.");
        return filteredPerformanceTracker;
    }


    @Step("Employee Trackers tıklanr ve Employee Performance Trackers sayfasına yönlendirildiği doğrulanır")
    public void openEmployeePerformanceTrackerPage() throws InterruptedException {
        String pageTitle=performancePage.clickEmployeeTrackerButton().getTtile();
        Assert.assertEquals(pageTitle,  "Employee Performance Trackers");

    }


    @Step("Employee Performance Tracker sayfasındaki ilk kayıtın View butonuna tıklanır ve Tracker detay sayfasına yönlendirildiği doğrulanır")
    public void openFirstTrackerDetailPage() throws InterruptedException {
        employeeTrackerPage = new EmployeeTrackerPage(driver);
       String title= employeeTrackerPage.openTrackerDetailPage(newTrackerName).getTrackerName();
       Assert.assertEquals(title,newTrackerName);

    }

    @Step("Tracker detay sayfasındaki Add Log butonu tıklanır")
    public void clickAddLog() throws InterruptedException {
        trackerDetailPage=new TrackerDetailPage(driver);
        String title= trackerDetailPage.openAddButtonLog().getTitleName();
        Assert.assertEquals(title,"Add Tracker Log");
    }



    @Step("Add Tracker Log Dialog penceresindeki gerekli alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır")
    public void fillNewTrackerLog() throws InterruptedException {
        addTrackerLogPage =new AddTrackerLogPage(driver);
        addTrackerLogPage.fillCorrectNewTrackerLog(newLog,newComment);


    }


    @Step("Yeni eklenen Log'un Tracker detay sayfasında göründüğü doğrulanır")
    public void verifyLogIsAddedToList(){
        boolean status= trackerDetailPage.searchLogByName(newLog);
        Assert.assertTrue(status, "Log bulunamadı: " + newLog);

    }




}
