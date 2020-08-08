package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class utility_Page {

	static WebDriver driver;
	JavascriptExecutor js;
	FileInputStream obj;
	XSSFWorkbook book;
	XSSFSheet objsheet;
	XSSFRow row;
	XSSFCell cell;

	public WebDriver web(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Jazz/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public String ReadExcel1(int r, int c) throws IOException {
		String Value = "";
		obj = new FileInputStream("C://Users//Jazz//Desktop//Book1.xlsx");
		book = new XSSFWorkbook(obj);
		objsheet = book.getSheet("Sheet1");
		row = objsheet.getRow(r);
		cell = row.getCell(c);
		CellType type = cell.getCellType();
		if (type == CellType.NUMERIC) {
			double Value1 = cell.getNumericCellValue();
			String str = String.valueOf(Value1);
			return str;
		} else if (type == CellType.STRING) {
			Value = cell.getStringCellValue();
		}
		return Value;
	}

	public WebDriver Navigate(String url) {
		driver.navigate().to(url);
		driver.navigate().forward();
		driver.navigate().back();
		return driver;
	}

	public WebElement element(By property) {
		WebElement element = driver.findElement(property);
		return element;
	}

	public void takescreenshot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Selenium_Screenshot"));
	}

	public By click(By property) {
		driver.findElement(property).click();
		return property;
	}
	public static void handleSleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}


	public void scrollup_down(int a, int b) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(a,b)");
	}

	public void scroll(String value) {
		js.executeScript("arguments[0].scrollIntoView();s", value);
	}

	public void sendkeys(By property, String value) {
		driver.findElement(property).sendKeys(value);
	}

	public void implicitywait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
