import Base.BaseTest;
import Pages.HeaderPage;
import Pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;

@Epic("Regression Tests")
@Feature("User")
public class LoginTest2 extends BaseTest {

    LoginPage loginPage;

    @Test(description = "Test Case 2: Login User with incorrect email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login User with incorrect email and password")
    @Description("""
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına yanlış datalar girilir
            4. Login butonuna tıklanır
            5. 'Invalid credentials' uyarısının göründüğü doğrulanır """)

    public  void loginUserWithInCorrectNameAndPassword() throws IOException, ParseException, InterruptedException {LoginError();}

    @Step("Error Login")
    public void LoginError() throws InterruptedException {
        loginPage=new LoginPage(driver);
        String errorText = loginPage
                .fillIncorrectLogin(nameData2, passwordData2)
                .getErrorText()
                .getText();
        softAssert.assertEquals(errorText, "Invalid credentials");
        sleep(2000);

    }

}
