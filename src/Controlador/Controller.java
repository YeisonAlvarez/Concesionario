package Controlador;

import java.util.ArrayList;

import Logica.Auto;
import Logica.Camion;
import Logica.Moto;
import Logica.Vehiculo;

public class Controller {

	Auto miAuto;
	Moto miMoto;
	Camion miCamion;

	// lista de vehiculos

	ArrayList<Vehiculo> lista_vehiculos_disponibles = new ArrayList<Vehiculo>();

	/**
	 * @return lista de vehiculos disponibles
	 */

	public ArrayList<Vehiculo> getLista_vehiculos_disponibles() {
		return lista_vehiculos_disponibles;
	}

	/**
	 * Set para lista de vehiculos
	 * @param lista_vehiculos_disponibles
	 */
	public void setLista_vehiculos_disponibles(ArrayList<Vehiculo> lista_vehiculos_disponibles) {
		this.lista_vehiculos_disponibles = lista_vehiculos_disponibles;
	}

	/**
	 * Metodo que registra un auto con todos sus parametros
	 * 
	 * @param placa
	 * @param marca
	 * @param referencia
	 * @param modelo
	 * @param precio
	 * @param num_ruedas
	 * @param num_puertas
	 * @param is_gasolina
	 * @return true or false
	 */
	public boolean registrarAuto(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int num_puertas, boolean is_gasolina) {

		miAuto = new Auto(placa, marca, referencia, modelo, precio, num_ruedas, num_puertas, is_gasolina);

		lista_vehiculos_disponibles.add(miAuto);

		return true;

	}

	/**
	 * Metodo que registra un moto con todos sus parametros
	 * 
	 * @param placa
	 * @param marca
	 * @param referencia
	 * @param modelo
	 * @param precio
	 * @param num_ruedas
	 * @param cilindraje
	 * @param tamano_tanque
	 * @return true or false
	 */
	public boolean registrarMoto(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int cilindraje, int tamano_tanque) {
		miMoto = new Moto(placa, marca, referencia, modelo, precio, num_ruedas, cilindraje, tamano_tanque);

		lista_vehiculos_disponibles.add(miMoto);

		return true;
	}

	/**
	 * Metodo que registra un camion con todos sus parametros
	 * 
	 * @param placa
	 * @param marca
	 * @param referencia
	 * @param modelo
	 * @param precio
	 * @param num_ruedas
	 * @param cap_carga
	 * @return si o registro o no
	 */
	public boolean registrarCamion(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int cap_carga) {
		miCamion = new Camion(placa, marca, referencia, modelo, precio, num_ruedas, cap_carga);

		lista_vehiculos_disponibles.add(miCamion);

		return true;

	}

}
