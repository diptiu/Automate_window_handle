package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{

// Navigate to URL  https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open
driver.get( "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
driver.manage().window().maximize();
String mainWindow= driver.getWindowHandle();
Thread.sleep(1000);
// switch to frame using Using Locator "XPath" //iframe[@id='iframeResult']
WebElement frame =driver.findElement(By.xpath("//*[@id='iframeResult']"));
driver.switchTo().frame(frame);
Thread.sleep(1000);
// locate try now button uing Using Locator "XPath" //button[text()='Try it']
 WebElement tryNow =driver.findElement(By.xpath("//button[text()='Try it']"));
 tryNow.click();
 Thread.sleep(3000);

// get windowhandles in a list/hashset/array  using getwindowhandles();
 Set <String> windowhandles= driver.getWindowHandles();

// print the list  print windowhandles
System.out.println("windowhandles are :"+ windowhandles);
// switch to that window using  using driver.switchTo().window(tab.get(2));
// get the url of the page  using driver.getCurrentUrl()
String url= driver.getCurrentUrl();
System.out.println("getCurrentUrl :"+ url);
// get the title of the page  using driver.getTitle()
String url2= driver.getTitle();
System.out.println("getTitle :"+ url2);
// close that tab  using driver.close()
//driver.close();
// switch to previous tab  driver.switchTo().window(newtab.get(1))
for(String window : windowhandles){
if(!window.equals(mainWindow)){
    driver.switchTo().window(window);
    driver.close();
}
}
driver.switchTo().window(mainWindow);
driver.switchTo().parentFrame();
}


}
