import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmailPage {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\noxiv\\Downloads\\drivers\\Chrome\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        driver.get("https://outlook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign in")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.id("i0116")).sendKeys("SoftwareTestingMain@outlook.com");
        driver.findElement(By.id("idSIButton9")).click();
        driver.findElement(By.id("i0118")).sendKeys("Testing123");
        driver.findElement(By.id("idSIButton9")).click();
        driver.findElement(By.id("declineButton")).click();
        Thread.sleep(2000);
    }


    @Test(priority = 1)
    public void testNavbarButtons() throws InterruptedException {

        // Find and click the second button twice
        WebElement button2 = driver.findElement(By.xpath("//*[@id='owaNoteFeedButton']"));
        button2.click();
        Thread.sleep(1000); // Wait for 1 second
        button2.click();
        Thread.sleep(1000); // Wait for 1 second

        // Find and click the third button twice
        WebElement button3 = driver.findElement(By.xpath("//*[@id=\"Time\"]"));
        button3.click();
        Thread.sleep(1000); // Wait for 1 second
        button3.click();
        Thread.sleep(1000); // Wait for 1 second

        // Find and click the fourth button twice
        WebElement button4 = driver.findElement(By.xpath("//*[@id='owaActivityFeedButton']/i"));
        button4.click();
        Thread.sleep(1000); // Wait for 1 second
        button4.click();
        Thread.sleep(1000); // Wait for 1 second

        // Find and click the fifth button twice
        WebElement button5 = driver.findElement(By.xpath("//*[@id='tips']/i"));
        button5.click();
        Thread.sleep(1000); // Wait for 1 second
        button5.click();
        Thread.sleep(1000); // Wait for 1 second

        // Wait for the webpage to load completely
        Thread.sleep(1000); // Wait for 1 second after all clicks
    }

    @Test(priority = 2)
    public void testFoldersTab() throws InterruptedException {
        // Find and click the button before all others
        WebElement preButtonClick = driver.findElement(By.xpath("//*[@id='TopBar']/div[1]/button/span/i/span/i"));
        preButtonClick.click();
        Thread.sleep(1000); // Wait for 1 second

        // Find and click the first button twice
        WebElement button1 = driver.findElement(By.xpath("//*[@id='folderPaneDroppableContainer']/div/div[1]/div"));
        button1.click();
        Thread.sleep(1000); // Wait for 1 second
        button1.click();
        Thread.sleep(1000); // Wait for 1 second

        // Find and click the folders button
        WebElement foldersButton = driver.findElement(By.xpath("//*[@id='folderPaneDroppableContainer']/div/div[2]/div/button/span/i"));
        foldersButton.click();
        Thread.sleep(1000); // Wait for 1 second

        // Find and click the third button
        WebElement button3 = driver.findElement(By.xpath("//*[@id='folderPaneDroppableContainer']/div/div[3]/div/div/div[1]/div"));
        button3.click();
        Thread.sleep(1000); // Wait for 1 second

        // Find and click the remaining buttons
        for (int i = 2; i <= 9; i++) {
            WebElement button = driver.findElement(By.xpath("//*[@id='folderPaneDroppableContainer']/div/div[3]/div/div/div[" + i + "]/div"));
            button.click();
            Thread.sleep(1000); // Wait for 1 second
        }
    }
//test folders tab

    @Test(priority = 3)
    public void testFolderOperations() throws InterruptedException {
        // Click the specified button

        Thread.sleep(1000); // Wait for 1 second


        WebElement folderNameInput = driver.findElement(By.xpath("//input[@type='text']"));
        folderNameInput.sendKeys("newTestFolder13332");

        Thread.sleep(2000); // Wait for 1 second

        // Find and click the third button
        WebElement button3 = driver.findElement(By.xpath("//*[@id='folderPaneDroppableContainer']/div/div[3]/div/div/div[1]/div"));
        button3.click();
        Thread.sleep(2000); // Wait for 1 second

        // Open the folder
        WebElement folder = driver.findElement(By.xpath("//*[@id='folderPaneDroppableContainer']/div/div[3]/div/div/div[9]/div"));
        folder.click();
        Thread.sleep(2000); // Wait for 1 second

        // Click the specified button
        WebElement mailListFilterMenu = driver.findElement(By.xpath("//*[@id='mailListFilterMenu']/span/i"));
        mailListFilterMenu.click();
        Thread.sleep(2000); // Wait for 1 second

        WebElement unreadElement = driver.findElement(By.xpath("//*[@id=\"Skip to message list-region\"]/div[1]/div[1]/div/div/div/button"));
        unreadElement.click();
        Thread.sleep(2000); // Wait for 1 second
        unreadElement.click();

        mailListFilterMenu.click();
        Thread.sleep(1000); // Wait for 1 second

        // Click the folder again to deselect it
        folder.click();
        Thread.sleep(1000); // Wait for 1 second

        // Use JavaScriptExecutor to perform a right-click on the folder element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('contextmenu', { bubbles: true, cancelable: true, view: window }));", folder);

        Thread.sleep(1000); // Wait for 1 second

        // Create an Actions object
        Actions actions = new Actions(driver);

// Simulate pressing the down arrow key three times
        for (int i = 0; i < 2; i++) {
            actions.sendKeys(Keys.ARROW_DOWN);
        }
// Simulate pressing the Enter key
        actions.sendKeys(Keys.ENTER);

        actions.perform();

        Thread.sleep(2000); // Wait for 1 second

        actions.sendKeys(Keys.ENTER);
        actions.perform();

    }


    @AfterClass
    public void tearDown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver quit.");
        }
    }

}
