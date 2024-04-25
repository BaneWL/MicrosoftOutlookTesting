import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.time.Duration;


public class ManageEmail {
    String delete = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
    String flag = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
    String readUnread = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
    String pin = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
    String forward = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
    String reply = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
    String archive = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
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

        driver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys(delete);
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Delete this");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys(flag);
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Flag this");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys(readUnread);
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Toggle read/unread on this");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys(pin);
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Pin this");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys(forward);
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Forward this");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys(reply);
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Reply to this");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='New mail']")).click();
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='Add a subject']")).sendKeys(archive);
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Archive this");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    void deleteEmail() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='"+ delete +"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Delete']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    void flagEmail() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='"+ flag +"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Flag / Unflag']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    void toggleReadUnreadEmail() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='"+ readUnread +"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Read / Unread']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 5)
    void pinEmail() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='"+ pin +"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Pin / Unpin']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 6)
    void forwardEmail() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='"+ forward +"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Forward']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("SoftwareTestingMain@outlook.com");
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 7)
    void replyToEmail() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='"+ reply +"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Reply']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Message body, press Alt+F10 to exit']")).sendKeys("Replied!");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@title='Send (Ctrl+Enter)']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 8)
    void archiveEmail() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='" + archive + "']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Archive']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
