package RealTimeProblems;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingLinks {

	public static void main(String[] args) throws InterruptedException {
		// Getting Links count on the Particular Entire page
		// a
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size()); // total links size = 27

		// Getting Links count on the footer page
		// limit driver scope to footer
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// limit driver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// Getting Links count on the one column
		// limit driver scope to coloumn
		WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());

		// click on each link and checking whether links working or not
		for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {
			String ClickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER); // press cntrl and enter
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickOnLinks);// keyboard events
			Thread.sleep(5000L);
		} // open all tabs
		
		// get headers/titles step by step
		Set<String> windowHandles = driver.getWindowHandles();// all window ids
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()) { // ask if window is present
		//	iterator.next(); // 1st move to zero index, move to 1st ,..//it gives ids
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle()); // print titles

		}

	}

}
