package Logica;

import java.util.ArrayList;

public class Auto extends Vehiculo {

	private ArrayList<Vehiculo> lista_autos_disponibles = new ArrayList<Vehiculo>();

	private ArrayList<Vehiculo> lista_autos_vendidos = new ArrayList<Vehiculo>();

	private int num_puertas;

	private boolean isGasolina;
	
	/**
	 * constructor vacio
	 */
	public Auto() {
		super();
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param placa
	 * @param marca
	 * @param referenica
	 * @param modelo
	 * @param precio
	 * @param num_ruedas
	 * @param num_puertas
	 * @param isGasolina
	 */
	public Auto(String placa, String marca, String referenica, String modelo, String precio, int num_ruedas,
			int num_puertas, boolean isGasolina) {
		super(placa, marca, referenica, modelo, precio, num_ruedas);
		this.num_puertas = num_puertas;
		this.isGasolina = isGasolina;

	}

	/**
	 * get para obtener el numero de puertas
	 * 
	 * @return
	 */
	public int getNum_puertas() {
		return num_puertas;
	}

	/**
	 * actualizar el numero de puertas
	 * 
	 * @param num_puertas
	 */
	public void setNum_puertas(int num_puertas) {
		this.num_puertas = num_puertas;
	}

	/**
	 * 
	 * @return true or false
	 */
	public boolean isGasolina() {
		return isGasolina;
	}

	/**
	 * set actuaizar si es a gasolina o no
	 * 
	 * @param isGasolina
	 */
	public void setGasolina(boolean isGasolina) {
		this.isGasolina = isGasolina;
	}

	/**
	 * get para obtener la lista de vehiculos disponibles
	 * 
	 * @return lista de vehiculos disponibles
	 */
	public ArrayList<Vehiculo> getLista_autos_disponibles() {
		return lista_autos_disponibles;
	}

	/**
	 * set para actualizar la lista de vehiculos disponibles
	 * 
	 * @param lista_autos_disponibles
	 */
	public void setLista_autos_disponibles(ArrayList<Vehiculo> lista_autos_disponibles) {
		this.lista_autos_disponibles = lista_autos_disponibles;
	}

	/**
	 * get para obtener la lista de vehiculos vendidos
	 * 
	 * @return
	 */
	public ArrayList<Vehiculo> getLista_autos_vendidos() {
		return lista_autos_vendidos;
	}

	/**
	 * set para actualizar la lista de vehiculos vendidos
	 * 
	 * @param lista_autos_vendidos
	 */
	public void setLista_autos_vendidos(ArrayList<Vehiculo> lista_autos_vendidos) {
		this.lista_autos_vendidos = lista_autos_vendidos;
	}

	

	@Override
	public String toString() {
		String cadena = "Placa: " + this.getPlaca() + "\n" + "Marca: " + this.getMarca() + "\n" + "Referencia: "
				+ this.getReferenica() + "\n" + "Modelo: " + this.getModelo() + "\n" + "Precio: $" + this.getPrecio()
				+ "\n" + "Numero de Ruedas: " + this.getNum_ruedas() + "\n" + "Numero de Puertas: "
				+ this.getNum_puertas() + "\n" + "Es a Gasolina: " + this.isGasolina() + "\n\n";

		return cadena;
	}

	@Override
	public double calcularDepreciacionFuturaVehiculo(double precio) {
		// TODO Auto-generated method stub
		return precio-(precio/5);
	}

}
