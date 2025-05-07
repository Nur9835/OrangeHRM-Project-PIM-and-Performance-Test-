import Base.BaseTest;
import Pages.*;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Add")
public class EmployeeTest14 extends BaseTest {
    static AddEmployeePage addEmployeePage;
    static PIMPage pimPage;

    @Test(description = "Test Case 14: Add Employee with numeric FirstName")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Employee")
    @Description("""
            1. Tarayıcıyı başlat
                    2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
                    3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
                    4. Sidebar menüsünden 'PIM' tıklanır
                    5. Açılan PIM sayfadaki Add Employee butonuna  tıklanır ve Add Employee sayfası açılır
                    6. Add Employee sayfasındaki Firstname alanı sayısal değer verilerek Save butonuna tıklanır
                    7. Employee kayıt edilmemeli
            """)
    public void addEmployee() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest.openAddEmployeePage();
        fillNewEmployeeWithNumericFirstName();
        EmployeeTest.openPIM();
        verifyEmployeeIsNotAddedToList();
    }


    @Step("Add Employee sayfasındaki Firstname alanı boş bırakılırak Save butonuna tıklanır")
    public static void fillNewEmployeeWithNumericFirstName() throws InterruptedException {
        addEmployeePage = new AddEmployeePage(driver);
        addEmployeePage.fillInCorrectNewEmployee("22", middlename, lastname, employeeID);
        sleep(1000);

    }

    @Step("Ekranda Required uyarısının yer aldığı doğrulanarak kayıt işleminin gerçekleşmediği doğrulanır")
    public static void verifyEmployeeIsNotAddedToList() throws InterruptedException {
        pimPage = new PIMPage(driver);
        sleep(4000);
        pimPage.getEmployeeNames();
        List<String> filteredEmploye = pimPage.filteredEmployeeNameList(searchEmployeeName);
        Assert.assertTrue(filteredEmploye.size() < 0, "Eleman bulunmamalı.");

    }


}
