package Base;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class BaseLibrary extends Data{
    public static WebDriver driver;

    @Step("{time} Süresi kadar beklenir")
    public static void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public static void clearInputWithJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='';", element);
    }

    public static void setInputWithJs( WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='';", element);
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    public void tıkla(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            // JavaScript ile öğeye tıklama
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("Tıklama işlemi sırasında hata: " + e.getMessage());
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
