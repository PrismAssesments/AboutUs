package selenium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class PrismAboutUs {

    static Map<String, String> hashmap = new HashMap<String, String>();
    
    java.util.List<java.util.Map.Entry<String,Integer>> pairList= new java.util.ArrayList<>();

    public static Map searchtext() {
    	//System.setProperty("webdriver.chrome.driver", "C:\\Distirb\\Selenium\\chromedriver_win32\\chromedriver.exe");

    	WebDriver driver = new ChromeDriver();
    	driver.get("http://www.n2net.net/team-company");


    	List<WebElement> element_names = driver.findElements(By.xpath("//div[@class='team-member-name']")); 

    	List<WebElement> element_titles = driver.findElements(By.xpath("//div[@class='team-member-title']")); 

    	for (int i = 0; i < element_names.size(); i++) {
    		hashmap.put(element_names.get(i).getText(), element_titles.get(i).getText());
    	}

    	/**
    	 * For debuging purposes - printing WebElements names and titles
    	 * 
    	 for(WebElement ele_n :element_names) for (WebElement ele_t :element_titles) {
    	 System.out.println(ele_n.getText());
    	 for(WebElement ele_t :element_titles) {
    	 System.out.println("Title===>"+ele_t.getText());}   	   
    	 */

    	driver.quit();
    	return hashmap;
    	
    }

    public static void main(String[] args) {

	    searchtext();
	    
	    for (Map.Entry entry : hashmap.entrySet()) {
    	    System.out.println(entry.getKey() + ", " + entry.getValue());
    	}
		

}
}
