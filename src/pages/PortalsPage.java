
package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PortalsPage {
    
//    *********** testCreateNewPortal ***********    
    
    private void clickOnAddButton(WebDriver driver){
        WebElement addPortalButton = driver.findElement(By.className("pull-right"));
        addPortalButton.click();
    }
    
    private void sendTextOnTitleField(WebDriver driver) {
        WebElement insertPortalField = driver.findElement(By.id("title"));
        insertPortalField.sendKeys(Helper.getRandomText());
    }
    
    private void sendTextOnUrlField(WebDriver driver) {
        WebElement insertUrlField = driver.findElement(By.id("url"));
        insertUrlField.sendKeys(Helper.getRandomUrl());
    }
    
//    ******!!!******
    private void selectRandomRegion(WebDriverWait wait) {
        Select regionCombo = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("region_id"))));
        List <WebElement> weblist = regionCombo.getOptions();
        WebElement randomRegion = weblist.get(Helper.getRandomInteger(weblist.size()));  
        randomRegion.click();
    }
    
    private void clickOnSavePortalButton(WebDriver driver) {
        WebElement saveButton = driver.findElement(By.id("save-portal-button"));
        saveButton.click();
    }
    
    public void createNewPortal(WebDriver driver, WebDriverWait wait) {
        clickOnAddButton(driver);
        sendTextOnTitleField(driver);
        sendTextOnUrlField(driver);
        selectRandomRegion(wait);
        clickOnSavePortalButton(driver);
    }
    
    
    
    
}
