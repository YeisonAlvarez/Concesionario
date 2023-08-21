package Presentacion;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controlador.Controller;
import Logica.Auto;
import Logica.Camion;
import Logica.Moto;
import Logica.Vehiculo;

public class Ventana {

	Controller miController = new Controller();
	private double monto_total = 0;

	ArrayList<Vehiculo> tipo_vehiculo_buscado = new ArrayList<Vehiculo>();

	ArrayList<Vehiculo> vehiculos_vendidos = new ArrayList<Vehiculo>();

	/**
	 * 
	 * Metodo que permite seleccionar como logearse
	 * 
	 * @return la posicion seleccionada por el usuario
	 */
	public int autenticarSesion() {

		String[] options = { "Usuario", "Administrador" };
		int seleccion = JOptionPane.showOptionDialog(null,
				"Bienvenido al Concesionario AUTO_AHORA \n\n" + "Seleccione una opcion de ingreso\n\n",
				"Concesionario AUTO_AHORA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
				options[0]);

		return seleccion;
	}

	/**
	 * Metodo que permite seleccionar opciones para usuario
	 * 
	 * @return la posicion de la opcion elegida por el usuario
	 */
	public String invocarMenuPrincipal() {

		String[] opciones_usuario = { "1.Registrar vehículo", "2.Buscar vehículo", "3.Listar vehículos disponibles",
				"4.Vender vehículo", "5.Registro de ventas", "6.Ver Stock por tipo", "7.Ver vendidos por tipo",
				"8.Autenticar Sesion", "9.Ver depreciacion vehiculo" };
		String item_seleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion",
				"Concesionario AUTO_AHORA Menu Principal", JOptionPane.DEFAULT_OPTION, null, opciones_usuario,
				opciones_usuario[0]);

		return item_seleccionado;

	}

	/**
	 * Metodo que permite seleccionar opciones para administrador
	 * 
	 * @return la posicion de la opcion elegida por el administrador
	 */
	public String invocarMenuPrincipalAdmin() {

		String[] opciones_usuario = { "1.Actualizar Vehiculo", "2.Ver total ventas", "3.Eliminar Vehiculo en stock",
				"4.Regresar Autenticar Sesion" };
		String item_seleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion",
				"Concesionario AUTO_AHORA Menu Principal Administrador", JOptionPane.DEFAULT_OPTION, null,
				opciones_usuario, opciones_usuario[0]);

		return item_seleccionado;

	}

	/**
	 * Metodo que permite seleccionar opciones de busqueda al usuario
	 * 
	 * @return la posicion de la opcion elegida de busqueda
	 */
	public int buscarVehiculoPorItem() {

		String[] opciones_busqueda = { "Placa", "Marca", "Referencia", "Modelo", "Precio" };
		int item_buscado = JOptionPane.showOptionDialog(null, "Seleccione un criterio de busqueda:",
				"Concesionario AUTO_AHORA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				opciones_busqueda, opciones_busqueda[0]);

		return item_buscado;
	}

	/**
	 * Metodo que permite buscar un vehiculo por placa
	 * 
	 * @return true and false si encontro el vehiculo
	 */
	public boolean buscarVehiculoPorPlaca() {

		int con = 0;

		String vehiculo_buscado = "";

		String placa_ingresada = JOptionPane.showInputDialog("Ingresar placa de vehiculo a buscar");

		for (int i = 0; i < miController.getLista_vehiculos_disponibles().size(); i++) {

			if (miController.getLista_vehiculos_disponibles().get(i).getPlaca().equalsIgnoreCase(placa_ingresada)) {

				vehiculo_buscado += miController.getLista_vehiculos_disponibles().get(i).toString();

				con++;

			}
		}
		if (con < 1) {
			JOptionPane.showMessageDialog(null, "El vehiculo con la placa ingresada no esta en stock");
			iniciarAplicacionUsuario();
		}

		pintarTabla(vehiculo_buscado, "Lista de Vehiculos por placa: " + placa_ingresada);
		iniciarAplicacionUsuario();

		return false;
	}

	/**
	 * Metodo que permite buscar un vehiculo por marca
	 * 
	 * @return true and false si encontro el vehiculo
	 */
	public boolean buscarVehiculoPorMarca() {

		String vehiculo_buscado = "";

		String marca_ingresada = JOptionPane.showInputDialog("Ingresar marca de vehiculo");

		int con = 0;
		for (int j = 0; j < miController.getLista_vehiculos_disponibles().size(); j++) {

			if (miController.getLista_vehiculos_disponibles().get(j).getMarca().equalsIgnoreCase(marca_ingresada)) {

				vehiculo_buscado += miController.getLista_vehiculos_disponibles().get(j).toString();

				con++;
			}

		}
		if (con < 1) {
			JOptionPane.showMessageDialog(null, "No hay vehiculos en stock de la marca ingresada");
			iniciarAplicacionUsuario();
		}

		pintarTabla(vehiculo_buscado, "Lista de Vehiculos por marca: " + marca_ingresada);
		iniciarAplicacionUsuario();

		return true;
	}

	/**
	 * Metodo que permite buscar un vehiculo por modelo
	 * 
	 * @return true and false si encontro el vehiculo
	 */
	public boolean buscarVehiculoPorModelo() {

		int con = 0;

		String vehiculo_buscado = "";

		String modelo_ingresado = JOptionPane.showInputDialog("Ingresar modelo de vehiculo");

		for (int j = 0; j < miController.getLista_vehiculos_disponibles().size(); j++) {

			if (miController.getLista_vehiculos_disponibles().get(j).getModelo().equalsIgnoreCase(modelo_ingresado)) {

				vehiculo_buscado += miController.getLista_vehiculos_disponibles().get(j).toString();

				con++;
			}

		}
		if (con < 1) {
			JOptionPane.showMessageDialog(null, "No hay vehiculos en stock del modelo ingresado");
			iniciarAplicacionUsuario();
		}

		pintarTabla(vehiculo_buscado, "Lista de Vehiculos por modelo: " + modelo_ingresado);
		iniciarAplicacionUsuario();

		return false;
	}

	/**
	 * Metodo que permite buscar un vehiculo por referencia
	 * 
	 * @return true and false si encontro el vehiculo
	 */
	public boolean buscarVehiculoPorReferencia() {

		int con = 0;

		String vehiculo_buscado = "";

		String referencia_ingresada = JOptionPane.showInputDialog("Ingresar referencia de vehiculo");

		for (int j = 0; j < miController.getLista_vehiculos_disponibles().size(); j++) {

			if (miController.getLista_vehiculos_disponibles().get(j).getReferenica()
					.equalsIgnoreCase(referencia_ingresada)) {
				vehiculo_buscado += miController.getLista_vehiculos_disponibles().get(j).toString();

				con++;
			}

		}

		if (con < 1) {
			JOptionPane.showMessageDialog(null, "No hay vehiculos en stock de la referenica ingresada");
			iniciarAplicacionUsuario();
		}

		pintarTabla(vehiculo_buscado, "Lista de Vehiculos por referencia: " + referencia_ingresada);
		iniciarAplicacionUsuario();

		return true;
	}

	/**
	 * Metodo que permite buscar un vehiculo por precio
	 * 
	 * @return true and false si encontro el vehiculo
	 */
	public boolean buscarVehiculoPorPrecio() {

		int con = 0;

		String vehiculo_buscado = "";

		String precio_ingresado = JOptionPane.showInputDialog("Ingresar precio de vehiculo");

		for (int j = 0; j < miController.getLista_vehiculos_disponibles().size(); j++) {

			if (miController.getLista_vehiculos_disponibles().get(j).getPrecio().equalsIgnoreCase(precio_ingresado)) {
				vehiculo_buscado += miController.getLista_vehiculos_disponibles().get(j).toString();

				con++;
			}
		}
		if (con < 1) {
			JOptionPane.showMessageDialog(null, "No hay vehiculo en stock del precio ingresado");
			iniciarAplicacionUsuario();
		}

		pintarTabla(vehiculo_buscado, "Lista de Vehiculos por precio: " + precio_ingresado);
		iniciarAplicacionUsuario();

		return true;
	}

	/**
	 * Metodo que permite elegir opcion de busqueda por tipo
	 * 
	 * @return la posicion de la opcion elegida por el usuario
	 */
	public int verMenuTipo() {
		String[] opciones_busqueda = { "Autos", "Motos", "Camiones" };
		int item_buscado1 = JOptionPane.showOptionDialog(null, "Seleccione un criterio de busqueda:",
				"Concesionario AUTO_AHORA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				opciones_busqueda, opciones_busqueda[0]);

		return item_buscado1;
	}

	/**
	 * Metodo que permite ver los vehiculos de el tipo seleccionado
	 * 
	 * @return true and false si existen vehiculos o no del tipo seleccionado
	 */
	public boolean verPorTipo() {

		String cadena = "";

		String tipo = "";

		int item_buscado1 = verMenuTipo();

		for (int i = 0; i < miController.getLista_vehiculos_disponibles().size(); i++) {

			if (item_buscado1 == 0) {

				if (miController.getLista_vehiculos_disponibles().get(i).getClass() == Auto.class) {

					tipo_vehiculo_buscado.add(miController.getLista_vehiculos_disponibles().get(i));
					cadena += miController.getLista_vehiculos_disponibles().get(i);

					tipo = "Auto";
				}
			}
			if (item_buscado1 == 1) {

				if (miController.getLista_vehiculos_disponibles().get(i).getClass() == Moto.class) {

					tipo_vehiculo_buscado.add(miController.getLista_vehiculos_disponibles().get(i));
					cadena += miController.getLista_vehiculos_disponibles().get(i);
					tipo = "Moto";
				}
			}
			if (item_buscado1 == 2) {

				if (miController.getLista_vehiculos_disponibles().get(i).getClass() == Camion.class) {

					tipo_vehiculo_buscado.add(miController.getLista_vehiculos_disponibles().get(i));
					cadena += miController.getLista_vehiculos_disponibles().get(i);
					tipo = "Camion";
				}

			}

		}

		pintarTabla(cadena, "Vehiculo de tipo: " + tipo);
		tipo_vehiculo_buscado = new ArrayList<>();
		cadena = "";
		iniciarAplicacionUsuario();
		return true;
	}

	/**
	 * Metodo que permite elegir la opcion de inicio
	 * 
	 * @return
	 */
	public void seleccionarUsuario() {
		int seleccion = autenticarSesion();

		if (seleccion == 0) {
			iniciarAplicacionUsuario();
		}
		if (seleccion == 1) {
			iniciarAplicacionAdministrador();
		}

	}

	/**
	 * Metodo que permite elegir opciones de administrador
	 * 
	 * @return
	 */
	private void iniciarAplicacionAdministrador() {
		// TODO Auto-generated method stub

		String item_seleccionado = invocarMenuPrincipalAdmin();

		if (item_seleccionado.equals("1.Actualizar Vehiculo")) { // Actualizar vehículo

			actualizarVehiculo();

		}
		if (item_seleccionado.equals("2.Ver total ventas")) { // Ver total del ventas

			verMontoTotalVentas();

		}
		if (item_seleccionado.equals("3.Eliminar Vehiculo en stock")) { // Eliminar vehiculo en stock

			eliminarVehiculo();

		}
		if (item_seleccionado.equals("4.Regresar Autenticar Sesion")) {// Logearse nuevamente

			seleccionarUsuario();
		}

	}

	/**
	 * Metodo que permite eliminar un vehiculo de la lista de disponibles
	 * 
	 * @return
	 */
	private void eliminarVehiculo() {
		// TODO Auto-generated method stub

		if (miController.getLista_vehiculos_disponibles().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay vehiculos en Stock");
			iniciarAplicacionAdministrador();
		} else {
			String placa_ingresada = JOptionPane.showInputDialog("Ingresar placa de vehiculo a eliminar");

			for (int i = 0; i < miController.getLista_vehiculos_disponibles().size(); i++) {

				if (miController.getLista_vehiculos_disponibles().get(i).getPlaca().equalsIgnoreCase(placa_ingresada)) {

					miController.getLista_vehiculos_disponibles().remove(i);
					JOptionPane.showMessageDialog(null, "Vehiculo eliminado correctamente del stock");
					break;
				}
			}
			iniciarAplicacionAdministrador();

		}

	}

	/**
	 * Metodo que permite calcular las ventas de vehiculos y mostrar el resultado
	 * 
	 * @return
	 */
	private void verMontoTotalVentas() {

		JOptionPane.showMessageDialog(null, "El valor total en ventas es: $ " + this.monto_total);
		iniciarAplicacionAdministrador();
	}

	/**
	 * Metodo que permite cambiar valores de un vehiculo ya registrado
	 * 
	 * @return
	 */
	private void actualizarVehiculo() {
		// TODO Auto-generated method stub

		String[] opciones_vehiculos = { "Auto", "Moto", "Camion" };
		int item_vehiculo = JOptionPane.showOptionDialog(null, "Actualizar?", "Concesionario AUTO_AHORA",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones_vehiculos,
				opciones_vehiculos[0]);

		String placa = "";
		String marca = "";
		String referencia = "";
		String modelo = "";
		String precio = "";
		int num_ruedas = 0;
		int num_puertas = 0;
		boolean is_gasolina = false;
		int cilindraje = 0;
		int tamano_tanque = 0;
		int cap_carga = 0;

		if (miController.getLista_vehiculos_disponibles().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay vehiculos en Stock");
			iniciarAplicacionAdministrador();
		} else {
			String placa_ingresada = JOptionPane.showInputDialog("Ingresar placa de vehiculo a actualizar");

			for (int i = 0; i < miController.getLista_vehiculos_disponibles().size(); i++) {

				if (miController.getLista_vehiculos_disponibles().get(i).getPlaca().equalsIgnoreCase(placa_ingresada)) {

					placa = JOptionPane.showInputDialog(null, "Diligencia la placa del vehiculo",
							miController.getLista_vehiculos_disponibles().get(i).getPlaca());
					marca = JOptionPane.showInputDialog(null, "Marca:",
							miController.getLista_vehiculos_disponibles().get(i).getMarca());
					referencia = JOptionPane.showInputDialog(null, "Referencia",
							miController.getLista_vehiculos_disponibles().get(i).getReferenica());
					modelo = JOptionPane.showInputDialog(null, "Modelo",
							miController.getLista_vehiculos_disponibles().get(i).getModelo());
					precio = JOptionPane.showInputDialog(null, "Precio",
							miController.getLista_vehiculos_disponibles().get(i).getPrecio());
					num_ruedas = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de ruedas",
							miController.getLista_vehiculos_disponibles().get(i).getNum_ruedas()));

					if (item_vehiculo == 0) {// Auto

						Auto auto_actualizar = (Auto) miController.getLista_vehiculos_disponibles().get(i);
						num_puertas = Integer.parseInt(JOptionPane.showInputDialog(null, "numero de puertas",
								auto_actualizar.getNum_puertas()));
						is_gasolina = isGasolina();

						auto_actualizar.setPlaca(placa);
						auto_actualizar.setPrecio(precio);
						auto_actualizar.setModelo(modelo);
						auto_actualizar.setReferenica(referencia);
						auto_actualizar.setGasolina(is_gasolina);
						auto_actualizar.setNum_puertas(num_puertas);
						auto_actualizar.setNum_ruedas(num_ruedas);

						miController.getLista_vehiculos_disponibles().set(i, auto_actualizar);

					}
					if (item_vehiculo == 1) {// Moto

						Moto moto_actualizar = (Moto) miController.getLista_vehiculos_disponibles().get(i);
						cilindraje = Integer.parseInt(
								JOptionPane.showInputDialog(null, "Cilindraje", moto_actualizar.getCilindraje()));
						tamano_tanque = Integer.parseInt(
								JOptionPane.showInputDialog(null, "tamano tanque", moto_actualizar.getTamano_tanque()));

						moto_actualizar.setPlaca(placa);
						moto_actualizar.setPrecio(precio);
						moto_actualizar.setModelo(modelo);
						moto_actualizar.setReferenica(referencia);
						moto_actualizar.setCilindraje(cilindraje);
						moto_actualizar.setTamano_tanque(tamano_tanque);
						moto_actualizar.setNum_ruedas(num_ruedas);

						miController.getLista_vehiculos_disponibles().set(i, moto_actualizar);
					}
					if (item_vehiculo == 2) {// Camion

						Camion camion_actualizar = (Camion) miController.getLista_vehiculos_disponibles().get(i);
						cap_carga = Integer.parseInt(JOptionPane.showInputDialog(null, "capacidad de carga",
								camion_actualizar.getCap_carga()));

						camion_actualizar.setPlaca(placa);
						camion_actualizar.setPrecio(precio);
						camion_actualizar.setModelo(modelo);
						camion_actualizar.setReferenica(referencia);
						camion_actualizar.setCap_carga(cap_carga);
						camion_actualizar.setNum_ruedas(num_ruedas);

						miController.getLista_vehiculos_disponibles().set(i, camion_actualizar);
					}
					JOptionPane.showMessageDialog(null, "Vehiculo Actualizado Correctamente");
					iniciarAplicacionAdministrador();

				} else {
					JOptionPane.showMessageDialog(null, "Vehiculo no encontrado");
					iniciarAplicacionAdministrador();

				}
			}
		}

	}

	/**
	 * Metodo que permite elegir opcion de busqueda del usuario
	 * 
	 * @return la posicion de la opcion elegida por el usuario
	 */
	public void iniciarAplicacionUsuario() {

		String item_seleccionado = invocarMenuPrincipal();

		if (item_seleccionado.equals("1.Registrar vehículo")) { // Registrar vehículo

			registrarVehiculoVista();

		}
		if (item_seleccionado.equals("2.Buscar vehículo")) {// Buscar vehículo

			int item_buscado = buscarVehiculoPorItem();

			switch (item_buscado) {
			case 0:
				buscarVehiculoPorPlaca(); // Placa
				break;
			case 1:
				buscarVehiculoPorMarca(); // Marca
				break;
			case 2:
				buscarVehiculoPorReferencia();// Referencia
				break;
			case 3:
				buscarVehiculoPorModelo(); // Modelo
				break;
			case 4:
				buscarVehiculoPorPrecio(); // Precio
				break;

			}
		}

		if (item_seleccionado.equals("3.Listar vehículos disponibles")) {// Listar vehículos disponibles

			listarVehiculosDisponibles();

		}
		if (item_seleccionado.equals("4.Vender vehículo")) {// Vender vehículo

			venderVehiculo();

		}

		if (item_seleccionado.equals("5.Registro de ventas")) { // registro ventas

			verRegistroVentas();

		}

		if (item_seleccionado.equals("6.Ver Stock por tipo")) {// Ver Stock por tipo

			verPorTipo();
		}

		if (item_seleccionado.equals("7.Ver vendidos por tipo")) { // Ver stock vendidos

			venderPorTipo();
		}
		if (item_seleccionado.equals("8.Autenticar Sesion")) {// Logearse nuevamente

			seleccionarUsuario();
		}
		if (item_seleccionado.equals("9.Ver depreciacion vehiculo")) {// metodo propio para calcular depreciacio futura

			calcularDepreciacionFutura();
		}

	}

	/**
	 * Metodo el calculo de la depresiacion futura del vehiculo
	 * 
	 */
	private void calcularDepreciacionFutura() {
		// TODO Auto-generated method stub

		int item_vehiculo = verMenuTipo();
		String placa_ingresada = JOptionPane.showInputDialog(
				"Ingresar placa de vehiculo del que desea ver la depreciaciòn: \n\nTener en cuenta lo siguiente:\nvida util auto: 5 años\r\n"
						+ "vida util moto: 2 años\r\n" + "vida util camion: 10 años");
		double precio = 0.0;

		int con = 0;

		for (int i = 0; i < miController.getLista_vehiculos_disponibles().size(); i++) {

			if (miController.getLista_vehiculos_disponibles().get(i).getPlaca().equalsIgnoreCase(placa_ingresada)) {

				precio = Double.parseDouble(miController.getLista_vehiculos_disponibles().get(i).getPrecio());

				if (item_vehiculo == 0) {// Auto

					Auto auto_encontrado = (Auto) miController.getLista_vehiculos_disponibles().get(i);
					double valor_depreciacion = auto_encontrado.calcularDepreciacionFuturaVehiculo(precio);
					JOptionPane.showMessageDialog(null, "El precio actual del vehiculo es:" + precio + "\n\n"
							+ "El precio del auto despues de depreciaciòn serà: " + valor_depreciacion);

					con++;

				}
				if (item_vehiculo == 1) {// Moto

					Moto auto_encontrado = (Moto) miController.getLista_vehiculos_disponibles().get(i);
					double valor_depreciacion = auto_encontrado.calcularDepreciacionFuturaVehiculo(precio);
					JOptionPane.showMessageDialog(null, "El precio actual del vehiculo es:" + precio + "\n\n"
							+ "El precio de la moto despues de depreciaciòn serà: " + valor_depreciacion);

					con++;
				}
				if (item_vehiculo == 2) {// Camion

					Camion auto_encontrado = (Camion) miController.getLista_vehiculos_disponibles().get(i);
					double valor_depreciacion = auto_encontrado.calcularDepreciacionFuturaVehiculo(precio);
					JOptionPane.showMessageDialog(null, "El precio actual del vehiculo es:" + precio + "\n\n"
							+ "El precio del camiòn despues de depreciaciòn serà: " + valor_depreciacion);
					con++;
				}
				iniciarAplicacionUsuario();

			}

		}
		if (con < 1) {
			JOptionPane.showMessageDialog(null, "Vehiculo no encontrado");
			iniciarAplicacionUsuario();

		}
	}

	/**
	 * Metodo que permite vender un vehiculo por tipo que se encuentra disponible
	 * 
	 * @return
	 */
	private void venderPorTipo() {
		// TODO Auto-generated method stub

		int item_buscado1 = verMenuTipo();

		String cadena = "";
		String tipo = "";

		for (int i = 0; i < vehiculos_vendidos.size(); i++) {

			if (item_buscado1 == 0) {

				if (vehiculos_vendidos.get(i).getClass() == Auto.class) {

					cadena += vehiculos_vendidos.get(i);
					tipo_vehiculo_buscado.add(vehiculos_vendidos.get(i));
					tipo = "Auto";

				}
			}

			if (item_buscado1 == 1) {

				if (vehiculos_vendidos.get(i).getClass() == Moto.class) {

					cadena += vehiculos_vendidos.get(i);
					tipo_vehiculo_buscado.add(vehiculos_vendidos.get(i));
					tipo = "Moto";

				}
			}

			if (item_buscado1 == 2) {

				if (vehiculos_vendidos.get(i).getClass() == Camion.class) {

					cadena += vehiculos_vendidos.get(i);
					tipo_vehiculo_buscado.add(vehiculos_vendidos.get(i));
					tipo = "Camion";

				}
			}

		}
		pintarTabla(cadena, tipo);
		iniciarAplicacionUsuario();

	}

	/**
	 * Metodo que permite ver las ventas realizadas
	 * 
	 * @return
	 */
	private void verRegistroVentas() {
		// TODO Auto-generated method stub

		String cadena = "";
		for (int i = 0; i < vehiculos_vendidos.size(); i++) {

			cadena += vehiculos_vendidos.get(i).toString() + "\n\n";

		}

		pintarTabla(cadena, "Registro vehiculos vendidos");

		iniciarAplicacionUsuario();

	}

	/**
	 * Metodo que permite vender un vehiculo
	 * 
	 * @return o
	 */
	private void venderVehiculo() {
		// TODO Auto-generated method stub

		int con = 0;

		String placa_ingresada = JOptionPane.showInputDialog("Ingresar placa de vehiculo a vender");

		for (int i = 0; i < miController.getLista_vehiculos_disponibles().size(); i++) {

			if (miController.getLista_vehiculos_disponibles().get(i).getPlaca().equalsIgnoreCase(placa_ingresada)) {

				vehiculos_vendidos.add(miController.getLista_vehiculos_disponibles().get(i));
				this.monto_total += Integer.parseInt(miController.getLista_vehiculos_disponibles().get(i).getPrecio());

				miController.getLista_vehiculos_disponibles().remove(i);
				JOptionPane.showMessageDialog(null, "Vehiculo vendido satisfactoriamente");
				con++;
				break;

			}
		}

		if (con < 1) {
			JOptionPane.showMessageDialog(null, "No se encontro el vehiculo en stock");
		}

		iniciarAplicacionUsuario();

	}

	/**
	 * Metodo que permite listar todos los vehiculos disponibles
	 * 
	 * @return
	 */
	private void listarVehiculosDisponibles() {
		// TODO Auto-generated method stub

		String cadena = "";
		for (int i = 0; i < miController.getLista_vehiculos_disponibles().size(); i++) {
			cadena += miController.getLista_vehiculos_disponibles().get(i).toString();

		}
		pintarTabla(cadena, "Listado de Vehiculos Disponibles");

		iniciarAplicacionUsuario();

	}

	/**
	 * Metodo que permite listar todo en un textArea
	 * 
	 * @return
	 */

	public void pintarTabla(String cadena, String mensaje_superior) {

		JTextArea textArea = new JTextArea(cadena);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		JOptionPane.showMessageDialog(null, scrollPane, mensaje_superior, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Metodo que permite elegir opcion de busqueda por tipo
	 * 
	 * @return la posicion de la opcion elegida por el usuario
	 */
	public boolean registrarVehiculoVista() {

		String[] opciones_vehiculos = { "Auto", "Moto", "Camion" };
		int item_vehiculo = JOptionPane.showOptionDialog(null, "Registrar?", "Concesionario AUTO_AHORA",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones_vehiculos,
				opciones_vehiculos[0]);

		String placa = JOptionPane.showInputDialog("Diligencia la placa del vehiculo");
		String marca = JOptionPane.showInputDialog("Marca:");
		String referencia = JOptionPane.showInputDialog("Referencia");
		String modelo = JOptionPane.showInputDialog("Modelo");
		String precio = JOptionPane.showInputDialog("Precio");
		int num_ruedas = Integer.parseInt(JOptionPane.showInputDialog("Numero de ruedas"));

		if (item_vehiculo == 0) {// Auto

			int num_puertas = Integer.parseInt(JOptionPane.showInputDialog("numero de puertas"));
			boolean is_gasolina = isGasolina();
			boolean is_registrado = registrarAutoVista(placa, marca, referencia, modelo, precio, num_ruedas,
					num_puertas, is_gasolina);

		}
		if (item_vehiculo == 1) {// Moto

			int cilindraje = Integer.parseInt(JOptionPane.showInputDialog("Cilindraje"));
			int tamano_tanque = Integer.parseInt(JOptionPane.showInputDialog("tamano tanque"));
			boolean is_moto_registrada = registrarMotoVista(placa, marca, referencia, modelo, precio, num_ruedas,

					cilindraje, tamano_tanque);

		}
		if (item_vehiculo == 2) {// Camion

			int cap_carga = Integer.parseInt(JOptionPane.showInputDialog("capacidad de carga"));

			boolean is_registrado = registrarCamionVista(placa, marca, referencia, modelo, precio, num_ruedas,
					cap_carga);

		}
		return false;
	}

	private boolean isGasolina() {
		boolean is_gasolina = false;
		String[] opcion_gasolina = { "Si", "No" };
		int item = JOptionPane.showOptionDialog(null, "Es a gasolina", null, JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, opcion_gasolina, opcion_gasolina[0]);
		if (item == 0) {
			is_gasolina = true;
		} else {
			is_gasolina = false;
		}
		return is_gasolina;
	}

	/**
	 * Metodo que permite registrar un auto
	 * 
	 * @return yes and false si se registro el vehiculo
	 */
	private boolean registrarAutoVista(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int num_puertas, boolean is_gasolina) {

		boolean is_registrado = miController.registrarAuto(placa, marca, referencia, modelo, precio, num_ruedas,
				num_puertas, is_gasolina);

		if (is_registrado) {
			int respuesta = JOptionPane.showConfirmDialog(null,
					"Auto registrado satisfactoriamente \n¿Desea registrar otro vehiculo?");

			if (respuesta == 0) {

				registrarVehiculoVista();

			} else if (respuesta == 1) {

				iniciarAplicacionUsuario();

			}

		} else {
			JOptionPane.showMessageDialog(null, "Ocurrio un error durante el registro");
		}
		return false;

	}

	/**
	 * Metodo que permite registrar un camion
	 * 
	 * @return yes and false si se registro el vehiculo
	 */
	private boolean registrarCamionVista(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int cap_carga) {

		boolean is_registrado = miController.registrarCamion(placa, marca, referencia, modelo, precio, num_ruedas,
				cap_carga);

		if (is_registrado) {
			int respuesta = JOptionPane.showConfirmDialog(null,
					"Camion registrado satisfactoriamente. \n¿Desea registar otro vehiculo?");

			if (respuesta == 0) {

				registrarVehiculoVista();

			} else if (respuesta == 1) {

				iniciarAplicacionUsuario();

			}
		} else {
			JOptionPane.showMessageDialog(null, "Ocurrio un error durante el registro");
		}
		return false;
	}

	/**
	 * Metodo que permite registrar una moto
	 * 
	 * @return yes and false si se registro el vehiculo
	 */
	private boolean registrarMotoVista(String placa, String marca, String referencia, String modelo, String precio,
			int num_ruedas, int cilindraje, int tamano_tanque) {

		boolean is_registrado = miController.registrarMoto(placa, marca, referencia, modelo, precio, num_ruedas,
				cilindraje, tamano_tanque);

		if (is_registrado) {
			int respuesta = JOptionPane.showConfirmDialog(null,
					"Moto registrada satisfactoriamente. \n¿Desea registar otro vehiculo?");

			if (respuesta == 0) {

				registrarVehiculoVista();

			} else if (respuesta == 1) {

				iniciarAplicacionUsuario();

			}

		} else {
			JOptionPane.showMessageDialog(null, "Ocurrio un error durante el registro");
		}
		return false;
	}

}
