package pasos;

import CentaJava.Core.Datasources;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class AgregarVariosProductos {
	AgregarUnProducto agregarUnProducto = new AgregarUnProducto();

	
	public void agregar(Reports report, String name, Repo_Template repo, Datasources data) {
		report.AddLine("se agregan: "+data.getTotalIterations()+"productos");
		
		for(int x=0; x<data.getTotalIterations();x++) {
			agregarUnProducto.agregar(report, name, repo, data.getValueFromDataSource("nombreProducto", x));
		}
			
	}

}
