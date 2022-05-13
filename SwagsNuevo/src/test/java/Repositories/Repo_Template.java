package Repositories;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Repo_Template {
	WebDriver driver = null;
	WebDriverWait waitt;

	public void setDriver(WebDriver d) {
		driver = d;
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	//
	public String[] get_def_txtsearch() {
	   return new String[] {"id","//input[@class='gLFyf gsfi']"};
   	};
	public WebElement get_obj_txtsearch(){		
		return driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
	}
	//
	public WebElement get_userNameImput() {
		return driver.findElement(By.xpath("//input[@id='user-name']"));
	}
	public WebElement get_passwordInput() {
		return driver.findElement(By.xpath("//input[@id='password']"));
	}
	public WebElement get_loginbtn() {
		return driver.findElement(By.xpath("//input[@id='login-button']"));
		
	}
	public WebElement get_productsTitle() {
		
		return driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
	}
	public WebElement get_addbtn(String nombreDelProducto) {
		
		return driver.findElement(By.xpath("//div[contains(text(),'"+nombreDelProducto+"')]/../../..//button"));
	}
	public WebElement get_removebtn(String nombreDelProducto) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+nombreDelProducto+"')]/../../..//button[contains(text(),'Remove')]"));
	}
	
	//CARRO
	public WebElement get_shopingLink() {
		return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	}
	
	public WebElement get_FirstNameInput() {
		return driver.findElement(By.xpath("//input[@id='first-name']"));
		
	}
	public WebElement get_LastNameInput() {
		return driver.findElement(By.xpath("//input[@id='last-name']"));
	}
	public WebElement get_PostalCodeInput() {
		return driver.findElement(By.xpath("//input[@id='postal-code']"));
	}
	public WebElement get_continueCheckoutBtn() {
		return driver.findElement(By.xpath("//input[@id='continue']"));
	}
	public WebElement get_nameProduct(String nombreProducto) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+nombreProducto+"')]"));
	}
	public WebElement get_checkoutBtn() {
		return driver.findElement(By.xpath("//button[@id='checkout']"));
	}
	public WebElement get_precioProducto(String nombreProducto) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//div[contains(text(),'"+nombreProducto+"')]/../..//div[@class='inventory_item_price']"));
	}

	
}
