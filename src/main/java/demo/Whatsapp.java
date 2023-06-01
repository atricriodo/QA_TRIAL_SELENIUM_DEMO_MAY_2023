package demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Whatsapp {

  public void main(String[] args) throws InterruptedException {
    System.out.println("Entering in WhatsApp Test");
  }

  public static void runWhatsAppTest() throws InterruptedException, MalformedURLException {
    //Starting Point of Execution
    System.out.println("Entering main()");

    // Code to Launch Chrome Browser on local setup
    WebDriverManager.chromedriver().timeout(30).setup();
    ChromeDriver driver = new ChromeDriver();

    // Maximize and Implicit Wait for things to initailize
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    // Launching the URL and maximize
    driver.get("https://web.whatsapp.com/");

    //Waiting for Manual Scan if required    
    Thread.sleep(20000);

    //initialize contact name, number and message content
    String contactName = "Dad";
    String contactNumber = "+919449084285";
    String messageContent = "Hi! This is an automated message. By Kiran Suresh.";		

    //Searching for the Crio Contact
    driver.findElementByXPath("//div[@title='Search input textbox']").clear();
    driver.findElementByXPath("//div[@title='Search input textbox']").sendKeys(contactNumber);
    
    Thread.sleep(5000);
    //Selecting the Crio Contact
    driver.findElementByXPath("(//span[@title='"+contactName+"']/parent::div)[1]").click();
    
    Thread.sleep(2000);
    //Typing in the Message and Sending
    driver.findElementByXPath("//div[@title='Type a message']").clear();
    driver.findElementByXPath("//div[@title='Type a message']").sendKeys(messageContent + Keys.ENTER);

   // Exiting Main()
   System.out.println("Exiting main()");

  }
}