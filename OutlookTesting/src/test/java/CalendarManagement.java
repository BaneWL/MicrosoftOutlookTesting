import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import org.testng.annotations.*;

import java.time.Duration;

public class CalendarManagement{
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
    public void checkCalendarButtons() throws InterruptedException {
        WebElement calendarButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Calendar')]"));
        calendarButton.click();
        Thread.sleep(1000);

        // Navigate to "Add calendar"
        WebElement addCalendar = driver.findElement(By.xpath("//div[contains(@class, 'ATH58') and text()='Add calendar']"));
        addCalendar.click();
        Thread.sleep(1000);
// Navigate through the dynamic elements
        String[] dynamicElementTexts = {"Recommended", "Edit my calendars", "Create blank calendar", "Subscribe from web", "Upload from file", "Holidays", "Birthdays", "Sports"};

        for (String text : dynamicElementTexts) {
            WebElement dynamicElement = driver.findElement(By.xpath("//div[contains(@class, 'kJFxt') and text()='" + text + "']"));
            dynamicElement.click();
        }

    }

    @Test(priority = 2)
    public void createCalendar() throws InterruptedException {

        WebElement createBlankCalendarButton = driver.findElement(By.xpath("//div[text()='Create blank calendar']/parent::span"));
        createBlankCalendarButton.click();


// Input text into the calendar name field
        WebElement calendarNameInput = driver.findElement(By.cssSelector("input[placeholder='Calendar name']"));
        calendarNameInput.sendKeys("testing calendar for the 369th time");


// Click on the dynamic element to save the changes
        WebElement saveButton = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label label-161') and text()='Save']"));
        saveButton.click();
        Thread.sleep(1000);
        // Click on the cancel icon
        WebElement cancelIcon = driver.findElement(By.xpath("//i[@data-icon-name='Cancel']"));
        cancelIcon.click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void shareCalendar() throws InterruptedException {
        // Click on the dynamic element to share

        Thread.sleep(1000);

        WebElement shareSpan = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Share']"));
        shareSpan.click();
        Thread.sleep(1000);

        // Click on the dynamic element representing the calendar name
        WebElement calendarName = driver.findElement(By.xpath("//span[text()='testing calendar for the 369th time']"));
        calendarName.click();
        Thread.sleep(1000);
        // Input email address into the box
        WebElement emailInput = driver.findElement(By.cssSelector("input[aria-label='People Picker']"));
        emailInput.sendKeys("loganesala@icloud.com");
        Thread.sleep(1000);
        // Click on the dynamic element representing the entered email address
        WebElement enteredEmail = driver.findElement(By.xpath("//div[contains(@class, 'ms-Persona-primaryText') and text()='loganesala@icloud.com']"));
        enteredEmail.click();
        Thread.sleep(1000);
        // Click on the dynamic element to confirm sharing
        WebElement confirmShareButton = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label label-161') and text()='Share']"));
        confirmShareButton.click();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver quit.");
        }
    }
}
