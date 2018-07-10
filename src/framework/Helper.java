
package framework;


public class Helper {
    
    
//    public static WebDriver initWebDriver (WebDriver driver) {
//        System.setProperty("webdriver.chrome.driver", Configuration.chrome_driver);
//        
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        return driver;
//    }
    
    public static String getRandomText() {
//        int random = (int)(Math.random() * 250 + 1);
//        String randomText = "category" + random;
//        return randomText;
        
        return "random-" + (int) (Math.random() * 1000);     
    }
    
    public static int getRandomInteger() {
        return (int) (Math.random() * 1000);
    }
    
    public static int getRandomInteger(int range) {
        return (int) (Math.random() * range + 1);
    }
      
    public static String getRandomUrl () { 
        return "http://".concat(getRandomText()).concat(".te");
    }
    
    public static String getRandomTitle() { 
        int random = (int)(Math.random() * 250 + 1);
        String randomText = "title" + random;
        return randomText;
        
    }
    
    
    
}
    
