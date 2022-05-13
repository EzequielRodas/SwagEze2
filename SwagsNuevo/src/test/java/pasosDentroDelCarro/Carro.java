package pasosDentroDelCarro;

import CentaJava.Core.Datasources;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class Carro {

	public void ingresar(Reports report, String name, Repo_Template repo) {
		report.AddLine("se ingresa al carro");
		repo.get_shopingLink().click();
	}

	public void completarFormulario(Reports report, String name, Repo_Template repo, Datasources formularioCheckout) {
		report.AddLine("se completa el formulario con los datos correspondietes");
		
		repo.get_checkoutBtn().click();
		report.Screenshot(name);
		repo.get_FirstNameInput().sendKeys(formularioCheckout.getValueFromDataSource("nombre", 0));
		repo.get_LastNameInput().sendKeys(formularioCheckout.getValueFromDataSource("apellido", 0));
		repo.get_PostalCodeInput().sendKeys(formularioCheckout.getValueFromDataSource("codigoPostal", 0));
		report.Screenshot(name);
		repo.get_continueCheckoutBtn().click();
		
	}
	
	
	
}
