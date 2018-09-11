package uk.co.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class HotelsPage extends AbstractPage {

    private static final By SECOND_HOTEL = By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[2]/td/div[3]/a/button");
    private static final By PICK_ROOM = By.xpath("//tbody//tr[2]//td[1]//div[2]//div[2]//div[1]//div[3]//div[1]//button[1]");
    private static final By CALENDAR = By.name("checkin");
    private static final By PICK_CHECKIN_DATE = By.xpath("//div[8]//div[1]//table[1]//tbody[1]//tr[4]//td[5]");
    private static final By CHECKOUT = By.name("checkout");
    private static final By PICK_CHECKOUT_DATE = By.xpath("//div[9]//div[1]//table[1]//tbody[1]//tr[5]//td[7]");
    private static final By MODIFY_BUTTON = By.xpath("//input[@value='Modify']");

    public void pickHotel() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SECOND_HOTEL));
        driver.findElement(SECOND_HOTEL).click();
    }

    public void pickRoom() {
        driver.findElement(PICK_ROOM).click();
    }

    public void calendar() {driver.findElement(CALENDAR).click();}

    public void pickCheckInDate() {driver.findElement(PICK_CHECKIN_DATE).click();}

    public void checkoutCalendar() {driver.findElement(CHECKOUT).click();}

    public void pickCheckOutDate() {driver.findElement(PICK_CHECKOUT_DATE).click();}

    public void modifyButton() {driver.findElement(MODIFY_BUTTON).click();}



//    WebElement dateWidget = driver.findElement(By.xpath("/html[1]/body[1]/div[8]"));
//    List rows=dateWidget.findElements(By.tagName("tr"));
//    List columns=dateWidget.findElements(By.tagName("td"));
//    for (WebElement cell: columns){
//    if (cell.getText().equals("20")){
//    cell.findElement(By.xpath("20")).click();
//    break;



//    public void printAndClickDate() {
//        List<WebElement> calendars =
//                driver.findElements(By.xpath("/html/body/div[8]/div[1]/table/tbody/*"));
//        for (WebElement thisCal : calendars) {
//            System.out.println("A list of dates: " + thisCal.getText());
//            if (thisCal.getText().contains("26")) {
//                thisCal.findElement(By.xpath("//td[contains(text(),'26')]")).click();
//                break;
//            }
//        }
//    }

    public HotelsPage(final WebDriver driver) {
        super(driver);
    }
}