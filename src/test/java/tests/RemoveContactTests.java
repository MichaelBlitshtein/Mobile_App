package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class RemoveContactTests extends AppiumConfig  {
    @BeforeClass
    public void preCondition(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("michael+1@gmail.com").password("Michael12345$").build())
                .submitlogin()
                .isContactListActivityDisplayed();
    }

    @Test
    public void removeOneContactSuccess(){
       int result =  new ContactListScreen(driver)
                .removeOneContact(2);
        Assert.assertEquals(result,1);
    }

    @Test
    public void removeOneContactSuccessAssert(){
        int result =  new ContactListScreen(driver)
                .removeOneContact(2);
    }

    @Test
    public void removeOneContactSuccess1(){
        new ContactListScreen(driver)
                .removeOneContactBase(4)
                .isListSizeLessOne();
    }
}
