//package seleniumtests;
//
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class AddOwnerTest {
//	private WebDriver driver;
//
//	@BeforeEach
//	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", "C:/Users/ТвоетоКорисничкоИме/Downloads/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("http://localhost:8080");
//	}
//
//	@Test
//	public void testAddOwner() {
//		driver.findElement(By.linkText("Owners")).click();
//		driver.findElement(By.linkText("Add New Owner")).click();
//		driver.findElement(By.id("firstName")).sendKeys("Marko");
//		driver.findElement(By.id("lastName")).sendKeys("Jovanov");
//		driver.findElement(By.id("address")).sendKeys("Bitola 45");
//		driver.findElement(By.id("city")).sendKeys("Bitola");
//		driver.findElement(By.id("telephone")).sendKeys("071234567");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//		assertTrue(driver.getPageSource().contains("Marko"));
//	}
//
//	@AfterEach
//	public void tearDown() {
//		driver.quit();
//	}
//}

//package seleniumtests;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.junit.jupiter.api.*;
//
//public class AddOwnerTest {
//
//	WebDriver driver;
//
//	@BeforeEach
//	void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8080");
//	}
//
//	@Test
//	void homePageLoadsSuccessfully() throws InterruptedException {
//		String title = driver.getTitle();
//		Thread.sleep(7000); // 3 секунди да го гледаш Chrome
//		Assertions.assertTrue(title.contains("PetClinic"));
//	}
//
//
//	@AfterEach
//	void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
//}

//package seleniumtests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class AddOwnerTest {
//
//	WebDriver driver;
//
//	@BeforeEach
//	void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//
//		// Selenium само ја отвора апликацијата
//		driver.get("http://localhost:8080");
//	}
//
//	@Test
//	void manualAddOwnerTest() throws InterruptedException {
//
//		// Остава време ТИ рачно да работиш во Chrome
//		// Кликни: Owners -> Add Owner
//		// Пополни форма
//		// Кликни Save
//		Thread.sleep(100000); // 30 секунди (можеш и 60000)
//	}
//
//	@AfterEach
//	void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
//}
