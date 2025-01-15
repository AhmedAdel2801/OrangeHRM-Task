package Pages;

import com.shaft.driver.SHAFT;
import com.shaft.properties.internal.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_AddNewUserPage {
    SHAFT.GUI.WebDriver driver;
    public P04_AddNewUserPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }
    //Locators
    By userRoleDropDown=By.xpath("//label[contains(.,'User Role')]/../following-sibling::div");
    By selectUserRole=By.xpath("//div[@class=\"oxd-select-option\"]//span[contains(.,'Admin')]");
    By employeeNameInput=By.xpath("(//label[contains(.,'Employee Name')]//following::input)[1]");
    By employeeNameElement=By.xpath("//span[@class='oxd-userdropdown-tab']//p");
    By selectEmpolyee=By.xpath("(//div[@role='option'])[1]");
    By statusDropDown=By.xpath("//label[contains(.,'Status')]/../following-sibling::div");
    By selectStatus=By.xpath("//div[@class=\"oxd-select-option\"]//span[contains(.,'Enabled')]");
    By userNameInput=By.xpath("(//label[contains(.,'Username')]//following::input)[1]");
    By passwordInput=By.xpath("(//label[contains(.,'Password')]//following::input)[1]");
    By ConfirmPasswordInput=By.xpath("(//label[contains(.,'Confirm Password')]//following::input)[1]");
    By saveButton=By.xpath("//button[@type=\"submit\"]");
 public P04_AddNewUserPage fillForm(String newUserName,String newPassword){
     driver.element().click(userRoleDropDown).
         and().click(selectUserRole)
             .and().type(employeeNameInput,getEmployeeName());

     WebDriverWait wait= new WebDriverWait(driver.getDriver(),Duration.ofSeconds(5));
     wait.until(d ->driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectEmpolyee));
             driver.element().click(selectEmpolyee)
                     .and().click(statusDropDown).click(selectStatus)
                     .and().type(userNameInput,newUserName)
                     .and().type(passwordInput,newPassword)
                     .and().type(ConfirmPasswordInput,newPassword)
                     .and().click(saveButton);
             return new P04_AddNewUserPage(driver);
 }
 public String getEmployeeName(){
     return driver.element().getText(employeeNameElement);
 }


}
