package uk.co.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uk.co.testcraft.pages.PHPTravelsPage;
import org.junit.Assert;

public class LoginPage extends AbstractPage {

    private static final By LOGIN_BUTTON = By.xpath("//ul[@class='nav navbar-nav navbar-right']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]");
    private static final By USERNAME = By.name("username");
    private static final By LOGIN_PASS = By.name("password");
    private static final By LOG_IN = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/form[1]/div[1]/div[5]/button[1]");
    private static final By ASSERT_LOGGED_IN = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/h3[1]");
    private static final By ASSERT_INCORRECT_INFO = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]");

    public void loginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void inputUsername(String username) {
        driver.findElement(USERNAME).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(LOGIN_PASS).sendKeys(password);
    }

    public void logIn() {
        driver.findElement(LOG_IN).click();
    }

    public void assertLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ASSERT_LOGGED_IN));
        String loggedAssertion = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/h3[1]")).getText();
        Assert.assertTrue(loggedAssertion.contains("Hi, Hello Hello"));
    }

    public void assertErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ASSERT_INCORRECT_INFO));
        String loggedAssertion = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]")).getText();
        Assert.assertTrue(loggedAssertion.contains("Invalid Email or Password"));
    }

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

}
