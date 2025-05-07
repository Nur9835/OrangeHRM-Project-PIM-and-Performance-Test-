import Base.BaseTest;
import Pages.AddKPIPage;
import Pages.AddReportPage;
import Pages.PIMPage;
import Pages.ReportPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class EmployeeTest9  extends BaseTest {
    static ReportPage reportPage;
    static AddReportPage addReportPage;
    static PIMPage pimPage;

    @Test(description = "Test Case 9: Add Report with Multiple Display Field")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Report")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
            6. Raporlar sayfasındaki Add butonu tklanarak Rapor Ekleme sayfasına yönlendirildiği doğrulanur
            7. Rapor ekleme sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
            8. Report sayfasında eklenen raporun adı doğrulanır
         
                  """)
    public  void addReport() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest6.openReportsPage();
        openAddReportPage();
        fillNewReport();
        EmployeeTest6.openReportsPage();
        verifyReportIsAddedToList();
    }

    @Step("Raporlar sayfasındaki Add butonu tklanarak Rapor Ekleme sayfasına yönlendirildiği doğrulanur")
    public static void openAddReportPage() throws InterruptedException {
        reportPage= new ReportPage(driver);
        String addReportsPage= reportPage.openAddReportPage().getTitle();
        Assert.assertEquals( "Add Report", addReportsPage);
    }

    @Step("Rapor ekleme sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır")
    public static void fillNewReport() throws InterruptedException {
        addReportPage= new AddReportPage(driver);
        addReportPage.fillCorrectNewReport(newReportName);

    }

    @Step("Report sayfasında eklenen raporun adı doğrulanır")
    public static List<String>  verifyReportIsAddedToList() throws InterruptedException {
        reportPage.getAllReports();
        List<String> filteredReport = reportPage.filteredReportNameList(newReportName);
        Assert.assertTrue(filteredReport.size() > 0, "Eleman bulunamadı.");
        return filteredReport;

    }
}
