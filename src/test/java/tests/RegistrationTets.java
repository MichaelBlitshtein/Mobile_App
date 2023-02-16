package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class RegistrationTets extends AppiumConfig {

    @Test
    public void registrationSuccess(){

        Random random = new Random();
        int i = random.nextInt(1000);

        boolean res = new AuthenticationScreen(driver)
                .fillEmail("farry"+i+"@gmail.com")
                .fillPassword("Farry12345$")
                .submitRegistration()
                .isContactListActivityDisplayed();
        Assert.assertTrue(res);
    }

    @Test
    public void registrationSuccessModel(){

        Random random = new Random();
        int i = random.nextInt(1000);

        Auth auth = Auth.builder().email("farry"+i+"@gmail.com").password("Farry12345$").build();

        boolean res = new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(auth)
                .submitRegistration()
                .isContactListActivityDisplayed();
        Assert.assertTrue(res);
    }

    @AfterMethod
    public void postConditions(){
        new ContactListScreen(driver)
                .logout();
    }
}
