package Logica;

import java.util.ArrayList;

public class Moto extends Vehiculo {

	private ArrayList<Vehiculo> lista_motos_disponibles = new ArrayList<Vehiculo>();

	private ArrayList<Vehiculo> lista_motos_vendidos = new ArrayList<Vehiculo>();
	private int cilindraje;
	private int tamano_tanque;

	/**
	 * Contructor vacio
	 */
	public Moto() {
		super();
	}

	/**
	 * Constructor de la moto con todos los parametros
	 * 
	 * @param placa
	 * @param marca
	 * @param referenica
	 * @param modelo
	 * @param precio
	 * @param num_ruedas
	 * @param cilindraje
	 * @param tamano_tanque
	 */
	public Moto(String placa, String marca, String referenica, String modelo, String precio, int num_ruedas,
			int cilindraje, int tamano_tanque) {
		super(placa, marca, referenica, modelo, precio, num_ruedas);
		cilindraje = cilindraje;
		this.tamano_tanque = tamano_tanque;

	}

	/**
	 * get obtener el cilindraje
	 * 
	 * @return
	 */
	public int getCilindraje() {
		return cilindraje;
	}

	/**
	 * set actualizar el cilindraje
	 * 
	 * @param cilindraje
	 */
	public void setCilindraje(int cilindraje) {
		cilindraje = cilindraje;
	}

	/**
	 * get obtener tamaño del tanque
	 * 
	 * @return int tamaño del tanque
	 */
	public int getTamano_tanque() {
		return tamano_tanque;
	}

	/**
	 * set actualizar el tamaño del tanque
	 * 
	 * @param tamano_tanque
	 */
	public void setTamano_tanque(int tamano_tanque) {
		this.tamano_tanque = tamano_tanque;
	}

	/**
	 * get par obtener lista de motos disonibles
	 * 
	 * @return
	 */
	public ArrayList<Vehiculo> getLista_motos_disponibles() {
		return lista_motos_disponibles;
	}

	/**
	 * set para actualizar la lista de motos disponible
	 * 
	 * @param lista_motos_disponibles
	 */
	public void setLista_motos_disponibles(ArrayList<Vehiculo> lista_motos_disponibles) {
		this.lista_motos_disponibles = lista_motos_disponibles;
	}

	/**
	 * get para obtener la lista de las motos vendidas
	 * 
	 * @return
	 */
	public ArrayList<Vehiculo> getLista_motos_vendidos() {
		return lista_motos_vendidos;
	}

	/**
	 * set actualizar lista de motos vendidas
	 * 
	 * @param lista_motos_vendidos
	 */
	public void setLista_motos_vendidos(ArrayList<Vehiculo> lista_motos_vendidos) {
		this.lista_motos_vendidos = lista_motos_vendidos;
	}

	@Override
	public String toString() {

		String cadena = "Placa: " + this.getPlaca() + "\n" + "Marca: " + this.getMarca() + "\n" + "Referencia: "
				+ this.getReferenica() + "\n" + "Modelo: " + this.getModelo() + "\n" + "Precio: $" + this.getPrecio()
				+ "\n" + "Numero de Ruedas: " + this.getNum_ruedas() + "\n" + "Cilindraje: " + this.getCilindraje()
				+ "\n" + "Tamaño del tanque: " + this.getTamano_tanque() + "\n\n";

		return cadena;
	}

	@Override
	public double calcularDepreciacionFuturaVehiculo(double precio) {
		// TODO Auto-generated method stub
		return precio-(precio/2);
	}
}
