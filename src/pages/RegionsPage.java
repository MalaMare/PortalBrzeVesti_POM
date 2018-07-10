
package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegionsPage {
    
//    *********** testCreateNewRegion ***********

    private void clickOnAddRegion(WebDriver driver, WebDriverWait wait) {
        WebElement addRegionButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addRegionButton.click();
    }
    
    private void sendTextOnTitleField(WebDriver driver) {
        WebElement insertTitleField = driver.findElement(By.id("title"));
        insertTitleField.sendKeys(Helper.getRandomTitle());
    }
    
    private void clickOnSaveRegionButtton(WebDriver driver) {    
        WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
        saveRegionButton.click();
    }
         
    //  testCreateNewRegion - objedinjeno predhodno 
    public void CreateNewRegion(WebDriver driver, WebDriverWait wait) {
        clickOnAddRegion(driver, wait);
        sendTextOnTitleField(driver);
        clickOnSaveRegionButtton(driver);
    }

//    *********** testEditFirstRegion ***********    
    
    private List<WebElement> getRowsFromTable(WebDriverWait wait) {
       WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));         
       List<WebElement> rows = tBody.findElements(By.tagName("tr"));
       return rows;
    }
    
    private WebElement chooseFirstRow(WebDriverWait wait) {  
       List<WebElement> rows = getRowsFromTable(wait);
       WebElement firstRow = rows.get(0);
       return firstRow;
    }
    
    private void clickOnEditButton(WebElement row) {
        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();
    }
    
    private void sendTextOnTitleFieldWithClear(WebDriver driver) {
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.clear();
        titleField.sendKeys(Helper.getRandomTitle());
    }
    
    //  testEditFirstRegion - objedinjeno predhodno 
    public void editFirstRegion(WebDriver driver, WebDriverWait wait) {
        WebElement firstRow = chooseFirstRow(wait);
        clickOnEditButton(firstRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveRegionButtton(driver);
    }
    
//        *********** testEditLastRegion ***********  
    
    private WebElement chooseLastRow(WebDriverWait wait) {  
       List<WebElement> rows = getRowsFromTable(wait);
       WebElement lastRow = rows.get(rows.size()-1);
       return lastRow;
    }
    
    //  testEditLastRegion - objedinjeno predhodno 
    public void editLastRegion(WebDriver driver, WebDriverWait wait) {
        WebElement lastRow = chooseLastRow(wait);
        clickOnEditButton(lastRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveRegionButtton(driver);     
    }
    
//        *********** testEditRandomRegion ***********  
    
    private WebElement chooseRandomRow(WebDriverWait wait) { 
        List<WebElement> rows = getRowsFromTable(wait);
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));    
        return randomRow;
    }
        
        //  testEditRandomRegion - objedinjeno predhodno 
    public void editRandomRegion(WebDriver driver, WebDriverWait wait) {
        WebElement randomRow = chooseRandomRow(wait);
        clickOnEditButton(randomRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveRegionButtton(driver);      
    }
    
//    *********** testDeleteFirstRagion ***********
    
    private void clickOnDeleteButton (WebElement row) {
        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }
    
    private void clickOnConfirmDeleteRegion (WebDriverWait wait) {
        WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='regionDeleteDialog']/div/div/div[3]/button[2]")));
        confirmDelete.click();
    }
    
    public void deleteFirstRegion(WebDriverWait wait) {
        WebElement firstRow = chooseFirstRow(wait);
        clickOnDeleteButton(firstRow);
        clickOnConfirmDeleteRegion(wait);
    }
    
}
