package pasos;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class Login {

	public void loginOk(Reports report, WebDriver driver, String name, Repo_Template repo, String usuario,
			String contrasenia) {
		driver.get("https://www.saucedemo.com/");
		
		report.AddLine("Se ingresa a la pagina saucedemo.com");
		report.AddLine("Se ingresa nombre de usuario: "+usuario+" y contrasenia:"+contrasenia);
		repo.get_userNameImput().sendKeys(usuario);
		repo.get_passwordInput().sendKeys(contrasenia);
		report.Screenshot(name);
		report.AddLine("se hace click en login");
		repo.get_loginbtn().click();
		
		
		
	}

}
