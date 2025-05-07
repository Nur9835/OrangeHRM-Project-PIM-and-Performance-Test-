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
public class EmployeeTest extends BaseTest {
    static SideBarPage sideBarPage;
    static AddEmployeePage addEmployeePage;
    static PIMPage pimPage;
    static PersonalDetailsPage personalDetailsPage;


    @Test(description = "Test Case 1: Add Employee  with correct parameters")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Employee")
    @Description("""
    1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. Açılan PIM sayfadaki Add Employee butonuna  tıklanır ve Add Employee sayfası açılır
            6. Gerekli bilgiler eksiksiz ve doğru bir şekilde doldurularak kaydet butonu tıklanır ve Çalışan Detay sayfasına yönlendirildiği doğrulanır
            7. PIM sayfasına gelinir
            8. Tüm Employee listesinde yeni eklenen Employee'nin da listede yer aldığı doğrulanır
            """)
    public  void addEmployee() throws IOException, ParseException, InterruptedException
    {
        LoginTest.LoginSuccesfull();
        openPIM();
        openAddEmployeePage();
        fillNewEmployee();
        openPIM();
        verifyEmployeeIsAddedToList();
    }

    @Step("Sidebar menüsünden 'PIM' tıklanır")
    public static void openPIM() throws InterruptedException {
        sideBarPage=new SideBarPage(driver);
        sideBarPage.openPIMMenu();

    }

    @Step("Açılan PIM sayfadaki Add Employee butonuna  tıklanır ve Add Employee sayfası açılır")
    public static void openAddEmployeePage() throws InterruptedException {
        pimPage=new PIMPage(driver);
        String pageTitle= pimPage.newEmployeeLink().getTitle().getText();
        softAssert.assertEquals(pageTitle,"Add Employee");

    }

    @Step("Gerekli bilgiler eksiksiz ve doğru bir şekilde doldurulur")
    public static void fillNewEmployee() throws InterruptedException {
        personalDetailsPage=new PersonalDetailsPage(driver);
        addEmployeePage=new AddEmployeePage(driver);
        WebElement resultWebElement =addEmployeePage.fillCorrectNewEmployee(firstname,middlename,lastname,employeeID).getTitle();
        sleep(5000);
        softAssert.assertTrue(resultWebElement.isDisplayed());
        sleep(1000);
        personalDetailsPage.updateEmployeeID();


    }



    @Step("Tüm Employee listesinde yeni eklenen Employee'nin da listede yer aldığı doğrulanır")
    public static List<String>  verifyEmployeeIsAddedToList() throws InterruptedException {

        pimPage = new PIMPage(driver);
        sleep(8000);
       pimPage.getEmployeeNames();
        List<String> filteredEmploye = pimPage.filteredEmployeeNameList(searchEmployeeName);
        Assert.assertTrue(filteredEmploye.size() > 0, "Eleman bulunamadı.");
        return filteredEmploye;

    }





}
