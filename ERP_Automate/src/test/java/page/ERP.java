package page;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.utility_Page;

public class ERP {
	WebDriver driver;
	utility_Page ob;
	JavascriptExecutor js;
	utility_Page read = new utility_Page();

	@Test(priority = 0)
	public void LoginPage() throws InterruptedException, IOException {
		WebElement Username = driver.findElement(By.id("loginform-username"));
		Username.sendKeys(read.ReadExcel1(0, 0));
		WebElement Password = driver.findElement(By.id("loginform-password"));
		Password.sendKeys(read.ReadExcel1(0, 1));
		utility_Page.handleSleep(6000);
		WebElement Login = driver.findElement(By.xpath("//*[@name='login-button']"));
		Login.click();
		utility_Page.handleSleep(6000);
	}

	@Test(priority = 1)
	public void CompanyProfilePage() throws InterruptedException {
		WebElement Company = driver.findElement(By.xpath("//*[@class='fa fa-university']"));
		Company.click();
		WebElement CompanyProfile = driver.findElement(By.xpath("//*[@href='/erp/company']"));
		CompanyProfile.click();
		utility_Page.handleSleep(6000);
		WebElement CompanyName = driver.findElement(By.name("Company[company_name]"));
		CompanyName.clear();
		WebElement CompanyNameFields = driver.findElement(By.name("Company[company_name]"));
		CompanyNameFields.sendKeys("Obsqura");
		WebElement CompanyEmail = driver.findElement(By.xpath("//*[@name='Company[company_email]']"));
		CompanyEmail.clear();
		WebElement CompanyEmailFields = driver.findElement(By.xpath("//*[@name='Company[company_email]']"));
		CompanyEmailFields.sendKeys("obsqura@gmail.com");
		WebElement CompanyAddress = driver.findElement(By.xpath("//*[@name='Company[company_address]']"));
		CompanyAddress.clear();
		WebElement CompanyAddressFields = driver.findElement(By.xpath("//*[@name='Company[company_address]']"));
		CompanyAddressFields.sendKeys("Obsqura zone, Trivandrum");
		WebElement CompanyStartedAtCalender = driver.findElement(By.xpath("//*[@name='Company[started_at]']"));
		CompanyStartedAtCalender.click();
		utility_Page.handleSleep(6000);
		WebElement CompanyStartedAt = driver.findElement(By.xpath("//*[@data-date='1597881600000']"));
		CompanyStartedAt.click();
		utility_Page.handleSleep(6000);
		WebElement Save = driver.findElement(By.xpath("//*[@type='submit']"));
		Save.click();
		utility_Page.handleSleep(6000);
	}

	@Test(priority = 2)
	public void Branches() throws InterruptedException {
		WebElement Company = driver.findElement(By.xpath("//*[@class='fa fa-university']"));
		Company.click();
		WebElement BranchesPage = driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[6]/ul/li[2]/a"));
		BranchesPage.click();
		WebElement BrancheName = driver.findElement(By.xpath("//*[@id='branch-branch_name']"));
		BrancheName.sendKeys("Obsqura");
		WebElement Email = driver.findElement(By.xpath("//*[@name='Branch[email]']"));
		Email.sendKeys("obsqura@gmail.com");
		WebElement Phone = driver.findElement(By.xpath("//*[@name='Branch[phone]']"));
		Phone.sendKeys("0471234857");
		WebElement Mobile = driver.findElement(By.xpath("//*[@name='Branch[mobile]']"));
		Mobile.sendKeys("09876543210");
		WebElement GSTno = driver.findElement(By.xpath("//*[@name='Branch[gst_no]']"));
		GSTno.sendKeys("1234");
		WebElement Address1 = driver.findElement(By.xpath("//*[@name='Branch[address1]']"));
		Address1.sendKeys("Obsqura zone");
		WebElement Address2 = driver.findElement(By.xpath("//*[@name='Branch[address2]']"));
		Address2.sendKeys("Trivandrum");
		WebElement State = driver.findElement(By.xpath("//*[@name='Branch[state]']"));
		State.sendKeys("Kerala");
		WebElement Pincode = driver.findElement(By.xpath("//*[@name='Branch[pincode]']"));
		Pincode.sendKeys("654321");
		WebElement Save = driver.findElement(By.xpath("//*[@type='submit']"));
		Save.click();
		utility_Page.handleSleep(6000);
	}

	@Test(priority = 3)
	public void Clients() throws InterruptedException {
		WebElement Company = driver.findElement(By.xpath("//*[@title='Clients']"));
		Company.click();
		utility_Page.handleSleep(6000);
		WebElement ClientName = driver.findElement(By.xpath("//*[@name='ClientSearch[client_name]']"));
		ClientName.sendKeys("qa");
		WebElement Postcode = driver.findElement(By.xpath("//*[@name='ClientSearch[postcode]']"));
		Postcode.click();
		utility_Page.handleSleep(6000);
	}

	@Test(priority = 4)
	public void LogoutPage() throws InterruptedException, AWTException {
		WebElement Profile = driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[8]/a"));
		Profile.click();
		WebElement Logout = driver.findElement(By.xpath("//*[@class='logout-btn']"));
		Logout.click();
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		ob = new utility_Page();
		driver = ob.web("http://qabible.in/erp/login");
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}