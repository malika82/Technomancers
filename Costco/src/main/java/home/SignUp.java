package home;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUp extends CommonAPI {


    //WebElements
    @FindBy(id = "header_sign_in")
    WebElement signInRegisterLink;

    @FindBy(xpath = "//a[@class='btn costco-button tertiary']")
    WebElement createAccountBtn;

    @FindBy(css = "#register_email1")
    WebElement registrationEmailTextBox;

    @FindBy(css = "[id='logonPassword']")
    WebElement passwordTextBox;

    @FindBy(css = "[id='logonPasswordVerify']")
    WebElement passwordVerifyTextBox;

    @FindBy(css = "[class='primary']")
    WebElement createAccountbtn;


    public void signup(String email, String password, String rePasword) {
        signInRegisterLink.click();
        createAccountBtn.click();
        registrationEmailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        passwordVerifyTextBox.sendKeys(rePasword);
        createAccountbtn.click();
    }

    //Methods
    public void sinUpWithDifferentPassword() {
        signup("f", "m", "m");
        String actualTittle = "https://www.costco.com/RegisterView?URL=&isPharmacy=false";
        String expectedTittle = driver.getCurrentUrl();
        Assert.assertEquals(actualTittle, expectedTittle);
    }

    public void sinUpWithLettersPassowrd() {
        signup("m","mamamama","mamamama");
        String actualULR = "https://www.costco.com/UserRegistrationAdd";
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualULR, expectedURL);
    }

    public void sinUpWithDigitPassword() {
    signup("","1234556678","1234556678");
        String actualULR = "https://www.costco.com/RegisterView?URL=&isPharmacy=false";
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualULR, expectedURL);
    }

    public void sinUpWithSpecialCharacters() {
        signup("m","12345566<","12345566<");
        String actualULR = "https://www.costco.com/RegisterView?URL=&isPharmacy=false";
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualULR, expectedURL);
    }

    public void sinUp() {
        signup("f", "m", "m");
        String actualTittle = "Register Account";
        String expectedTittle = driver.getTitle();
        Assert.assertEquals(actualTittle, expectedTittle);
    }

}
