package uk.co.testcraft.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class FlightsPage extends AbstractPage {

    private static final By DEPARTURE_DATE = By.xpath("//input[@placeholder='Depart']");
    private static final By PASSENGERS = By.name("totalManualPassenger");
    private static final By DONE_BUTTON = By.cssSelector("#sumManualPassenger");
    private static final By SEARCH_BUTTON = By.cssSelector("#body-section > div.search_head > div > form > div.bgfade.col-md-1.col-xs-12.search-button > button");
    private static final By BOOK_FLIGHT = By.cssSelector("#bookbtn");
    private static final By FLIGHT_FIRST_NAME = By.name("firstname");
    private static final By FLIGHT_SURNAME = By.name("lastname");
    private static final By FLIGHT_EMAIL = By.name("email");
    private static final By FLIGHT_CONFIRMEMAIL = By.name("confirmemail");
    private static final By FLIGHT_PHONE = By.name("phone");
    private static final By FLIGHT_ADDRESS = By.name("address");
    private static final By CONFIRM_FLIGHTS = By.name("guest");
    private static final By ASSERT_FLIGHTS_INVOICE = By.xpath("//div[contains(text(),'Invoice')]");

    @FindBy(css = "#s2id_location_from > a")
    WebElement flightsFrom;

//    @FindBy(name = "departure")
//    WebElement departureDate;

    @FindBy(css = "#s2id_location_to > a")
    WebElement flightsTo;

    @FindBy(css = "#s2id_autogen1 > a")
    WebElement flightsCountry;

    public void flightsFrom() {
        flightsFrom.click();
        flightsFrom.sendKeys("Moscow");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div")));
        flightsFrom.sendKeys(Keys.RETURN);
    }

    public void flightsTo() {
        flightsTo.click();
        flightsTo.sendKeys("Bahrain");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div")));
        flightsTo.sendKeys(Keys.RETURN);
    }

    public void enterDepartDate(String date) {
        driver.findElement(DEPARTURE_DATE).sendKeys(date);
        {
            driver.findElement(DEPARTURE_DATE).click();
        }
    }

    public void clickOnPassengers() {
        driver.findElement(PASSENGERS).click();
    }

    public void pickThreeAdults() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("madult")));
        new Select(driver.findElement(By.name("madult"))).selectByValue("3");
    }

    public void clickOnDone() {
        driver.findElement(DONE_BUTTON).click();
    }

    public void selectCabinClass() {new Select(driver.findElement(By.name("cabinclass"))).selectByVisibleText("Business");}

    public void clickSearchButton() {driver.findElement(SEARCH_BUTTON).submit();}

    public void bookFlight() {driver.findElement(BOOK_FLIGHT).click();}

    public void flightsForename(String forename) {driver.findElement(FLIGHT_FIRST_NAME).sendKeys(forename);}

    public void flightsSurname(String surname) {
        driver.findElement(FLIGHT_SURNAME).sendKeys(surname);
    }

    public void flightsEmail(String email) {
        driver.findElement(FLIGHT_EMAIL).sendKeys(email);
    }

    public void flightsConfirmEmail(String email) {
        driver.findElement(FLIGHT_CONFIRMEMAIL).sendKeys(email);
    }

    public void flightsPhone(String phone) {
        driver.findElement(FLIGHT_PHONE).sendKeys(phone);
    }

    public void flightsAddress(String address) {
        driver.findElement(FLIGHT_ADDRESS).sendKeys(address);
    }

    public void flightsCountry() {
        flightsCountry.click();
        flightsCountry.sendKeys("Azerbaijan");
        flightsCountry.sendKeys(Keys.RETURN);
    }

    public void confirmFlights() {
        driver.findElement(CONFIRM_FLIGHTS).click();
    }

    public void assertInvoiceThere() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ASSERT_FLIGHTS_INVOICE));
        Assert.assertTrue(driver.getTitle().contains("Invoice"));
    }

    public FlightsPage(final WebDriver driver) {
        super(driver);
    }
}
