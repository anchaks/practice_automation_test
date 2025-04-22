package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPageObjects;
import pageObjects.LoginSuccessPageObject;

public class TC_login_WrongPassword extends BaseClass
{
    @Test
    public void login()
    {
        LoginPageObjects lp = new LoginPageObjects(driver);

        lp.enterUserName("student");
        lp.enterPassword("inCorrectPassword");
        lp.clickSubmit();

        String errorMsg = lp.getUserErrorMsg(); // Assume this gets the error shown on failed login
        Boolean btnPresent = false;

         try {
                LoginSuccessPageObject lspo = new LoginSuccessPageObject(driver);
                btnPresent = lspo.isLogoutBtnDisplayed();
                } catch (Exception e) {
                // Ignore, since we expect failure
            }

            System.out.println("Logout button displayed??:" + btnPresent);
            System.out.println("Error message: " + errorMsg);

            if (!btnPresent && errorMsg.contains("Invalid password") ) 
            {
                    System.out.println("TEST CASE PASSED - Login failed as expected.");
            } 
            else 
            {
             Assert.fail("Login succeeded or unexpected behavior: " + errorMsg);
            }
    }

}
