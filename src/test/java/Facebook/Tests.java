package Facebook;
import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_AdminPage;
import Pages.P04_AddNewUserPage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    //Test Methods
    @Test
    public void login() throws InterruptedException {
    new P01_LoginPage(driver).
            loginSteps(testData.getTestData("username"), testData.getTestData("password"))
           .clickOnAdminTab()
         .getRecordsBeforeAddingUser()
            .clickOnAddButton()
            .fillForm(testData.getTestData("newUserName"),testData.getTestData("newPassword"));
    new P03_AdminPage(driver).formSubmitted()
    .getRecordsAfterAddingUser();
           Thread.sleep(Duration.ofMillis(3000));

    }
    //Before Method
    @BeforeClass
    public void setUp(){
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL
                ("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        testData =new SHAFT.TestData.JSON("orangeTestData.json");
    }

    //After Method
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
