import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login_test extends json_parsor{

    WebDriver driver;
    private JSONObject json;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "geckodriver/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void testLogin() throws Exception {

        //Opening the URL in Firefox Browser
        String url = "Enter your URL here";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(20000);

        //Sample with wait
        //new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("some xpath")));

        //Elements
        WebElement login_field    = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[2]/form/div[2]/input"));
        WebElement password_field = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[2]/form/div[3]/input"));
        WebElement login_btn      = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[2]/form/button"));


        //Actions
        json = json_parsor.getJsonObject("testLogin.json");

        //Entering login name
        login_field.sendKeys(json_parsor.getObject(json, "user_1", "user").toString());
        //Entering password
        password_field.sendKeys(json_parsor.getObject(json, "user_1", "pass").toString());
        //Taping on Login button
        login_btn.click();

    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(20000);
        //Closing the driver
        driver.close();
        System.out.println("Test script executed successfully.");

    }
}
