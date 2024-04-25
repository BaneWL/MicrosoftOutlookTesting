import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class EventManagement{
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
    public void testEventCreation() throws InterruptedException {
        // Click on the calendar button
        WebElement calendarButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Calendar')]"));
        calendarButton.click();
        Thread.sleep(1000);

        // Click on the event creation button
        WebElement eventCreationButton = driver.findElement(By.xpath("//*[@id=\"2102-group\"]/div/div[1]/div/div/span/button[2]/span/i/span/i"));
        eventCreationButton.click();
        Thread.sleep(1000);

        // Click on the "Event" option
        WebElement eventOption = driver.findElement(By.xpath("//span[contains(text(), 'Event')]"));
        eventOption.click();
        Thread.sleep(1000);

        // Input event title
        WebElement eventTitleInput = driver.findElement(By.xpath("//input[@placeholder='Add a title']"));
        eventTitleInput.sendKeys("testTitle");
        Thread.sleep(500);

        // Input start date
        WebElement startDateInput = driver.findElement(By.xpath("//input[contains(@aria-label, 'Start date')]"));
        startDateInput.clear();
        startDateInput.sendKeys("4/25/2024");
        Thread.sleep(500);

        // Input end date
        WebElement endDateInput = driver.findElement(By.xpath("//input[contains(@aria-label, 'End date')]"));
        endDateInput.clear();
        endDateInput.sendKeys("04/26/2024");
        Thread.sleep(500);

        // Input start time
        WebElement startTimeInput = driver.findElement(By.xpath("//input[contains(@aria-label, 'Start time')]"));
        startTimeInput.click();
        startTimeInput.sendKeys("5:00");
        Thread.sleep(500);

        // Input end time
        WebElement endTimeInput = driver.findElement(By.xpath("//input[contains(@aria-label, 'End time')]"));
        endTimeInput.click();
        endTimeInput.sendKeys("6:30");
        Thread.sleep(500);

        // Input event description
        WebElement eventDescriptionDiv = driver.findElement(By.xpath("//div[@aria-label='Add a description or attach documents, press Alt+F10 to exit']"));
        eventDescriptionDiv.sendKeys("Hey this is a test");

        Thread.sleep(500);

        WebElement locationInput = driver.findElement(By.cssSelector("input[aria-label='Search for a location']"));
        locationInput.sendKeys("fgcu");

        Thread.sleep(500);
        // Click on the save button
        WebElement saveButton = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Save']"));
        saveButton.click();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void testEventDeletion() throws InterruptedException {
        // Click on the dynamic element with class 'xWbuA' and text 'testTitle'
        WebElement eventTitle = driver.findElement(By.xpath("//span[@class='xWbuA' and contains(text(), 'testTitle')]"));
        eventTitle.click();
        Thread.sleep(1000);

        // Click on the first 'Delete' button
        WebElement deleteButton1 = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and contains(text(), 'Delete')]"));
        deleteButton1.click();
        Thread.sleep(1000);

        // Click on the second 'Delete' button
        WebElement deleteButton2 = driver.findElement(By.xpath("(//span[contains(@class, 'ms-Button-label') and contains(text(), 'Delete')])[2]"));
        deleteButton2.click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void testEventNavbar() throws InterruptedException {
        // Click on the dynamic element with partial text matching for ''
        WebElement dynamicElement1 = driver.findElement(By.xpath("//i[contains(@class, 'Q0K3G') and contains(text(), '')]"));
        dynamicElement1.click();
        Thread.sleep(1000);

        // Click on the button with aria-label 'Work week'
        WebElement workWeekButton = driver.findElement(By.xpath("//button[@aria-label='Work week']"));
        workWeekButton.click();
        Thread.sleep(1000);

        // Click on the span with text 'Week'
        WebElement weekSpan = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Week']"));
        weekSpan.click();
        Thread.sleep(1000);

        WebElement dynamicElement2 = driver.findElement(By.xpath("//i[contains(@class, 'Q0K3G') and contains(text(), '')]"));
        dynamicElement2.click();
        Thread.sleep(1000);

        // Click on the span with text 'Filter'
        WebElement filterSpan = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Filter']"));
        filterSpan.click();
        Thread.sleep(1000);

        // Click on the span with text 'Share'
        WebElement shareSpan = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Share']"));
        shareSpan.click();
        Thread.sleep(1000);


        // Click on the span with text 'Print'
        WebElement printSpan = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Print']"));
        printSpan.click();
        Thread.sleep(1000);

        WebElement cancelSpan = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and contains(text(), 'Cancel')]"));
        cancelSpan.click();
        Thread.sleep(1000);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver quit.");
        }
    }
}
