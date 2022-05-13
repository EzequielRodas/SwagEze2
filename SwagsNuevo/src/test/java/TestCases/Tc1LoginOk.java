package TestCases;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;
import pasos.Login;

//Modificado
public class Tc1LoginOk {
	WebDriver driver;

	public boolean Test(Datasources data,Reports report, DriverManager DM, int iteration,String name) {
	
		boolean result = true;
		try {			
			System.out.println("Configuring");
			//INSTANCIAS
			Login login= new Login();
			
			
			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);
			
			//SET THE REPOSITORIES TO USE
			Repo_Template repo = new Repo_Template();
			repo.setDriver(driver);
			
			System.out.println("Initializating test");

			//ADD THE STEPS BELOW

			login.loginOk(report,driver,name,repo,"standard_user","secret_sauce");			
			
			//ADD VALIDATIONS AT THE END
			
			result=report.validateObjectIsDisplayable(repo.get_productsTitle());
			
		} catch (Exception e) {
	        e.printStackTrace();
			report.AddLineAssertionError(e.getStackTrace()[0].toString());
			report.AddLineAssertionError(e.getMessage());
			report.Screenshot(name);
			result = false;
			}
		//Try to erase the driver
		try {
			driver.quit();}
			catch(Exception e2) {}
		//return the test result
		return result;
	}
	
	private void WaitTime(int i) {
		try
		{
		    Thread.sleep(i);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
 
}
