package Logica;

import java.util.ArrayList;

public class Camion extends Vehiculo {

	private ArrayList<Vehiculo> lista_camiones_disponibles = new ArrayList<Vehiculo>();

	private ArrayList<Vehiculo> lista_camiones_vendidos = new ArrayList<Vehiculo>();

	private int cap_carga;

	public Camion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Camion(String placa, String marca, String referenica, String modelo, String precio, int num_ruedas,
			int cap_carga) {
		super(placa, marca, referenica, modelo, precio, num_ruedas);
		this.cap_carga = cap_carga;
		// TODO Auto-generated constructor stub
	}

	public Camion(int cap_carga) {
		super();
		this.cap_carga = cap_carga;
	}

	public int getCap_carga() {
		return cap_carga;
	}

	public void setCap_carga(int cap_carga) {
		this.cap_carga = cap_carga;
	}

	public ArrayList<Vehiculo> getLista_camiones_disponibles() {
		return lista_camiones_disponibles;
	}

	public void setLista_camiones_disponibles(ArrayList<Vehiculo> lista_camiones_disponibles) {
		this.lista_camiones_disponibles = lista_camiones_disponibles;
	}

	public ArrayList<Vehiculo> getLista_camiones_vendidos() {
		return lista_camiones_vendidos;
	}

	public void setLista_camiones_vendidos(ArrayList<Vehiculo> lista_camiones_vendidos) {
		this.lista_camiones_vendidos = lista_camiones_vendidos;
	}

	@Override
	public boolean registarVehiculo(Vehiculo vehiculo_nuevo) {
		if (vehiculo_nuevo == null) {

			return false;

		} else {

			lista_camiones_disponibles.add(vehiculo_nuevo);

			return true;
		}
	}

	@Override
	public boolean venderVehiculo(Vehiculo vehiculo_comprado) {
		for (int i = 0; i < lista_camiones_disponibles.size(); i++) {

			if (lista_camiones_disponibles.get(i).equals(vehiculo_comprado)) {

				lista_camiones_vendidos.add(vehiculo_comprado);

				lista_camiones_disponibles.remove(i);// Para eliminar el vehiculo del array

				return true;
			}

		}
		return false;
	}

	@Override
	public String toString() {
		String cadena = "Placa: " + this.getPlaca() + "\n" + "Marca: " + this.getMarca() + "\n" + "Referencia: "
				+ this.getReferenica() + "\n" + "Modelo: " + this.getModelo() + "\n" + "Precio: $" + this.getPrecio()
				+ "\n" + "Numero de Ruedas: " + this.getNum_ruedas() + "\n" + "Capacidad de Carga: "
				+ this.getCap_carga()+"\n\n";

		return cadena;
	}

}
