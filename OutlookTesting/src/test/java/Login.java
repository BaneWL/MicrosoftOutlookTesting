import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
public class Login {
    WebDriver driver;
    @Test(priority = 1)
    void initialize() throws InterruptedException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\noxiv\\Downloads\\drivers\\Chrome\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    void openOutlook() throws InterruptedException {
        driver.get("https://outlook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    void falseUsernameCredentials() throws InterruptedException {
        driver.findElement(By.id("i0116")).sendKeys("testfalseusername@outlook.com");
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("i0116")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("i0116")).sendKeys(Keys.DELETE);
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    void typeUsername() throws InterruptedException {
        driver.findElement(By.id("i0116")).sendKeys("TestUsername123");
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 5)
    void typePassword() throws InterruptedException {
        driver.findElement(By.id("i0118")).sendKeys("TestPassword123");
        Thread.sleep(2000);
        driver.findElement(By.id("i0118")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("i0118")).sendKeys(Keys.DELETE);
        Thread.sleep(2000);
    }
    @Test(priority = 6)
    void falsePasswordCredentials() throws InterruptedException {
        driver.findElement(By.id("i0118")).sendKeys("testfalsepassword");
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("i1051")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 7)
    void correctUsernameCredentials() throws InterruptedException {
        driver.findElement(By.id("i0116")).sendKeys("SoftwareTestingMain@outlook.com");
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 8)
    void correctPasswordCredentials() throws InterruptedException {
        driver.findElement(By.id("i0118")).sendKeys("Testing123");
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("declineButton")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 9)
    void logout() throws InterruptedException {
        driver.findElement(By.id("O365_MainLink_MePhoto")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mectrl_body_signOut")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
// SoftwareTestingMain
// Testing123

// SoftwareTestingSecondary
// Testing123