
package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CategoriesPage {
    
//    *********** testCreateNewCategory ***********
    
    private void clickOnAddButton(WebDriver driver) {
        WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
        addCategoryButton.click();        
    }
    
    private void sendTextOnTitleField(WebDriver driver) {
        WebElement insertCategoryField = driver.findElement(By.id("title"));
        insertCategoryField.sendKeys(Helper.getRandomText());      
    }
    
    private void clickOnSaveCategoryButton(WebDriver driver) {
        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
    }
 
//  testCreateNewCategory - objedinjeno predhodno   
    public void addNewCategory(WebDriver driver) {
        clickOnAddButton(driver);
        sendTextOnTitleField(driver);
        clickOnSaveCategoryButton(driver);
    }

    
//    *********** testEditLastCategory ***********
    
    private List<WebElement> getRowsFromTable(WebDriverWait wait) {
       WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));         
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
         
        System.out.println(rows.size()); 
        return rows;
    }
    
    
    private WebElement chooseLastRow(WebDriverWait wait) {
        
        List<WebElement> rows = getRowsFromTable(wait);
//        //pronalazenje poslednjeg zapisa na listi
        WebElement lastRow = rows.get(rows.size()-1);  
        return lastRow;

//        return rows.get(rows.size() - 1);
    }
    
    private void clickOnEditButton(WebElement row) {
        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();
        
    }
    
    private void sendTextOnTitleFieldWithClear(WebDriver driver) {
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.clear();
        titleField.sendKeys(Helper.getRandomText());
    }

    public void editLastCategory(WebDriver driver, WebDriverWait wait) {
        
        WebElement lastRow = chooseLastRow(wait);
        clickOnEditButton(lastRow);
        sendTextOnTitleField(driver);
        clickOnSaveCategoryButton(driver);
    }   
        
////        ne pravimo novu metodu clickOnSaveCategoryButton jer imamo u predhodnom tekstu
//        WebElement saveButton = driver.findElement(By.id("save-category-button"));
//        saveButton.click();


//    *********** testEditFirstCategory ***********
    
    private WebElement chooseFirstRow(WebDriverWait wait) {
        
        List<WebElement> rows = getRowsFromTable(wait);
//        //pronalazenje prvog zapisa na listi
        WebElement firstRow = rows.get(0);
        return firstRow;

//        return getRowsFromTable(wait).get(0);
    }
    
    public void editFirstCategory(WebDriver driver, WebDriverWait wait) {
        WebElement firstRow = chooseFirstRow(wait);
        clickOnEditButton(firstRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveCategoryButton(driver);
    }

    
//    *********** testEditRandomCategory ***********
    
    private WebElement chooseRandomRow(WebDriverWait wait) {
        
        List<WebElement> rows = getRowsFromTable(wait);
        //pronalazenje random zapisa na listi
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));    
        return randomRow;
        
    }
    
    public void editRandomCategory(WebDriver driver, WebDriverWait wait) {
        WebElement randomRow = chooseRandomRow(wait);
        clickOnEditButton(randomRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveCategoryButton(driver);
    }
    
    
//    *********** testDeleteFirstCategory ***********
    
    private void clickOnDeleteButton(WebElement row) {
        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
        
//        row.findElement(By.cssSelector("button[title='Delete']")).click();
    }
    
    private void clickOnConfirmDeleteButton(WebDriver driver, WebDriverWait wait) {
//        driver.switchTo().activeElement();
        WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'categoryDeleteDialog\']/div/div/div[3]/button[2]")));
        confirmDelete.click();
//        driver.switchTo().defaultContent();
    }

    public void deliteFirstCategory(WebDriver driver, WebDriverWait wait) {
        WebElement firstRow = chooseFirstRow(wait);
        clickOnDeleteButton(firstRow);
        clickOnConfirmDeleteButton(driver, wait);
    }
    
    public void deliteLastCategory(WebDriver driver, WebDriverWait wait) {
        WebElement lastRow = chooseLastRow(wait);
        clickOnDeleteButton(lastRow);
        clickOnConfirmDeleteButton(driver, wait);
    }
    
    public void deliteRandomCategory(WebDriver driver, WebDriverWait wait) {
        WebElement randomRow = chooseRandomRow(wait);
        clickOnDeleteButton(randomRow);
        clickOnConfirmDeleteButton(driver, wait);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
