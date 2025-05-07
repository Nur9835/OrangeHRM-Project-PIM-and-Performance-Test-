import Base.BaseTest;
import Pages.AdminPage;
import Pages.HeaderPage;
import Pages.SideBarPage;
import com.beust.ah.A;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {
    static SideBarPage sideBarPage;
    static HeaderPage headerPage;
    @Test(description = "Test Case 1:Get Admin Name")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Get Admin Name")
    @Description(""" 
            1. Tarayıcıyı başlat
            2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
            3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
            4. Admin adı soyadı alınır
         
     """)

    public void getAdminInformation() throws InterruptedException {
        LoginTest.LoginSuccesfull();
        getAdminInfo();

    }

    @Step("Admin sayfasından Admin ad soyad bilgisi okunur")
    public static String getAdminInfo(){
        headerPage = new HeaderPage(driver);
        return headerPage.getAdminInfo();
    }




}
