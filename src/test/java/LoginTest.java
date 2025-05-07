import Base.BaseTest;
import Pages.HeaderPage;
import Pages.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.ParseException;
import static java.sql.DriverManager.getDriver;

@Epic("Regression Tests")
@Feature("User")
public class LoginTest extends BaseTest {
    static LoginPage loginPage;
    static HeaderPage headerPage;

    @Test(description = "Test Case 1: Login User with correct username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login User with correct name and password")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            """)
    public void loginUserWithCorrectNameAndPassword() throws IOException, ParseException, InterruptedException {
        LoginSuccesfull();
        Logout();
    }

    @Step("Verify Login")
    public static void LoginSuccesfull() throws InterruptedException {
        loginPage=new LoginPage(driver);
        String headerTitle = loginPage
                .fillCorrectLogin(nameData, passwordData)
                .getHeaderTitle()
                .getText();
        softAssert.assertEquals(headerTitle,"Dashboard");
        sleep(2000);
        softAssert.assertEquals(driver.getTitle(),"OrangeHRM");
    }



    @Step("Verify Logout")
    public static void Logout() throws InterruptedException {
        headerPage=new HeaderPage(driver);
        String loginPageTitle =headerPage.logOutClick().getLoginPageTitle().getText();
        softAssert.assertEquals(loginPageTitle, "Login" );
    }

}
