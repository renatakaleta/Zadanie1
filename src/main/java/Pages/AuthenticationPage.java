package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "field-email")
    WebElement emailInput;

    @FindBy(id = "field-password")
    WebElement passwordInput;

    @FindBy(id = "submit-login")
    WebElement signInBtn;

    public void LogIntoApp(String email, String haslo) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(haslo);
        signInBtn.click();
    }
}
