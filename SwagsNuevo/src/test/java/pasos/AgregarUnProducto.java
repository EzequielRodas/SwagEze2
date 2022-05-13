package pasos;


import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class AgregarUnProducto {

	public void agregar(Reports report, String name, Repo_Template repo, String nombreDelProducto) {
		report.AddLine("se agrega el producto: "+nombreDelProducto);
		repo.get_addbtn(nombreDelProducto).click();
		report.Screenshot(name);
	}

}
