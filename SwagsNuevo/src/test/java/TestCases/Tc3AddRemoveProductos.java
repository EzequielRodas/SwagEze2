package TestCases;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;
import pasos.AgregarVariosProductos;
import pasos.Login;

public class Tc3AddRemoveProductos {
	WebDriver driver;
	
	public boolean Test(Datasources data,Reports report, DriverManager DM,int iteration, String name) {
		
		boolean result = true;
		try {			
			System.out.println("Configuring");
			//INSTANCIAS
			Login login= new Login();
			AgregarVariosProductos agregarVariosProductos = new AgregarVariosProductos();
			
			
			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);
			
			//SET THE REPOSITORIES TO USE
			Repo_Template repo = new Repo_Template();
			repo.setDriver(driver);
			
			System.out.println("Initializating test");

			//ADD THE STEPS BELOW
			login.loginOk(report,driver,name,repo,"standard_user","secret_sauce");
			agregarVariosProductos.agregar(report,name,repo,data);
			
			//ADD VALIDATIONS AT THE END
			
			result=this.validacion(report,name,repo,data);
			
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

	private boolean validacion(Reports report, String name, Repo_Template repo, Datasources data) {

		boolean validaciones=true;
		for(int x=0;x<data.getTotalIterations();x++) {
			validaciones = validaciones&&report.validateObjectIsDisplayable(repo.get_removebtn(data.getValueFromDataSource("nombreProducto", x)));
		}
		return validaciones;
	}
}
