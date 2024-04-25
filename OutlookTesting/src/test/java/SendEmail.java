import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class SendEmail {
    WebDriver driver;
    @Test(priority = 1)
    void initialize() throws InterruptedException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\noxiv\\Downloads\\drivers\\Chrome\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        driver.get("https://outlook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign in")).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.id("i0116")).sendKeys("SoftwareTestingMain@outlook.com");
        driver.findElement(By.id("idSIButton9")).click();
        driver.findElement(By.id("i0118")).sendKeys("Testing123");
        driver.findElement(By.id("idSIButton9")).click();
        driver.findElement(By.id("declineButton")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    void composeEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    void typeRecipient() throws InterruptedException {
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        Thread.sleep(2000);
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    void typeSubject() throws InterruptedException {
        driver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys("Test Subject!");
        Thread.sleep(2000);
    }
    @Test(priority = 5)
    void typeContent() throws InterruptedException {
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Test Email Content!");
        Thread.sleep(2000);
    }
    @Test(priority = 6)
    void checkDrafts() throws InterruptedException {
        driver.findElement(By.xpath("//*[@data-icon-name='DraftsRegular']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[.='Test Subject!']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@aria-label='[Draft]']")).click();
    }
    @Test(priority = 7)
    void sendEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@aria-label='Send']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 8)
    void verifySent() throws InterruptedException {
        driver.findElement(By.xpath("//*[@data-icon-name='SendRegular']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Test Subject!']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
