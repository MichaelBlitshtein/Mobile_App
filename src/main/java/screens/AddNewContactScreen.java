package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import models.Contact;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddNewContactScreen extends BaseScreen{
    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement nameEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement lastNameEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement emailEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement phoneEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement addressEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement descriptionEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
    MobileElement createButton;
    @FindBy(id="android:id/message")
    MobileElement errorMessageWrongName;
    @FindBy(id="android:id/button1")
    MobileElement okButton;

    public AddNewContactScreen fillContactForm(Contact contact){
        should(nameEditText,10);
        type1(nameEditText, contact.getName());
        type1(lastNameEditText, contact.getLastName());
        type1(emailEditText, contact.getEmail());
        type1(phoneEditText, contact.getPhone());
        type1(addressEditText, contact.getAddress());
        type1(descriptionEditText, contact.getDescription());
        return this;
    }

    public ContactListScreen submitContactForm(){
        createButton.click();
        return new ContactListScreen(driver);
    }

    public AddNewContactScreen submitContactFormNegative(){
        createButton.click();
        return this;
    }

    public AddNewContactScreen isErrorMessageHasText(String text){
        Assert.assertEquals(errorMessageWrongName.getText(),text);
        return this;
    }

    public AddNewContactScreen clickOKButton(){
        okButton.click();
        return this;
    }

    public ContactListScreen returnToContactList(){
       pause(2000);
        driver.navigate().back();
        return new ContactListScreen(driver);
    }
}
