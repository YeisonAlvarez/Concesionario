package Logica;

import java.util.ArrayList;

public class Camion extends Vehiculo {

	private ArrayList<Vehiculo> lista_camiones_disponibles = new ArrayList<Vehiculo>();

	private ArrayList<Vehiculo> lista_camiones_vendidos = new ArrayList<Vehiculo>();

	private int cap_carga;

	/**
	 * Constructor vacio
	 */
	public Camion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de camion con todos su parametros
	 * 
	 * @param placa
	 * @param marca
	 * @param referenica
	 * @param modelo
	 * @param precio
	 * @param num_ruedas
	 * @param cap_carga
	 */
	public Camion(String placa, String marca, String referenica, String modelo, String precio, int num_ruedas,
			int cap_carga) {
		super(placa, marca, referenica, modelo, precio, num_ruedas);
		this.cap_carga = cap_carga;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Contructor con su atributo propio
	 * @param cap_carga
	 */
	public Camion(int cap_carga) {
		super();
		this.cap_carga = cap_carga;
	}

	/**
	 * get obtener capacidad de carga
	 * 
	 * @return
	 */
	public int getCap_carga() {
		return cap_carga;
	}

	/**
	 * set actualizar capacidad de carga
	 * 
	 * @param cap_carga
	 */
	public void setCap_carga(int cap_carga) {
		this.cap_carga = cap_carga;
	}

	/**
	 * get obtener camiones disponibles
	 * 
	 * @return
	 */
	public ArrayList<Vehiculo> getLista_camiones_disponibles() {
		return lista_camiones_disponibles;
	}

	/**
	 * set actualizar camiones disponibles
	 * 
	 * @param lista_camiones_disponibles
	 */
	public void setLista_camiones_disponibles(ArrayList<Vehiculo> lista_camiones_disponibles) {
		this.lista_camiones_disponibles = lista_camiones_disponibles;
	}

	/**
	 * get obtener lista camiones vendidos
	 * 
	 * @return
	 */
	public ArrayList<Vehiculo> getLista_camiones_vendidos() {
		return lista_camiones_vendidos;
	}

	/**
	 * set actualizar lista camiones vendidos
	 * 
	 * @param lista_camiones_vendidos
	 */
	public void setLista_camiones_vendidos(ArrayList<Vehiculo> lista_camiones_vendidos) {
		this.lista_camiones_vendidos = lista_camiones_vendidos;
	}

	@Override
	public String toString() {
		String cadena = "Placa: " + this.getPlaca() + "\n" + "Marca: " + this.getMarca() + "\n" + "Referencia: "
				+ this.getReferenica() + "\n" + "Modelo: " + this.getModelo() + "\n" + "Precio: $" + this.getPrecio()
				+ "\n" + "Numero de Ruedas: " + this.getNum_ruedas() + "\n" + "Capacidad de Carga: "
				+ this.getCap_carga() + "\n\n";

		return cadena;
	}

	@Override
	public double calcularDepreciacionFuturaVehiculo(double precio) {
		// TODO Auto-generated method stub
		return precio-(precio/10);
	}
}
