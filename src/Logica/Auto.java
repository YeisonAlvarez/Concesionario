package Logica;

import java.util.ArrayList;

public class Auto extends Vehiculo {

	private ArrayList<Vehiculo> lista_autos_disponibles = new ArrayList<Vehiculo>();
	
	private ArrayList<Vehiculo> lista_autos_vendidos = new ArrayList<Vehiculo>();
	
	private int num_puertas;
	
	private boolean isGasolina;

	public Auto() {
		super();
	}

	public Auto(String placa, String marca, String referenica, String modelo, String precio, int num_ruedas,
			int num_puertas, boolean isGasolina) {
		super(placa, marca, referenica, modelo, precio, num_ruedas);
		this.num_puertas = num_puertas;
		this.isGasolina = isGasolina;

	}

	public int getNum_puertas() {
		return num_puertas;
	}

	public void setNum_puertas(int num_puertas) {
		this.num_puertas = num_puertas;
	}

	public boolean isGasolina() {
		return isGasolina;
	}

	public void setGasolina(boolean isGasolina) {
		this.isGasolina = isGasolina;
	}

	
	public ArrayList<Vehiculo> getLista_autos_disponibles() {
		return lista_autos_disponibles;
	}

	public void setLista_autos_disponibles(ArrayList<Vehiculo> lista_autos_disponibles) {
		this.lista_autos_disponibles = lista_autos_disponibles;
	}

	public ArrayList<Vehiculo> getLista_autos_vendidos() {
		return lista_autos_vendidos;
	}

	public void setLista_autos_vendidos(ArrayList<Vehiculo> lista_autos_vendidos) {
		this.lista_autos_vendidos = lista_autos_vendidos;
	}

	@Override
	public boolean registarVehiculo(Vehiculo vehiculo_nuevo) {
		if (vehiculo_nuevo == null) {

			return false;

		} else {

			lista_autos_disponibles.add(vehiculo_nuevo);

			return true;
		}
	}

	@Override
	public boolean venderVehiculo(Vehiculo vehiculo_comprado) {
		for (int i = 0; i < lista_autos_disponibles.size(); i++) {

			if (lista_autos_disponibles.get(i).equals(vehiculo_comprado)) {

				lista_autos_vendidos.add(vehiculo_comprado);

				lista_autos_disponibles.remove(i);// Para eliminar el vehiculo del array

				return true;
			}

		}
		return false;
	}

	@Override
	public String toString() {
		String cadena = "Placa: " + this.getPlaca() + "\n" + "Marca: " + this.getMarca() + "\n" + "Referencia: "
				+ this.getReferenica() + "\n" + "Modelo: " + this.getModelo() + "\n" + "Precio: $" + this.getPrecio()
				+ "\n" + "Numero de Ruedas: " + this.getNum_ruedas() + "\n" + "Numero de Puertas: " + this.getNum_puertas()
				+ "\n" + "Es a Gasolina: " + this.isGasolina() + "\n\n";

		return cadena;
	}



}
