package region;

import framework.Helper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
import pages.RegionsPage;



public class TestRegions {
    
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static RegionsPage regionsPage;
    
    public static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    
    @BeforeClass
    public static void setUpClass() {
        
//       dateFormat = new SimpleDateFormat("HH:mm:ss");
       System.out.println("@BeforeClass: " + dateFormat.format(new Date()));
        
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, 10);
       regionsPage = new RegionsPage();
          
        
       driver.manage().window().maximize();
       driver.get("http://bvtest.school.cubes.rs/login");
       
       
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("qa@cubes.rs");
        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        loginButton.click();
        
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
        
        WebElement regions = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Regions")));
        regions.click();
        
    }
    
    @After
    public void tearDown() throws InterruptedException {
        
        Thread.sleep(3000);
        System.out.println("@After: " + dateFormat.format(new Date()));
//        driver.quit();
             
    }

    
     @Test
     public void testCreateNewRegion() {
         
//        WebElement addRegionButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
//        addRegionButton.click();
//         
//        WebElement insertTitleField = driver.findElement(By.id("title"));
//        insertTitleField.sendKeys(Helper.getRandomTitle());
//         
//        WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
//        saveRegionButton.click();

        regionsPage.CreateNewRegion(driver, wait);
         
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualURL = driver.getCurrentUrl();
        
        Assert.assertEquals("Url se ne poklapa", expectedUrl, actualURL);       
         
     }
     
     
     @Test
     public void testEditFirstRegion() {
         
//        WebElement tBody = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-sortable")));
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//        WebElement firstRow = rows.get(0);
//        
//        WebElement editButton = firstRow.findElement(By.cssSelector("a[title='Edit']"));
//        editButton.click();
//        
//        WebElement insertTitleField = driver.findElement(By.id("title"));
//        insertTitleField.clear();
//        insertTitleField.sendKeys(Helper.getRandomTitle());
//         
//        WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
//        saveRegionButton.click();

        regionsPage.editFirstRegion(driver, wait);
         
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualURL = driver.getCurrentUrl();
        
        Assert.assertEquals("Url se ne poklapa", expectedUrl, actualURL);
                     
     }

    @Test
     public void testEditLastRegion() {    
     
//        WebElement tBody = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-sortable")));
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//        WebElement lastRow = rows.get(rows.size()-1);
//        
//        WebElement editButton = lastRow.findElement(By.cssSelector("a[title='Edit']"));
//        editButton.click();
//        
//        WebElement insertTitleField = driver.findElement(By.id("title"));
//        insertTitleField.clear();
//        insertTitleField.sendKeys(Helper.getRandomTitle());
//         
//        WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
//        saveRegionButton.click();
//     }
     
        regionsPage.editLastRegion(driver, wait);
                
     } 
     
    @Test
     public void testEditRandomRegion() {
         
//        WebElement tBody = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-sortable")));
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
//        
//        WebElement editButton = randomRow.findElement(By.cssSelector("a[title='Edit']"));
//        editButton.click();
//        
//        WebElement insertTitleField = driver.findElement(By.id("title"));
//        insertTitleField.clear();
//        insertTitleField.sendKeys(Helper.getRandomTitle());
//         
//        WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
//        saveRegionButton.click();
        
        regionsPage.editRandomRegion(driver, wait);
        
     } 
     
    @Test
    public void testDeleteFirstRegion() {
        
//        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//        WebElement firstRow = rows.get(0);
//        
//        WebElement deleteButton = firstRow.findElement(By.cssSelector("button[title='Delete']"));        
//        deleteButton.click();
//    
//        WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'regionDeleteDialog\']/div/div/div[3]/button[2]")));
//        confirmDelete.click();
        
        regionsPage.deleteFirstRegion(wait);
        
    } 
}
