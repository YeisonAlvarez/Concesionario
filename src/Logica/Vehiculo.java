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

	/**
	 * 
	 * @param placa
	 * @param marca
	 * @param referenica
	 * @param modelo
	 * @param precio
	 * @param num_ruedas
	 */

	public Vehiculo(String placa, String marca, String referenica, String modelo, String precio, int num_ruedas) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.referenica = referenica;
		this.modelo = modelo;
		this.precio = precio;
		this.num_ruedas = num_ruedas;
	}

	/**
	 * 
	 * @return String placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Actualizar placa
	 * 
	 * @param placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * obtener marca
	 * 
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * set actualizar marca
	 * 
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * get obtener la referencia
	 * 
	 * @return referencia
	 */
	public String getReferenica() {
		return referenica;
	}

	/**
	 * set actualizar referencia
	 * 
	 * @param referenica
	 */
	public void setReferenica(String referenica) {
		this.referenica = referenica;
	}

	/**
	 * get obtener el modelo
	 * 
	 * @return Modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * set actualizar modelo
	 * 
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * get obtener el precio
	 * 
	 * @return String precio
	 */
	public String getPrecio() {
		return precio;
	}

	/**
	 * set actualizar precio
	 * 
	 * @param precio
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	/**
	 * get obtener numero de ruedas
	 * 
	 * @return int numero ruedas
	 */
	public int getNum_ruedas() {
		return num_ruedas;
	}

	/**
	 * set actualizar numero de ruedas
	 * 
	 * @param num_ruedas
	 */
	public void setNum_ruedas(int num_ruedas) {
		this.num_ruedas = num_ruedas;
	}


	/**
	 * Se sobreescribe el metodo tostring para cada vehiculo
	 */
	public abstract String toString();
	
	/**
	 * Este metodo calcula el valor futuro del vehiculo depues de depreciacion, teniendo en cuenta lo siguiente:
	 * vida util auto: 5 años
	 * vida util moto: 2 años
	 * vida util camion: 10 años
	 * @return el precio luego de la depreciacion
	 */
	public abstract double calcularDepreciacionFuturaVehiculo(double precio);

}
