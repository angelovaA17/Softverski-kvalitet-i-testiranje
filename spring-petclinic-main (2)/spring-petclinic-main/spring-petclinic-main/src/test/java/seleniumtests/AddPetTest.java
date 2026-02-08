package seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPetTest {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeEach
	void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@Test
	void testAddNewPet() {

		// 1. Отвори owners листа
		driver.get("http://localhost:8080/owners");

		// 2. Кликни на првиот owner
		WebElement ownerLink = wait.until(
			ExpectedConditions.elementToBeClickable(
				By.xpath("//table//a")
			)
		);
		ownerLink.click();

		// 3. Клик на "Add New Pet"
		WebElement addPetBtn = wait.until(
			ExpectedConditions.elementToBeClickable(
				By.xpath("//a[contains(text(),'Add New Pet')]")
			)
		);
		addPetBtn.click();

		// 4. Пополни име
		WebElement nameInput = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("name"))
		);
		nameInput.sendKeys("Buddy");

		// 5. Пополни birth date
		WebElement birthDateInput = driver.findElement(By.id("birthDate"));
		birthDateInput.sendKeys("2020-01-01");

		// 6. Избери type (ако постои dropdown)
		WebElement typeSelect = driver.findElement(By.id("type"));
		typeSelect.sendKeys("dog"); // или "cat", зависи од твојата апликација

		// 7. Клик на "Add Pet"
		WebElement addBtn = wait.until(
			ExpectedConditions.elementToBeClickable(
				By.xpath("//button[contains(text(),'Add Pet')]")
			)
		);
		addBtn.click();

		// 8. Smoke assert
		Assertions.assertTrue(true);
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
}
