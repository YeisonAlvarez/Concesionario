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
	 * Este metodo busca un vehiculo por su placa
	 * 
	 * @param placa_busqueda
	 * @return un objeto de tipo de vehiculo que corresponde al vehiculo encontrado
	 */

	public ArrayList<Vehiculo> getLista_vehiculos_disponibles() {
		return lista_vehiculos_disponibles;
	}

	public void setLista_vehiculos_disponibles(ArrayList<Vehiculo> lista_vehiculos_disponibles) {
		this.lista_vehiculos_disponibles = lista_vehiculos_disponibles;
	}

	public Vehiculo buscarPorPlaca(String placa_busqueda) {

		for (int i = 0; i < miAuto.getLista_autos_disponibles().size(); i++) {

			if (miAuto.getLista_autos_disponibles().get(i).getPlaca().equals(placa_busqueda)) {

				return miAuto.getLista_autos_disponibles().get(i);
			}

		}
		return null;
	}

	/**
	 * Este metodo busca un vehiculo por su marca
	 * 
	 * @param marca_busqueda
	 * @return un ArrayList con los vehiculos que tengas la misma marca buscada
	 */
	public ArrayList<Vehiculo> buscarPorMarca(String marca_busqueda) {

		ArrayList lista_vehiculos_encontrados = new ArrayList<Vehiculo>();

		for (int i = 0; i < lista_vehiculos_disponibles.size(); i++) {

			if (lista_vehiculos_disponibles.get(i).getMarca().equals(marca_busqueda)) {

				lista_vehiculos_encontrados.add(lista_vehiculos_disponibles.get(i));
			}

		}

		return lista_vehiculos_encontrados;
	}

	/**
	 * Este metodo busca vehiculo por referencia
	 * 
	 * @param referencia_busqueda
	 * @return un arraylist con los vehiculos que cuentan con la misma referencia
	 *         buscada
	 */
	public ArrayList<Vehiculo> buscarPorReferencia(String referencia_busqueda) {

		ArrayList lista_vehiculos_referencia = new ArrayList<Vehiculo>();

		for (int i = 0; i < lista_vehiculos_disponibles.size(); i++) {

			if (lista_vehiculos_disponibles.get(i).getReferenica().equals(referencia_busqueda)) {

				lista_vehiculos_referencia.add(lista_vehiculos_disponibles.get(i));
			}

		}

		return lista_vehiculos_referencia;
	}

	/**
	 * Este metodo busca vehiculo por modelo
	 * 
	 * @param referencia_busqueda
	 * @return un arraylist con los vehiculos que cuentan con el mismo modelo
	 *         buscado
	 */
	public ArrayList<Vehiculo> buscarPorModelo(String modelo_busqueda) {

		ArrayList lista_vehiculos_modelo = new ArrayList<Vehiculo>();

		for (int i = 0; i < lista_vehiculos_disponibles.size(); i++) {

			if (lista_vehiculos_disponibles.get(i).getReferenica().equals(modelo_busqueda)) {

				lista_vehiculos_modelo.add(lista_vehiculos_disponibles.get(i));
			}

		}

		return lista_vehiculos_modelo;
	}

	/**
	 * Este metodo busca un vehiculo por precio
	 * 
	 * @param referencia_busqueda
	 * @return un arraylist con los vehiculos que cuentan con el mismo precio
	 *         buscado
	 */
	public ArrayList<Vehiculo> buscarPorPrecio(int precio_busqueda) {

		ArrayList lista_vehiculos_precio = new ArrayList<Vehiculo>();

		for (int i = 0; i < lista_vehiculos_disponibles.size(); i++) {

			if (lista_vehiculos_disponibles.get(i).getReferenica().equals(precio_busqueda)) {

				lista_vehiculos_precio.add(lista_vehiculos_disponibles.get(i));
			}

		}

		return lista_vehiculos_precio;
	}

	/**
	 * Este metodo permite listar todos los vehiculos disponibles
	 * 
	 * @return el listado con todos los vehiculos disponibles
	 */
	public ArrayList<Vehiculo> listarVehiculos() {

		return miAuto.getLista_autos_disponibles();
	}

	public int getMotosDisponibles() {
		return 0;
	}

	public int getAutosDisponibles() {
		return 0;
	}

	public int getCamionesDisponibles() {
		return 0;
	}

	public int getMotosVendidas() {
		return 0;
	}

	public int getAutosVendidos() {
		return 0;
	}

	public int getCamionesVendidos() {
		return 0;
	}

	public boolean registrarAuto(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int num_puertas, boolean is_gasolina) {

		miAuto = new Auto(placa, marca, referencia, modelo, precio, num_ruedas, num_puertas, is_gasolina);

		lista_vehiculos_disponibles.add(miAuto);

		return true;

	}

	public boolean registrarMoto(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int cilindraje, int tamano_tanque) {
		miMoto = new Moto(placa, marca, referencia, modelo, precio, num_ruedas, cilindraje, tamano_tanque);

		lista_vehiculos_disponibles.add(miMoto);

		return true;
	}

	public boolean registrarCamion(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int cap_carga) {
		miCamion = new Camion(placa, marca, referencia, modelo, precio, num_ruedas, cap_carga);

		lista_vehiculos_disponibles.add(miCamion);

		return true;

	}



}
