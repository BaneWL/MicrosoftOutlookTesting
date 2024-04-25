import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactManagement {
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
    public void testSideTab() throws InterruptedException {
        // XPaths of the elements to be clicked
        WebElement peopleButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'People')]"));
        peopleButton.click();
        Thread.sleep(1000);

        String[] xPaths = {
                "//*[@id=\"355fbd79-3ba2-4554-8f2d-0300fde91f30\"]/span",
                "//*[@id=\"favorites\"]/span",
                "//*[@id=\"contacts\"]/span/span",
                "//*[@id=\"contactLists\"]/span",
                "//*[@id=\"deletedItems\"]/span",
                "//*[@id=\"MainModule\"]/div[1]/div/div/div/ul/li[5]/ul/button[1]/span",
                "//*[@id=\"MainModule\"]/div[1]/div/div/div/ul/li[5]/ul/button[2]/span",
                "//*[@id=\"MainModule\"]/div[1]/div/div/div/ul/li[5]/ul/button[3]/span"
        };

        // Cycle through the XPaths and click on each element
        for (String xPath : xPaths) {
            WebElement element = driver.findElement(By.xpath(xPath));
            element.click();
            // Optional: Add some delay to see the click action
            Thread.sleep(1000);
        }
    }
//test folders tab

    //@Test(priority = 1)
    //public void testContactsNavbarButtons() throws InterruptedException {

    // }

    @Test(priority = 2)
    public void testContactsOperations() throws InterruptedException {
        // Find and click on the button to initiate contact operations
        WebElement startButton = driver.findElement(By.xpath("//*[@id=\"8109-group\"]/div/div[1]/div/span/button[1]/span"));
        startButton.click();

        // Values to input
        String[] values = {
                "Tester",
                "Name",
                "Dookieemail@email.com",
                "123-456-7899",
                "burgerhut",
                "testStuff"
        };

        // Data automation values corresponding to each input field
        String[] dataAutomationValues = {
                "Name.firstName",
                "Name.lastName",
                "Email.email1",
                "Phone.Mobile.phone2",
                "Work.company",
                "Notes.notes"
        };

        // Iterate through input fields and input values
        for (int i = 0; i < values.length && i < dataAutomationValues.length; i++) {
            WebElement textBox = driver.findElement(By.cssSelector("input[data-automation='" + dataAutomationValues[i] + "'], textarea[data-automation='" + dataAutomationValues[i] + "']"));
            textBox.sendKeys(values[i]);
            // Add a 0.5-second delay after each input
            Thread.sleep(500);
        }

        // Find and click on the button to submit contact operations
        // Click on the dynamic element to save
        WebElement saveButton = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Save']"));
        saveButton.click();

        // Optional: Add some delay to see the action
        Thread.sleep(2000);
    }


    @Test(priority = 3)  //can only create one group every 24 hours issue
    public void testGroupCreation() throws InterruptedException {
        // Click on the button to initiate group creation
        Thread.sleep(2000);
        WebElement createGroupButton = driver.findElement(By.xpath("//*[@id=\"8109-group\"]/div/div[1]/div/span/button[2]/span"));
        createGroupButton.click();
        Thread.sleep(1000);


        // Click on the "Create Group" button
        // Locate the "New group" element
        WebElement createGroupListButton2 = driver.findElement(By.xpath("//span[contains(text(), 'New group')]"));
        createGroupListButton2.click();
        Thread.sleep(1000);


        // Input group name
        WebElement groupNameInput = driver.findElement(By.xpath("//input[@aria-label='New group Group name']"));
        groupNameInput.sendKeys("Project Group");
        Thread.sleep(500);

        // Input group description
        WebElement groupDescriptionInput = driver.findElement(By.xpath("//textarea[@aria-label='DescriptionTell people the purpose of your group']"));
        groupDescriptionInput.sendKeys("Hi, for the project");
        Thread.sleep(500);

        // Click on the "Create" button
        WebElement confirmCreateButton = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Create']"));
        confirmCreateButton.click();
        Thread.sleep(6000);

        // Add member to group
        WebElement memberInput = driver.findElement(By.xpath("//input[@placeholder='Enter a name or email address']"));
        memberInput.sendKeys("13nagol@gmail.com");
        Thread.sleep(4000);

        // Click to submit email
        WebElement submitEmailButton = driver.findElement(By.xpath("//div[contains(@class, 'ms-TooltipHost') and text()='13nagol@gmail.com']"));
        submitEmailButton.click();
        Thread.sleep(1000);

        // Click on the "Add" button
        // Click on the dynamic element to add
        WebElement addButton = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Add']"));
        addButton.click();
        Thread.sleep(1000);

    }

    @Test(priority = 4)
    public void testContactListCreation() throws InterruptedException {
        // Click on the button to initiate contact list creation
        Thread.sleep(2000);
        WebElement createGroupButton = driver.findElement(By.xpath("//*[@id=\"8109-group\"]/div/div[1]/div/span/button[2]/span"));
        createGroupButton.click();
        Thread.sleep(1000);

        WebElement createContactListButton2 = driver.findElement(By.xpath("//span[contains(text(), 'New contact list')]"));
        createContactListButton2.click();
        Thread.sleep(1000);

        // Input contact list name
        WebElement contactListNameInput = driver.findElement(By.xpath("//input[@aria-labelledby='labelContactListName']"));
        contactListNameInput.sendKeys("Help me");
        Thread.sleep(500);

        // Input email address
        WebElement emailInput = driver.findElement(By.xpath("//input[@aria-label='Type a name or an email address']"));
        emailInput.sendKeys("13nagol@gmail.com");
        Thread.sleep(500);
        Thread.sleep(1000);

        // Click on the "Add" button
        // Click on the dynamic element to add
        WebElement addButton = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Add']"));
        addButton.click();
        Thread.sleep(1000);
        // Add contact list description
        WebElement contactListDescriptionInput = driver.findElement(By.xpath("//textarea[@placeholder='Add a description']"));
        contactListDescriptionInput.sendKeys("Useless contact list");
        Thread.sleep(500);

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);

// Perform 15 tab key presses
        for (int i = 0; i < 1; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

// Press the Enter key
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Test(priority = 5)
    public void testDeleteContact() throws InterruptedException {

        WebElement groupCreationButton = driver.findElement(By.xpath( "//*[@id=\"contactLists\"]/span"));

        // Click the button
        groupCreationButton.click();
        // Locate the element to right-click
        WebElement contactElement = driver.findElement(By.xpath("//div[contains(@aria-label, 'Help me')]"));

        // Right-click on the element
        Actions actions = new Actions(driver);
        actions.contextClick(contactElement).perform();
        Thread.sleep(1000);
        // Click on the "Delete" button from the context menu
        WebElement deleteButton = driver.findElement(By.xpath("//span[contains(@class, 'ms-Button-label') and text()='Delete']"));
        deleteButton.click();
        Thread.sleep(3000);

        // Press Tab key to navigate to the confirm delete button
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(500);

        // Press Enter key to confirm deletion
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);

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
