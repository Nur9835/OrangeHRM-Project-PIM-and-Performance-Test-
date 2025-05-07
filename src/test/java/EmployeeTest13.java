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
public class EmployeeTest13 extends BaseTest {
    static AddEmployeePage addEmployeePage;

    @Test(description = "Test Case 13: Add Employee with empty Last Name")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Employee")
    @Description("""
    1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. Açılan PIM sayfadaki Add Employee butonuna  tıklanır ve Add Employee sayfası açılır
            6. Add Employee sayfasındaki Last name alanı boş bırakılırak Save butonuna tıklanır
            7. Ekranda Required uyarısının yer aldığı doğrulanarak kayıt işleminin gerçekleşmediği doğrulanır
            """)
    public  void addEmployee() throws IOException, ParseException, InterruptedException
    {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        EmployeeTest.openAddEmployeePage();
        fillNewEmployeeWithEmptyLastName();
        EmployeeTest12.verifyRequiredTitle();
    }


    @Step("Add Employee sayfasındaki Last name alanı boş bırakılırak Save butonuna tıklanır")
    public static void fillNewEmployeeWithEmptyLastName() throws InterruptedException {
        addEmployeePage=new AddEmployeePage(driver);
        addEmployeePage.fillInCorrectNewEmployee(firstname,middlename,"",employeeID);
        sleep(1000);
    }

}
