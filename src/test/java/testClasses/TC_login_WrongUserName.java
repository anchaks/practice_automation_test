package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPageObjects;
import pageObjects.LoginSuccessPageObject;

public class TC_login_WrongUserName extends BaseClass
{
    @Test
    public void login()
    {
        LoginPageObjects lp = new LoginPageObjects(driver);

        lp.enterUserName("incorrectUser");
        lp.enterPassword("Password123");
        lp.clickSubmit();

        String errorMsg = lp.getUserErrorMsg(); // Assume this gets the error shown on failed login
        Boolean btnPresent = false;
        
         try 
         {
                LoginSuccessPageObject lspo = new LoginSuccessPageObject(driver);
                btnPresent = lspo.isLogoutBtnDisplayed();
                } catch (Exception e) {
                // Ignore, since we expect failure
            }

            System.out.println("Logout button displayed??:" + btnPresent);
            System.out.println("Error message: " + errorMsg);

            /* 

            if (!btnPresent && errorMsg.contains("Invalid username") ) 
            {
                    System.out.println("TEST CASE PASSED - Login failed as expected.");
            } 
            else 
            {
             Assert.fail("Login succeeded or unexpected behavior: " + errorMsg);
            }
             */

            if(!btnPresent && errorMsg.equals("Your username is invalid!"))
             {
                System.out.println("TEST CASE PASSED - Login failed as expected.");
             }
             else
             {
                Assert.fail("Login succeeded or unexpected behavior: " + errorMsg);
             }
    }

}
