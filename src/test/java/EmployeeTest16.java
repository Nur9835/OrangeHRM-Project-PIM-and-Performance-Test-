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

public class EmployeeTest16  extends BaseTest {
    static ReportPage reportPage;
    static AddReportPage addReportPage;
    static PIMPage pimPage;

    @Test(description = "Test Case 16: Add Report with single Display Field ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Report")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
            6. Raporlar sayfasındaki Add butonu tklanarak Rapor Ekleme sayfasına yönlendirildiği doğrulanur
            7. Rapor ekleme sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur(single display field) ve Save butonuna tıklanır
            8. Report sayfasında eklenen raporun adı doğrulanır
         
                  """)
    public  void addReport() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest6.openReportsPage();
        EmployeeTest9.openAddReportPage();
        fillNewReportwithSingleDisplayField();
        EmployeeTest6.openReportsPage();
        EmployeeTest9.verifyReportIsAddedToList();
    }



    @Step("Rapor ekleme sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur(single display field) ve Save butonuna tıklanır")
    public static void fillNewReportwithSingleDisplayField() throws InterruptedException {
        addReportPage= new AddReportPage(driver);
        addReportPage.fillCorrectNewReportwithSingleDisplayField(newReportName);

    }

}
