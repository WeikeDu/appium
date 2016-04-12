import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by wkdu on 16/4/7.
 */
public class WeChatTest {

    AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","AndroidTestDevice");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void Login() throws InterruptedException {
        WebElement MoreButton = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.mm:id/akz")));
        MoreButton.click();

        WebElement SwitchAccountButton = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")));
        SwitchAccountButton.click();

        WebElement LoginModeChangeButton = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.mm:id/akh")));
        LoginModeChangeButton.click();

        WebElement AccountTextField = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.mm:id/a6t")));
        AccountTextField.sendKeys("43822960");

        WebElement PasswordTextField;
        PasswordTextField = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]"));
        PasswordTextField.sendKeys("LrtDwk10010405");

        WebElement LoginButton;
        LoginButton = driver.findElement(By.id("com.tencent.mm:id/akv"));
        LoginButton.click();

        Thread.sleep(10000);
        driver.tap(1,540,1181,1);

        WebElement MyPostsButton = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")));

        TouchAction action = new TouchAction(driver);
        action.tap(MyPostsButton).perform();

        WebElement MyIconButton = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.mm:id/c9")));
        MyIconButton.click();
        
        WebElement messageButton = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.mm:id/ahu")));
        messageButton.click();

        WebElement textArea = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.mm:id/c50")));
        textArea.sendKeys("Hello DevDay!");

        WebElement sendButton = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.mm:id/c55")));
        sendButton.click();

        WebElement textMessage = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.mm:id/be")));
        assertEquals("Hello DevDay!", textMessage.getText());
    }
}


