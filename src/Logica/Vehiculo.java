package Logica;

import java.util.ArrayList;

public abstract class Vehiculo {

	private String placa;

	private String marca;

	private String referenica;

	private String modelo;

	private String precio;

	private int num_ruedas;

	public Vehiculo() {
		super();
	}

	public Vehiculo(String placa, String marca, String referenica, String modelo, String precio, int num_ruedas) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.referenica = referenica;
		this.modelo = modelo;
		this.precio = precio;
		this.num_ruedas = num_ruedas;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getReferenica() {
		return referenica;
	}

	public void setReferenica(String referenica) {
		this.referenica = referenica;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public int getNum_ruedas() {
		return num_ruedas;
	}

	public void setNum_ruedas(int num_ruedas) {
		this.num_ruedas = num_ruedas;
	}

	/**
	 * Este metodo registra un vehiculo
	 * 
	 * @param vehiculo_nuevo
	 * @return true or false si el registro fue exitoso o no
	 */
	public  abstract boolean registarVehiculo(Vehiculo vehiculo_nuevo);

	/**
	 * Este metodo permmite vender un vehiculo y eliminarlo de la lista de
	 * disponibles
	 * 
	 * @param vehiculo_comprado
	 * @return true or false si se vendio el vehiculo o no
	 */
	public abstract boolean venderVehiculo(Vehiculo vehiculo_comprado) ;
	

	public abstract String toString();

}
