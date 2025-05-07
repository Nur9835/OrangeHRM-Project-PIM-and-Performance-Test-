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
public class EmployeeTest3  extends BaseTest {
    String employeeName;
    static PIMPage pimPage;
    @Test(description = "Test Case 3: Delete Employee ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete Employee")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. Listedeki ilk employee silme işlemi yapılır
            6. Listeden silme işlemnin gerçekleştiği doğrulanır

                  """)
    public void deleteEmployee() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        deleteFirstEmployee();
        verifyDeletedFirstEmployeed();
    }

    @Step("Listedeki ilk employee silme işlemi yapılır")
    public void deleteFirstEmployee() throws InterruptedException {
        pimPage = new PIMPage(driver);
        //ilk çalışan ismi
        employeeName= pimPage.getFirstEmployeeName();
        //ilk çalışan silme
        String message= pimPage.firstDeleteEmployee();
        Assert.assertTrue(message.contains("Success"), "Çalışan Silindi uyarısı vermeli!");
    }



    @Step("Listeden silme işlemnin gerçekleştiği doğrulanır")
    public void verifyDeletedFirstEmployeed() throws InterruptedException {
        //silinmiş olan çalışan çalışanlar listesinde olmamalı
        pimPage.getEmployeeNames();
        List<String> filteredEmploye = pimPage.filteredEmployeeNameList(employeeName);
       Assert.assertTrue(filteredEmploye.size() ==0, "Çalışan silinmeli.");

    }



}
