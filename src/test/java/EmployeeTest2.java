import Base.BaseTest;
import Pages.PIMPage;
import Pages.SideBarPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Search")
public class EmployeeTest2 extends BaseTest {
    static PIMPage pimPage;

    @Test(description = "Test Case 2: Search Employee with correct EmployeeName")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Employee")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. Açılan PIM sayfadaki Add Employee butonuna  tıklanır ve Add Employee sayfası açılır
            6. Gerekli bilgiler eksiksiz ve doğru bir şekilde doldurularak kaydet butonu tıklanır ve Çalışan Detay sayfasına yönlendirildiği doğrulanır
            7. PIM sayfasına gelinir
            8. Employee Information'da bulunan formdaki kullanıcının girmiş oldu Employee Name'e uygun doğru filtrelenmiş Employee listesinin getirildiği doğrulanır
            
            """)

    public void searchEmployee() throws IOException, ParseException, InterruptedException {

        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest.openAddEmployeePage();
        EmployeeTest.fillNewEmployee();
        EmployeeTest.openPIM();
        verifyEmployeeNameSearchFilter();
    }

    @Step("Employee Information'da bulunan formdaki kullanıcının girmiş oldu Employee Name'e uygun doğru filtrelenmiş Employee listesinin getirildiği doğrulanır")
    public static void verifyEmployeeNameSearchFilter() throws InterruptedException {

          pimPage = new PIMPage(driver);
          pimPage.getEmployeeNames();
          //tüm çalışanlardan kullanıcının girmiş olduğu karaktere göre filtrelenmiş çalışan listesi
          List<String> actualFilteredEmployee = pimPage.filteredEmployeeNameList(searchEmployeeName);
          sleep(3000);
          pimPage.searchEmployeeName(searchEmployeeName);
          sleep(6000);
          //kullanıcının search işlemi sonucunda ekrana gösterilen listedaki çalışan isimleri listesi:
          List<String> expectedFilteredEmployee= pimPage.getEmployeeNames();
          //filtreli olarak gösterilen liste ile olması gereken liste aynı olmalı
          Assert.assertEquals(actualFilteredEmployee, expectedFilteredEmployee, "Doğru filtrelenmedi!");




    }


}