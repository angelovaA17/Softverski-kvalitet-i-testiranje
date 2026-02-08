//package seleniumtests;
//
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//
//public class VetScheduleTest {
//	private WebDriver driver;
//
//	@BeforeEach
//	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", "C:/Users/Anastasija/Downloads/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("http://localhost:8080");
//	}
//
//
////	@BeforeEach
////	public void setUp() {
////		WebDriverManager.chromedriver().setup();
////		driver = new ChromeDriver();
////		driver.get("http://localhost:8080");
////	}
//
//
//	@Test
//	public void testVetSchedule() {
//		driver.findElement(By.linkText("Veterinarians")).click();
//		driver.findElement(By.linkText("Show Schedule")).click();
//		// Може да провериш текст или елемент на распоред
//	}
//
//	@AfterEach
//	public void tearDown() {
//		driver.quit();
//	}
//}


package seleniumtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VetScheduleTest {

	private WebDriver driver;

	@BeforeEach
	public void setUp() {
		// Автоматски ја симнува и конфигурира вистинската верзија на ChromeDriver
		WebDriverManager.chromedriver().setup();

		// Креира ChromeDriver инстанца
		driver = new ChromeDriver();

		// Отворај ја веб апликацијата (пример)
		driver.get("http://localhost:8080"); // замени со вистинската URL на твојата апликација
	}

	@Test
	public void testVetSchedulePageTitle() {
		// Проверка на title (пример)
		String title = driver.getTitle();
		System.out.println("Page title: " + title);

		// Може да додадеш assertions
		// Assertions.assertEquals("Expected Title", title);
	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
