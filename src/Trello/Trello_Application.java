package Trello;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Trello_Application {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String timeStamp = LocalDateTime.now().toString().replace(':','-');

		driver.get("https://trello.com/");
		WebElement Login_Link = driver.findElement(By.xpath("//div[@class=\"Buttonsstyles__ButtonGroup-sc-1jwidxo-3 jnMZCI\"]/a[text()='Log in']"));
		Login_Link.click();
		wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
		driver.switchTo().activeElement().sendKeys("kn29102000@gmail.com");
		WebElement Continue_Button = driver.findElement(By.xpath("//span[text()='Continue']"));
		Continue_Button.submit();
		WebElement Password_Text_Field = driver.findElement(By.id("password"));
		Password_Text_Field.sendKeys("Naveen@110");
		WebElement Login_Button = driver.findElement(By.id("login-submit"));
		Login_Button.submit();
		Thread.sleep(3000);

		//WebElement Continue_without_two_step_verification_Button = driver.findElement(By.id("mfa-promote-dismiss"));
		//Continue_without_two_step_verification_Button.click();

		wait.until(ExpectedConditions.urlToBe("https://trello.com/u/naveenk132/boards"));
		WebElement CreateNewBoard = driver.findElement(By.xpath("//div[@class=\"board-tile mod-add\"]"));
		CreateNewBoard.click();
		WebElement Create_Board_Title = driver.findElement(By.xpath("//input[@data-testid=\"create-board-title-input\"]"));
		Create_Board_Title.sendKeys("Selenium");
		Thread.sleep(2000);
		WebElement Create_Button = driver.findElement(By.xpath("//button[@data-testid=\"create-board-submit-button\"]"));
		System.out.println("Create_Button_Enabled :"+Create_Button.isEnabled());
		Create_Button.click();

		Thread.sleep(4000);

		WebElement ThreeDotMenu = driver.findElement(By.xpath("//button[@aria-label=\"Show menu\"]"));
		ThreeDotMenu.click();
		Thread.sleep(5000);		

		//WebElement Close_Board = driver.findElement(By.xpath("//div[contains(text(),\"Close board\")]"));
		//WebElement Close_Board = driver.findElement(By.xpath("//div[@class=\"board-menu-close-button-react-root\"]"));
		WebElement Close_Board =driver.findElement(By.xpath("//button[@class=\"TJ69T0gm8D5GkA board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board bxgKMAm3lq5BpA SEj5vUdI3VvxDc\" and @type=\"button\"]"));
		

		Close_Board.click();
		Thread.sleep(5000);

		WebElement Close = driver.findElement(By.xpath("//input[@value=\"Close\"]"));
		Close.click();

		WebElement Trello_icon = driver.findElement(By.xpath("//div[@class=\"qsCZSrobO7JoSv\"]"));
		Trello_icon.click();		

		WebElement Selenium = driver.findElement(By.xpath("//div[text()=\"selenium\"]"));
		Selenium.click();

		TakesScreenshot ts = (TakesScreenshot)driver;
		File TempSS = ts.getScreenshotAs(OutputType.FILE);
		File PermSS = new File("./ScreenShot "+timeStamp+" BeforeMovingTheElementsScreenShot.png");
		FileUtils.copyFile(TempSS,PermSS);

		WebElement GetCurrentUrl_Method = driver.findElement(By.linkText("public String getCurrentUrl()"));
		WebElement getRect_Method = driver.findElement(By.linkText("public Rectangle getRect()"));
		WebElement deselectByValue_Method = driver.findElement(By.linkText("public void deselectByValue(String value)"));
		WebElement getSize_Method = driver.findElement(By.linkText("public Dimension getSize()"));


		WebElement WebDiver_Chart = driver.findElement(By.xpath("//li[@data-list-id=\"66fe71a561c4969f4623ec9f\"]"));
		WebElement webElement_Chart = driver.findElement(By.xpath("//li[@data-list-id=\"66fe72ffa22de626254ac89d\"]"));
		WebElement Select_Chart = driver.findElement(By.xpath("//li[@data-list-id=\"66fe826384c6c8f6d6918e7b\"]"));


		Actions action = new Actions(driver);


		Thread.sleep(3000);
		action.dragAndDrop(GetCurrentUrl_Method, WebDiver_Chart).perform();
		Thread.sleep(3000);
		action.clickAndHold(getRect_Method).release(webElement_Chart).perform();
		Thread.sleep(3000);
		action.clickAndHold(getSize_Method).release(webElement_Chart).perform();
		Thread.sleep(3000);
		action.dragAndDrop(deselectByValue_Method, Select_Chart).perform();

		TakesScreenshot tss = (TakesScreenshot)driver;
		File TempSs = tss.getScreenshotAs(OutputType.FILE);
		File PermSs = new File("./ScreenShot "+timeStamp+" AfterMovingTheElementsScreenShot.png");
		FileUtils.copyFile(TempSs,PermSs);

		Thread.sleep(2000);


		WebElement Add_Another_List_Button = driver.findElement(By.xpath("//button[@data-testid=\"list-composer-button\"]"));
		Add_Another_List_Button.click();

		action.sendKeys(driver.switchTo().activeElement()).keyDown(Keys.SHIFT).sendKeys("f").keyUp(Keys.SHIFT).sendKeys("rames").sendKeys(Keys.ENTER).perform();

		////		WebElement AddListButton = driver.findElement(By.xpath("//button[@data-testid=\"list-composer-add-list-button\"]"));
		////		AddListButton.click();


		WebElement Account = driver.findElement(By.xpath("//button[@data-testid=\"header-member-menu-button\"]"));
		Account.click();

		WebElement Logout_Button = driver.findElement(By.xpath("//button[@data-testid=\"account-menu-logout\"]"));
		Logout_Button.click();
		//wait.until(ExpectedConditions.titleIs("https://id.atlassian.com/logout?continue=https%3A%2F%2Ftrello.com%2Flogout%3Fdsc%3D526df664b7e55f28e367f3205116b09dbad2b0cc5da0de4d10292155dc63a464"));
		Thread.sleep(2000);
		WebElement Log_out_Button = driver.findElement(By.id("logout-submit"));

		Log_out_Button.click();



		driver.manage().window().minimize();	
		driver.quit();


	}

}
