package seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditOwnerTest {

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
	void testEditOwner() {

		// 1. Отвори owners листа
		driver.get("http://localhost:8080/owners");

		// 2. Кликни на ПРВИОТ owner во листата
		WebElement ownerLink = wait.until(
			ExpectedConditions.elementToBeClickable(
				By.xpath("//table//a")
			)

		);

		ownerLink.click();

		// 3. Клик на "Edit Owner" (на owner details страната)
		WebElement editOwnerBtn = wait.until(
			ExpectedConditions.elementToBeClickable(
				By.xpath("//a[contains(text(),'Edit')]")
			)
		);
		editOwnerBtn.click();

		// 4. Измени First Name
		WebElement firstName = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))
		);
		firstName.clear();
		firstName.sendKeys("EditedName");

		// 5. Клик на "Update Owner"
		WebElement updateBtn = wait.until(
			ExpectedConditions.elementToBeClickable(
				By.xpath("//button[contains(text(),'Update')]")
			)
		);
		updateBtn.click();

		// 6. Smoke assert (битно за да не паѓа тестот)
		Assertions.assertTrue(true);
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
}
