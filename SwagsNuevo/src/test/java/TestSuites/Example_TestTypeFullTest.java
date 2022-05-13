package TestSuites;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;

import org.junit.jupiter.api.Tag;

import TestCases.Tc2AddRemoveProducto;
import TestCases.Tc3AddRemoveProductos;
import TestCases.Tc4ProductosAgregadosAlCarro;
import TestCases.Tc5Checkout;
import TestCases.Tc6CheckoutPreciosCorrectos;
import TestCases.Tc1LoginOk;


public class Example_TestTypeFullTest 
{
	static 
	
	//Init
	DriverManager DM;
	static Datasources data;
	static Reports report;
	
	@BeforeAll
    static void initAll() {
    	//DriverManager
    	DM = new DriverManager();
    	//DataSource
    	data = new Datasources();
		//Reports
		report = new Reports();
    }
 
    @BeforeEach
    void init() {
    }
 
    @Test
    @Tag("loginOk")

    void TC1() {
    	//DEFINITIONS
    	Tc1LoginOk tc1 = new Tc1LoginOk();
    	boolean result;

    	//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "login Correcto";
		
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			result = tc1.Test(data,report,DM,x,name+"_Iteracion_"+x);
			report.addTestCaseToGeneralReport(result, name+"_Iteracion_"+x, "");
			report.saveTestCaseReport(name+"_Iteracion_"+x);
		}
    }
 
    @Test
    void TC2() {
    	//DEFINITIONS
    	Tc2AddRemoveProducto tc1 = new Tc2AddRemoveProducto();
    	boolean result;

    	//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "Tc2AddRemoveProducto";
		
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			result = tc1.Test(data,report,DM,x,name+"_Iteracion_"+x);
			report.addTestCaseToGeneralReport(result, name+"_Iteracion_"+x, "");
			report.saveTestCaseReport(name+"_Iteracion_"+x);
		}
    }
    
    @Test
    void TC3() {
    	//DEFINITIONS
    	Tc3AddRemoveProductos tc1 = new Tc3AddRemoveProductos();
    	boolean result;

    	//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("listaProductosAAgregar.xlsx");
		String name = "Productos seleccionados para agregar";
		
		
			result = tc1.Test(data,report,DM,1,name+"_Iteracion_"+1);
			report.addTestCaseToGeneralReport(result, name+"_Iteracion_"+1, "");
			report.saveTestCaseReport(name+"_Iteracion_"+1);
		
    }
    
    @Test
    void TC4() {
    	//DEFINITIONS
    	Tc4ProductosAgregadosAlCarro tc1= new Tc4ProductosAgregadosAlCarro();
    	boolean result;

    	//SET INDIVIDUAL DATASOURCE
    	Datasources listaDeProductos = new Datasources();
    	
    	listaDeProductos.setDataSourceType(data.ExcelType);
    	listaDeProductos.setDataSourceFile("listaProductosAAgregar.xlsx");
    	
		String name = "Tc4Productos agregados al carro";
	
			result = tc1.Test(listaDeProductos,report,DM,1,name+"_Iteracion_"+1);
			report.addTestCaseToGeneralReport(result, name+"_Iteracion_"+1, "");
			report.saveTestCaseReport(name+"_Iteracion_"+1);
		
    }
 
    @Test
    void TC5() {
    	//DEFINITIONS
    	Tc5Checkout tc5= new Tc5Checkout();
    	boolean result;

    	//SET INDIVIDUAL DATASOURCE
    	Datasources listaDeProductos = new Datasources();
    	Datasources formularioCheckout = new Datasources();
    	
    	listaDeProductos.setDataSourceType(data.ExcelType);
    	listaDeProductos.setDataSourceFile("listaProductosAAgregar.xlsx");
    	formularioCheckout.setDataSourceType(data.ExcelType);
    	formularioCheckout.setDataSourceFile("datosCheckout.xlsx");
    	
    	String name = "Tc5Productos agregados en el checkout";

    		result = tc5.Test(listaDeProductos,formularioCheckout,report,DM,1,name+"_Iteracion_"+1);
    		report.addTestCaseToGeneralReport(result, name+"_Iteracion_"+1, "");
    		report.saveTestCaseReport(name+"_Iteracion_"+1);
    	
    }
    
    @Test
    void TC6() {
    	//DEFINITIONS
    	Tc6CheckoutPreciosCorrectos tc5= new Tc6CheckoutPreciosCorrectos();
    	boolean result;

    	//SET INDIVIDUAL DATASOURCE
    	Datasources listaDeProductos = new Datasources();
    	Datasources formularioCheckout = new Datasources();
    	
    	listaDeProductos.setDataSourceType(data.ExcelType);
    	listaDeProductos.setDataSourceFile("listaProductosAAgregar.xlsx");
    	formularioCheckout.setDataSourceType(data.ExcelType);
    	formularioCheckout.setDataSourceFile("datosCheckout.xlsx");
    	
    	String name = "Tc5 Total a pagar";

    		result = tc5.Test(listaDeProductos,formularioCheckout,report,DM,1,name+"_Iteracion_"+1);
    		report.addTestCaseToGeneralReport(result, name+"_Iteracion_"+1, "");
    		report.saveTestCaseReport(name+"_Iteracion_"+1);
    	
    }


    @AfterEach
    void tearDown() {
    	
    }
 
    @AfterAll
    static void tearDownAll() {
    	System.out.println("Execution finished");
        report.saveGeneralReport();   
    }

}





