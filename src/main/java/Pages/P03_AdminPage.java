package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P03_AdminPage {
    SHAFT.GUI.WebDriver driver;
    static int recordsBeforeAddingUser,recordsAfterAddingUser;
    public P03_AdminPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }
    //Locators

    By numberOfElements=By.xpath("//span[@class=\"oxd-text oxd-text--span\"][contains(.,'Records')]");
    By addButton=By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    By succsessMassage =By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    public int getNumberOfElements()
{
    String elementsCount = driver.element().getText(numberOfElements).replaceAll("[^0-9]", "");
    System.out.println("Number of Records:"+ elementsCount);
    return Integer.parseInt(elementsCount);
}
public P03_AdminPage getRecordsBeforeAddingUser(){
recordsBeforeAddingUser=getNumberOfElements();
    System.out.println("Records before adding user:"+recordsBeforeAddingUser);
    return this;
}
    public void getRecordsAfterAddingUser(){
        recordsAfterAddingUser=getNumberOfElements();
        System.out.println("Records after adding user:"+recordsAfterAddingUser);
    }

public P04_AddNewUserPage clickOnAddButton(){
        driver.element().click(addButton);
    return new P04_AddNewUserPage(driver);
}
    public P03_AdminPage formSubmitted()
{
        driver.element().assertThat(succsessMassage).exists().perform();
        return this;
}
public void incrementCheckAfterAddingUser(){
        SHAFT.Validations.verifyThat().object(recordsAfterAddingUser)
                .isEqualTo(recordsBeforeAddingUser+1).perform();
}
}
