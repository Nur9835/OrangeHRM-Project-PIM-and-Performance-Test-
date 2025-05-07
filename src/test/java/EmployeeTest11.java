import Base.BaseTest;
import Pages.ReportPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class EmployeeTest11 extends BaseTest {
    static ReportPage reportPage;
    static String actualTitle;
    static String expectedTtile;
    @Test(description = "Test Case 11: Verify redirection to the report detail page ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify Report Detail Page")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
            6. Raporlar listesindeki ilk raporun detay icon buttonuna tıklanır
            7. Açılan sayfann ilk raporun detay sayfası olduğu doğrulanır
                    """)

    public void verifyNavigationToReportDetail() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest6.openReportsPage();
        getFirstName();
        clickFirstReportDetail();
        verifyReportDetailPage();

    }

    public static String  clickFirstReportDetail() throws InterruptedException {
        actualTitle=reportPage.clickFirstReportDetailButton().getPageTitle();
        return actualTitle;
    }


    public String  getFirstName() throws InterruptedException {
        reportPage= new ReportPage(driver);
       return expectedTtile=reportPage.getFirstReport();
    }

    public static void verifyReportDetailPage() throws InterruptedException {
        Assert.assertEquals(expectedTtile, actualTitle);
    }

    }
