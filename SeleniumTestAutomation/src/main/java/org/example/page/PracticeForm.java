package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class PracticeForm{
    protected static WebDriver driver;
    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }



    public static void fillInFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys(firstName);
    }
    public static void fillInLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys(lastName);
    }
    public void fillInEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys(email);
    }
    public void fillInGender(String gender) {
        WebElement genderMaleInput = driver.findElement(By.xpath("//label[text()='" + gender + "']"));
        genderMaleInput.click();
    }
    public void fillInMobile(String mobile) {
        WebElement mobileInput = driver.findElement(By.id("userNumber"));
        mobileInput.sendKeys(mobile);
    }
    public void fillInDateOfBirth(String day ,int month,String year){
        driver.findElement(By.id("dateOfBirthInput")).click();
        Select MonthSelect = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        MonthSelect.selectByIndex(month-1);
        Select YearSelect = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        YearSelect.selectByValue(year);
        driver.findElement(By.className("react-datepicker__day--0"+day)).click();
    }
    public void fillInSubject(String subject){
        WebElement subjectInput = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        subjectInput.sendKeys(subject);
    }
    public void selectHobbies() {
        List<WebElement> hobbies = (List<WebElement>) Collections.singletonList(driver.findElement(By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline']")));
        for (WebElement el : hobbies) {
            boolean isSelected = el.isSelected();
            if (!isSelected) {
                el.click();
            }
        }
    }
    public void uploadFile() {
        String dir = System.getProperty("user.dir");
        String filePath;
        filePath = dir + "/imagefile" + "/NTTdata.png" ;
        driver.findElement(By.id("uploadPicture")).sendKeys(filePath);
    }
    public void fillInCurrentAddress(String currentAddress) {
        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys(currentAddress);
    }
    public void stateValue(){
        WebElement state = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        state.sendKeys("Haryana");
        state.sendKeys(Keys.TAB);
    }
    public void cityValue(){
        WebElement city = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        city.sendKeys("Karnal");
        city.sendKeys(Keys.TAB);
    }
    public void SubmitForm() {
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
    }
}
