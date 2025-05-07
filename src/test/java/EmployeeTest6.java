import Base.BaseTest;
import Pages.PIMPage;
import Pages.ReportPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Delete")
public class EmployeeTest6  extends BaseTest {
    String employeeName;
    static PIMPage pimPage;
    static ReportPage reportPage;
    @Test(description = "Test Case 6: Cancel Delete Report ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Cancel Delete Report")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
            6. Listedeki ilk raporun silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki No cancel butona tıklanır ve raporun silmediği doğrulanır
         
                  """)

    public void revertDeleteReport() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        openReportsPage();
        cancelDeleteFirstReport();

    }


    @Step ("PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır")
    public static void openReportsPage() throws InterruptedException {
        pimPage = new PIMPage(driver);
        String reportsPageTitle= pimPage.openReportsPage().getPageTitle();
        Assert.assertEquals( "Employee Reports", reportsPageTitle);


    }


    @Step("Listedeki ilk raporun silinmesi için delete icon button tıklanır")
    public void cancelDeleteFirstReport() throws InterruptedException {
        reportPage= new ReportPage(driver);
        reportPage.rejectDeleteFirstReport();
        sleep(2000);
        String firstReportName= reportPage.getFirstReportName();
        List<String> filteredReport = reportPage.filteredReportNameList(firstReportName);
        Assert.assertTrue(filteredReport.size() >=1, "Rapor silinmemeli.");



    }



}
