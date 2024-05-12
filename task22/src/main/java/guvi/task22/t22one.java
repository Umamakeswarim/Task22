package guvi.task22;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class t22one {

 public static void main(String[] args) throws InterruptedException, IOException {
	 System.setProperty("webdriver.chrome.driver", "/Users/gokulakkannanm/Downloads/chromedriver-mac-arm64/chromedriver");
  WebDriver d= new ChromeDriver();
  d.manage().window().maximize();
  
  d.manage().deleteAllCookies();

  // Go to URL
  d.get("https://phptravels.com/demo/");
  WebDriverWait wait = new WebDriverWait(d, Duration.ofMinutes(3));
  
   // First Name
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='first_name']")));
  d.findElement(By.xpath("//input[@name='first_name']")).sendKeys("rohit");
   
  // Last Name
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='last_name']")));
  d.findElement(By.xpath("//input[@name='last_name']")).sendKeys("sharma");
  
  // Business Name
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Business Name']")));
  d.findElement(By.xpath("//input[@placeholder='Business Name']")). sendKeys("rohit sharma Business");
  
  //Email ID
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
  d.findElement(By.name("email")).sendKeys("varishini22@gmail.com");
  Thread.sleep(2000);
  
  // sum verification
  //Located number1
  WebElement number1 = d.findElement(By.xpath("//span[@id='numb1']"));
  String num1 = number1.getText();
  //Convert string into Integer
  int n1= Integer.parseInt(num1);
     
   //Located number2
  WebElement number2 = d.findElement(By.xpath("//span[@id='numb2']"));
  String num2 = number2.getText();
  int n2 = Integer.parseInt(num2);
     
   //calculate sum of two numbers
    int sum = n1+n2;
   // convert this sum into string because sendkeys method will take String as a parameter
    String sum1 = Integer.toString(sum);
     
   //Enter sum value
    d.findElement(By.id("number")).sendKeys(sum1);
   
   // Click on submit
    d.findElement(By.xpath("//button[@id='demo']")).click();
   
    //Verify that the form is submitted successfully
    WebElement f=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Request Form')]")));
    String formPageMsg=f.getText();

    WebElement fm=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='text-center cw']")));
    String formMsg=fm.getText();


    if(formPageMsg.equals("Instant Demo Request Form") && (formMsg.equals("Thank you!"))) {
     System.out.println("User registered");
    }
    else {
     System.out.println("User not registered");
    }
    Thread.sleep(1000);
    
   // Take screenshot
    File s= ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(s, new File("/Users/gokulakkannanm/Desktop/task22.jpg"));
    Thread.sleep(2000);  
    
      
    //Close the browser instance
    d.quit();

 }
}