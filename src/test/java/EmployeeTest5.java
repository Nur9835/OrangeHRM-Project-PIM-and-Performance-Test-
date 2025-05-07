import Base.BaseTest;
import Pages.PIMPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Delete")
public class EmployeeTest5  extends BaseTest {
    String employeeName;
    static PIMPage pimPage;
    @Test(description = "Test Case 5: Cancel Delete Employee ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Cancel Delete Employee")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. Listedeki ilk employee'nın  delete butonuna tıklanır ve çıkan Toast Popup'taki No cancel butona tıklanır ve çalışanın silmediği doğrulanır

                  """)
    public void revertDeleteEmployee() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        cancelDeleteEmployee();
    }




    @Step("Listedeki ilk employee'nın  delete butonuna tıklanır ve çıkan Toast Popup'taki No cancel butona tıklanır ve çalışanın silmediği doğrulanır")
    public void cancelDeleteEmployee() throws InterruptedException {
        pimPage = new PIMPage(driver);
        //ilk çalışan ismi
        employeeName= pimPage.getFirstEmployeeName();
        pimPage.cancelDeleteFirstEmployee();
        pimPage.getEmployeeNames();
        List<String> filteredEmploye = pimPage.filteredEmployeeNameList(employeeName);

        Assert.assertTrue(filteredEmploye.size() >=1, "Çalışan silinmemeli.");

    }



}
