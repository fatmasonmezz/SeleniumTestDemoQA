import org.example.page.PracticeForm;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class DemoqaTest extends Browser{
    String url= "https://demoqa.com";

    @Test
    public void fillInForm() {
        driver.get(url);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)","");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement elementButton = driver.findElement(By.xpath("//h5[normalize-space()='Forms']"));
        elementButton.click();
        WebElement formButton = driver.findElement(By.xpath("//span[normalize-space()='Practice Form']"));
        formButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String url=driver.getCurrentUrl();
        PracticeForm practiceForm = new PracticeForm(driver);
        PracticeForm.fillInFirstName("Fatma");
        PracticeForm.fillInLastName("Sonmez");
        practiceForm.fillInEmail("fsonmezz@gmail.com");
        practiceForm.fillInGender("Female");
        practiceForm.fillInMobile("05372774785");
        practiceForm.fillInDateOfBirth("01",7,"1998");
        practiceForm.fillInSubject("Computer Science");
        //practiceForm.selectHobbies();
        practiceForm.uploadFile();
        practiceForm.fillInCurrentAddress("Istanbul,Turkey");
        practiceForm.stateValue();
        practiceForm.cityValue();
        practiceForm.SubmitForm();


    }
}
