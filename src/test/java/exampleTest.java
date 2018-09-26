import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest {
    private WebDriver driver;
    private By productsBtn = By.cssSelector(ta(   "productsBtn"));
    private By tryForFreeBtn = By.cssSelector(ta(   "tryForFreeBtn"));
    private By firstNameFld = By.cssSelector(ta(   "firstNameFld"));
    private By lastNameFld = By.cssSelector(ta(   "lastNameFld"));
    private By jobtitleFld = By.cssSelector(ta(   "jobtitleFld"));
    private By emailFld = By.cssSelector(ta(   "emailFld"));
    private By phoneNumberFld = By.cssSelector(ta(   "phoneNumberFld"));
    private By companyFld = By.cssSelector(ta(   "companyFld"));
    private By employeesDrpDn = By.cssSelector(ta(   "employeesDrpDn"));

    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() throws InterruptedException  {
        driver.get("https://www.salesforce.com");
        String parentHandle = driver.getWindowHandle();

        driver.findElement(productsBtn).click();
        driver.findElement(tryForFreeBtn).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        driver.findElement(firstNameFld).sendKeys("firs name");
        driver.findElement(lastNameFld).sendKeys("last name");
        driver.findElement(jobtitleFld).sendKeys("job title");
        driver.findElement(emailFld).sendKeys("email@email.com");
        driver.findElement(phoneNumberFld).sendKeys("+380639977874");
        driver.findElement(companyFld).sendKeys("Company");
        driver.findElement(employeesDrpDn).click();

        driver.switchTo().window(parentHandle);
        Thread.sleep(5000);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
