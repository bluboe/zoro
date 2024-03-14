SECOND WEEK CODE CHALLENGE

EMI calculator

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class EMICalculator {
    
    // Declaring variables
	static WebDriver driver;

    public static String alertMessage;
    
    public WebDriver createDriver() {
        driver = DriverSetup.getDriver();
        return driver;
	    //Create a driver using the class 'DriverSetup'. Assign it to static variable 'driver' and return it.
	}
    
    public Alert clickAlert() {
        
        //Locate the 'click' button and click. Click 'ok' in the 'Alert' box. 
        //Assign the message in 'Alert' in the static variable 'alertMessage'
        //Return the web element reference of the 'Alert'
        
        driver.get("http://webapps.tekstac.com/FormRegistration/indexemi.html");
    WebElement clickButton = driver.findElement(By.xpath("//input[@value='Click']"));
    clickButton.click();
    Alert alert = driver.switchTo().alert();
    alertMessage = alert.getText(); // Get the text before accepting the alert
    alert.accept();
    return alert;
        
    }
    
    public WebElement invokePrompt(String userName) throws Exception { 
        driver.get("http://webapps.tekstac.com/FormRegistration/EMICalculator.html");
        WebElement nameLink = driver.findElement(By.id("demo"));
nameLink.click();
        Thread.sleep(1000); // Wait for the prompt to appear
        driver.switchTo().alert().sendKeys(userName);
        driver.switchTo().alert().accept();
return driver.findElement(By.id("demo")); 
        //Navigate to the URL 'http://webapps.tekstac.com/FormRegistration/EMICalculator.html'  
        
        
        //In the EMI calculation page, locate 'click ON ME to enter your name' message and click to open prompt.
        //Enter user name
        //Locate the 'Hello, XXXXX' user message and return the web element
        
    }
    
    public WebElement calculateEMI(String amount,String year,String roi) throws Exception { 

        //Pass values to calculate emi.
        //Locate the form element and submit for emi calculation
        //Return the web element of the calculated emi message
        WebElement amountField = driver.findElement(By.id("amount"));
    WebElement yearField = driver.findElement(By.id("year"));
    WebElement roiField = driver.findElement(By.id("roi"));
    WebElement calculateButton = driver.findElement(By.xpath("//input[@value='calculate']"));

    amountField.sendKeys(amount);
    yearField.sendKeys(year);
    roiField.sendKeys(roi);
    calculateButton.click();

    // Wait up to 10 seconds
    WebDriverWait wait = new WebDriverWait(driver, 10);
    Alert emiAlert = wait.until(ExpectedConditions.alertIsPresent());
    alertMessage = emiAlert.getText();
    emiAlert.accept();
        
    return driver.findElement(By.id("msg"));
    }
   
    
    public void closeBrowser() {
        driver.quit();
        //close the driver
    }
    
    public static void main(String args[]) throws Exception {

        EMICalculator win = new EMICalculator();
        win.createDriver();
        
        // Implement your code here
        win.clickAlert();
        System.out.println("Alert Message: " + alertMessage);
 
        // ChildURL Scenario
        WebElement userNameElement = win.invokePrompt("John");
        System.out.println("User Name Element Text: " + userNameElement.getText());
 
        WebElement emiAmountElement = win.calculateEMI("6000", "2", "2");
        System.out.println("EMI Amount: " + emiAmountElement.getText());
 
        win.closeBrowser();
        
    }
    
}

----------------------------------------------------------------------------------------------------------------------

Commodity Details New


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;		



public class JavaScriptExecutor {
    WebDriver driver;

    public WebDriver createDriver() {
        this.driver = DriverSetup.getWebDriver();
        return driver;
    }

    public void submitForm(String name, int weight, int length, int width, int height) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('name').value='" + name + "';");
        js.executeScript("document.getElementById('weight').value='" + weight + "';");
        js.executeScript("document.getElementById('length').value='" + length + "';");
        js.executeScript("document.getElementById('width').value='" + width + "';");
        js.executeScript("document.getElementById('height').value='" + height + "';");
        js.executeScript("document.querySelector('#add').click();");
    }

    public String getNoOfCommodity() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return document.getElementById('count').value;");
    }

    public String getWeightTotal() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return document.getElementById('total').value;");
    }

    public Object getCommodityName() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.querySelector('#myTable > tbody > tr:nth-child(2) > td:nth-child(1)').innerText;");
    }

    public Object getCommodityWeight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.querySelector('#myTable > tbody > tr:nth-child(2) > td:nth-child(2)').innerText;");
    }

    public Object getCommodityLength() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.querySelector('#myTable > tbody > tr:nth-child(2) > td:nth-child(3)').innerText;");
    }

    public Object getCommodityWidth() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.querySelector('#myTable > tbody > tr:nth-child(2) > td:nth-child(4)').innerText;");
    }

    public Object getCommodityHeight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.querySelector('#myTable > tbody > tr:nth-child(2) > td:nth-child(5)').innerText;");
    }

    public static void main(String[] args) {
        JavaScriptExecutor executor = new JavaScriptExecutor();
        executor.createDriver();
        executor.submitForm("Commodity1", 70, 150, 75, 160);
        System.out.println(executor.getCommodityName());
        System.out.println(executor.getCommodityWeight());
        System.out.println(executor.getCommodityLength());
        System.out.println(executor.getCommodityWidth());
        System.out.println(executor.getCommodityHeight());
        System.out.println(executor.getNoOfCommodity());
        System.out.println(executor.getWeightTotal());
    }
}

------------------------------------------------------------------------------------------------------------------------------------------
Cargo Shipping (Partial success)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class CustomizedXpath {
    static WebDriver driver;
    static int textBoxCount, labelsCount, buttonCount, radiobuttonCount, linkCount;
    static String result;
    static List<WebElement> textBoxList, labelsList, buttonList, radioButtonList, linksList;
    By textBoxXpath, labelXpath1, labelXpath2, buttonXpath, radioButtonXpath, linkXpath1, linkXpath2;
    public WebDriver setDriver() {
        driver = DriverSetup.getDriver();
        return driver;
    }
    public void setNewFormValues(String weight, String transportMode) {
WebElement weightField = driver.findElement(By.xpath("//input[@id='weight']"));
        weightField.clear();
        weightField.sendKeys(weight);
        WebElement transportModeField = driver.findElement(By.xpath("//input[@type='radio'][@id='" + transportMode + "']"));
transportModeField.click();
        WebElement calculateButton = driver.findElement(By.xpath("//button[@id='calculate']"));
calculateButton.click();
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='result']"));
        result = successMessage.getText();
    }
    public List<WebElement> textBoxCount() {
        textBoxList = driver.findElements(By.xpath("//input[@type='text']"));
        textBoxCount = textBoxList.size();
        return textBoxList;
    }
    public List<WebElement> labelsCount() {
        labelsList = driver.findElements(By.xpath("/html/body/center/table/tbody/tr[1]/td[1]"));
        labelsList.addAll(driver.findElements(By.xpath("/html/body/center/table/tbody/tr[2]/td[1]")));
        labelsCount = labelsList.size();
        return labelsList;
    }
    public List<WebElement> buttonCount() {
        buttonList = driver.findElements(By.xpath("//button[@type='button']"));
        buttonCount = buttonList.size();
        return buttonList;
    }
    public List<WebElement> radiobuttonCount() {
        radioButtonList = driver.findElements(By.xpath("//input[@type='radio']"));
        radiobuttonCount = radioButtonList.size();
        return radioButtonList;
    }
    public List<WebElement> linkCount() {
        linksList = driver.findElements(By.xpath("//a[@id='signup']"));
        linksList.addAll(driver.findElements(By.xpath("//a[@id='login']")));
        linkCount = linksList.size();
        return linksList;
    }
    public void closeBrowser() {
        driver.quit();
    }
    public static void main(String[] args) {
        CustomizedXpath printOptions = new CustomizedXpath();
        printOptions.setDriver();
        System.out.println("Total number of text boxes: " + printOptions.textBoxCount().size());
        System.out.println("Total number of labels: " + printOptions.labelsCount().size());
        System.out.println("Total number of buttons: " + printOptions.buttonCount().size());
        System.out.println("Total number of radio buttons: " + printOptions.radiobuttonCount().size());
        System.out.println("Total number of links: " + printOptions.linkCount().size());
        printOptions.setNewFormValues("100", "Air");
        printOptions.closeBrowser();
    }
}

-------------------------------------------------------------------------------------------------------------------------------
Users New - JavaScript Executor

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutor {   // Do not change the class name
	
	public WebDriver driver;
	public static Object jsname, jsaddress, jsmobileno, jssubmit, jsmail;
	
	public WebDriver createDriver() {
	    this.driver = DriverSetup.getWebDriver();
	    return driver;
	}
 
    public String setUserDetails(String name,String address, String mobileno, String mail){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName('name')[0].value='" + name + "'");
        js.executeScript("document.getElementsByName('address')[0].value='" + address + "'");
        js.executeScript("document.getElementsByName('mobile')[0].value='" + mobileno + "'");
        js.executeScript("document.getElementsByName('email')[0].value='" + mail + "'");
        js.executeScript("document.getElementsByName('Submit')[0].click()");
        WebElement message = (WebElement) js.executeScript("return document.querySelector('#result')");
        return message.getText();
    }
    
    public void refreshPage() {
        driver.navigate().refresh();
    }
    
    public String getNameErrorMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement errorMessage = (WebElement) js.executeScript("return document.querySelector('#nameWarning')");
        return errorMessage.getText();
    }
    
    public String getMobileErrorMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement errorMessage = (WebElement) js.executeScript("return document.querySelector('#mobileWarning')");
        return errorMessage.getText();
    }
    
    public String getEmailErrorMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement errorMessage = (WebElement) js.executeScript("return document.querySelector('#emailWarning')");
        return errorMessage.getText();
    }
    
    
    public static void main(String[] args) {
	  	JavaScriptExecutor at=new JavaScriptExecutor();
		at.createDriver();
		at.setUserDetails("Steven", "Coimbatore", "2139495624", "steve@ca.com");
		at.refreshPage();
		at.setUserDetails("", "", "", "");
		System.out.println(at.getNameErrorMessage());
		System.out.println(at.getMobileErrorMessage());
		System.out.println(at.getEmailErrorMessage());
	}
}

-------------------------------------------------------------------------------------------------------------------------


