package Steps;

import Pages.AddNewAdress;
import Pages.AdressDetails;
import Pages.AuthenticationPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LogAndAddAdressStep {
    public static WebDriver driver;
    public String url = "https://mystore-testlab.coderslab.pl/index.php";

    @Given("Uzytkownik znajduje sie na stronie glownej aplikacji")
    public void setApp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }
    @When("Uzytkownik wybiera opcje SignIn")
    public void goToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToSignInPage();
    }
    @And("Uzytkownik wpisuje poprawny adres {string} oraz {string} po czym zatwierdza logowanie")
    public void logIntoApp(String email, String haslo) {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.LogIntoApp(email, haslo);
    }
    @And("Po przeniesieniu uzytkownik klika AddNewAdress")
    public void AddNewAdress() {
        AddNewAdress addNewAdress = new AddNewAdress(driver);
        addNewAdress.goToAdress();
    }
    @Then("Uzupełnia dane {string}, {string}, {string}, {string}, {string}, {string} oraz sprawdza poprawnosc zapisu")
    public void AddAdressDetails(String alias, String adress, String city, String zipcode, String country, String phone) {
        AdressDetails adressDetails = new AdressDetails(driver);
        adressDetails.AddAdressDetails(alias, adress, city, zipcode, country, phone);
        Assert.assertEquals(AdressDetails.getSuccessHeader(), "Address successfully added!");
    }
    //@And("Zamyka przegladarke")
   // public void tearDown() {
       // driver.quit();
   // }

}
