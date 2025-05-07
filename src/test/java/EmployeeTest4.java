import Base.BaseTest;
import Pages.PIMPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

@Epic("Regression Tests")
@Feature("Employee count")
public class EmployeeTest4  extends BaseTest {
    static PIMPage pimPage;
    static Integer actualEmployeeSize;
    static Integer expectedEmployeeSize;
    @Test(description = "Test Case 4: Verify the count of employees")
    @Severity(SeverityLevel.NORMAL)
    @Story("Employee count")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Sidebar menüsünden 'PIM' tıklanır
            5. Tüm employee sayısının doğruluğu test edilir

                  """)

    public void verifyEmployeeCount() throws IOException, ParseException, InterruptedException {
        LoginTest.LoginSuccesfull();
        EmployeeTest.openPIM();
        employeeSize();

    }

    @Step("Tüm employee sayısının doğruluğu test edilir")
    public void employeeSize() throws InterruptedException {
        pimPage = new PIMPage(driver);
        actualEmployeeSize  = pimPage.getEmployeeNames().size();
        System.out.printf("Listedeki çalışan sayısı: "+ actualEmployeeSize);
        sleep(3000);
        expectedEmployeeSize= pimPage.employeeSize();
        sleep(2000);
        Assert.assertEquals( expectedEmployeeSize, actualEmployeeSize);


    }



}
