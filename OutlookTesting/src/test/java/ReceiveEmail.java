import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReceiveEmail {
    WebDriver driver;
    WebDriver testDriver;
    String subject = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
    String content = RandomStringUtils.randomAlphanumeric(17).toUpperCase();

    @Test(priority = 1)
    void initialize () throws InterruptedException {
        driver = new ChromeDriver();
        testDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\noxiv\\Downloads\\drivers\\Chrome\\chromedriver.exe");
        testDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        testDriver.get("https://outlook.com/");
        testDriver.manage().window().maximize();
        testDriver.findElement(By.linkText("Sign in")).click();
        for (String winHandle : testDriver.getWindowHandles()) {
            testDriver.switchTo().window(winHandle);
        }
        testDriver.findElement(By.id("i0116")).sendKeys("SoftwareTestingSecondary@outlook.com");
        testDriver.findElement(By.id("idSIButton9")).click();
        testDriver.findElement(By.id("i0118")).sendKeys("Testing123");
        testDriver.findElement(By.id("idSIButton9")).click();
        testDriver.findElement(By.id("declineButton")).click();
        Thread.sleep(2000);
        testDriver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        testDriver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(testDriver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(2000);
        testDriver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys(subject);
        testDriver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys(content);
        Thread.sleep(4000);
        testDriver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(2000);
        testDriver.quit();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\noxiv\\Downloads\\drivers\\Chrome\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
    void checkInbox() throws InterruptedException {
        driver.findElement(By.xpath("//*[@data-icon-name='MailInboxRegular']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[.='Test Subject!']")).click();
        //driver.findElement(By.xpath("//*[@aria-label='[Draft]']")).click();
    }
    @Test(priority = 3)
    void openEmail() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='"+ subject +"']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void assertEmailContent() throws InterruptedException {
        String outputContent = driver.findElement(By.xpath("//*[@aria-label='Message body']")).getText();
        Assert.assertEquals(outputContent, content);
        Thread.sleep(2000);
        driver.quit();
    }
}

// SoftwareTestingMain
// Testing123

// SoftwareTestingSecondary
// Testing123