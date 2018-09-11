package uk.co.testcraft.stepDefs;

import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.testcraft.pages.*;
import java.util.concurrent.TimeUnit;


public class PHPTravelsSteps implements En {
    private WebDriver driver = new ChromeDriver();

    PHPTravelsPage travelsPage = new PHPTravelsPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    ToursPage toursPage = new ToursPage(driver);
    FlightsPage flightsPage = new FlightsPage(driver);
    HotelsPage hotelsPage = new HotelsPage(driver);

    public PHPTravelsSteps() {

        Given("^I am on the PHPTravels homepage$", () ->

        {
            travelsPage.goTo();
        });

        When("^I click on the 'Sign Up' button located under 'My Account'$", () ->
        {
            travelsPage.newAccountButton();
            travelsPage.signUpButton();
        });

        And("^I fill in the form with valid details$", () ->
        {
            travelsPage.firstName("Emily");
            travelsPage.secondName("Kohler");
            travelsPage.phoneNo("038473648227");
            travelsPage.emailAddress("blahblahh@gmail.com");
            travelsPage.password("Hellooo");
            travelsPage.confirmPassword("Hellooo");
            travelsPage.signUp();

        });

        Then("^I should be able to create an account$", () ->
        {
            travelsPage.assertAccountCreated();
        });


        Given("^I am on the PHPTravels home page$", () ->

        {
            travelsPage.goTo();
        });

        When("^I want to login to my account$", () ->
        {
            travelsPage.newAccountButton();
            loginPage.loginButton();
            loginPage.inputUsername("hello@gmail.com");
            loginPage.inputPassword("Meowmeow");
        });

        Then("^I should be able to login$", () ->
        {
            loginPage.logIn();
            loginPage.assertLoggedIn();
        });


        Given("^I am on PHPTravels$", () ->

        {
            travelsPage.goTo();
        });

        When("^I go to book a tour$", () ->
        {
            travelsPage.bookATour();
            toursPage.pickTwoAdults();
            toursPage.pickOneChildren();
            toursPage.pickOneInfant();
            toursPage.bookNow();
            toursPage.enterForename("Emily");
            toursPage.enterSurname("Kohler");
            toursPage.enterEmail("blahblahhh@gmail.com");
            toursPage.confirmEmail("blahblahhh@gmail.com");
            toursPage.enterPhone("01928374658");
            toursPage.enterAddress("134 hello street");
            toursPage.set_Country();
            toursPage.confirmBooking();
        });

        Then("The invoice should show$", () ->
        {
            toursPage.assertInvoicePresent();

        });

        Given("^I am on the PHPTravels mainpage", () ->

        {
            travelsPage.goTo();
        });

        When("^I go to book a flight", () ->
        {
            travelsPage.goToFlights();
            flightsPage.flightsFrom();
            flightsPage.flightsTo();
            flightsPage.enterDepartDate("2018-09-13");
            flightsPage.clickOnPassengers();
            flightsPage.pickThreeAdults();
            flightsPage.clickOnDone();
            flightsPage.selectCabinClass();
            flightsPage.clickSearchButton();
            flightsPage.bookFlight();
            flightsPage.flightsForename("Emily");
            flightsPage.flightsSurname("Kohler");
            flightsPage.flightsEmail("blahblahhh@gmail.com");
            flightsPage.flightsConfirmEmail("blahblahhh@gmail.com");
            flightsPage.flightsPhone("01928374658");
            flightsPage.flightsAddress("132 hello street");
            flightsPage.flightsCountry();
            flightsPage.confirmFlights();
        });

        Then("^The invoice should be there$", () ->
        {
                flightsPage.assertInvoiceThere();
    });

        Given("^I'm on the homepage", () ->
        {
            travelsPage.goTo();
        });

        When("^I go to book a hotel", () ->
        {
            travelsPage.pickHotel();
            hotelsPage.pickHotel();
            hotelsPage.pickRoom();
        });

        And("^I want to select check-in and check-out dates", () ->
        {
            //driver.switchTo().frame(0);
            //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            hotelsPage.calendar();
            //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            hotelsPage.pickCheckInDate();
            hotelsPage.checkoutCalendar();
            hotelsPage.pickCheckOutDate();
            hotelsPage.modifyButton();
           // hotelsPage.printAndClickDate();
        });

        Given("^I am on the login page", () ->
        {
            travelsPage.goTo();
        });

        When("^I enter incorrect user information$", () ->
        {
            travelsPage.newAccountButton();
            loginPage.loginButton();
            loginPage.inputUsername("meowmeow@gmail.com");
            loginPage.inputPassword("meowoem");
            loginPage.logIn();
        });

        Then("^I should receive an error message", () ->
        {
            loginPage.assertErrorMessage();
        });
    }

}