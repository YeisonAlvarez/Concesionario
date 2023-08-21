package Inicio;

import java.util.ArrayList;

import Logica.Auto;
import Logica.Moto;
import Logica.Vehiculo;
import Presentacion.Ventana;

/**
 * Clase main principal
 * 
 * @author Yeison Alvarez
 */
public class Principal {

	/**
	 * Main principal
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ventana miVentana = new Ventana();

		//Metodo por donde se autentica el usuario e inicia la aplicacion
		miVentana.seleccionarUsuario();

	}

}
