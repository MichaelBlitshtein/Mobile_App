package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddContactTests extends AppiumConfig {

    @BeforeMethod
    public void preCondition(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("michael+1@gmail.com").password("Michael12345$").build())
                .submitlogin()
                .isContactListActivityDisplayed();
    }

    @Test
    public void addNewContactSuccess(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Julia")
                .lastName("Larson")
                .email("lars"+i+"@mail.ru")
                .phone("8529638741")
                .address("Ramat Gan")
                .description("classmate").build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByNameLastName(contact.getName(),contact.getLastName())
                .isContactAddedByPhone(contact.getPhone())
                .logout();
    }

    @Test
    public void addNewContactEmptyName(){

        Contact contact = Contact.builder()
                .lastName("Larson")
                .email("lars@mail.ru")
                .phone("8529638741")
                .address("Ramat Gan")
                .description("classmate").build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageHasText("{name=must not be blank}")
                .clickOKButton();


    }

    @Test
    public void addNewContactEmptyLastName(){
        Contact contact = Contact.builder()
                .name("Julia")
                .email("lars@mail.ru")
                .phone("8529638741")
                .address("Ramat Gan")
                .description("classmate").build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageHasText("{lastName=must not be blank}")
                .clickOKButton();
    }


}
