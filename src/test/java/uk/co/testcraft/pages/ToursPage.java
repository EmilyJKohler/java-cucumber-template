package uk.co.testcraft.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;


public class ToursPage extends AbstractPage {

    private static final By BOOK_NOW = By.xpath("//button[contains(text(),'Book Now')]");
    private static final By GUEST_FIRST_NAME = By.name("firstname");
    private static final By GUEST_SURNAME = By.name("lastname");
    private static final By GUEST_EMAIL = By.name("email");
    private static final By GUEST_CONFIRMEMAIL = By.name("confirmemail");
    private static final By GUEST_PHONE = By.name("phone");
    private static final By GUEST_ADDRESS = By.name("address");
    private static final By CONFIRM_BOOKING = By.name("guest");
    private static final By ASSERT_INVOICE = By.xpath("//div[contains(text(),'Invoice')]");

    @FindBy(css = "#s2id_autogen1 > a")
    WebElement country;

    public void pickTwoAdults() {
        new Select(driver.findElement(By.name("adults"))).selectByValue("2");
    }
    public void pickOneChildren() {
        new Select(driver.findElement(By.name("child"))).selectByValue("1");
    }
    public void pickOneInfant() {
        new Select(driver.findElement(By.name("infant"))).selectByValue("1");
    }

    public void bookNow() {driver.findElement(BOOK_NOW).click();}

    public void enterForename(String forename) {driver.findElement(GUEST_FIRST_NAME).sendKeys(forename);}

    public void enterSurname(String surname) {driver.findElement(GUEST_SURNAME).sendKeys(surname);}

    public void enterEmail(String email) {driver.findElement(GUEST_EMAIL).sendKeys(email);}

    public void confirmEmail(String email) {driver.findElement(GUEST_CONFIRMEMAIL).sendKeys(email);}

    public void enterPhone(String phone) {driver.findElement(GUEST_PHONE).sendKeys(phone);}

    public void enterAddress(String address) {driver.findElement(GUEST_ADDRESS).sendKeys(address);}

        public void set_Country() {
        country.click();
        country.sendKeys("Azerbaijan");
        country.sendKeys(Keys.RETURN);
        }

    public void confirmBooking() {driver.findElement(CONFIRM_BOOKING).click();}

    public void assertInvoicePresent() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ASSERT_INVOICE));
        Assert.assertTrue(driver.getTitle().contains("Invoice"));
    }

    public ToursPage (final WebDriver driver) {
        super(driver);
    }

}
