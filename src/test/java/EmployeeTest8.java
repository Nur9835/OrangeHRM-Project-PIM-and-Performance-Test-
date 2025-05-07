import Base.BaseTest;
import Pages.EditReportPage;
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
public class EmployeeTest8  extends BaseTest {
    String employeeName;
    static PIMPage pimPage;
    static ReportPage reportPage;
    static EditReportPage editReportPage;
    @Test(description = "Test Case 8: Edit Report ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Edit Report")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
            6. Listedeki ilk raporun güncellenmesi için edit icon button tıklanır ve Edit Report sayfasına yönledirildiği doğrulanır
            7. Edit Report sayfasındaki rapor adı güncellenerek Save butonuna tıkanır
            8. Report sayfasında güncellenen raporun adı doğrulanır
         
                  """)
    public void editReport() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest6.openReportsPage();
        openEditReportPage();
        updateReportName();
        verifyUpdateReportName();

    }

    @Step("Listedeki ilk raporun güncellenmesi için edit icon button tıklanır ve Edit Report sayfasına yönledirildiği doğrulanır")
    public void openEditReportPage() throws InterruptedException {
        reportPage= new ReportPage(driver);
        String editReportsPage= reportPage.openEditReportPage().getPageTitle();
        Assert.assertEquals( "Edit Report", editReportsPage);

    }

    @Step("Edit Report sayfasındaki rapor adı güncellenerek Save butonuna tıkanır")
    public void updateReportName() throws InterruptedException {
        editReportPage= new EditReportPage(driver);
        editReportPage.updateReportName(newReportName);

    }

    @Step("Report sayfasında güncellenen raporun adı doğrulanır")
    public void verifyUpdateReportName() throws InterruptedException {
        //güncellenen raporun adı tüm listede aranır
        List<String> filteredReport= reportPage.filteredReportNameList(newReportName);
        Assert.assertTrue(filteredReport.size() >=1, "Rapor ismi güncellenmedi.");


    }



}
