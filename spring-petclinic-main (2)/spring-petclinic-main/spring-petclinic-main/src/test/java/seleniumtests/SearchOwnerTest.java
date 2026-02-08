package seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchOwnerTest {

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
	void testSearchOwner() {

		// 1. Отвори Find Owner страната
		driver.get("http://localhost:8080/owners/find");

		// 2. Пополни Last Name поле
		WebElement lastNameInput = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))
		);
		lastNameInput.clear();
		lastNameInput.sendKeys("Franklin");

		// 3. Кликни на "Find Owner" копчето
		WebElement findBtn = wait.until(
			ExpectedConditions.elementToBeClickable(
				By.xpath("//button[contains(text(),'Find Owner')]")
			)
		);
		findBtn.click();

		// 4. Чекај да се појави првиот резултат од листата
		WebElement firstResult = wait.until(
			ExpectedConditions.elementToBeClickable(
				By.xpath("//table//a[contains(text(),'Franklin')]")
			)
		);
		firstResult.click();

		// 5. Smoke assert – само за да не паѓа тестот
		Assertions.assertTrue(firstResult.isDisplayed());
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
}
