
package category;

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
import pages.CategoriesPage;


public class TestCategories {
    
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static CategoriesPage categoriesPage;
    
    public static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    
    @BeforeClass
    public static void setUpClass() {
        
        //brisemo jer smo napravili varijablu
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
                
//       dateFormat = new SimpleDateFormat("HH:mm:ss");
 
       System.out.println("@BeforeClass: " + dateFormat.format(new Date()));
        
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, 10);
       categoriesPage = new CategoriesPage();
        
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
        
        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories")));
        categories.click();
        
    }
    
    
    @After
    public void tearDown() throws InterruptedException {
        
        Thread.sleep(3000);
        System.out.println("@After: " + dateFormat.format(new Date()));
//        driver.quit();
        
    }

    
     @Test
     public void testCreateNewCategory() {
         
//        for (int i = 0; i < 5; i++) {
    
//        CategoriesPage categoriesPage = new CategoriesPage();
        
//        categoriesPage.clickOnAddButton(driver);
////        WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
////        addCategoryButton.click();   
//        
//        categoriesPage.sendTextOnTitleField(driver);
////        WebElement insertCategoryField = driver.findElement(By.id("title"));
////        insertCategoryField.sendKeys(Helper.getRandomText());
//
//        categoriesPage.clickOnSaveCategoryButton(driver);
////        WebElement saveButton = driver.findElement(By.id("save-category-button"));
////        saveButton.click();

//        testCreateNewCategory - objedinjeno predhodno 
        categoriesPage.addNewCategory(driver);
        
           
        //test da li vraca na ocekivani url
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualURL = driver.getCurrentUrl();
        
        Assert.assertEquals("Url se ne poklapa", expectedUrl, actualURL);
 
        
        //test da li se ispisuje ocekivani title
        String expectedTitle = "Brze vesti admin  | Categories ".replaceAll("\\s+", " ").trim();
//         System.out.println("Expected title: '" + expectedTitle + "'");
        
        String actualTitle = driver.getTitle();
//         System.out.println("Actual title: '" + actualTitle + "'");
     
        Assert.assertEquals("Titles doesn't match", expectedTitle, actualTitle);
        
        
//         } 
             
     }
     
    
    @Test
     public void testEditLastCategory() {
         
//        CategoriesPage categoriesPage = new CategoriesPage();
        
        categoriesPage.editLastCategory(driver, wait);
        
//        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));         
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//         
//        System.out.println(rows.size());
//         
//        //pronalazenje poslednjeg zapisa na listi
//        WebElement lastRow = rows.get(rows.size()-1);
//         
//         
//        //WebElement editButton = lastRow.findElement(By.className("btn-default"));
//        WebElement editButton = lastRow.findElement(By.cssSelector("button[title='Edit']"));
//        editButton.click();
//         
//  
//        WebElement insertCategoryField = driver.findElement(By.id("title"));
//        insertCategoryField.clear();
//        insertCategoryField.sendKeys(Helper.getRandomText());
//        
//        WebElement saveButton = driver.findElement(By.id("save-category-button"));
//        saveButton.click();

        
        //test da li vraca na ocekivani url
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualURL = driver.getCurrentUrl();
        
        Assert.assertEquals(expectedUrl, actualURL);
 
       
        //test da li se ispisuje ocekivani title
        String expectedTitle = "Brze vesti admin  | Categories ".replaceAll("\\s+", " ").trim();
//        System.out.println(expectedTitle);
        
        String actualTitle = driver.getTitle();
//        System.out.println(actualTitle);
     
        Assert.assertEquals(expectedTitle, actualTitle);
    
}

     
    @Test
    public void testEditFirstCategory(){
        
//        CategoriesPage categoriesPage = new CategoriesPage();
        
        categoriesPage.editFirstCategory(driver, wait);
        
        Assert.assertEquals("Url doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
    } 
     
     
    @Test
    public void testDeleteFirstCategory() {
        
//        CategoriesPage categoriesPage = new CategoriesPage();
        
        categoriesPage.deliteFirstCategory(driver, wait);
               
//        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//         
//        System.out.println(rows.size());
//         
//        WebElement firstRow = rows.get(0);  
//        
//        //WebElement deleteButton = driver.findElement(By.cssSelector("#categoriesTable > tbody > tr:nth-child(1) > td:nth-child(5) > div > button:nth-child(3)"));        
//        WebElement deleteButton = firstRow.findElement(By.cssSelector("button[title='Delete']"));        
//        deleteButton.click();
//    
//        WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'categoryDeleteDialog\']/div/div/div[3]/button[2]")));
//        confirmDelete.click();
            
}
    
    
    @Test
    public void testDeleteLastCategory() {
//        CategoriesPage categoriesPage = new CategoriesPage();    
        categoriesPage.deliteLastCategory(driver, wait);
    } 
     
    @Test
    public void testDeleteRandomCategory() {
//        CategoriesPage categoriesPage = new CategoriesPage();    
        categoriesPage.deliteRandomCategory(driver, wait);
    }  
     
}
