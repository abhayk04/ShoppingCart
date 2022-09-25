package actions.mouse.frame.window;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandline {

	public static void main(String[] args) {
		// TODO Frames Handling
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); //parent id and child id ,subChild
		Iterator<String> ids = windows.iterator(); //get next windows id came here //keep doing next to get
		String parentId=ids.next();
		String childId=ids.next();
		driver.switchTo().window(childId); 
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		//give knowledge to driver that find the text in the next window otherwise it keep searching
		//in the older/ parent window
		String stringN = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(stringN);
		driver.switchTo().window(parentId); //switch back to parent id
		driver.findElement(By.id("username")).sendKeys(stringN);
	}
	


}
