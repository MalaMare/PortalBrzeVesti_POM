
package portal;

import static category.TestCategories.categoriesPage;
import static category.TestCategories.dateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CategoriesPage;
import pages.PortalsPage;


public class TestPortals {
    
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static PortalsPage portalsPage;
    
    public static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @BeforeClass
    public static void setUpClass() {
        
        System.out.println("@BeforeClass: " + dateFormat.format(new Date()));
        
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, 10);
       portalsPage = new PortalsPage();
        
       driver.manage().window().maximize();
       driver.get("http://bvtest.school.cubes.rs/login");
       
       
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("qa@cubes.rs");
        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        loginButton.click();

        System.out.println("Page title is: " + driver.getTitle());
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        
        Thread.sleep(3000);
        System.out.println("@AfterClass: " + dateFormat.format(new Date()));
//        driver.quit();
    }
    
    @Before
    public void setUp() {
        
         System.out.println("@Before: " + dateFormat.format(new Date()));
        
        WebElement portals = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Portals")));
        portals.click();
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     public void testCreateNewPortal() {
         
     portalsPage.createNewPortal(driver, wait);
     
     }
     
     
     
}
