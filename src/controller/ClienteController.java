package controller;

import model.DataBaseCommunicator;
import java.util.ArrayList;

public class ClienteController {

	private DataBaseCommunicator dataBase;

	public ClienteController() {
		this.dataBase = new DataBaseCommunicator();
	}

	public String insertarCliente(String pTipo, String pNombre, String pDireccion, String pCiudad, String pCedula, String pTelefono, String pNombreContacto, String pTelContacto, String pCargoContacto){
		int tipo = Integer.parseInt(pTipo);
		long cedula = Long.parseLong(pCedula);
		int telefono = Integer.parseInt(pTelefono);
		int telContacto = Integer.parseInt(pTelContacto);

		return dataBase.insertarCliente(tipo, pNombre, pDireccion, pCiudad, cedula, telefono, pNombreContacto, telContacto, pCargoContacto);
	}

	public String modificarCliente(String pTipo, String pNombre, String pDireccion, String pCiudad, String pCedula, String pTelefono, String pNombreContacto, String pTelContacto, String pCargoContacto){
		int tipo = Integer.parseInt(pTipo);
		long cedula = Long.parseLong(pCedula);
		int telefono = Integer.parseInt(pTelefono);
		int telContacto = Integer.parseInt(pTelContacto);
		
		return dataBase.modificarCliente(tipo, pNombre, pDireccion, pCiudad, cedula, telefono, pNombreContacto, telContacto, pCargoContacto);
	}

	public String suspenderCliente(String pTipo, String pCedula, String pCedulaJ){
		int tipo = Integer.parseInt(pTipo);
		int cedula = Integer.parseInt(pCedula);
		int cedulaJ = Integer.parseInt(pCedulaJ);

		return dataBase.suspenderCliente(tipo, cedula, cedulaJ);
	}

	public String activarCliente(String pTipo, String pCedula, String pCedulaJ){
		int tipo = Integer.parseInt(pTipo);
		int cedula = Integer.parseInt(pCedula);
		int cedulaJ = Integer.parseInt(pCedulaJ);

		return dataBase.activarCliente(tipo, cedula, cedulaJ);
	}

	public String[][] listarClientes(){
		ArrayList<String[]> clientes = dataBase.listarClientes();
		String[][] array = new String[clientes.size()][];
		int i = 0;

		for (String[] cliente : clientes){
			array[i] = cliente;
			i++;
		}

		return array;
	}
}
