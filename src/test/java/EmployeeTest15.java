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
public class EmployeeTest15  extends BaseTest {
    static AddEmployeePage addEmployeePage;
    static PIMPage pimPage;
    @Test(description = "Test Case 15: Add Employee with numeric LastName")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Employee")
    @Description("""
    1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. Açılan PIM sayfadaki Add Employee butonuna  tıklanır ve Add Employee sayfası açılır
            6. Add Employee sayfasındaki Lastname alanı sayısal değer verilerek Save butonuna tıklanır
            7. Employee kayıt edilmemeli
            """)
    public  void addEmployee() throws IOException, ParseException, InterruptedException
    {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest.openAddEmployeePage();
        fillNewEmployeeWithNumericLastName();
        EmployeeTest.openPIM();
        EmployeeTest14.verifyEmployeeIsNotAddedToList();
    }


    @Step("Add Employee sayfasındaki Firstname alanı boş bırakılırak Save butonuna tıklanır")
    public static void fillNewEmployeeWithNumericLastName() throws InterruptedException {
        addEmployeePage=new AddEmployeePage(driver);
        addEmployeePage.fillInCorrectNewEmployee(firstname,middlename,"22",employeeID);
        sleep(1000);
    }
}
