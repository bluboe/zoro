
package Quora_search;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class quoraSearch 
{
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver dr = new ChromeDriver();
		
	//	Quora Search
		//	Case Study: Quora Search
			//	Problem Statement
			//	Automate the search in Quora and verify the results.
			//	Suggested site: https://www.quora.com/profile/Quora
		
		
	//	Detailed Description:
		
		//	•	Launch the browser and open the Quora site using the given URL.
		dr.get("https://www.quora.com/profile/Quora");
		dr.manage().window().maximize();
		Thread.sleep(2000);
		
		
		//	•	Verify the title “Quora” is present or not on the webpage.
		String expTitle = "Quora";
		String actTitle = dr.getTitle();
		
		if (actTitle.contains(expTitle))
		{
			if (actTitle.equals(expTitle))
			{
				System.out.println("Test for Title is passed. Title is an exact match.");
			}
			else 
			{
			System.out.println("Test for Title is passed. Title contains expected values, but is not an exact match.");
			}
		}
		else {
			System.out.println("Test for Title failed");
		}
		Thread.sleep(2000);
		
		
//			•	In the section “Credentials & Highlights” print all the detail list displayed screen.
		
		String credAndHead;
		//credAndHead=dr.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[1]/div/div[1]/div")).getText();
		credAndHead=dr.findElement(By.xpath("//div[text()='Credentials & Highlights']")).getText();
		System.out.println("\n" +credAndHead);
		
		
			//Lived In
		String livedInText;
		livedInText=dr.findElement(By.xpath("//span[contains(text(),'Lived in ')]")).getText();
//		livedInText = dr.findElement(By.xpath
//				("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/span")
//				).getText(); 
		System.out.println("  " +livedInText);
		
			//Content views
		String contV=dr.findElement(By.xpath
				("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/span[1]")
				).getText();
		String contV2=dr.findElement(By.xpath
				("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/span[2]")
				).getText();
		System.out.println("  " + contV + " : " + contV2);
		
			//Active in
		String actIn=dr.findElement(By.xpath
				("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[3]/div[2]/span")
				).getText();
		System.out.println("  " + actIn);
		
			//Date join
		String dtJoin=dr.findElement(By.xpath
				("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/span")
				).getText();
		System.out.println("  " + dtJoin);

		Thread.sleep(2000);
		
		
		//	•	Scroll down and in the section “Spaces” print all the detail list displayed screen.

		
		

			int n=1;
			
			//find view more
			//WebElement viewMore=dr.findElement(By.partialLinkText("View more"));
			WebElement viewMore=dr.findElement(By.xpath
					("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[3]/div/div[6]/div/div/div/div/button"));
			Thread.sleep(1000);
			
			while (n==1)
			{
				try 
					{
									
					//scroll*******
					((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",viewMore); 
					System.out.println("Scrolled");	//Print scrolled
					Thread.sleep(2000);
					
					//click********
					JavascriptExecutor executor = (JavascriptExecutor) dr;
					executor.executeScript("arguments[0].click();", viewMore); //click 'view more'
					System.out.println("Scrolled and clicked");		//print scrolled and clicked
					System.out.println(n);
					}
				catch(StaleElementReferenceException e) 
					{
					  //  Block of code to handle errors
						n=2;
						
						//print Spaces content*******
						Thread.sleep(2000);
						String spacesHead=dr.findElement(By.xpath
								("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div")
								).getText();
						System.out.println("\n"+ spacesHead);
						String spacesElem=dr.findElement(By.xpath
								("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[3]/div")
								).getText();
						System.out.println("\n" + spacesElem);
					}
			}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//try to click on the view more button	
//		//WebElement viewMore=dr.findElement(By.partialLinkText("View more"));
//		WebElement viewMore=dr.findElement(By.xpath
//				("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[3]/div/div[6]/div/div/div/div/button"));
//		Thread.sleep(1000);
//		
//		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",viewMore); 
//		System.out.println("Scrolled");
//		Thread.sleep(2000);
//		
//		JavascriptExecutor executor = (JavascriptExecutor) dr;
//		executor.executeScript("arguments[0].click();", viewMore); //click 'view more'
//		 
//		 
//		//viewMore.click();
//		System.out.println("Scrolled and clicked");
//
//		
//		Thread.sleep(2000);
//		String spacesHead=dr.findElement(By.xpath
//				("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div")
//				).getText();
//		System.out.println("\n"+ spacesHead);
//		String spacesElem=dr.findElement(By.xpath
//				("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[3]/div")
//				).getText();
//		System.out.println("\n" + spacesElem);
//		
		
		
		
		
		
		
		//	•	Click on “sign In” link
		dr.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[2]/div/div[2]/div/button/div/div/div")).click();
		Thread.sleep(3000);
		
		
		//	•	In the prompt, click on “Sign up with email” link.
		dr.findElement(By.xpath
				("//*[@id='root']/div/div[2]/div[2]/div/div/div[2]/div/span/span[4]/div")
				).click();
		Thread.sleep(3000);
		
		
		//	•	Verify if the “Next” button is disabled.
		String nxtButton = dr.findElement(By.xpath("//*[@id=\'root\']/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/button/div/div/div")).getText();
		//System.out.println(nxtButton);
		System.out.println("\n");
		
		WebElement nextButton = dr.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/button"));
		boolean chNextButton = nextButton.isEnabled();
		if (chNextButton == true) 
			{
				System.out.println(nxtButton + " button is enabled.");
			}else
			{
				System.out.println(nxtButton +" button is disabled.");
			}
		
		//	•	Enter an invalid mail in Email field (ex: abc@abc)
		dr.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("abc@abc");
		Thread.sleep(3000);
		
		//	•	Verify and capture the respective error message shown.
		String errorMsg = dr.findElement(By.xpath("//*[@id=\"form-field-error:19\"]/div")).getText();
		System.out.println("Error message: " + errorMsg);
		

		//	•	Close the browser.
		Thread.sleep(4000);
		//dr.close();
		dr.quit();
		System.out.println("Browser closed.");
		
			
			
	//	Key Automation Scope:
		//	•	Do the automation for more than one browser.
		//	•	Handle the Exceptions
		//	•	Verify if the title matches with the search topic.
		//	•	Handle multiple windows.
		//	•	Capture screen.

	}

}
