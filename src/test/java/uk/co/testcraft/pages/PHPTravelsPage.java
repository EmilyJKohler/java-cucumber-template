package uk.co.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uk.co.testcraft.pages.PHPTravelsPage;
import org.junit.Assert;


public class PHPTravelsPage extends AbstractPage {

    private static final String URL = "https://www.phptravels.net/";

    private static final By ACCOUNT_BUTTON = By.xpath("//ul[@class='nav navbar-nav navbar-right']//li[@id='li_myaccount']//a[@class='dropdown-toggle go-text-right']");
    private static final By SIGN_UP = By.xpath("//ul[@class='nav navbar-nav navbar-right']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Sign Up')]");
    private static final By FIRST_NAME = By.name("firstname");
    private static final By SECOND_NAME = By.name("lastname");
    private static final By MOB_NO = By.name("phone");
    private static final By EMAIL = By.name("email");
    private static final By PASSWORD = By.name("password");
    private static final By CONFIRM_PASSWORD = By.name("confirmpassword");
    private static final By SIGN_UP_BUTTON = By.xpath("/html[1]/body[1]/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/button[1]");
    private static final By ASSERT_ACCOUNT_CREATED = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/h3[1]");
    private static final By FOURTH_TOUR = By.xpath("/html[1]/body[1]/div[4]/div[6]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]");
    private static final By FLIGHTS = By.xpath("//a[@title='Flights']");
    private static final By HOTELS = By.xpath("//a[@title='Hotels']");


    public void newAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
    }

    public void signUpButton() {
        driver.findElement(SIGN_UP).click();
    }

    public void firstName(String firstname) {
        driver.findElement(FIRST_NAME).sendKeys(firstname);
    }

    public void secondName(String surname) {
        driver.findElement(SECOND_NAME).sendKeys(surname);
    }

    public void phoneNo(String phonenumber) {
        driver.findElement(MOB_NO).sendKeys(phonenumber);
    }

    public void emailAddress(String email) {
        driver.findElement(EMAIL).sendKeys(email);
    }

    public void password(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void confirmPassword(String secondpassword) {
        driver.findElement(CONFIRM_PASSWORD).sendKeys(secondpassword);
    }

    public void signUp() {
        driver.findElement(SIGN_UP_BUTTON).click();
    }

    public void assertAccountCreated() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ASSERT_ACCOUNT_CREATED));
        String assertion = driver.findElement(By.xpath("//h3[@class='RTL']")).getText();
        Assert.assertTrue(assertion.contains("Hi, Emily Kohler"));
    }

    public void bookATour() {
        driver.findElement(FOURTH_TOUR).click();
    }

    public void goToFlights() {
        driver.findElement(FLIGHTS).click();
    }

    public void pickHotel() {driver.findElement(HOTELS).click(); }


    public PHPTravelsPage(final WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        this.driver.get(URL);
        driver.manage().window().maximize();
    }


}
