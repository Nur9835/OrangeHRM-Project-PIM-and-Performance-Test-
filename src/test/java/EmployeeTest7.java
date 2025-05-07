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
public class EmployeeTest7  extends BaseTest {
    String employeeName;
    static PIMPage pimPage;
    static ReportPage reportPage;
    @Test(description = "Test Case 7: Delete Report ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete Report")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
            6. Listedeki ilk raporun silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve raporun silidndiği doğrulanır
         
                  """)
    public void deleteReport() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest6.openReportsPage();
        deleteFirstReport();

    }



    @Step("Listedeki ilk raporun silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve raporun silidndiği doğrulanır")
    public void deleteFirstReport() throws InterruptedException {
        reportPage= new ReportPage(driver);
        String message=reportPage.acceptDeleteFirstReport();
        Assert.assertTrue(message.contains("Success"), "Rapor Silindi uyarısı vermeli!");;



    }



}
