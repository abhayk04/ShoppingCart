package actions.mouse.frame.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Drag and Drop
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size()); //count total frames 
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame"))); //switch to frames / iframes
		//switch frames with webelement , index (0) , (1)
		driver.findElement(By.id("draggable")).click(); 
		Actions A = new Actions(driver); //drag and drop with help of actions class
		WebElement source = driver.findElement(By.id("draggable")); //drag
		WebElement target = driver.findElement(By.id("droppable")); //droop
		A.dragAndDrop(source, target).build().perform();
		 
		//switch to Normal
		driver.switchTo().defaultContent();//coming out of frames and do normal operations
		Thread.sleep(2000);
		driver.findElement(By.linkText("Accept")).click();

	} 

}
