import org.assertj.core.api.Assertions
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import org_nebra_driver.DriverManager
import org_nebra_enums.WaitStrategy
import org_nebra_pages.OrangeHRMLoginPage
import org_nebra_tests.TestBase
import java.util.concurrent.TimeUnit

class LoginPageTests: TestBase() {

    //1. Never hardcode
    // keep right thing at right place so we will move chrome path to -->src/main/kotlin/org.nebra.constants
    //val chromedriverpath = System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe")

    // class or interface name example --> BrankoMilovanovic
    // final constant values example --> BRANKOMILOVANOVIC or BRANKO_MILOVANOVIC
    // method name example --> brankoMilovanovic
    // package name example --> brankomilovanovi
    @Ignore
    @Test
    fun test1(){
        DriverManager.getDriver()?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        val title = OrangeHRMLoginPage.enterUserName("Admin", WaitStrategy.CLICKABLE).enterPassword("admin123", WaitStrategy.CLICKABLE)
            .clickLogin(WaitStrategy.CLICKABLE).
            clickUserName().clickLogout().getTitle()

        println(title)
        Assertions.assertThat(title)
            .isEqualTo("OrangeHRM")
    }

    @Test(priority = 3)
    fun login(){

    }
}