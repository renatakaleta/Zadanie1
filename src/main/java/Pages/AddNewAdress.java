package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAdress {
    public AddNewAdress(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "address-link")
    WebElement addNewAdressBtn;

    public void goToAdress() {
        addNewAdressBtn.click();
    }
}
