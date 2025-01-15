package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_LoginPage {
    SHAFT.GUI.WebDriver driver;
    public P01_LoginPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }
    //Locators
    By userNameInput = By.xpath("//input[@name=\"username\"]");
    By passInput = By.xpath("//input[@type=\"password\"]");
    By loginButton = By.xpath("//button[@type=\"submit\"]");

    public P02_HomePage loginSteps(String username, String password )
    {
        driver.element().type(userNameInput,username).
            and().type(passInput,password).
            and().click(loginButton);
        return new P02_HomePage(driver);

    }
}
