package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdressDetails {
    public AdressDetails(WebDriver driver) {
        PageFactory.initElements(driver,this);
        countySelect = new Select(driver.findElement(By.id("field-id_country")));
    }
    @FindBy(id = "field-alias")
    WebElement aliasInput;

    @FindBy(id = "field-address1")
    WebElement adressInput;

    @FindBy(id = "field-city")
    WebElement cityInput;
    @FindBy(id = "field-postcode")
    WebElement zipcodeInput;

    @FindBy(id = "field-id_country")
    WebElement countryInput;

    Select countySelect;

    @FindBy(id = "field-phone")
    WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary.form-control-submit.float-xs-right")
    WebElement saveAdressBtn;
    @FindBy(id = "notifications")
    static
    WebElement succesHeader;


    public void AddAdressDetails(String alias, String adress, String city, String zipcode, String country, String phone) {
        aliasInput.sendKeys(alias);
        adressInput.sendKeys(adress);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        countySelect.selectByVisibleText(country);
        countryInput.sendKeys(country);
        phoneInput.sendKeys(phone);
       saveAdressBtn.click();
    }  //alias, address, city, zipcode, country, phone
    public static String getSuccessHeader() {
        return succesHeader.getText();
    }
}
