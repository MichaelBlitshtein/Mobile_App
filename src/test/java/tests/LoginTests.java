package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
       boolean res = new AuthenticationScreen(driver)
            //    .checkVersion("Version 1.0.0")   // present only on SplashScreen page
                .fillEmail("michael+1@gmail.com")
                .fillPassword("Michael12345$")
                .submitlogin()
                .isContactListActivityDisplayed();
        Assert.assertTrue(res);
    }

    @Test
    public void loginSuccessModel(){
        Auth auth = Auth.builder().email("michael+1@gmail.com").password("Michael12345$").build();

        boolean res = new AuthenticationScreen(driver)
           //     .checkVersion("Version 1.0.0")       // present only on SplashScreen page
                .fillLoginRegistrationForm(auth)
                .submitlogin()
                .isContactListActivityDisplayed();
        Assert.assertTrue(res);
    }


    @Test(enabled = false)
    public void loginWrongEmail(){

    }

    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver)
                .logout();
    }
}
