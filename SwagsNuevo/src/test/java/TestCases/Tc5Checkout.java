package TestCases;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;
import pasos.AgregarVariosProductos;
import pasos.Login;
import pasosDentroDelCarro.Carro;

public class Tc5Checkout {
WebDriver driver;
	
	public boolean Test(Datasources listaProductos,Datasources formularioCheckout, Reports report, DriverManager DM,int iteration, String name) {
		
		boolean result = true;
		try {			
			System.out.println("Configuring");
			//INSTANCIAS
			Login login= new Login();
			AgregarVariosProductos agregarVariosProductos = new AgregarVariosProductos();
			Carro carro=new Carro();
			
			
			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);
			
			//SET THE REPOSITORIES TO USE
			Repo_Template repo = new Repo_Template();
			repo.setDriver(driver);
			
			System.out.println("Initializating test");

			//ADD THE STEPS BELOW
			login.loginOk(report,driver,name,repo,"standard_user","secret_sauce");
			agregarVariosProductos.agregar(report,name,repo,listaProductos);
			carro.ingresar(report,name,repo);
			carro.completarFormulario(report,name,repo,formularioCheckout);

			//ADD VALIDATIONS AT THE END
			report.AddLine("Se verifica que esten los: "+listaProductos.getTotalIterations()+" productos agregados en el Checkout");
			
			result=this.validacion(report,name,repo,listaProductos);
			
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

	private boolean validacion(Reports report, String name, Repo_Template repo,
			Datasources listaProductos) {
		boolean validaciones=true;
		
		
		for(int x=0;x<listaProductos.getTotalIterations();x++) {
			validaciones = validaciones&&report.validateObjectIsDisplayable(repo.get_nameProduct(listaProductos.getValueFromDataSource("nombreProducto", x)));
		}
		report.Screenshot(name);
		return validaciones;
	}

}
