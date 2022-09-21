package ShoppingCart;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	
	
	public static void main(String[] args)  {
		// TODO Adding Items to Cart which are Dynamic In Nature
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //implicit wait
		WebDriverWait w = new WebDriverWait(driver,5);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		String[] list = { "Cucumber", "Brocolli", "Cauliflower", "Beetroot", "Carrot" };
		getItem(driver, list);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); //Explicit wait for promocode box

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); //Explicit wait
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	//	driver.close();
		

	}

	public static void getItem(WebDriver driver, String[] list) {

		// Code for Multiple Element Adding to Cart
		int itemCount = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // get all items
		List FinalList = Arrays.asList(list); // convert Required items list to array list
		for (int i = 0; i < products.size(); i++) { // Cocumber - 1kg // remove 1kg because our list have only names
			String name = products.get(i).getText().split(" ")[0]; // GET ALL PRODUCT NAMES / TEXTS FROM SHOP
			if (FinalList.contains(name)) { // compare with list and its contents
				// click of Add to cart
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				itemCount++; // text based locators are Inconsistent Hence Should be Avoid
				if (itemCount == list.length) {
					break; // break when all items added
				}

			}
		}
	}
	/*
	 * Code for Single Element Adding to Cart
	 * 
	 * List<WebElement> products =
	 * driver.findElements(By.cssSelector("h4.product-name")); //SHIFT ALT AND
	 * CAPITAL L for (int i = 0; i < products.size(); i++) { String name =
	 * products.get(i).getText();//GET ALL PRODUCT NAMES / TEXTS FROM SHOP if
	 * (name.contains("Cucumber")) { //click of Add to cart
	 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
	 * ); break; } }
	 */

}
