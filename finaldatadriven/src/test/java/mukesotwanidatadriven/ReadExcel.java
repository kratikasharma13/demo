package mukesotwanidatadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.ExcelDataConfig;

public class ReadExcel {

	static WebDriver driver;
	@BeforeMethod()
	public static void start() {
		driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\finaldatadriven\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver.get("https://ui.cogmento.com/");
	}
	@Test(dataProvider="wordpress")

	public void dataone(String Username, String Password) {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.manage().window().maximize() ;
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		System.out.println("page titlte");
	}
		@AfterMethod
		public void teardown1()
		{
			driver.quit();
		}

@DataProvider(name="wordpress")
public Object[][] passData(){
	ExcelDataConfig obj1 = new ExcelDataConfig("C:\\Users\\HP\\eclipse-workspace\\Driven\\src\\test\\java\\testdata\\TestData.xlsx","sheet1");
	int rows= obj1.getRowCount(0);
	System.out.println("row count id"+rows);
	int col = obj1.getcolumnCount("Sheet1");
	 System.out.println("column count is"+col);
	Object[][] data= new Object[rows][col]; // we create an array of object type which content 3 row 2 columnn
	for(int i=0; i<rows;i++) {
		for(int j=0; j<col; j++) {
		data[i][j]=obj1.getData("sheet1", i, j);
	//	data[i][j]=obj1.getData("sheet1", i, j);
		
		}
	
}
	return data;
}
}