import Base.BaseTest;
import Pages.PIMPage;
import Pages.ReportPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class EmployeeTest10 extends BaseTest {

    static ReportPage reportPage;
    @Test(description = "Test Case 10: Search Report with correct Report Name ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Report")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
            6. Raporlar sayfasındaki Add butonu tklanarak Rapor Ekleme sayfasına yönlendirildiği doğrulanur
            7. Rapor ekleme sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
            8. Employee Reports'da bulunan formdaki kullanıcının girmiş oldu Report Name'e uygun doğru filtrelenmiş Report listesinin getirildiği doğrulanır
         
                  """)
    public void searchReport() throws IOException, ParseException, InterruptedException {

        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest6.openReportsPage();
        EmployeeTest9.openAddReportPage();
        EmployeeTest9.fillNewReport();
        EmployeeTest6.openReportsPage();
        verifyReportNameSearchFilter();
    }


    @Step("Employee Reports'da bulunan formdaki kullanıcının girmiş oldu Report Name'e uygun doğru filtrelenmiş Report listesinin getirildiği doğrulanır")
    public static void verifyReportNameSearchFilter() throws InterruptedException {

        reportPage = new ReportPage(driver);
        reportPage.getAllReports();
        //tüm raporlardan kullanıcının girmiş olduğu karaktere göre filtrelenmiş rapor listesi
        List<String> actualFilteredReport = reportPage.filteredReportNameList(newReportName);
        sleep(3000);
        reportPage.searchReportName(newReportName);
        sleep(6000);
        //kullanıcının search işlemi sonucunda ekrana gösterilen listedaki rapor isimleri listesi:
        List<String> expectedFilteredReport= reportPage.getAllReports();
        //filtreli olarak gösterilen liste ile olması gereken liste aynı olmalı
        Assert.assertEquals(actualFilteredReport, expectedFilteredReport, "Doğru filtrelenmedi!");




    }



}
