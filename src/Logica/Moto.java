package Logica;

import java.util.ArrayList;

public class Moto extends Vehiculo {

	private ArrayList<Vehiculo> lista_motos_disponibles = new ArrayList<Vehiculo>();

	private ArrayList<Vehiculo> lista_motos_vendidos = new ArrayList<Vehiculo>();
	private int cilindraje;
	private int tamano_tanque;

	public Moto() {
		super();
	}

	public Moto(String placa, String marca, String referenica, String modelo, String precio, int num_ruedas,
			int cilindraje, int tamano_tanque) {
		super(placa, marca, referenica, modelo, precio, num_ruedas);
		cilindraje = cilindraje;
		this.tamano_tanque = tamano_tanque;

	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		cilindraje = cilindraje;
	}

	public int getTamano_tanque() {
		return tamano_tanque;
	}

	public void setTamano_tanque(int tamano_tanque) {
		this.tamano_tanque = tamano_tanque;
	}

	public ArrayList<Vehiculo> getLista_motos_disponibles() {
		return lista_motos_disponibles;
	}

	public void setLista_motos_disponibles(ArrayList<Vehiculo> lista_motos_disponibles) {
		this.lista_motos_disponibles = lista_motos_disponibles;
	}

	public ArrayList<Vehiculo> getLista_motos_vendidos() {
		return lista_motos_vendidos;
	}

	public void setLista_motos_vendidos(ArrayList<Vehiculo> lista_motos_vendidos) {
		this.lista_motos_vendidos = lista_motos_vendidos;
	}

	@Override
	public boolean registarVehiculo(Vehiculo vehiculo_nuevo) {
		if (vehiculo_nuevo == null) {

			return false;

		} else {

			lista_motos_disponibles.add(vehiculo_nuevo);

			return true;
		}
	}

	@Override
	public boolean venderVehiculo(Vehiculo vehiculo_comprado) {
		for (int i = 0; i < lista_motos_disponibles.size(); i++) {

			if (lista_motos_disponibles.get(i).equals(vehiculo_comprado)) {

				lista_motos_vendidos.add(vehiculo_comprado);

				lista_motos_disponibles.remove(i);// Para eliminar el vehiculo del array

				return true;
			}

		}
		return false;
	}

	@Override
	public String toString() {

		String cadena = "Placa: " + this.getPlaca() + "\n" + "Marca: " + this.getMarca() + "\n" + "Referencia: "
				+ this.getReferenica() + "\n" + "Modelo: " + this.getModelo() + "\n" + "Precio: $" + this.getPrecio()
				+ "\n" + "Numero de Ruedas: " + this.getNum_ruedas() + "\n" + "Cilindraje: " + this.getCilindraje()
				+ "\n" + "Tamaño del tanque: " + this.getTamano_tanque() + "\n\n";

		return cadena;
	}

}
