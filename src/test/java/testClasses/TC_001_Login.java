package testClasses;


import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjects.LoginPageObjects;
import pageObjects.LoginSuccessPageObject;

public class TC_001_Login extends BaseClass
{
    @Test
    public void login()
    {
        LoginPageObjects lp=new LoginPageObjects(driver);
        lp.enterUserName("student");
        lp.enterPassword("Password123");
        lp.clickSubmit();

        LoginSuccessPageObject lspo=new LoginSuccessPageObject(driver);

        String message=lspo.getLoginSuccessText();
        Boolean btnPresent=lspo.isLogoutBtnDisplayed();

        System.out.println("Logout button displayed??:"+btnPresent);
        System.out.println(message);
        String expMsg="Logged In Successfully";

        if(message.equals(expMsg) && btnPresent==true)
        {
            System.out.println("TEST CASE PASSED");
   
        }
        else
        {
            Assert.fail("TEST CASE FAILED");
        }
    }

}
